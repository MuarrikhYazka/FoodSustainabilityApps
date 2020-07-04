package com.example.fastreg.Activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.fastreg.Fragment.DashboardFragment;
import com.example.fastreg.Fragment.InputFragment;
import com.example.fastreg.Fragment.ListFragment;
import com.example.fastreg.R;
import com.example.fastreg.RoomDatabase.ViewModel;

public class MainActivity extends AppCompatActivity {
    private ViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new InputFragment()).commit();



        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;
                    switch (menuItem.getItemId()){
                        case R.id.navigation_deteksi:
                            selectedFragment = new InputFragment();
                            break;
//                        case R.id.navigation_peta:
//                            selectedFragment = new DashboardFragment();
//                            break;
                        case R.id.navigation_list:
                            selectedFragment = new ListFragment();
                            break;
                        case R.id.navigation_predict:
                            selectedFragment = new DashboardFragment();
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };
}
