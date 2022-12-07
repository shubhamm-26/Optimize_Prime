package com.example.placementcellapp;

import static android.app.PendingIntent.getActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class edit_first extends AppCompatActivity {
    Button next,back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editprofile_first);
        next = findViewById(R.id.Next);
        back = findViewById(R.id.Back);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 nextpage();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backpage();
            }
        });
    }
    private void backpage()
    {
        Intent intent = new Intent(getApplicationContext(),userprofile.class);
        startActivity(intent);
    }
    private void nextpage()
    {
        Intent intent = new Intent(getApplicationContext(),edit_second.class);
        startActivity(intent);
    }
}
