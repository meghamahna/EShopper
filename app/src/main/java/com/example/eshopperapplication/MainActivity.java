package com.example.eshopperapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView shops, services;
    ViewPager viewPager;
    PagerViewAdapter pagerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shops = (TextView) findViewById(R.id.shop);
        services = findViewById(R.id.services);
        viewPager = findViewById(R.id.viewPager);

        PagerViewAdapter pagerViewAdapter = new PagerViewAdapter(getSupportFragmentManager());
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

        if(position == 0){

            shops.setTextSize(30);
            services.setTextSize(25);
        }

        else if(position == 1){

            shops.setTextSize(25);
            services.setTextSize(30);
        }
    }

}
