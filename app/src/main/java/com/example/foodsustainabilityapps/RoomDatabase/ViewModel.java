package com.example.foodsustainabilityapps.RoomDatabase;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.foodsustainabilityapps.RoomDatabase.Table.DataKota;
import com.example.foodsustainabilityapps.RoomDatabase.Table.Kota;
import com.example.foodsustainabilityapps.RoomDatabase.Table.Provinsi;

import java.util.List;

public class ViewModel extends AndroidViewModel {
    private Repository mRepository;
    public ViewModel(@NonNull Application application) {
        super(application);
        mRepository = new Repository(application);
    }
    public List<Kota> getKota(){return mRepository.getListKotadarilokal();}
    public List<Provinsi> getProv(){return mRepository.getListProvinsidarilokal();}
    public DataKota getDataKotabyKota(String kota){return mRepository.getdataKotabyKotalocal(kota);}
    public DataKota getDataProvbyProv(String prov){return mRepository.getdataKotabyKotalocal(prov);}
}
