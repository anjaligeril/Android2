package com.example.customlistviewdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    Context context;
    String[] fruit={"mango","banana","watermelon","grapes","apple","kiwi"};
    String[] desc={"this is mango","this is banana","this is watermelon","this is grapes","this is apple","this is kiwi"};
    public static int [] image={R.mipmap.mango,R.mipmap.banana,R.mipmap.watermelon,R.mipmap.grapes,R.mipmap.kiwi};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView ls=(ListView)findViewById(R.id.list);
        context=this;

        lv=(ListView) findViewById(R.id.list);
        lv.setAdapter(new CustomAdaptor(this, fruit,image,desc));
    }



}
