package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.contentArea, new FragHome()).commit();
        bottomNavigationView = findViewById(R.id.bottomNavBar);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()) {
                    case R.id.home:
                        fragment = new FragHome();
                        break;
                    case R.id.checkout:
                        fragment = new FragCheckout();
                        break;
                    case R.id.browse:
                        fragment = new FragBrowse();
                        break;
                    case R.id.pastOrder:
                        fragment = new FragOrders();
                        break;
                    case R.id.account:
                        fragment = new FragAccount();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.contentArea, fragment).commit();
                return true;
            }
        });


    }

}