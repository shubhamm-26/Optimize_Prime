package com.example.placementcellapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

  EditText student_id, password;
  boolean passwordVisible;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.lin);
    getSupportActionBar().hide();


    @SuppressLint({"MissingInflatedId", "LocalSuppress"})
    Button login_button = findViewById(R.id.Login);
    login_button.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v){
        openDashboard();
      }
    });
    @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button signup_button = findViewById(R.id.signup);
    signup_button.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v){
        opensignup();
      }
    });

    student_id = findViewById(R.id.studentID);
    password = findViewById(R.id.Password);

    password.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View view, MotionEvent motionEvent) {
        final int Right = 2;

        if(motionEvent.getAction() == MotionEvent.ACTION_UP){
          if(motionEvent.getRawX() >= password.getRight()-password.getCompoundDrawables()[Right].getBounds().width()){
            int selection = password.getSelectionEnd();
            if(passwordVisible){
              // set drawable image here
              password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0, R.drawable.password_invisible,0);
              // for hide password
              password.setTransformationMethod(PasswordTransformationMethod.getInstance());
              passwordVisible = false;
            }
            else{
              password.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0, R.drawable.password_visible,0);
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

  private void opensignup()
  {
    Intent intent = new Intent(this, signup.class);
    startActivity(intent);
  }

  public void openDashboard(){
    Intent intent = new Intent(this, nav_drawer.class);
    startActivity(intent);
  }
}
