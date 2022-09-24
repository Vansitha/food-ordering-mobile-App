package com.example.foodapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodapp.logic.CheckoutCartList;
import com.example.foodapp.models.CartItem;
import com.example.foodapp.models.FoodItem;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragSelectedFoodItem#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragSelectedFoodItem extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private final String INCREASE = "increase";
    private final String DECREASE = "decrease";

    private FoodItem foodItem;
    private ImageView foodImage;
    private TextView foodName;
    private TextView resturantName;
    private TextView totalCost;
    private  TextView quantity;
    private  Button increaseQuantity;
    private  Button decreaseQuantity;
    private Button addToCart;
    private int currentQuantity = 1; // this is the default quantity
    private float currentTotal;
    private float originalPrice;
    private final int maxQuantity = 10;
    private final int minQuantity = 1;
    private static int notificationBadgeNumber = 0;

    public FragSelectedFoodItem() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragSelectedFoodItem.
     */
    // TODO: Rename and change types and number of parameters
    public static FragSelectedFoodItem newInstance(String param1, String param2) {
        FragSelectedFoodItem fragment = new FragSelectedFoodItem();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selected_food_item, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // get a handle on all the views
        foodImage = view.findViewById(R.id.selectedFoodImage);
        foodName = view.findViewById(R.id.selectedFoodItem);
        resturantName = view.findViewById(R.id.selectedResturant);
        totalCost = view.findViewById(R.id.amountText);
        quantity = view.findViewById(R.id.quantityText);
        increaseQuantity = view.findViewById(R.id.checkoutIncreaseBtn);
        decreaseQuantity = view.findViewById(R.id.checkoutReduceBtn);
        addToCart = view.findViewById(R.id.addToCartBtn);

        setContentFromFoodObject();
        initializeValues();

        increaseQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adjustQuantity(INCREASE);

            }
        });

        decreaseQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adjustQuantity(DECREASE);

            }
        });

        addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // call all to cart handler also
                updateCheckoutBadge(view);
                addCartToHandler();
            }
        });
    }

    public void setSelectedFoodItem(FoodItem item) {
        this.foodItem = item;
    }

    private void setContentFromFoodObject() {
        if (foodItem != null) {
            foodImage.setImageResource(foodItem.getFoodImageRef());
            foodName.setText(foodItem.getFoodName());
            resturantName.setText(foodItem.getResturantName());
            totalCost.setText("$" + Float.toString(foodItem.getPrice()));
            quantity.setText(Integer.toString(currentQuantity));

        }
    }

    private void initializeValues() {
        originalPrice = foodItem.getPrice();
        currentTotal = originalPrice;
    }

    private void adjustQuantity(String type) {
            if (type.equals("increase") && currentQuantity != maxQuantity) {
                currentQuantity += 1;
                currentTotal += originalPrice;
                quantity.setText(Integer.toString(currentQuantity));
                totalCost.setText("$" + Float.toString(currentTotal));
            }
            if (type.equals("decrease") && currentQuantity != minQuantity) {
                currentQuantity -= 1;
                currentTotal -= originalPrice;
                quantity.setText(Integer.toString(currentQuantity));
                totalCost.setText(Float.toString(currentTotal));
            }

    }

    private void addCartToHandler() {

        // create a cart object -> bundle up the name, resturant, price and quantity
        // then add the cart object to the arraylist in checkout
        // so that it can display it
        // there should also be a number that pops up in the cart

        String foodName = foodItem.getFoodName();
        String resturant = foodItem.getResturantName();
        int image = foodItem.getFoodImageRef();

        CartItem item = new CartItem(image, foodName, resturant, currentQuantity, (int)currentTotal, (int)originalPrice);
        CheckoutCartList.addToCart(item);

    }

    private void updateCheckoutBadge(View view) {
        BottomNavigationView bottomNavigationView = MainActivity.bottomNavigationView;
        if (MainActivity.bottomNavigationView != null) {
            BadgeDrawable badgeDrawable = bottomNavigationView.getOrCreateBadge(R.id.checkout);
            badgeDrawable.setVisible(true);
            notificationBadgeNumber += 1;
            badgeDrawable.setNumber(notificationBadgeNumber);
        }
    }

}