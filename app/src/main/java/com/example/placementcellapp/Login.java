package com.example.placementcellapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

  TextView forgot_password;
  EditText student_id, pass;
  boolean passwordVisible;

  FirebaseAuth mAuth;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();

    if(user!=null){
      startActivity(new Intent(Login.this,dashboard.class));
      finish();
    }





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

    @SuppressLint({"MissingInflatedId", "LocalSuppress"})
    TextView signup_button = findViewById(R.id.signup);
    signup_button.setOnClickListener(new View.OnClickListener() {
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

    mAuth = FirebaseAuth.getInstance();

    login_button.setOnClickListener(view ->{
      loginUser();
    });

    signup_button.setOnClickListener(view ->{
      startActivity(new Intent(Login.this,signup.class));
    });

  }

  private void loginUser(){
    String StudentID = student_id.getText().toString();
    String Password = pass.getText().toString();

    if(TextUtils.isEmpty(StudentID)){
      student_id.setError("Enter a Valid ID");
      student_id.requestFocus();
    }
    else if(TextUtils.isEmpty(Password)){
      pass.setError("Password cannot be empty");
      pass.requestFocus();
    }
    else if(Password.length()<=8){
      pass.setError("Password should be minimum 8 characters");
      pass.requestFocus();
    }
    else{
      mAuth.signInWithEmailAndPassword(StudentID,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
          if(task.isSuccessful()){
            Toast.makeText(Login.this,"Logged in successfully",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Login.this,nav_drawer.class));
          }
          else {
            Toast.makeText(Login.this,"Login Error: " + task.getException().getMessage(),Toast.LENGTH_SHORT).show();
          }
        }
      });
    }
  }

  private void openForgetpass()
  {
    Intent intent = new Intent(this,forgot_pass.class);
    startActivity(intent);
  }



  private void opensignup()
  {
    Intent intent = new Intent(this, signup.class);
    startActivity(intent);
  }


}
