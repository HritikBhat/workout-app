package com.example.workoutapp;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.PagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class home extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //fragments

        adapter.AddFragment(new excersisefrag(), "Excersise");
        adapter.AddFragment(new dietfrag(), "DietPlane");
        adapter.AddFragment(new videosfrag(), "Videos");
        adapter.AddFragment(new paymentfrag(), "Payment");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);




    }
}