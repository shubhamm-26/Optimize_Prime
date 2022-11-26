package com.example.placementcellapp;

import static com.example.placementcellapp.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class signup extends AppCompatActivity {

    EditText student_id, password;
    boolean passwordVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.signup1);
        getSupportActionBar().hide();

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button button = findViewById(R.id.signup);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                openDashboard();
            }
        });

        student_id = findViewById(id.studentID);
        password = findViewById(id.Password);

        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                final int Right = 2;

                if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                    if(motionEvent.getRawX() >= password.getRight()-password.getCompoundDrawables()[Right].getBounds().width()){
                        int selection = password.getSelectionEnd();
                        if(passwordVisible){
                            // set drawable image here
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0, drawable.password_invisible,0);
                            // for hide password
                            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible = false;
                        }
                        else{
                            password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0, drawable.password_visible,0);
                            // for show password
                            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible = true;
                        }
                        password.setSelection(selection);
                        return true;
                    }
                }
                return false;
            }
        });

    }

    public void openDashboard(){
        Intent intent = new Intent(this, dashboard.class);
        startActivity(intent);
    }

}