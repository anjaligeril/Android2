package com.example.list2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class userProfile extends AppCompatActivity {

    public String name;
    public  int position1;
    public EditText userName1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        Intent userIntent = getIntent();
        name=userIntent.getStringExtra("userName");
        String position=userIntent.getStringExtra("position");
        //TextView userName=(TextView)findViewById(R.id.name);
        position1=Integer.parseInt(position);
        //Toast.makeText(this,"position "+position,Toast.LENGTH_LONG).show();

        userName1=(EditText)findViewById(R.id.userName1);
        userName1.setText(name);
    }

    public void updateBtn(View v) {

            String name = userName1.getText().toString();
        if (name != "") {
            DBHelper dbH = new DBHelper(this);
            boolean up = dbH.updateData(name, position1 + 1);
            userName1.setText("");
            if (up) {
                Toast.makeText(this, "success ", Toast.LENGTH_LONG).show();
                Intent mainPageIntent = new Intent(this, MainActivity.class);
                startActivity(mainPageIntent);

            } else {
                Toast.makeText(this, "failed ", Toast.LENGTH_LONG).show();
            }
       }else{
            Toast.makeText(this, "failed ", Toast.LENGTH_LONG).show();
        }
    }

    public void deleteBtn(View v){
        DBHelper dbH = new DBHelper(this);
dbH.deleteData(position1+1);

            Intent mainPageIntent = new Intent(this, MainActivity.class);
            startActivity(mainPageIntent);


    }
}
