package com.example.eshopperapplication;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class ServicesFragment extends Fragment {

    int[] imageIcons ;
    String[] imageNames;


    public ServicesFragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        return inflater.inflate(R.layout.fragment_services, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        imageIcons = new int[]{R.drawable.real_estate, R.drawable.travel, R.drawable.entertainment, R.drawable.food};
        imageNames = new String[]{"Real Estate", "Travel", "Entertainment", "Food"};
        GridView gridView = (GridView)getView().findViewById(R.id.gridView);

        final GridAdapter gridAdapter = new GridAdapter(getActivity(),imageIcons,imageNames);
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (gridAdapter.getItem(position)) {

                    case "Real Estate":

                        Toast.makeText(getActivity(), "Real Estate", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), Real_Estate.class);
                        startActivity(intent);
                        break;

                    case "Travel":

                        Toast.makeText(getActivity(), "Travel", Toast.LENGTH_SHORT).show();
                        Intent intent1 = new Intent(getActivity(), Travel.class);
                        startActivity(intent1);
                        break;

                    case "Entertainment":

                        Toast.makeText(getActivity(), "Entertainment", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(getActivity(), Entertainment.class);
                        startActivity(intent2);
                        break;

                    case "Food":

                        Toast.makeText(getActivity(), "Food", Toast.LENGTH_SHORT).show();
                        break;

                }
            }
        });
    }
}
