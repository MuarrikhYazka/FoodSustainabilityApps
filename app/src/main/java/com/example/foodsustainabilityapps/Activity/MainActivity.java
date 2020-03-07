package com.example.foodsustainabilityapps.Activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.foodsustainabilityapps.Fragment.DeteksiFragment;
import com.example.foodsustainabilityapps.Fragment.ListFragment;
import com.example.foodsustainabilityapps.Fragment.PetaFragment;
import com.example.foodsustainabilityapps.R;
import com.example.foodsustainabilityapps.RoomDatabase.ViewModel;

public class MainActivity extends AppCompatActivity {
    private ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new PetaFragment()).commit();



//        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
//        bottomNav.setOnNavigationItemSelectedListener(navListener);

    }

//    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
//            new BottomNavigationView.OnNavigationItemSelectedListener() {
//                @Override
//                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                    Fragment selectedFragment = null;
//                    switch (menuItem.getItemId()){
//                        case R.id.navigation_deteksi:
//                            selectedFragment = new DeteksiFragment();
//                            break;
//                        case R.id.navigation_peta:
//                            selectedFragment = new PetaFragment();
//                            break;
//                        case R.id.navigation_list:
//                            selectedFragment = new ListFragment();
//                            break;
//                        case R.id.navigation_predict:
//                            selectedFragment = new PetaFragment();
//                    }
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                            selectedFragment).commit();
//                    return true;
//                }
//            };
}
