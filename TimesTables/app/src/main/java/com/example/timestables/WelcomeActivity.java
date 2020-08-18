package com.example.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class WelcomeActivity extends AppCompatActivity {

    public static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Welcome Page Start
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent welcomePage = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(welcomePage);
                finish();
            }
        }, SPLASH_TIME_OUT);
        // Welcome Page Finish
    }
}