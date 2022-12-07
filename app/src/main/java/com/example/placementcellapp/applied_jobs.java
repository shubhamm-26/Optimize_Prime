package com.example.placementcellapp;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class applied_jobs extends AppCompatActivity {
    String a;
    String b;
    String c;
    String d;

    @Nullable

    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_applied_jobs);

        ImageView imageView = findViewById(R.id.img2);
        TextView post = findViewById(R.id.post2);
        TextView title = findViewById(R.id.comp_name2);
        TextView desc = findViewById(R.id.po2);


        FirebaseDatabase.getInstance().getReference().child("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("applied_jobs").get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.d("Heloo", "Some error");
                } else {
                    a = task.getResult().child("a").getValue().toString();
                    b = task.getResult().child("b").getValue().toString();
                    c = task.getResult().child("c").getValue().toString();
                    d = task.getResult().child("d").getValue().toString();
                    Log.d("Hello", a + " " + b + " " + c + " " + d);

                    imageView.setImageDrawable(getDrawable(Integer.parseInt(d)));
                    title.setText(task.getResult().child("a").getValue().toString());
                    desc.setText(getString(Integer.parseInt(b)));
                    post.setText(c);


                }
            }
        });

    }

}
