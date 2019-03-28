package com.example.foodsustainabilityapps.RoomDatabase.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.foodsustainabilityapps.RoomDatabase.Table.DataKota;


@Dao
public interface DataKotaDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDataKota(DataKota dataKota);

    @Query("SELECT * FROM data_kota WHERE kota = :kota")
    DataKota getDataKotaByKota(String kota);

    @Query("SELECT prority_kota FROM data_kota WHERE kota = :kota")
    int getPriorityKotaByKota(String kota);

}
