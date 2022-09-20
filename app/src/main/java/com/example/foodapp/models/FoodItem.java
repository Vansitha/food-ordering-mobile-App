package com.example.foodapp.models;

public class FoodItem {

    int resturantID;
    String resturantName;
    String foodName;
    float price;
    String foodDesc;
    int foodImageRef;

    public FoodItem(int resturantID, String resturantName, String foodName, float price, String foodDesc, int foodImageRef) {
        this.resturantID = resturantID;
        this.resturantName = resturantName;
        this.foodName = foodName;
        this.price = price;
        this.foodDesc = foodDesc;
        this.foodImageRef = foodImageRef;
    }

    public int getResturantID() {
        return resturantID;
    }

    public String getResturantName() {
        return resturantName;
    }

    public String getFoodName() {
        return foodName;
    }

    public float getPrice() {
        return price;
    }

    public String getFoodDesc() {
        return foodDesc;
    }

    public int getFoodImageRef() {
        return foodImageRef;
    }
}
