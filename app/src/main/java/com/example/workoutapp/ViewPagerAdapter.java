package com.example.workoutapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> oneFragment = new ArrayList<>();
    private final List<String> oneTitles = new ArrayList<>();

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        return oneFragment.get(position);
    }

    @Override
    public int getCount() {
        return oneTitles.size();
    }
    public CharSequence getPageTitle(int position){
        return oneTitles.get(position);

    }
    public void AddFragment(Fragment fragment,String title){
        oneFragment.add(fragment);
        oneTitles.add(title);
    }
}
