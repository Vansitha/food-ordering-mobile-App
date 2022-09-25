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
 * Use the {@link FragSignup2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragSignup2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragSignup2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragSignup2.
     */
    // TODO: Rename and change types and number of parameters
    public static FragSignup2 newInstance(String param1, String param2) {
        FragSignup2 fragment = new FragSignup2();
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
        View view = inflater.inflate(R.layout.fragment_signup2, container, false);

        Button finishBtn;
        EditText Umail,PassWd,ConfPassWd;
        TextView Msg1;


        Umail       = (EditText) view.findViewById(R.id.editEmail);
        PassWd      = (EditText) view.findViewById(R.id.editPassword);
        ConfPassWd  = (EditText) view.findViewById(R.id.editConfirmPW);
        finishBtn   = (Button) view.findViewById(R.id.finish);
        Msg1        = (TextView) view.findViewById(R.id.Msg1);



        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Editable edit;
                String date,month,year,UserName,passwd,confpass;
                int birthDate=0,birthMonth=0,birthYear=0;

                edit = Umail.getText();
                UserName = edit.toString();

                edit = PassWd.getText();
                passwd = edit.toString();

                edit = ConfPassWd.getText();
                confpass = edit.toString();





                if(!UserName.equals("") && !passwd.equals("") && !confpass.equals("") ){

                    if(passwd.compareTo(confpass) != 0) {
                        Msg1.setText("Recheck the password");
                    }

                    else{

                        FragHome FH = new FragHome();
                        FragmentTransaction FT = getFragmentManager().beginTransaction();
                        FT.replace(R.id.contentArea,FH).commit();
                    }




                }
                else{

                    //Do nothing
                }

            }
        });


        return view;
    }
}