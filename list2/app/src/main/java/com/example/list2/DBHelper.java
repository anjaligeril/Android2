package com.example.list2;

import android.app.ActionBar;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DBHelper extends SQLiteOpenHelper {

    private static final String dbName="list";
    private static final String Table_name="users";
    private static final String COL0="id";
    private static final String COL1="name";
    public DBHelper(Context context){
        super(context,Table_name,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String create="create table "+Table_name+"(id integer primary key autoincrement,"+COL1+" text);";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addUser(String name){

        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL1,name);
       long result= db.insert(Table_name,null,cv);
       if(result==-1){
           return false;
       }
       else{
           return true;
       }
    }

    public Cursor getData(){
        SQLiteDatabase db=this.getWritableDatabase();
        String sql="select * from "+ Table_name;
        Cursor data=db.rawQuery(sql,null);
        return data;
    }

    public boolean updateData(String name,int id){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues data=new ContentValues();
        data.put(COL1,name);
        long result=db.update(Table_name, data, "id=" + id, null);
        //String strSQL = "UPDATE "+Table_name+" SET name "+name+" WHERE id = "+id;
       //db.rawQuery(strSQL,null);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
   }
    public void deleteData(int id){
        SQLiteDatabase db=this.getWritableDatabase();
        //  long result=db.delete(Table_name,  "id=" +id, null);
        //  String result1=Long.toString(result);
        //Log.i("result",result1);
        String sql1="select count(*) from users;";
        Cursor result=db.rawQuery(sql1,null);
        String sql="DELETE FROM users WHERE id=1;";
        db.execSQL(sql);
        String sql2="select count(*) from users;";
        db.rawQuery(sql2,null);
        Log.i("result",sql);
    }

}
