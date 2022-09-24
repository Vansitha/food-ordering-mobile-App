package com.example.foodapp.models;

public class FoodItem {

    int resturantID;
    String resturantName;
    String foodName;
    int price;
    String foodDesc;
    int foodImageRef;
    int resturantImageRef;

    public FoodItem(int resturantID, String resturantName, String foodName, int price, String foodDesc, int foodImageRef, int resturantImageRef) {
        this.resturantID = resturantID;
        this.resturantName = resturantName;
        this.foodName = foodName;
        this.price = price;
        this.foodDesc = foodDesc;
        this.foodImageRef = foodImageRef;
        this.resturantImageRef = resturantImageRef;
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

    public int getPrice() {
        return price;
    }

    public String getFoodDesc() {
        return foodDesc;
    }

    public int getFoodImageRef() {
        return foodImageRef;
    }

    public int getResturantImageRef() {
        return  resturantImageRef;
    };
}
