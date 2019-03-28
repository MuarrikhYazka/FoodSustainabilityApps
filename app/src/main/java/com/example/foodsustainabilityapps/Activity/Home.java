package com.example.foodsustainabilityapps.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.foodsustainabilityapps.Fragment.DeteksiFragment;
import com.example.foodsustainabilityapps.Fragment.ListFragment;
import com.example.foodsustainabilityapps.Fragment.PetaFragment;
import com.example.foodsustainabilityapps.R;
import com.example.foodsustainabilityapps.ServiceGenerator;

public class Home extends AppCompatActivity {
    TextView deteksi,peta, list, ketDeteksi, ketPeta, ketList;
    private LinearLayout linearDeteksi, linearPeta, linearList;
    private ImageView logoDeteksi, logoPeta, logoList;
    private Button mulaiBtn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        deteksi = findViewById(R.id.tv_deteksi);
        ketDeteksi = findViewById(R.id.tv_ketDeteksi);
        peta = findViewById(R.id.tv_peta);
        ketPeta = findViewById(R.id.tv_ketPeta);
        list = findViewById(R.id.tv_list);
        ketList = findViewById(R.id.tv_ketList);
        logoDeteksi = findViewById(R.id.im_deteksi);
        logoList = findViewById(R.id.im_list);
        logoPeta = findViewById(R.id.im_peta);
        linearDeteksi = findViewById(R.id.linear_deteksi);
        linearPeta = findViewById(R.id.linear_peta);
        linearList = findViewById(R.id.linear_list);
        mulaiBtn = findViewById(R.id.mulaideteksi);

        linearDeteksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, MainActivity.class);
                startActivity(intent);
            }
        });

        mulaiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}
