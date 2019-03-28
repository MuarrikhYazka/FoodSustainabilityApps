package com.example.foodsustainabilityapps.RoomDatabase.Table;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "provinsi")
public class Provinsi {
    @PrimaryKey
    @NonNull
    private int id_prov;
    private String provinsi;

    public Provinsi(int id_prov, String provinsi) {
        this.id_prov = id_prov;
        this.provinsi = provinsi;
    }

    public int getId_prov() {
        return id_prov;
    }

    public void setId_prov(int id_prov) {
        this.id_prov = id_prov;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }
}
