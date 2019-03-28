package com.example.foodsustainabilityapps.RoomDatabase.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.foodsustainabilityapps.RoomDatabase.Table.Kota;

import java.util.List;

@Dao
public interface KotaDao {
    @Query("SELECT * FROM kota")
    List<Kota> getAllKota();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllKota(Kota kota);

    @Update
    void updateKota(Kota kota);

}
