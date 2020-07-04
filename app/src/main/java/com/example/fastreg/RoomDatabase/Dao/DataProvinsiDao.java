package com.example.fastreg.RoomDatabase.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.fastreg.RoomDatabase.Table.DataProvinsi;

import java.util.List;

@Dao
public interface DataProvinsiDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDataProv(DataProvinsi dataProvinsi);

    @Query("SELECT * FROM data_prov WHERE provinsi = :provinsi")
    DataProvinsi getDataProvByProv(String provinsi);

    @Query("SELECT prority FROM data_prov WHERE provinsi = :provinsi")
    int getPriorityProvByProv(String provinsi);

    @Query("SELECT * FROM data_prov ")
    List<DataProvinsi> getAllDataProv();

}
