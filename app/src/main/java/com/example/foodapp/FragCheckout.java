package com.example.foodapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.foodapp.logic.CheckoutCartList;
import com.example.foodapp.logic.HomeFragFoodList;
import com.example.foodapp.models.CartItem;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FragCheckout extends Fragment {

    private RecyclerView recyclerView;
    private CheckoutCartList cart;
    private Button checkoutButton;
    private TextView orderTotal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cart = new CheckoutCartList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_checkout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        orderTotal = view.findViewById(R.id.checkoutTotal);
        recyclerView = view.findViewById(R.id.checkoutRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        CheckoutAdapter myAdapter = new CheckoutAdapter(getContext());
        recyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

        checkoutButton = view.findViewById(R.id.checkoutButton); // this is the checkout button
        enableCheckoutButton();
        updateOrderTotal();

        // add an onclick listener to the checkout button to trigger login activity
        // do it the way you want
        checkoutButton.setOnClickListener(new View.OnClickListener() {  //  onclick listener to the checkout button to trigger login activity
            @Override
            public void onClick(View v) {

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                FragLogIN login = new FragLogIN();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.contentArea, login).commit();
            }
        });

    }

    public void enableCheckoutButton() {
        if (CheckoutCartList.getSize() != 0) {
            checkoutButton.setEnabled(true);
        }
    }

    public void updateOrderTotal() {
        int total = 0;
        if (CheckoutCartList.getSize() != 0) {
            for(CartItem item: CheckoutCartList.getCheckoutList()) {
                total += item.getTotal();
            }
            orderTotal.setText("$"+ Integer.toString(total));
        }

    }


}