package com.example.placementcellapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class dashboard extends Fragment
{
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
                ViewGroup root = (ViewGroup) inflater.inflate(R.layout.dashboard,container,false);
        //Image Slider
        ImageSlider imageSlider = root.findViewById(R.id.image_slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.google,"Google",ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.adobe,"Adobe",ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.mathworks,"Mathworks",ScaleTypes.FIT));
        imageSlider.setImageList(slideModels,ScaleTypes.FIT);


                return root;
        }}
