package com.example.placementcellapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class signup extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        Button button = (Button) findViewById(R.id.signup);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openDashboard();
            }
        });
    }

    public void openDashboard(){
        Intent intent = new Intent(this, dashboard.class);
        startActivity(intent);
        getSupportActionBar().hide();
    }
}
