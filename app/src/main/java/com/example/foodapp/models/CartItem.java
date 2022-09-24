package com.example.foodapp.models;

public class CartItem {

    int foodItemImage;
    String foodName;
    String resturantName;
    int quantity;
    int total;
    int originalPrice;

    public CartItem(int foodItemImage, String foodName, String resturantName, int quantity, int total, int originalPrice) {
        this.foodItemImage = foodItemImage;
        this.foodName = foodName;
        this.resturantName = resturantName;
        this.quantity = quantity;
        this.total = total;
        this.originalPrice = originalPrice;
    }

    public int getFoodItemImage() {
        return foodItemImage;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getResturantName() {
        return resturantName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotal() {
        return total;
    }
}
