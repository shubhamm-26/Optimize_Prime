package com.example.placementcellapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class userprofile extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userprofile);

        getSupportActionBar().hide();
    }
}
