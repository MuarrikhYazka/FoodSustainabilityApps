package com.example.foodsustainabilityapps.Fragment;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodsustainabilityapps.R;
import com.example.foodsustainabilityapps.RoomDatabase.Table.Kota;
import com.example.foodsustainabilityapps.RoomDatabase.Table.Provinsi;
import com.example.foodsustainabilityapps.RoomDatabase.ViewModel;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DeteksiFragment extends Fragment {
    List<Provinsi> provinsi = new LinkedList<Provinsi>();
    List<Kota> kota = new LinkedList<Kota>();
    ArrayList<Integer> id_prov = new ArrayList<Integer>();
    ArrayList<String> nama_prov = new ArrayList<String>();
    ArrayList<Integer> id_kota = new ArrayList<Integer>();
    ArrayList<String> nama_kota = new ArrayList<String>();
    Spinner spinnerProv, spinnerKota;
    TextView prioritas1, prioritas2, prioritas3, prioritas4, prioritas5, prioritas6;
    Button deteksiProv, deteksiKota;
    Switch togle;
    TableRow tableRowKota, tableRowProv;
    private ViewModel viewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.freagment_deteksi, container, false);
        spinnerProv = view.findViewById(R.id.rst_prov);
        spinnerKota = view.findViewById(R.id.rst_kota);
        prioritas1 = view.findViewById(R.id.tvPrioritas1);
        prioritas2 = view.findViewById(R.id.tvPrioritas2);
        prioritas3 = view.findViewById(R.id.tvPrioritas3);
        prioritas4 = view.findViewById(R.id.tvPrioritas4);
        prioritas5 = view.findViewById(R.id.tvPrioritas5);
        prioritas6 = view.findViewById(R.id.tvPrioritas6);
        deteksiKota = view.findViewById(R.id.deteksiKota);
        deteksiProv = view.findViewById(R.id.mulaideteksi);
        tableRowKota = view.findViewById(R.id.tableRow_kota);
        tableRowProv = view.findViewById(R.id.tableRow4a);
        togle = view.findViewById(R.id.switchTogle);

        id_prov.add(0);
        nama_prov.add("Pilih Salah Satu");






        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        togle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    tableRowKota.setVisibility(View.VISIBLE);
                    spinnerKota.setVisibility(View.VISIBLE);
                    tableRowProv.setVisibility(View.GONE);
                    spinnerProv.setVisibility(View.GONE);

                }else {
                    tableRowKota.setVisibility(View.GONE);
                    spinnerKota.setVisibility(View.GONE);
                    tableRowProv.setVisibility(View.VISIBLE);
                    spinnerProv.setVisibility(View.VISIBLE);
                    deteksiProv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String prov = String.valueOf(spinnerProv.getSelectedItem());

                        }
                    });
                }
            }
        });
        viewModel = ViewModelProviders.of(DeteksiFragment.this).get(ViewModel.class);
        provinsi = viewModel.getProv();
        for (int i = 0; i< provinsi.size(); i++){
            id_prov.add(provinsi.get(i).getId_prov());
            nama_prov.add(provinsi.get(i).getProvinsi());
            Log.e(provinsi.get(i).getProvinsi(), String.valueOf(provinsi.get(i).getId_prov()));

        }

        spinnerProv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, nama_prov);
        spinnerProv.setAdapter(adapter);

        nama_kota.add("Pilih Salah Satu");
        kota = viewModel.getKota();
        for (int i = 0; i< kota.size(); i++){
            nama_kota.add(kota.get(i).getKota());
            Log.e(kota.get(i).getKota(), String.valueOf(kota.get(i).getId_kota()));
        }
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, nama_kota);
        spinnerKota.setAdapter(adapter2);




    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

}
