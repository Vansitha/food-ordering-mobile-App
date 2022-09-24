package com.example.foodapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.foodapp.R;
import com.example.foodapp.database.FoodDeliverySchema.ResturantTable;
import com.example.foodapp.database.FoodDeliverySchema.CustomerTable;
import com.example.foodapp.database.FoodDeliverySchema.OrderTable;

public class DBHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "foodApp.db";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // need to create all the database tables here
        createResturantTable(db);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

    private void createCustomerTable(SQLiteDatabase db) {

    }

    private void createOrderTable(SQLiteDatabase db) {

    }

    private void createResturantTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + ResturantTable.NAME + "(" +
                ResturantTable.Cols.RESTURANT_ID + " INTEGER, " +
                ResturantTable.Cols.RESTURANT_NAME + " TEXT, " +
                ResturantTable.Cols.FOOD_ITEM + " TEXT, " +
                ResturantTable.Cols.PRICE + " INTEGER, " +
                ResturantTable.Cols.DESCRIPTION + " TEXT, " +
                ResturantTable.Cols.FOOD_IMAGE_REF + " INTEGER, " +
                ResturantTable.Cols.RESTURANT_LOGO_REF + " INTEGER)");

    }


}