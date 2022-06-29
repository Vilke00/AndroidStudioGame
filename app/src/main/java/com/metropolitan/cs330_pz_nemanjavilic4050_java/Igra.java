package com.metropolitan.cs330_pz_nemanjavilic4050_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Igra extends AppCompatActivity {

    private LinearLayout parentLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        // Set the content of the activity
        // to use the activity_main.xml
        // layout file
        setContentView(R.layout.activity_igra);

        // Find the view pager that will
        // allow the user to swipe
        // between fragments
        ViewPager viewPager
                = (ViewPager)findViewById(
                R.id.viewpager);

        // Create an adapter that
        // knows which fragment should
        // be shown on each page
        SimpleFragmentPagerAdapter
                adapter
                = new SimpleFragmentPagerAdapter(
                getSupportFragmentManager());

        // Set the adapter onto
        // the view pager
        viewPager.setAdapter(adapter);

        //parentLinearLayout=(LinearLayout) findViewById(R.id.parentLayout);

    }

}