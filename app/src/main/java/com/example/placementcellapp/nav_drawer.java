package com.example.placementcellapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;
import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;
import com.shrikanthravi.customnavigationdrawer2.data.MenuItem;


public class nav_drawer extends AppCompatActivity
{
    SNavigationDrawer sNavigationDrawer;
    Class fragmentClass;
    public static Fragment fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation);
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
    }
}
