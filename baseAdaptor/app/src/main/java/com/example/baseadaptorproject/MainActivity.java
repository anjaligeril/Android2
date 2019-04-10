package com.example.baseadaptorproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String[] BrandName = new String[]{"iPhone", "Samsung", "Nokia", "HTC", "Moto"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mList = (ListView) findViewById(R.id.list);
        MyListAdapter mAdapter = new MyListAdapter();
        mList.setAdapter(mAdapter);
    }

    private class MyListAdapter extends BaseAdapter {

        @Override
        public int getCount(){

            if(BrandName != null && BrandName.length != 0 )
            {
                return BrandName.length;
            }
            return 0;
        }

        @Override
        public  Object getItem (int position)
        {
            return BrandName[position];
        }

        @Override
        public long getItemId (int position)
        {
            return  position;
        }

        private  class ViewHolder
        {
            TextView txtBrandName;
            int ref;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent)
        {
            final ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                LayoutInflater inflater = MainActivity.this.getLayoutInflater();
                convertView = inflater.inflate(R.layout.activity_item_list, null);
                holder.txtBrandName = (TextView) convertView.findViewById(R.id.itemName);

                convertView.setTag(holder);
            }
            else{
                holder = (ViewHolder) convertView.getTag();
            }

            holder.ref=position;
            holder.txtBrandName.setText(BrandName[position]);

            return convertView;
        }
    }
}
