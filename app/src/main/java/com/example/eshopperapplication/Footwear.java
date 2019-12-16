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

public class Footwear extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    ListView listView;
    int[] imageIcons;
    String[] imageNames;

    ArrayList<customclass> newlist = new ArrayList<>();
    final ListAdapter listAdapter = new ListAdapter(this, newlist);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footwear);

        newlist.add(new customclass(R.drawable.sketchers,"Sketchers"));
        newlist.add(new customclass(R.drawable.footlocker,"Foot Locker"));
        newlist.add(new customclass(R.drawable.timberland,"Timberland"));



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

                    case "Sketchers":
                        Intent intent = new Intent(Footwear.this, WebViewFile.class);
                        intent.putExtra("link", "https://www.skechers.com/en-ca/");
                        startActivity(intent);
                        break;


                    case "Foot Locker":
                        Intent intent1 = new Intent(Footwear.this, WebViewFile.class);
                        intent1.putExtra("link", "https://www.footlocker.ca");
                        startActivity(intent1);
                        break;

                    case "Timberland":
                        Intent intent2 = new Intent(Footwear.this, WebViewFile.class);
                        intent2.putExtra("link", "https://www.timberland.ca");
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
            Toast.makeText(Footwear.this, "contact selected", Toast.LENGTH_SHORT).show();
        }  else if (menuItem.getItemId() == R.id.feedback){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new feedback()).commit();
            Toast.makeText(Footwear.this, "feedback selected", Toast.LENGTH_SHORT).show();
        }
        else if (menuItem.getItemId() == R.id.about) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new rate()).commit();
            Toast.makeText(Footwear.this, "about selected", Toast.LENGTH_SHORT).show();
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
