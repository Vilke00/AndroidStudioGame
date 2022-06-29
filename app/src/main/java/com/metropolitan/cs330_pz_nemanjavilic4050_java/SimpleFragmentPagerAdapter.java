package com.metropolitan.cs330_pz_nemanjavilic4050_java;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SimpleFragmentPagerAdapter
        extends FragmentPagerAdapter {

    public SimpleFragmentPagerAdapter(
            FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        if (position == 0) {
            return new Fragment1();
        }
        else if (position == 1) {
            return new Fragment2();
        }
        else {
            return new Fragment3();        }
    }

    @Override
    public int getCount()
    {
        return 3;
    }
}