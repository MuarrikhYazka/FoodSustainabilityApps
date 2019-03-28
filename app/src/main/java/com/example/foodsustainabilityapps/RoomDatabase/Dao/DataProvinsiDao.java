package com.example.foodsustainabilityapps.RoomDatabase.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.foodsustainabilityapps.RoomDatabase.Table.DataKota;
import com.example.foodsustainabilityapps.RoomDatabase.Table.DataProvinsi;

@Dao
public interface DataProvinsiDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDataProv(DataProvinsi dataProvinsi);

    @Query("SELECT * FROM data_prov WHERE provinsi = :provinsi")
    DataProvinsi getDataProvByProv(String provinsi);

    @Query("SELECT prority FROM data_prov WHERE provinsi = :provinsi")
    int getPriorityProvByProv(String provinsi);
}
