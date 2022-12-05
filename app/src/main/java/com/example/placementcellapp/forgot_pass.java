package com.example.placementcellapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class forgot_pass extends AppCompatActivity {

    private EditText txtEmail1;
    private EditText txtEmail2;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.forgot_password);

        mAuth = FirebaseAuth.getInstance();
        txtEmail1 = findViewById(R.id.instEmail);
        txtEmail2 = findViewById(R.id.reinstEmail);
        Button buttongroup = findViewById(R.id.Reset);

        buttongroup.setOnClickListener(view -> validateData());
    }

    private void validateData(){
        String email1 = txtEmail1.getText().toString();
        String email2 = txtEmail2.getText().toString();

        if(email1.isEmpty()){
            txtEmail1.setError("Enter valid email address");
        }
        else if(!email1.equals(email2)){
            txtEmail2.setError("Both fields should match");
            txtEmail2.requestFocus();
        }
        else{
            forgotPass();
        }
    }

    private void forgotPass(){

        String email1 = txtEmail1.getText().toString();

        mAuth.sendPasswordResetEmail(email1).addOnCompleteListener(task -> {
            if(task.isSuccessful()){
                Toast.makeText(forgot_pass.this,"Please check email",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(forgot_pass.this,Login.class));
                finish();
            }
            else{
                Toast.makeText(forgot_pass.this,"Error: " + Objects.requireNonNull(task.getException()).getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}
