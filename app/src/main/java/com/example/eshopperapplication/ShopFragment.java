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
public class ShopFragment extends Fragment {

    //GridView gridView;
    int[] imageIcons ;
    String[] imageNames;


    public ShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState);
        return inflater.inflate(R.layout.fragment_shop, container, false);




    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        imageIcons = new int[]{R.drawable.clothing, R.drawable.electronics, R.drawable.books, R.drawable.footwear};
        imageNames = new String[]{"Clothing", "Electronics", "Books", "Footwear"};
        GridView gridView = (GridView)getView().findViewById(R.id.gridView);

        final GridAdapter gridAdapter = new GridAdapter(getActivity(),imageIcons,imageNames);
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch(gridAdapter.getItem(position)){

                    case "Clothing":

                        Toast.makeText(getActivity(), "Clothing", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), Clothing.class);
                        startActivity(intent);
                        break;

                    case "Electronics":

                        Toast.makeText(getActivity(), "Electronics", Toast.LENGTH_SHORT).show();
                        break;

                    case "Books":

                        Toast.makeText(getActivity(), "Books", Toast.LENGTH_SHORT).show();
                        break;

                    case "Footwear":

                        Toast.makeText(getActivity(), "Footwear", Toast.LENGTH_SHORT).show();
                        break;

                }

            }
        });
    }
}
