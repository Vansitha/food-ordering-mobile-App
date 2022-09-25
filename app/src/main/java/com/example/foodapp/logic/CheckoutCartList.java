package com.example.foodapp.logic;

import com.example.foodapp.models.CartItem;

import java.util.ArrayList;

public class CheckoutCartList {

    private static ArrayList<CartItem> checkoutList = new ArrayList<>();

    static public int getSize() {
        return checkoutList.size();
    }

    static public CartItem getCheckoutItem(int position) {
        return checkoutList.get(position);
    }

    static public void addToCart(CartItem item) {
        checkoutList.add(item);
    }

    static public void removeFromCart(int position) {
        checkoutList.remove(position);
    }

    static public ArrayList<CartItem> getCheckoutList() {
        return checkoutList;
    }

}
