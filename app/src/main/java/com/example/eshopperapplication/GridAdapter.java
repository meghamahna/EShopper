package com.example.eshopperapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class GridAdapter extends BaseAdapter {

    Context context;
    int[] imageIcons;
    String[] imageNames;

    public GridAdapter(Context context, int[] imageIcons, String[] imageNames) {
        this.context = context;
        this.imageIcons = imageIcons;
        this.imageNames = imageNames;
    }

    @Override
    public int getCount() {
        return imageNames.length;
    }

    @Override
    public String getItem(int position) {

        return imageNames[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.grid_cell_item, null);

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView = convertView.findViewById(R.id.icon_text);
        imageView.setImageResource(imageIcons[position]);
        textView.setText(imageNames[position]);
        return convertView;
    }
}
