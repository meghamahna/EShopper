package com.example.eshopperapplication;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Clothings extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    SearchView searchView;

    ListView listView;
    int[] imageIcons;


    ArrayList<customclass> newlist = new ArrayList<>();
    final ListAdapter listAdapter = new ListAdapter(this, newlist);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothings);

        newlist.add(new customclass(R.drawable.gap,"GAP"));
        newlist.add(new customclass(R.drawable.hollister,"Hollister"));
        newlist.add(new customclass(R.drawable.hnm,"HnM"));

        listView = findViewById(R.id.listView);

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch(newlist.get(position).imageNames){

                    case "GAP":
                        Intent intent = new Intent(Clothings.this, WebViewFile.class);
                        intent.putExtra("link", "https://www.gapcanada.ca");
                        startActivity(intent);
                        break;

                    case "Hollister":
                        Intent intent1 = new Intent(Clothings.this, WebViewFile.class);
                        intent1.putExtra("link", "https://www.hollisterco.com/shop/ca/sale");
                        startActivity(intent1);
                        break;

                    case "HnM":
                        Intent intent2 = new Intent(Clothings.this, WebViewFile.class);
                        intent2.putExtra("link", "https://www2.hm.com/en_ca/index.html");
                        startActivity(intent2);
                        break;
                }
            }
        });



    }

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.home){

            getSupportFragmentManager().beginTransaction().replace(R.id.container, new home()).commit();
        }else if (menuItem.getItemId() == R.id.contact) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new contact()).commit();
            Toast.makeText(Clothings.this, "contact selected", Toast.LENGTH_SHORT).show();
        }  else if (menuItem.getItemId() == R.id.feedback){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new feedback()).commit();
            Toast.makeText(Clothings.this, "feedback selected", Toast.LENGTH_SHORT).show();
        }
        else if (menuItem.getItemId() == R.id.about) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new rate()).commit();

        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) menuItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                ArrayList<customclass> results = new ArrayList<>();

                for (customclass c1 : newlist) {
                    if (c1.imageNames.contains(newText)) {
                        results.add(c1);
                    }

                    ( (ListAdapter)listView.getAdapter()).update(results);
                }


                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }


}

