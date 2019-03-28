package com.example.foodsustainabilityapps.RoomDatabase.Table;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "data_kota")
public class DataKota {
    @PrimaryKey
    @NonNull
    private String kota;
    private double ncpr_kota;
    private double pov_kota;
    private double road_kota;
    private double elec_kota;
    private double water_kota;
    private double life_kota;
    private double flit_kota;
    private double health_kota;
    private int prority_kota;

    public DataKota(@NonNull String kota, double ncpr_kota, double pov_kota, double road_kota, double elec_kota, double water_kota, double life_kota, double flit_kota, double health_kota, int prority_kota) {
        this.kota = kota;
        this.ncpr_kota = ncpr_kota;
        this.pov_kota = pov_kota;
        this.road_kota = road_kota;
        this.elec_kota = elec_kota;
        this.water_kota = water_kota;
        this.life_kota = life_kota;
        this.flit_kota = flit_kota;
        this.health_kota = health_kota;
        this.prority_kota = prority_kota;
    }

    @NonNull
    public String getKota() {
        return kota;
    }

    public void setKota(@NonNull String kota) {
        this.kota = kota;
    }

    public double getNcpr_kota() {
        return ncpr_kota;
    }

    public void setNcpr_kota(double ncpr_kota) {
        this.ncpr_kota = ncpr_kota;
    }

    public double getPov_kota() {
        return pov_kota;
    }

    public void setPov_kota(double pov_kota) {
        this.pov_kota = pov_kota;
    }

    public double getRoad_kota() {
        return road_kota;
    }

    public void setRoad_kota(double road_kota) {
        this.road_kota = road_kota;
    }

    public double getElec_kota() {
        return elec_kota;
    }

    public void setElec_kota(double elec_kota) {
        this.elec_kota = elec_kota;
    }

    public double getWater_kota() {
        return water_kota;
    }

    public void setWater_kota(double water_kota) {
        this.water_kota = water_kota;
    }

    public double getLife_kota() {
        return life_kota;
    }

    public void setLife_kota(double life_kota) {
        this.life_kota = life_kota;
    }

    public double getFlit_kota() {
        return flit_kota;
    }

    public void setFlit_kota(double flit_kota) {
        this.flit_kota = flit_kota;
    }

    public double getHealth_kota() {
        return health_kota;
    }

    public void setHealth_kota(double health_kota) {
        this.health_kota = health_kota;
    }

    public int getPrority_kota() {
        return prority_kota;
    }

    public void setPrority_kota(int prority_kota) {
        this.prority_kota = prority_kota;
    }
}
