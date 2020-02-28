package com.example.instagram;



import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

//import androidx.fragment.app.FragmentPagerAdapter;

public class CustomPagerAdapter extends FragmentPagerAdapter {
    private  List<Fragment> fragmentList;


    public CustomPagerAdapter(FragmentManager fm, List<Fragment> fragmentList){
        super(fm);

        this.fragmentList=fragmentList;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }



}


