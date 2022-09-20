package com.example.foodapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "foodApp.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // need to create all the database tables here
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}
}
