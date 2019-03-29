package com.example.foodsustainabilityapps.RoomDatabase;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.foodsustainabilityapps.RoomDatabase.Table.DataKota;
import com.example.foodsustainabilityapps.RoomDatabase.Table.DataProvinsi;
import com.example.foodsustainabilityapps.RoomDatabase.Table.Kota;
import com.example.foodsustainabilityapps.RoomDatabase.Table.Provinsi;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    private Repository mRepository;
    public ViewModel(@NonNull Application application) {
        super(application);
        mRepository = new Repository(application);
    }
    public List<Kota> getKota(){return mRepository.getAllKotaLocal();}
    public List<Provinsi> getProv(){return mRepository.getAllProvinsiLocal();}
    public List<DataKota> getAllDataKota(){return mRepository.getAllDataKotaLocal();}
    public List<DataProvinsi> getAllDataProv(){return mRepository.getAllDataProvinsiLocal();}
    public int getPriorProv(String prov){return mRepository.getPriorProv(prov);}
    public int getPriorKota(String kota){return mRepository.getPriorKota(kota);}
}
