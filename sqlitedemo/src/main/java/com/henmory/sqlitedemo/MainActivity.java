package com.henmory.sqlitedemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //测试数据库
    void testDatabase(){
        SQLiteDatabase db = MyDatabaseHelper.getDatabase(this);
        String sql;

        //insert
        sql = "insert into "  + MyDatabaseHelper.TABLE_NAME + " (username, password)"
                + " values ('henmory', 'changhong')";
        db.execSQL(sql);
        sql = "insert into " + MyDatabaseHelper.TABLE_NAME + "(username, password)"
                + " values ('hao de', 'ok')";
        db.execSQL(sql);

        //delete
        sql = "delete from " + MyDatabaseHelper.TABLE_NAME + " where username = 'henmory'";
        db.execSQL(sql);

        //modify
        sql = "update " + MyDatabaseHelper.TABLE_NAME + " set password = '123' where username = 'hao de'";
        db.execSQL(sql);

        //query
        sql = "select * from " + MyDatabaseHelper.TABLE_NAME + " where username = 'hao de'" ;
        Cursor c = db.rawQuery(sql, null);
        while (c.moveToNext()){
        }
    }
}
