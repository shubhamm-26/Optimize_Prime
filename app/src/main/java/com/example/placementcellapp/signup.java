package com.example.placementcellapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        getSupportActionBar().hide();
    }
}
