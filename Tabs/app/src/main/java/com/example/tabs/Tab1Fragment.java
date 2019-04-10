package com.example.tabs;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1Fragment extends Fragment {


   ArrayList<String> users = new ArrayList<String>(Arrays.asList("John"));
    public Tab1Fragment() {
        // Required empty public constructor
    }

View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //return inflater.inflate(R.layout.fragment_tab1, container, false);
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);
        this.v=view;
        ListView lv= (ListView)view.findViewById(R.id.list);
        lv.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.activity_urgent_item,R.id.itemUrgent , users));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DBHelper dbH = new DBHelper(getActivity());

                dbH.deleteData(position+1);
                updateList();
            }
        });
        ImageButton button = (ImageButton)view.findViewById(R.id.add);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText newUser = (EditText)getView().findViewById(R.id.addItem);

                        // users.add(newUser.getText().toString());

                        DBHelper dbH = new DBHelper(getActivity());

                        boolean result = dbH.addItem(newUser.getText().toString());
                         updateList();
                    }
                }
        );

         updateList();
        return view;

    }

    public void updateList(){

        ListView lv = (ListView)v.findViewById(R.id.list);
        ArrayList<String> userDataFromDB = new ArrayList<>();

        DBHelper dbH = new DBHelper(getActivity());

        Cursor data = dbH.getData();

        while(data.moveToNext()){

            userDataFromDB.add(data.getString(1));

        }
        lv.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.activity_urgent_item,R.id.itemUrgent , userDataFromDB));
}



}
