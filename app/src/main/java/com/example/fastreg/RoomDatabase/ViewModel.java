package com.example.fastreg.RoomDatabase;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.fastreg.RoomDatabase.Table.DataKota;
import com.example.fastreg.RoomDatabase.Table.DataProvinsi;
import com.example.fastreg.RoomDatabase.Table.Kota;
import com.example.fastreg.RoomDatabase.Table.Provinsi;

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
}
