package com.example.placementcellapp;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class dashboard extends Fragment
{
        TabLayout tabLayout;
        ViewPager2 viewPager2;
        TextView link;
        tab_adapter adapter;

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
                ViewGroup root = (ViewGroup) inflater.inflate(R.layout.dashboard,container,false);
                tabLayout = root.findViewById(R.id.tablayout);
                viewPager2 = root.findViewById(R.id.view_pager2);
                tabLayout.addTab(tabLayout.newTab().setText("BTech"));
                tabLayout.addTab(tabLayout.newTab().setText("MTech"));
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                adapter = new tab_adapter(fragmentManager,getLifecycle());
                viewPager2.setAdapter(adapter);
                tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                        @Override
                        public void onTabSelected(TabLayout.Tab tab) {
                                viewPager2.setCurrentItem(tab.getPosition());
                        }

                        @Override
                        public void onTabUnselected(TabLayout.Tab tab) {

                        }

                        @Override
                        public void onTabReselected(TabLayout.Tab tab) {

                        }
                });
                viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
                        @Override
                        public void onPageSelected(int position) {
                                tabLayout.selectTab(tabLayout.getTabAt(position));
                        }
                });

        //Image Slider
        ImageSlider imageSlider = root.findViewById(R.id.image_slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.google,"Google",ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.adobe,"Adobe",ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.mathworks,"Mathworks",ScaleTypes.FIT));
        imageSlider.setImageList(slideModels,ScaleTypes.FIT);

        //hyperlink
                link = root.findViewById(R.id.stats);
                link.setMovementMethod(LinkMovementMethod.getInstance());

                return root;
        }}
