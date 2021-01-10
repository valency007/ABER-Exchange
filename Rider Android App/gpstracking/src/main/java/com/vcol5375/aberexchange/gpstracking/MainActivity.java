package com.vcol5375.aberexchange.gpstracking;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hlab.animatedPullToRefresh.AnimatedPullToRefreshLayout;
import com.marcoscg.fingerauth.FingerAuth;
import com.marcoscg.fingerauth.FingerAuthDialog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.util.HashMap;

import butterknife.OnEditorAction;
import cheekiat.slideview.SlideView;

public class MainActivity extends AppCompatActivity implements AnimatedPullToRefreshLayout.OnRefreshListener {
    private final String ChannelId = "Updates";
    private final int NotificationId = 15;
    private AnimatedPullToRefreshLayout mPullToRefreshLayout;
    private JSONObject fuser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //set content view AFTER ABOVE sequence (to avoid crash)
        this.setContentView(R.layout.activity_main);

        mPullToRefreshLayout = findViewById(R.id.pullToRefreshLayout);
        mPullToRefreshLayout.setColorAnimationArray(new int[]{Color.CYAN, Color.RED, Color.YELLOW, Color.MAGENTA});
        mPullToRefreshLayout.setOnRefreshListener(this);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, OrderHistoryActivity.class);
                startActivity(i);
            }
        });



        //LetsLocate(); //Location Update Function


//                SharedPrefManager.getInstance(getApplicationContext()).logout();





//        try{
//            User user = SharedPrefManager.getInstance(this).getUser();
//            if (user.getEmail().toString().length()>5){
//                Toast.makeText(getApplicationContext(), "Email: " + user.getEmail(), Toast.LENGTH_SHORT).show();
//            }
//
//        }
//        catch(NullPointerException e){
//            Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
//            e.printStackTrace();
//        }


    }


    //value("Hello","World of Notifications" ); displays notifications


    public void value(String s1, String s2) {
        createNotificationChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, ChannelId);
        builder.setSmallIcon(R.drawable.ic_fullscreen_exit_black_24dp);
        builder.setContentTitle(s1);
        builder.setContentText(s2);
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(NotificationId, builder.build());
    }

    public void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Order Details";
            String description = "Order Status Notification";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel(ChannelId, name, importance);
            notificationChannel.setDescription(description);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);

        }
    }



    public void getNewOrders(final String email) {

        class getNewOrders extends AsyncTask<Void, Void, String> {


            @Override
            protected void onPreExecute() {
                super.onPreExecute();

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                String status = "";

                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(s);
                    //Toast.makeText(getApplicationContext(), "" + obj, Toast.LENGTH_LONG).show();
                    JSONArray arr = obj.getJSONArray("orders");
                    for (int i = 0; i < arr.length(); i++)
                    {
                        status = arr.getJSONObject(i).getString("status");
                        if (status.contentEquals("0")){
                            //Toast.makeText(MainActivity.this, ""+arr.getJSONObject(i), Toast.LENGTH_SHORT).show();
                            value("New Order","You have a pending order request" );
                            fuser = arr.getJSONObject(i);
                            showDialogMessage();

                            break;
                        }

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                //creating request handler object
                RequestHandler requestHandler = new RequestHandler();

                HashMap<String, String> params = new HashMap<>();
                params.put("email", email.toString());
                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_NEW_ORDERS, params);


            }
        }

        getNewOrders nO = new getNewOrders();
        nO.execute();


    }


    @Override
    public void onRefresh() {
        //todo: do something here when it starts to refresh
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (SharedPrefManager.getInstance(getApplicationContext()).isLoggedIn()) {
                    User user = SharedPrefManager.getInstance(getApplicationContext()).getUser();
                    // Toast.makeText(getApplicationContext(), "Email: " + user.getEmail(), Toast.LENGTH_SHORT).show();
                    getNewOrders(user.getEmail().toString());
                } else {
                    Toast.makeText(getApplicationContext(), "Fatal Error", Toast.LENGTH_SHORT).show();
                }

                mPullToRefreshLayout.refreshComplete();
            }
        }, 1000);
    }

    private void showDialogMessage(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        try {
            builder.setTitle("New Order: #"+fuser.getString("id"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        builder.setMessage("By accepting this order, you agree to our terms and conditions of the data usage policy (ACSC Compliant)");

        builder.setCancelable(false);
        // Add the buttons
        builder.setPositiveButton("Accept", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
//                Toast.makeText(MainActivity.this, ""+fuser, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, ActiveOrder.class);
                i.putExtra("fuser", fuser.toString());
                startActivity(i);

            }
        });
        builder.setNegativeButton("Reject", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }


}










