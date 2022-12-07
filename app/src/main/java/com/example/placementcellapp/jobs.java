package com.example.placementcellapp;

import android.app.Fragment;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class jobs extends AppCompatActivity {
    RecyclerView recyclerView;
    List<DataClass> dataList;
    Adapter adapter;
    DataClass androidData;
    SearchView searchView;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_apply);
        recyclerView = findViewById(R.id.recyclerview);
        searchView = findViewById(R.id.search);

        searchView.clearFocus();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(jobs.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList = new ArrayList<>();

        androidData = new DataClass("Adobe",R.string.adobedesc,"SDE-1",R.drawable.adobe);
        dataList.add(androidData);

        androidData = new DataClass("Google",R.string.googledesc,"Manager",R.drawable.google);
        dataList.add(androidData);

        androidData = new DataClass("Goldmann Sachs",R.string.sachs,"Associate Engineer",R.drawable.sachs);
        dataList.add(androidData);

        androidData = new DataClass("Twitter",R.string.twitter,"Worker",R.drawable.twitter);
        dataList.add(androidData);

        androidData = new DataClass("Mathworks",R.string.mworks,"System Manager",R.drawable.mathworks);
        dataList.add(androidData);

        androidData = new DataClass("Adobe",R.string.adobe,"SDE-1",R.drawable.adobe);
        dataList.add(androidData);

        androidData = new DataClass("Google",R.string.google,"Manager",R.drawable.google);
        dataList.add(androidData);

        androidData = new DataClass("Goldmann Sachs",R.string.sachs,"Associate Engineer",R.drawable.sachs);
        dataList.add(androidData);

        androidData = new DataClass("Twitter",R.string.twitter,"Worker",R.drawable.twitter);
        dataList.add(androidData);

        androidData = new DataClass("Mathworks",R.string.mworks,"System Manager",R.drawable.mathworks);
        dataList.add(androidData);

        adapter = new Adapter(jobs.this,dataList);
        recyclerView.setAdapter(adapter);

    }

    private void searchList(String text){
        List<DataClass> dataSearchList = new ArrayList<>();
        for(DataClass data: dataList){
            if(data.getDataTitle().toLowerCase().contains(text.toLowerCase())){
                dataSearchList.add(data);
            }
        }
        if(dataSearchList.isEmpty()){

        }
        else{
            adapter.setSearchList(dataSearchList);
        }
    }

}