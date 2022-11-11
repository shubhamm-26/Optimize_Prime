package com.example.placementcellapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        Intent login=new Intent(MainActivity.this,Login.class);
        Handler handlee=new Handler();
        handlee.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(login);
            }
        },3000);
    }
}