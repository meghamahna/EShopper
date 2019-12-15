package com.example.eshopperapplication;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


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
    }
}
