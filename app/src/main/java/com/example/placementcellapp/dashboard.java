package com.example.placementcellapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class dashboard extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        ImageSlider imageSlider = findViewById(R.id.image_slider);
        getSupportActionBar().hide();
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.google,"Google",ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.adobe,"Adobe",ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.mathworks,"Mathworks",ScaleTypes.FIT));
        imageSlider.setImageList(slideModels,ScaleTypes.FIT);
    }
}
