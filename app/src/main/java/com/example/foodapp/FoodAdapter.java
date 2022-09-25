package com.example.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.models.FoodItem;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodCardViewHolder> {

    private Context context;
    private ArrayList<FoodItem> foodList;

    public FoodAdapter(Context context, ArrayList<FoodItem> foodList) {
        this.context = context;
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.food_item_card, parent, false);
        return new FoodCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodCardViewHolder holder, int position) {
        FoodItem item = foodList.get(position);
        holder.foodImageView.setImageResource(item.getFoodImageRef());
        holder.foodName.setText(item.getFoodName());
        holder.foodDesc.setText(item.getFoodDesc());
        holder.resturant.setText(item.getResturantName());
        holder.price.setText("$ "+ Float.toString(item.getPrice()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                FragSelectedFoodItem fragSelectedFoodItem = new FragSelectedFoodItem();
                fragSelectedFoodItem.setSelectedFoodItem(item);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.contentArea, fragSelectedFoodItem).commit();
            }
        });


    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class FoodCardViewHolder extends RecyclerView.ViewHolder {

        ImageView foodImageView;
        TextView foodName;
        TextView foodDesc;
        TextView resturant;
        TextView price;

        public FoodCardViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImageView = itemView.findViewById(R.id.browseResturantImage);
            foodName = itemView.findViewById(R.id.checkoutFoodName);
            foodDesc = itemView.findViewById(R.id.foodDescText);
            resturant = itemView.findViewById(R.id.browseResturantName);
            price = itemView.findViewById(R.id.checkoutItemPrice);

        }
    }
}
