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

    private String[] resturantNames = {"KFC", "MC Donald's", "Burger King", "Dunkin Donut", "Popeye's",
            "Subway", "Pizza Hut", "Taco Bell", "Baskin Robbins", "Starbucks"};

    private String[] foodItemNames = {"Biryani", "Chicken Nuggets", "Chicken Rice", "Chocolate Sundae",
            "Cola", "Crisp Chicken", "Fries", "submarine", "Oreo MFlurry", "Burger"};


    private int[] foodImages = {R.drawable.biriyani, R.drawable.chicken_nuggets, R.drawable.chicken_rice,
                                R.drawable.chocolate_sundae, R.drawable.cola, R.drawable.crisp_chicken,
                                R.drawable.fries, R.drawable.submarine, R.drawable.oreo_mcflury,
                                R.drawable.burger};

    private int[] resturantImages = {R.drawable.kfc_logo, R.drawable.mcdonalds_logo, R.drawable.burger_king_logo,
                                    R.drawable.dunkin_donuts_logo, R.drawable.popeyes_logo, R.drawable.subway_logo,
                                    R.drawable.pizza_hut_logo, R.drawable.taco_bell_logo, R.drawable.baskin_robins_logo,
                                    R.drawable.star_bucks_logo};

    private int[] prices = {15, 10, 13, 20, 3, 15, 22, 17, 19, 21};

    public HomeFragFoodList(Context context) {
        this.db = new DBHelper(context.getApplicationContext()).getWritableDatabase();
        if (DatabaseUtils.queryNumEntries(db, ResturantTable.NAME) == 0) {
            insertDataToResturantTable();
        }
    }

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

   public int[] getResturantImageList() {
        return resturantImages;
   }

   public String[] getResturantNameList() {
        return resturantNames;
   }

    public int size() {
        return  foodItems.size();
    }

    public FoodItem get(int i) {
        return foodItems.get(i);
    }

    public ArrayList<FoodItem> getFoodList() {
        return foodItems;
    }

    public void insertDataToResturantTable() {

        ContentValues cv;
        for(int i = 0; i < resturantNames.length ; i++) {
            int id = i + 1;
            for(int j = 0 ; j < foodItemNames.length; j++) {
                cv = new ContentValues();
                cv.put(ResturantTable.Cols.RESTURANT_ID, id);
                cv.put(ResturantTable.Cols.RESTURANT_NAME, resturantNames[i]);
                cv.put(ResturantTable.Cols.FOOD_ITEM, foodItemNames[j]);
                cv.put(ResturantTable.Cols.PRICE, prices[j]);
                cv.put(ResturantTable.Cols.DESCRIPTION, "This is the description for " + foodItemNames[j] + " offered by " + resturantNames[i]);
                cv.put(ResturantTable.Cols.FOOD_IMAGE_REF, foodImages[j]);
                cv.put(ResturantTable.Cols.RESTURANT_LOGO_REF, resturantImages[i]);
                db.insert(ResturantTable.NAME, null, cv);
            }
        }
    }

}
