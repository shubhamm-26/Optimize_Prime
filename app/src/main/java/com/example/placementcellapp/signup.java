package com.example.placementcellapp;

import static com.example.placementcellapp.R.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class signup extends AppCompatActivity {

    EditText instituteEmail, password,name,mobile,skills,linkedin,github;
    TextView login;
    boolean passwordVisible;
    FirebaseAuth mAuth;

    DatabaseReference firebaseDatabase;

    @SuppressLint({})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.signup1);
        Objects.requireNonNull(getSupportActionBar()).hide();

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button button = findViewById(R.id.signup);
        button.setOnClickListener(v -> openDashboard());

                        Log.d("Hello","done");
        instituteEmail = findViewById(R.id.instEmail);
        password = findViewById(R.id.Password);
        name = findViewById(R.id.name);
        mobile = findViewById(R.id.mobile);
        login = findViewById(R.id.Login);
        skills = findViewById(id.Skills);
        linkedin=findViewById(id.LinkedInURl);
        github=findViewById(id.github_profile);
        password.setOnTouchListener((view, motionEvent) -> {
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
        });


        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance().getReference("Students");

        button.setOnClickListener(view -> createUser());

        login.setOnClickListener(view -> startActivity(new Intent(signup.this,Login.class)));

    }

    private void createUser(){
        String InstituteEmail = instituteEmail.getText().toString();
        String Password = password.getText().toString();
        String Mobile = mobile.getText().toString();
        String Name = name.getText().toString();
        String Skills = skills.getText().toString();
        String Github = github.getText().toString();
        String LinkedIn = linkedin.getText().toString();

        if(TextUtils.isEmpty(InstituteEmail)){
            instituteEmail.setError("Enter Valid Student ID");
            instituteEmail.requestFocus();
        }
        else if(TextUtils.isEmpty(Password)){
            password.setError("Password cannot be empty");
        }
        else if(Password.length()<=8){
            password.setError("Password should be minimum 8 characters");
            password.requestFocus();
        }
        else if(Mobile.length() != 10){
            mobile.setError("Mobile Number should be 10 digits");
            mobile.requestFocus();
        }
        else if(TextUtils.isEmpty(Name) &&TextUtils.isEmpty(Skills)){
            name.setError("This field is required");
            name.requestFocus();
        }
        else{
            sign_up(Name,Mobile,InstituteEmail,Password,Skills,Github,LinkedIn);
        }
    }

    public void openDashboard(){
        Intent intent = new Intent(this, dashboard.class);
        startActivity(intent);
    }
    public void sign_up(String Name,String Mobile,String InstituteEmail,String Password,String Skills,String LinkedIn,String Github){

        mAuth.createUserWithEmailAndPassword(InstituteEmail, Password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                students information = new students(Name,InstituteEmail,Mobile,Skills,LinkedIn,Github);
                Toast.makeText(signup.this, "Registration Completed", Toast.LENGTH_SHORT).show();
                FirebaseDatabase.getInstance().getReference().child("Users").child(user.getUid().toString()).setValue(information);
                openDashboard();
            } else {

                Toast.makeText(signup.this, "Registration Error:" + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}