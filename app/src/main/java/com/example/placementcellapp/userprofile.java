package com.example.placementcellapp;

import static android.content.Intent.getIntent;
import static android.content.Intent.getIntentOld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

public class userprofile extends Fragment {
    @Nullable
    Button Logout;
    TextView edit,name,student_id,skills,git,linkedin;


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.userprofile,container,false);

        Logout = root.findViewById(R.id.Logout);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openlogin();
            }
        });

        edit = root.findViewById(R.id.edit);
        name=root.findViewById(R.id.Name);
        student_id=root.findViewById(R.id.ID);
        skills = root.findViewById(R.id.skills);
        git = root.findViewById(R.id.github_profile);
        linkedin = root.findViewById(R.id.testlink);

        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        String id=user.getUid();
        FirebaseDatabase.getInstance().getReference().child("Users").child(id).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                    name.setText(task.getResult().child("name").getValue().toString());
                    skills.setText(task.getResult().child("skills").getValue().toString());
                    git.setText(task.getResult().child("github").getValue().toString());
                    linkedin.setText(task.getResult().child("linkedIn").getValue().toString());
                    String a=task.getResult().child("instituteEmail").getValue().toString();
                    student_id.setText(a.substring(0,9));



                }
            }
        });



        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editprof_first();
            }
        });
        return root;

    }



    private void openlogin()
    {
        Intent intent = new Intent(getActivity(),Login.class);
        FirebaseAuth.getInstance().signOut();
        startActivity(intent);

    }
    private void editprof_first()
    {
        Intent intent = new Intent(getActivity(),edit_first.class);
        startActivity(intent);

    }

}
