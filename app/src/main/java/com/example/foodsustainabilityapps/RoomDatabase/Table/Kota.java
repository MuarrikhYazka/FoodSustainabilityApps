package com.example.foodsustainabilityapps.RoomDatabase.Table;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "kota")
public class Kota {
    @PrimaryKey
    @NonNull
    private int id_kota;
    private String kota;


    public Kota(int id_kota, String kota) {
        this.id_kota = id_kota;
        this.kota = kota;
    }

    public int getId_kota() {
        return id_kota;
    }

    public void setId_kota(int id_kota) {
        this.id_kota = id_kota;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }
}
