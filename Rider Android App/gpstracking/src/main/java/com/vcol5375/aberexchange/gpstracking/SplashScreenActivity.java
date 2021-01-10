package com.vcol5375.aberexchange.gpstracking;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.marcoscg.fingerauth.FingerAuth;
import com.marcoscg.fingerauth.FingerAuthDialog;

public class SplashScreenActivity extends AppCompatActivity {

    private FingerAuthDialog fingerAuthDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        //Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //set content view AFTER ABOVE sequence (to avoid crash)
        this.setContentView(R.layout.activity_splash);

        final boolean hasFingerprintSupport = FingerAuth.hasFingerprintSupport(this);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Do something after 5s = 5000ms

                if (SharedPrefManager.getInstance(getApplicationContext()).isLoggedIn()){
                    User user = SharedPrefManager.getInstance(getApplicationContext()).getUser();
                    // Toast.makeText(getApplicationContext(), "Email: " + user.getEmail(), Toast.LENGTH_SHORT).show();

                            fingerAuthDialog = null;
                            if (hasFingerprintSupport){
                                createAndShowDialog();}
                            else{
                                Toast.makeText(getApplicationContext(), "Your device does not support fingerprint authentication", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                                startActivity(i);
                                finish();

                        }
                }



                else{
                    Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }



            }
        }, 1000);


    }

    private void createAndShowDialog() {
        fingerAuthDialog = new FingerAuthDialog(this)
                .setTitle("Sign in")
                .setCancelable(false)
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(SplashScreenActivity.this, LoginActivity.class);
                        startActivity(i);
                        finish();
                    }
                })
                .setOnFingerAuthListener(new FingerAuth.OnFingerAuthListener() {
                    @Override
                    public void onSuccess() {
                        Intent i = new Intent(SplashScreenActivity.this, MainActivity.class);
                        startActivity(i);
                        finish();
                    }

                    @Override
                    public void onFailure() {

                    }

                    @Override
                    public void onError() {
                        System.exit(0);
                    }
                });

        fingerAuthDialog.show();

    }
}
