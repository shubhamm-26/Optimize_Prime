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
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

  TextView forgot_password;
  EditText student_id, pass;
  boolean passwordVisible;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.login);
    getSupportActionBar().hide();
    student_id = findViewById(R.id.studentID);
    pass = findViewById(R.id.Password);
    forgot_password=findViewById(R.id.forgot);

    forgot_password.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        openForgetpass();
      }
    });

    @SuppressLint({"MissingInflatedId", "LocalSuppress"})
    Button login_button = findViewById(R.id.Login);
    login_button.setOnClickListener(new View.OnClickListener()
    {@Override
      public void onClick(View v){
        String studentID = student_id.getText().toString();
        String password = pass.getText().toString();
        boolean check= validateinfo(studentID,password);
        if(check)
        {
        openDashboard();
        }
      }
    });
    @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView signup_button = findViewById(R.id.signup);
    signup_button.setOnClickListener(new View.OnClickListener()
    {
      @Override
      public void onClick(View v){
        opensignup();
      }
    });




    pass.setOnTouchListener(new View.OnTouchListener() {
      @Override
      public boolean onTouch(View view, MotionEvent motionEvent) {
        final int Right = 2;

        if(motionEvent.getAction() == MotionEvent.ACTION_UP){
          if(motionEvent.getRawX() >= pass.getRight()- pass.getCompoundDrawables()[Right].getBounds().width()){
            int selection = pass.getSelectionEnd();
            if(passwordVisible){
              // set drawable image here
              pass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0, R.drawable.password_invisible,0);
              // for hide password
              pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
              passwordVisible = false;
            }
            else{
              pass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0, R.drawable.password_visible,0);
              // for show password
              pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
              passwordVisible = true;
            }
            pass.setSelection(selection);
            return true;
          }
        }
        return false;
      }
    });

  }

  private void openForgetpass()
  {
    Intent intent = new Intent(this,forgot_pass.class);
    startActivity(intent);
  }

  private boolean validateinfo(String studentID, String password)
  {
    if(studentID.length()==0     || studentID.length()!=9) {
      student_id.requestFocus();
      student_id.setError("Please Enter a Valid ID");
      return false;
    }
    else if(pass.length()<=8)
    {
      pass.requestFocus();
      pass.setError("Minimum 8 Characters");
      return false;
    }

    else
      return true;
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
