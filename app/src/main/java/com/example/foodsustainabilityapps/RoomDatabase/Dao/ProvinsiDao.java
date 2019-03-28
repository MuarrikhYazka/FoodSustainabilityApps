package com.example.foodsustainabilityapps.RoomDatabase.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;


import com.example.foodsustainabilityapps.RoomDatabase.Table.Provinsi;

import java.util.List;

@Dao
public interface ProvinsiDao {
    @Query("SELECT * FROM provinsi")
    List<Provinsi> getAllProv();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllProv(Provinsi prov);

    @Update
    void updateProv(Provinsi prov);

}
