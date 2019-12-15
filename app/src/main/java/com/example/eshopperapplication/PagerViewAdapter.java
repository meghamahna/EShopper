package com.example.eshopperapplication;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PagerViewAdapter extends FragmentPagerAdapter {

    public PagerViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch(position){

            case 0: fragment = new ShopFragment();
                break;
            case 1: fragment = new ServicesFragment();
                break;

        }

        return fragment;
    }


    @Override
    public int getCount() {
        return 2;
    }
}
