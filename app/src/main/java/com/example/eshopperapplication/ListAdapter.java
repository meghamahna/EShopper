package com.example.eshopperapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter{

    Context context;

    ArrayList<customclass> newlist;


    public ListAdapter(Context context, ArrayList<customclass> newlist) {
        this.context = context;
        this.newlist = newlist;
    }

    public  void update(ArrayList<customclass> results){
        newlist = new ArrayList<>();
        newlist.addAll(results);
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return newlist.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.list_cell_item, null);
        customclass c = newlist.get(position);
        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView = convertView.findViewById(R.id.icon_text);
        imageView.setImageResource(c.getImageIcons());
        textView.setText(c.imageNames);
        return convertView;
    }
}
