package com.example.finalprojectmobilelnt_raihansyabana;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final String database_name = "db_login";
    public static final String table_name = "table_login";

    public static final String rov_id = "_id";
    public static final String rov_username = "Username";
    public static final String rov_password = "Password";

    private SQLiteDatabase db;

    public DBHelper (Context context){
        super(context, database_name, factory: null, version 2);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate (SQLiteDatabase db) {
        String query = "CREATE TABLE" + table_name + "(" + rov_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + rov_username + "TEXT" + rov_password + "TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS") + table_name;
    }

    //Insert Data
    public void insertData (ContentValues values){
        db.insert(table_name, null, values);
    }

    public boolean checkUser (String Username, String password){
        String[] columns = {rov_id};
        SQLiteDatabase db = getReadableDatabase();
        String selection = rov_username + "=?" + " and " + rov_password + "=?";
        String[] selectionArga = {username,password};
        Cursor cursor = db.query(, columns, selection, selectionArga, groupBy: null, having: null, orderBy: null);
        int count = cursor.getCount();
        cursor.close();
        db.close();

        if (count>0)
            return true;
        else
            return false;
    }
}
