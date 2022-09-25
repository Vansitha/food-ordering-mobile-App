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
 * Use the {@link FragLogIN#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class FragLogIN extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragLogIN.
     */
    // TODO: Rename and change types and number of parameters
    public static FragLogIN newInstance(String param1, String param2) {
        FragLogIN fragment = new FragLogIN();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public FragLogIN() {
        // Required empty public constructor
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
        View view,view1;

        Button LoginBtn,SignBtn;
        EditText UserEmail,passWD;

        view = inflater.inflate(R.layout.fragment_log_in, container, false);

        UserEmail       = (EditText) view.findViewById(R.id.editTextEmail);
        passWD      = (EditText) view.findViewById(R.id.editTextPassword);
        LoginBtn    = (Button) view.findViewById(R.id.LoginButton);
        SignBtn     = (Button) view.findViewById(R.id.Signupbutton);


        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Editable edit;
                String UserMail,UserPassWD,UserInfo;

                edit = UserEmail.getText();
                UserMail = edit.toString();

                edit = passWD.getText();
                UserPassWD = edit.toString();

                UserInfo = "Your Account \nEmail: "+UserMail;

                if(!UserMail.equals("")&& !UserPassWD.equals("")){

                    Bundle bundle = new Bundle();
                    bundle.putString("User",UserInfo);

                    FragUserInfo fUser = new FragUserInfo();
                    fUser.setArguments(bundle);

                    FragmentTransaction Ft = getFragmentManager().beginTransaction();
                    Ft.replace(R.id.contentArea,fUser).commit();

                }
                else{
                     //Do nothing
                }



                /*Bundle bundle = new Bundle();
                bundle.putString("userDetails",UserDetails);
                bundle.putString("BtnText",BtnText);
                FragAccount FAc = new FragAccount();
                FAc.setArguments(bundle);
                FAc.getMessage(inflater,container,savedInstanceState);
                FragmentTransaction FT = getParentFragmentManager().beginTransaction();
                FT.replace(R.id.contentArea,FAc).commit();*/
            }
        });

        SignBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragSignup1 S1 = new FragSignup1();
                FragmentTransaction FT = getFragmentManager().beginTransaction();
                FT.replace(R.id.contentArea,S1).commit();

            }
        });


        return view;
    }

}