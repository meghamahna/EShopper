package com.example.eshopperapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class home extends Fragment {

    TextView shops, services;
    ViewPager viewPager;
    PagerViewAdapter pagerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home_frag, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        shops = (TextView) getView().findViewById(R.id.shop);
        services = getView().findViewById(R.id.services);
        viewPager = getView().findViewById(R.id.viewPager);

        PagerViewAdapter pagerViewAdapter = new PagerViewAdapter(getChildFragmentManager());
        viewPager.setAdapter(pagerViewAdapter);
        shops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });

        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                onChangeTab(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
        private void onChangeTab(int position) {

            if (position == 0) {

                shops.setTextSize(30);
                services.setTextSize(25);
            } else if (position == 1) {

                shops.setTextSize(25);
                services.setTextSize(30);
            }

    }

}