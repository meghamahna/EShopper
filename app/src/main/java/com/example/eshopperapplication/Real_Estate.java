package com.example.eshopperapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Real_Estate extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    ListView listView;
    int[] imageIcons;
    String[] imageNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real__estate);

        imageIcons = new int[] {R.drawable.remax, R.drawable.century21, R.drawable.comfree};
        imageNames = new String[]{"RE/MAX", "Century21", "ComFree"};

        listView = findViewById(R.id.listView);

        final ListAdapter listAdapter = new ListAdapter(this, imageIcons, imageNames);
        listView.setAdapter(listAdapter);

        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolBar);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        setSupportActionBar(toolbar);
        //getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawerOpen,R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.home){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new home()).commit();
        }else if (menuItem.getItemId() == R.id.contact) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new contact()).commit();
            Toast.makeText(Real_Estate.this, "contact selected", Toast.LENGTH_SHORT).show();
        }  else if (menuItem.getItemId() == R.id.feedback){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new feedback()).commit();
            Toast.makeText(Real_Estate.this, "feedback selected", Toast.LENGTH_SHORT).show();
        }
        else if (menuItem.getItemId() == R.id.about) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new rate()).commit();
            Toast.makeText(Real_Estate.this, "about selected", Toast.LENGTH_SHORT).show();
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }

}
