package com.example.foodsustainabilityapps.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.foodsustainabilityapps.R;

public class ListActivity extends AppCompatActivity {
    private TextView kota, prioritas, npcr, pov, road, elec, water, life, flit, health;
    private static final String TAG = "ListActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_details);

        kota = findViewById(R.id.kota_tv);
        prioritas = findViewById(R.id.priority_tv);
        npcr = findViewById(R.id.npcr_tv);
        pov = findViewById(R.id.pov_tv);
        road = findViewById(R.id.road_tv);
        elec = findViewById(R.id.elec_tv);
        water = findViewById(R.id.water_tv);
        life = findViewById(R.id.life_tv);
        flit = findViewById(R.id.flit_tv);
        health = findViewById(R.id.health_tv);

        kota.setText("Kota/Kabupaten " + getIntent().getStringExtra("kota"));
        prioritas.setText("Prioritas "+getIntent().getStringExtra("priioritas"));
        npcr.setText("Kota/Kabupaten " + getIntent().getStringExtra("npcr"));
        pov.setText("Prioritas "+getIntent().getStringExtra("pov"));
        road.setText("Kota/Kabupaten " + getIntent().getStringExtra("road"));
        elec.setText("Prioritas "+getIntent().getStringExtra("elec"));
        water.setText("Kota/Kabupaten " + getIntent().getStringExtra("water"));
        life.setText("Prioritas "+getIntent().getStringExtra("life"));
        flit.setText("Kota/Kabupaten " + getIntent().getStringExtra("flit"));
        health.setText("Prioritas "+getIntent().getStringExtra("health"));




    }
}
