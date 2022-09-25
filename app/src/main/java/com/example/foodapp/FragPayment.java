package com.example.foodapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragPayment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragPayment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragPayment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragPayment.
     */
    // TODO: Rename and change types and number of parameters
    public static FragPayment newInstance(String param1, String param2) {
        FragPayment fragment = new FragPayment();
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
        View view;
        TextView Msg;
        Button Btn;
        String Text;

        view = inflater.inflate(R.layout.fragment_payment, container, false);

        Msg = view.findViewById(R.id.ThankMsg);
        Btn = view.findViewById(R.id.DoneBtn);

        Text = "Payment successful\n\nThank you for ordering\n\nEnjoy your meals :)";
        Msg.setText(Text);

        Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Delete the Items in the checkout list

                FragCheckout FH = new FragCheckout();
                FragmentTransaction Ft = getFragmentManager().beginTransaction();
                Ft.replace(R.id.contentArea,FH).commit();
            }
        });

        return view;
    }
}