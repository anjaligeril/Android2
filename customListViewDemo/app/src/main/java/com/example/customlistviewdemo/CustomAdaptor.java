package com.example.customlistviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomAdaptor extends BaseAdapter {

    String [] fruitName;
    String [] description;
    Context context;
    int [] imageFruit;
    private static LayoutInflater inflater=null;

    public CustomAdaptor(MainActivity mainActivity, String[] fruit, int[] image,String[] fruitDescription) {

        fruitName=fruit;
        context=mainActivity;
        imageFruit=image;
        description=fruitDescription;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return fruitName.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    private class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        View rowView;
        rowView = inflater.inflate(R.layout.activity_list_item, null);
        TextView tv=(TextView) rowView.findViewById(R.id.name);
        TextView tv1=(TextView) rowView.findViewById(R.id.description);
        ImageView img=(ImageView) rowView.findViewById(R.id.image);
        tv.setText(fruitName[position]);
        tv1.setText(description[position]);
        img.setImageResource(imageFruit[position]);


        return rowView;
    }
}