package com.example.list2;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

 //final  ArrayList<String> users = new ArrayList<String>(Arrays.asList("john", "jane", "sam","alex","anu"));
 ArrayList<String> userDataFromDB=new ArrayList<>();
    EditText userName1;
    private ArrayAdapter userData;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
/*
       users.add("john");
         users.add("jane");
         users.add("alex");
         users.add("sam");   */
      /* adaptorUpdate(users);*/
        adaptorUpdate();

    }
  public void onClick(View v){
        userName1=(EditText)findViewById(R.id.listContent);
      // String userName = ((EditText)findViewById(R.id.listContent)).getText().toString();
     /* String userName =userName1.getText().toString();
      userName1.clearFocus();*/
        //      Toast.makeText(this,"update user"+userName,Toast.LENGTH_LONG).show();
     //  String name=userName.toString();
   /*   users.add(userName);*/
       //userData.notifyDataSetChanged();
   /*  adaptorUpdate(users);*/

      DBHelper dbH=new DBHelper(this);
      boolean result=dbH.addUser(userName1.getText().toString());
      if(result){
          Toast.makeText(this,"inserted successfully",Toast.LENGTH_LONG).show();
      }else{
          Toast.makeText(this,"failed",Toast.LENGTH_LONG).show();
      }
    /*  adaptorUpdate(users);*/

      adaptorUpdate();
   }

   public void adaptorUpdate(/*List users*/){

        DBHelper dbH=new DBHelper(this);
        Cursor data=dbH.getData();
        while(data.moveToNext()){
            userDataFromDB.add(data.getString(1));
        }
       userData=new ArrayAdapter<String>(this,R.layout.activity_list_component,R.id.listName,/*users*/userDataFromDB);
       ListView lv=(ListView)findViewById(R.id.list);
       lv.setAdapter(userData);
       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Toast.makeText(MainActivity.this,MainActivity.this.userDataFromDB.get(position),Toast.LENGTH_LONG).show();
               Intent userIntent=new Intent(MainActivity.this,userProfile.class);
               userIntent.putExtra("userName",MainActivity.this.userDataFromDB.get(position));
             // Toast.makeText(MainActivity.this,"position "+position,Toast.LENGTH_LONG).show();
              String position1=Integer.toString(position);
              userIntent.putExtra("position",position1);
               startActivity(userIntent);
          //  MainActivity.this.users.remove(position);
           //    adaptorUpdate(MainActivity.this.users);
           }
       });
      // Toast.makeText(this,"update user",Toast.LENGTH_LONG).show();
   }



}
