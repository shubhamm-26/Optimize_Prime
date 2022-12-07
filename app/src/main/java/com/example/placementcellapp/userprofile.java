package com.example.placementcellapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class userprofile extends Fragment {
    @Nullable
    Button Logout;
    TextView edit;
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
        startActivity(intent);
    }
    private void editprof_first()
    {
        Intent intent = new Intent(getActivity(),edit_first.class);
        startActivity(intent);
    }

}
