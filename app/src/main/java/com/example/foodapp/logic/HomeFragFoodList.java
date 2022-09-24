package com.example.foodapp.logic;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.foodapp.R;
import com.example.foodapp.database.DBCursor;
import com.example.foodapp.database.DBHelper;
import com.example.foodapp.database.FoodDeliverySchema.ResturantTable;
import com.example.foodapp.models.FoodItem;
import java.util.ArrayList;

public class HomeFragFoodList {

    private ArrayList<FoodItem> foodItems = new ArrayList<>();
    private SQLiteDatabase db;

    public HomeFragFoodList(Context context) {
        this.db = new DBHelper(context.getApplicationContext()).getWritableDatabase();
        if (DatabaseUtils.queryNumEntries(db, ResturantTable.NAME) == 0) {
            insertDataToResturantTable();
        }
    }

    // fix cursor
    public void load() {
        DBCursor cursor = new DBCursor(
                db.query(ResturantTable.NAME,
                        null,
                        null,
                        null,
                        null,
                        null,
                        null)
        );

        try {
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                foodItems.add(cursor.getFoodItem());
                cursor.moveToNext();
            }
        }
        finally {
            cursor.close();
        }
   }

    public int size() {
        return  foodItems.size();
    }

    public FoodItem get(int i) {
        return foodItems.get(i);
    }

    public void insertDataToResturantTable() {
        String[] resturantNames = {"KFC", "MC Donald's", "Burger King", "Dunkin Donut", "Popeye's",
                "Subway", "Pizza Hut", "Taco Bell", "Baskin Robins", "Starbucks"};

        String[] foodItemNames = {"Biryani", "Chicken Nuggets", "Chicken Rice", "Chocolate Sundae",
                "Cola", "Crisp Chicken", "Fries", "Happy Meal", "Oreo MFlurry", "Burger"};

        int[] foodImages = {R.drawable.cheese_lovers};

        int totalResturant = 10;

        ContentValues cv;
        for(int i = 0; i < totalResturant ; i++) {
            cv = new ContentValues();
            cv.put(ResturantTable.Cols.RESTURANT_ID, i + 1);
            cv.put(ResturantTable.Cols.RESTURANT_NAME, resturantNames[i]);
            cv.put(ResturantTable.Cols.FOOD_ITEM, foodItemNames[i]);
            cv.put(ResturantTable.Cols.PRICE, 10);
            cv.put(ResturantTable.Cols.DESCRIPTION, "This is a test desc");
            cv.put(ResturantTable.Cols.FOOD_IMAGE_REF, foodImages[0]);
            cv.put(ResturantTable.Cols.RESTURANT_LOGO_REF, foodImages[0]);
            db.insert(ResturantTable.NAME, null, cv);
        }
    }

}
