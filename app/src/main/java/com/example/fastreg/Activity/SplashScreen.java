package com.example.fastreg.Activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.fastreg.R;

public class SplashScreen extends AppCompatActivity {
    private static final String TAG = "SplashScreen";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread mySplash = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);

                    Intent intent = new Intent(SplashScreen.this, Home.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        };
        mySplash.start();
    }


    }
