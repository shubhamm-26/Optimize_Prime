package com.example.placementcellapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

import java.util.ArrayList;
import java.util.List;

public class dashboard extends AppCompatActivity{
    SNavigationDrawer sNavigationDrawer;
    Class fragmentClass;
    public static Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        //Image Slider
        ImageSlider imageSlider = findViewById(R.id.image_slider);
        getSupportActionBar().hide();
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.google,"Google",ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.adobe,"Adobe",ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.mathworks,"Mathworks",ScaleTypes.FIT));
        imageSlider.setImageList(slideModels,ScaleTypes.FIT);


        sNavigationDrawer = findViewById(R.id.nav_drawer);
        List<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem("Home",R.drawable.profile_icon));
        menuItems.add(new MenuItem("Profile",R.drawable.profile_icon));
        menuItems.add(new MenuItem("Apply For jobs",R.drawable.apply_icon));
        menuItems.add(new MenuItem("Applied Jobs",R.drawable.applied_jobs_icon));


        sNavigationDrawer.setMenuItemList(menuItems);
        fragmentClass =  dashboard.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frame_layout, fragment).commit();
        }

        sNavigationDrawer.setOnMenuItemClickListener(new SNavigationDrawer.OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int position) {
                System.out.println("Position "+position);

                switch (position){
                    case 0:{
                        fragmentClass = dashboard.class;
                        break;
                    }
                    case 1:{
                        fragmentClass = userprofile.class;
                        break;
                    }
                    case 2:{
                        fragmentClass = applied_jobs.class;
                        break;
                    }
                    case 3:{
                        fragmentClass = apply.class;
                        break;
                    }

                }

                //Listener for drawer events such as opening and closing.
                sNavigationDrawer.setDrawerListener(new SNavigationDrawer.DrawerListener() {

                    @Override
                    public void onDrawerOpened() {

                    }

                    @Override
                    public void onDrawerOpening(){

                    }

                    @Override
                    public void onDrawerClosing(){
                        System.out.println("Drawer closed");

                        try {
                            fragment = (Fragment) fragmentClass.newInstance();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        if (fragment != null) {
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            fragmentManager.beginTransaction().setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out).replace(R.id.frame_layout, fragment).commit();

                        }
                    }

                    @Override
                    public void onDrawerClosed() {

                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        System.out.println("State "+newState);
                    }
                });
            }
        });

}}
