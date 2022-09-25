package com.example.foodapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodapp.logic.HomeFragFoodList;
import com.example.foodapp.models.FoodItem;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragHome#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragHome extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;
    private ArrayList<FoodItem> foodList;
    private HomeFragFoodList foodListObject;

    public FragHome() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragHome.
     */
    // TODO: Rename and change types and number of parameters
    public static FragHome newInstance(String param1, String param2) {
        FragHome fragment = new FragHome();
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
        foodListObject = new HomeFragFoodList(getActivity());
        foodListObject.load();
        foodList = foodListObject.getFoodList();
        //setRandomFoodList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recylerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        FoodAdapter myAdapter = new FoodAdapter(getContext(), foodList);
        recyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

    }

    private void setRandomFoodList() {
        for(int i = 0; i < foodListObject.size(); i++) {
            int randomFoodItemIndex = (int)(Math.random()*(9 - 0 + 1) + 0);
            foodList.add(foodListObject.get(randomFoodItemIndex));
        }





    }

}