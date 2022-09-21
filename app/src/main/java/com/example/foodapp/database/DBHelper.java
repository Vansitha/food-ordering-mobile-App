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
        insertDataToResturantTable(db);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

    private void createCustomerTable(SQLiteDatabase db) {

    }

    private void createOrderTable(SQLiteDatabase db) {

    }

    private void createResturantTable(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + FoodDeliverySchema.ResturantTable.NAME + "(" +
                ResturantTable.Cols.RESTURANT_ID + "INTEGER, " +
                ResturantTable.Cols.RESTURANT_NAME + "VARCHAR, " +
                ResturantTable.Cols.FOOD_ITEM + "VARCHAR, " +
                ResturantTable.Cols.PRICE + "FLOAT, " +
                ResturantTable.Cols.FOOD_IMAGE_REF + "INTEGER, " +
                ResturantTable.Cols.RESTURANT_LOGO_REF + "INTEGER)");

    }

    private void insertDataToResturantTable(SQLiteDatabase db) {
        String[] resturantNames = {"KFC", "MC Donald's", "Burger King", "Dunkin Donut", "Popeye's",
                                "Subway", "Pizza Hut", "Taco Bell", "Baskin Robins", "Starbucks"};

        String[] foodItemNames = {"Biryani", "Chicken Nuggets", "Chicken Rice", "Chocolate Sundae",
                                "Cola", "Crisp Chicken", "Fries", "Happy Meal", "Oreo MFlurry", "Burger"};

        int[] foodImages = {R.drawable.mc_chicken_biryani, R.drawable.mc_chicken_nuggets, R.drawable.mc_chicken_rice,
                           R.drawable.mc_chocolate_sundae, R.drawable.mc_cola, R.drawable.mc_crisp_chicken, R.drawable.mc_fry,
                            R.drawable.mc_happy_meals, R.drawable.mc_oreo_mcflurry, R.drawable.burger};

        int totalResturant = 10;

        for(int i = 0; i < totalResturant ; i++) {
            ContentValues cv = new ContentValues();
            cv.put(ResturantTable.Cols.RESTURANT_ID, i + 1);
            cv.put(ResturantTable.Cols.RESTURANT_NAME, resturantNames[i]);
            cv.put(ResturantTable.Cols.FOOD_ITEM, foodItemNames[i]);
            cv.put(ResturantTable.Cols.PRICE, 10);
            cv.put(ResturantTable.Cols.FOOD_IMAGE_REF, R.drawable.burger);
            cv.put(ResturantTable.Cols.RESTURANT_LOGO_REF, R.drawable.burger);
            db.insert(ResturantTable.NAME, null, cv);
        }
    }
}