package com.bwei.heqianqian20181203.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/12/3 0003.
 */

public class FlowDatabase extends SQLiteOpenHelper {
    SQLiteDatabase db;
    private final  static String TABLE_NAME="search";
    public FlowDatabase(Context context) {
        super(context, "bwei.db", null, 1);
        db=getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
         db.execSQL("create table "+TABLE_NAME+"(_id integer primary key autoincrement,keys text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insert(String keys){
        ContentValues values=new ContentValues();
        values.put("keys",keys);
        db.insert(TABLE_NAME,null,values);
    }
    public  void  delete(){
        db.delete(TABLE_NAME,null,null);
    }
    //查询
    public List<String> query(){
        Cursor cursor=db.query(TABLE_NAME,null,null,null,null,null,null);
        List<String> list=new ArrayList<>();
        while (cursor.moveToNext()){
            String keys = cursor.getString(cursor.getColumnIndex("keys"));
            list.add(keys);
        }
        return list;
    }

}
