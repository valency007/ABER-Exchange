package com.vcol5375.aberexchange.gpstracking;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;


public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private static final int REQUEST_SIGNUP = 0;
    private EditText _emailText;
    private EditText _passwordText;
    private Button _loginButton;

     @Override
    public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_login);

         _emailText = (EditText) findViewById(R.id.input_email);
         _passwordText = (EditText) findViewById(R.id.input_password);
         _loginButton = (Button) findViewById(R.id.btn_login);

         _loginButton.setOnClickListener(new View.OnClickListener() {

             @Override
             public void onClick(View v) {
                 login();
             }
         });

     }
    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);


        final String email = _emailText.getText().toString();
        final String password = _passwordText.getText().toString();

        class UserLogin extends AsyncTask<Void, Void, String> {

            ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this,
                    R.style.Theme_MyDialog);

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);


                try {
                    //converting response to json object
                    JSONObject obj = new JSONObject(s);
                   // Toast.makeText(LoginActivity.this, ""+obj, Toast.LENGTH_LONG).show();

                    //if no error in response
                    if (!obj.getBoolean("error")) {
                        //Toast.makeText(getApplicationContext(), obj.getString("message"), Toast.LENGTH_SHORT).show();

                        //getting the user from the response
                        String user = obj.getString("email");


                        //storing the user in shared preferences
                        SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);
                        onLoginSuccess();

                    } else {
                        onLoginFailed();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(Void... voids) {
                //creating request handler object
                RequestHandler requestHandler = new RequestHandler();

                //creating request parameters
                HashMap<String, String> params = new HashMap<>();
                params.put("email", email);
                params.put("password", password);

                //returing the response
                return requestHandler.sendPostRequest(URLs.URL_LOGIN, params);
            }
        }

        UserLogin ul = new UserLogin();
        ul.execute();




    }




    @Override
    public void onBackPressed() {
        // disable going back to the MainActivity
        moveTaskToBack(true);
    }

    public void onLoginSuccess() {
        _loginButton.setEnabled(false);
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(i);
        finish();
       // Toast.makeText(getBaseContext(), "Login success", Toast.LENGTH_SHORT).show();
        //getAllOrders(); //Gets user-specific orders

    }

    public void onLoginFailed() {

        Toast.makeText(getBaseContext(), "Invalid Email or Password", Toast.LENGTH_LONG).show();
        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }
}