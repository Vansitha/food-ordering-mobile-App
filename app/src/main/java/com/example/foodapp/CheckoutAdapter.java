package com.example.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.logic.CheckoutCartList;
import com.example.foodapp.models.CartItem;

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.CheckoutItemViewHolder> {

    private Context context;


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
    public void onBindViewHolder(@NonNull CheckoutItemViewHolder holder, int position) {
        CartItem item = CheckoutCartList.getCheckoutItem(position);
        holder.foodImageView.setImageResource(item.getFoodItemImage());
        holder.foodName.setText(item.getFoodName());
        holder.resturant.setText(item.getResturantName());
        holder.price.setText(Float.toString(item.getTotal()));
        holder.quantity.setText(Integer.toString(item.getQuantity()));

        // TODO: set on click listener for the + and - here

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

        public CheckoutItemViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImageView = itemView.findViewById(R.id.checkoutResturantImage);
            foodName = itemView.findViewById(R.id.checkoutFoodName);
            resturant = itemView.findViewById(R.id.checkoutResturantName);
            quantity = itemView.findViewById(R.id.checkoutItemQuantity);
            price = itemView.findViewById(R.id.checkoutItemPrice);
        }
    }
}
