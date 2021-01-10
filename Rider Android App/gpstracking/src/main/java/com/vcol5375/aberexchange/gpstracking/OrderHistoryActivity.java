package com.vcol5375.aberexchange.gpstracking;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class OrderHistoryActivity extends AppCompatActivity {

    String[] orderslist = new String[] {};

    // Create a List from String Array elements
    final List<String> orders_list = new ArrayList<String>(Arrays.asList(orderslist));
    ListView lv;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //set content view AFTER ABOVE sequence (to avoid crash)
        this.setContentView(R.layout.activity_history);

        Button logout = (Button) findViewById(R.id.logout);
        lv = (ListView) findViewById(R.id.lv);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPrefManager.getInstance(getApplicationContext()).logout();
                Intent i = new Intent(OrderHistoryActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OrderHistoryActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });




        // DataBind ListView with items from ArrayAdapter

        getAllOrders();






    }

    public void getAllOrders() {

        class getOrders extends AsyncTask<Void, Void, String> {


            @Override
            protected void onPreExecute() {
                super.onPreExecute();

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                String name = "";
                String id = "";
                String fare = "";

                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(s);
                    JSONArray arr = obj.getJSONArray("orders");
                    for (int i = 0; i < arr.length(); i++)
                    {
                        id = arr.getJSONObject(i).getString("id");
                        name = arr.getJSONObject(i).getString("name");
                        fare = arr.getJSONObject(i).getString("fare");
                        orders_list.add("Order ID: #"+id+" - "+name+" | $"+fare);
                    }

                    // Create an ArrayAdapter from List
                    final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                            (getApplicationContext(), android.R.layout.simple_list_item_1, orders_list);

                    lv.setAdapter(arrayAdapter);
                    arrayAdapter.notifyDataSetChanged();


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                //creating request handler object
                RequestHandler requestHandler = new RequestHandler();


                User user = SharedPrefManager.getInstance(getApplicationContext()).getUser();
                //creating request parameters
                HashMap<String, String> params = new HashMap<>();
                params.put("email", user.getEmail().toString());
                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_ORDERS, params);




            }
        }


        getOrders gO = new getOrders();
        gO.execute();

    }

}

