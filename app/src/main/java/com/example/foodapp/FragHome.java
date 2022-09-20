package com.example.foodapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragHome extends Fragment {

    RecyclerView recyclerView;

    private class FoodListAdapter extends  RecyclerView.Adapter<FoodCardViewHolder> {

        Context context;

        public FoodListAdapter(Context context) {
            this.context = context;
        }

        @NonNull
        @Override
        public FoodCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context).inflate(R.layout.food_item_card, parent, false);
            return new FoodCardViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull FoodCardViewHolder holder, int position) {



        }

        @Override
        public int getItemCount() {
            return 10;
        }
    }

    private class FoodCardViewHolder extends RecyclerView.ViewHolder {

        public FoodCardViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Inflate the layout for this fragment
        recyclerView = (RecyclerView) recyclerView.findViewById(R.id.homeRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setHasFixedSize(true);
        // initialize the adapter

    }
}