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

import com.example.foodapp.logic.HomeFragFoodList;
import com.example.foodapp.models.FoodItem;

import java.util.ArrayList;

public class BrowseAdapter extends RecyclerView.Adapter<BrowseAdapter.ResturantItemViewHolder>  {

    private Context context;
    private ArrayList<FoodItem> selectedResturantFoodItems = new ArrayList<>();
    private HomeFragFoodList homeFragFoodList;

    public BrowseAdapter(Context context, HomeFragFoodList homeFragFoodList) {
        this.context = context;
        this.homeFragFoodList = homeFragFoodList;
    }

    @NonNull
    @Override
    public ResturantItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.resturant_card, parent, false);
        return new BrowseAdapter.ResturantItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ResturantItemViewHolder holder, int position) {
        FoodItem item = homeFragFoodList.get(position);
        holder.resturantImage.setImageResource(item.getResturantImageRef());
        holder.resturantName.setText(item.getResturantName());

        // set an on click listener here
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create a list with the name of the resturant only
                ArrayList<FoodItem> foodlist = homeFragFoodList.getFoodList();
                for(FoodItem foodItem: foodlist) {
                    if(foodItem.getResturantName().equals(item.getResturantName())) {
                        FoodItem itemFromResturant = new FoodItem(
                                foodItem.getResturantID(),
                                foodItem.getResturantName(),
                                foodItem.getFoodName(),
                                foodItem.getPrice(),
                                foodItem.getFoodDesc(),
                                foodItem.getFoodImageRef(),
                                foodItem.getFoodImageRef()
                        );
                        selectedResturantFoodItems.add(itemFromResturant);
                    }
                }

                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                FragResturantMenu menu = new FragResturantMenu();
                menu.setFoodList(selectedResturantFoodItems);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.contentArea, menu).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return homeFragFoodList.size();
    }

    public static class ResturantItemViewHolder extends RecyclerView.ViewHolder {

        ImageView resturantImage;
        TextView resturantName;

        public ResturantItemViewHolder(@NonNull View itemView) {
            super(itemView);
            resturantImage = itemView.findViewById(R.id.browseResturantImage);
            resturantName = itemView.findViewById(R.id.browseResturantName);
        }
    }
}
