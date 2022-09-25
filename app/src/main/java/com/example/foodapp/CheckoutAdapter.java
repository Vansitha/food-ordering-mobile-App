package com.example.foodapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.logic.CheckoutCartList;
import com.example.foodapp.models.CartItem;

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.CheckoutItemViewHolder> {

    private Context context;

    public static void updateFragment() {
    }

    public CheckoutAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CheckoutItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.checkout_item_card, parent, false);
        return new CheckoutItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CheckoutItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        CartItem item = CheckoutCartList.getCheckoutItem(position);
        holder.foodImageView.setImageResource(item.getFoodItemImage());
        holder.foodName.setText(item.getFoodName());
        holder.resturant.setText(item.getResturantName());
        holder.price.setText("$ " + Float.toString(item.getTotal()));
        holder.quantity.setText(Integer.toString(item.getQuantity()));

        holder.increaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (item.getQuantity() != 10){
                    item.incrementQuantity();
                    int newTotal = item.getQuantity() * item.getOriginalPrice();
                    item.setNewTotal(newTotal);
                    holder.price.setText("$ " + Float.toString(item.getTotal()));
                    holder.quantity.setText(Integer.toString(item.getQuantity()));

                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    FragCheckout checkout = new FragCheckout();
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.contentArea, checkout).commit();

                }
            }
        });

        holder.decreaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (item.getQuantity() != 10){
                    item.decrementQuantity();
                    if (item.getQuantity() == 0) {
                        CheckoutCartList.removeFromCart(position);
                        notifyItemRemoved(position);
                        // delete one number from the red indicator
                        FragCheckout.decreaseCheckoutBadge();

                    }
                    else {
                        int newTotal = item.getQuantity() * item.getOriginalPrice();
                        item.setNewTotal(newTotal);

                        holder.price.setText("$ " + Float.toString(item.getTotal()));
                        holder.quantity.setText(Integer.toString(item.getQuantity()));
                    }
                }

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                FragCheckout checkout = new FragCheckout();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.contentArea, checkout).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return CheckoutCartList.getSize();
    }

    public static class CheckoutItemViewHolder extends RecyclerView.ViewHolder {

        ImageView foodImageView;
        TextView foodName;
        TextView resturant;
        TextView quantity;
        TextView price;
        Button increaseBtn;
        Button decreaseBtn;

        public CheckoutItemViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImageView = itemView.findViewById(R.id.checkoutResturantImage);
            foodName = itemView.findViewById(R.id.checkoutFoodName);
            resturant = itemView.findViewById(R.id.checkoutResturantName);
            quantity = itemView.findViewById(R.id.checkoutItemQuantity);
            price = itemView.findViewById(R.id.checkoutItemPrice);
            increaseBtn = itemView.findViewById(R.id.checkoutIncreaseBtn);
            decreaseBtn = itemView.findViewById(R.id.checkoutReduceBtn);
        }
    }
}
