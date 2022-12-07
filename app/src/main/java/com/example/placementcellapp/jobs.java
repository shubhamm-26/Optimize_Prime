package com.example.placementcellapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class jobs extends Fragment {
    RecyclerView recyclerView;
    List<DataClass> dataList;
    Adapter adapter;
    DataClass androidData;
    SearchView searchView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.activity_apply,container,false);
        recyclerView = root.findViewById(R.id.recyclerview);
        searchView = root.findViewById(R.id.search);

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

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 1);
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

        adapter = new Adapter(getActivity(),dataList);
        recyclerView.setAdapter(adapter);
        return root;
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