package com.example.foodapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FragAccount extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        TextView UserAcc;
        Button Btn1;
        String noLogin;

        view = inflater.inflate(R.layout.fragment_account, container, false);

        UserAcc = (TextView) view.findViewById(R.id.acc_details);
        Btn1 = (Button) view.findViewById(R.id.button);

        noLogin = "Purchase Something to login";


        UserAcc.setText(noLogin);


        Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragHome FH = new FragHome();
                FragmentTransaction FT = getFragmentManager().beginTransaction();
                FT.replace(R.id.contentArea,FH).commit();
            }
        });


        return view;
    }

    public void getMessage(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState){
        View view = view = inflater.inflate(R.layout.fragment_account, container, false);
        TextView T = view.findViewById(R.id.acc_details);

        Bundle bundle = new Bundle();
        String A = bundle.getString("userDetails");
        T.setText(A);
    }

}