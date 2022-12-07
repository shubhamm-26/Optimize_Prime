package com.example.placementcellapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;



public class tab_adapter extends FragmentStateAdapter
{
    private final String[] fragmenttitle = new String[]{"BTech", "MTech"};

    public tab_adapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }


    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if(position==1)
        {
            return new tab_news();
        }
        else return new tab_events();
    }



    @Override
    public int getItemCount() {
        return 2;
    }
}

