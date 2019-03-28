package com.example.foodsustainabilityapps.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.foodsustainabilityapps.R;
import com.example.foodsustainabilityapps.RoomDatabase.Table.Kota;
import com.example.foodsustainabilityapps.RoomDatabase.Table.Provinsi;
import com.example.foodsustainabilityapps.RoomDatabase.ViewModel;

import java.util.LinkedList;
import java.util.List;

public class DeteksiFragment extends Fragment {
    List<Provinsi> provinsi = new LinkedList<Provinsi>();
    List<Kota> kota = new LinkedList<Kota>();
    Spinner sp_prov
    private ViewModel viewModel;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.freagment_deteksi, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
            toolbar.setTitle("Deteksi");
        }catch(Exception e){
            Toast.makeText(context, "Aplikasi tidak mendukung posisi landscape.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
