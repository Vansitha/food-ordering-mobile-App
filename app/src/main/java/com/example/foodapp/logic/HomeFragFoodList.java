package com.example.foodapp.logic;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.foodapp.R;
import com.example.foodapp.database.DBCursor;
import com.example.foodapp.database.DBHelper;
import com.example.foodapp.database.FoodDeliverySchema.ResturantTable;
import com.example.foodapp.models.FoodItem;
import java.util.ArrayList;

public class HomeFragFoodList {

    private ArrayList<FoodItem> foodItems = new ArrayList<>();
    private SQLiteDatabase db;

    public HomeFragFoodList() {
        initilizeData();
    }

    public void load(Context context) {
        this.db = new DBHelper(context.getApplicationContext()).getWritableDatabase();
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
            while(!cursor.isAfterLast()) {
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

    private void initilizeData() {
        String[] resturantNames = {"KFC", "MC Donald's", "Burger King", "Dunkin Donut", "Popeye's",
                "Subway", "Pizza Hut", "Taco Bell", "Baskin Robins", "Starbucks"};

        String[] foodItemNames = {"Biryani", "Chicken Nuggets", "Chicken Rice", "Chocolate Sundae",
                "Cola", "Crisp Chicken", "Fries", "Happy Meal", "Oreo MFlurry", "Burger"};

        int[] foodImages = {R.drawable.mc_chicken_biryani, R.drawable.mc_chicken_nuggets, R.drawable.mc_chicken_rice,
                R.drawable.mc_chocolate_sundae, R.drawable.mc_cola, R.drawable.mc_crisp_chicken, R.drawable.mc_fry,
                R.drawable.mc_happy_meals, R.drawable.mc_oreo_mcflurry, R.drawable.burger};

        int totalResturant = 10;

        for (int i = 0; i < totalResturant; i++) {
            int id = i + 1;
            String resturant = resturantNames[i];
            String food = foodItemNames[i];
            int foodImage = R.drawable.burger;
            String foodDesc = "This is a test description";
            float price = 10F;
            FoodItem foodItem = new FoodItem(id, resturant, food, price, foodDesc, foodImage);
            foodItems.add(foodItem);
        }
    }

}
