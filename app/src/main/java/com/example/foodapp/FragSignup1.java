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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragSignup1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragSignup1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragSignup1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragSignUp1.
     */
    // TODO: Rename and change types and number of parameters
    public static FragSignup1 newInstance(String param1, String param2) {
        FragSignup1 fragment = new FragSignup1();
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
        View view;
        Button nextBtn;
        EditText FName,LName,Address;


        view    = inflater.inflate(R.layout.fragment_sign_up1, container, false);
        nextBtn = (Button) view.findViewById(R.id.Nextbutton);
        FName   = (EditText) view.findViewById(R.id.PersonName1);
        LName   = (EditText) view.findViewById(R.id.PersonName2);
        Address = (EditText) view.findViewById(R.id.PostalAddress);


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FirstName,LastName,UserAddress;
                Editable edit;

                edit = FName.getText();
                FirstName = edit.toString();

                edit = LName.getText();
                LastName = edit.toString();

                edit = Address.getText();
                UserAddress = edit.toString();

                if(!FirstName.equals("") && !LastName.equals("") && !UserAddress.equals("")){

                    FragSignup2 S2 = new FragSignup2();
                    FragmentTransaction FT = getFragmentManager().beginTransaction();
                    FT.replace(R.id.contentArea,S2).commit();

                }
                else{
                    //Do nothing
                }


            }
        });


        return view;
    }
}