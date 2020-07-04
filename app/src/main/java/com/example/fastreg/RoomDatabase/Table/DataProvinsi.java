package com.example.fastreg.RoomDatabase.Table;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "data_prov")
public class DataProvinsi {
    @PrimaryKey
    @NonNull
    private String provinsi;
    private double ncpr;
    private double pov;
    private double road;
    private double elec;
    private double water;
    private double life;
    private double flit;
    private double health;
    private int prority;

    public DataProvinsi(@NonNull String provinsi, double ncpr, double pov, double road, double elec, double water, double life, double flit, double health, int prority) {
        this.provinsi = provinsi;
        this.ncpr = ncpr;
        this.pov = pov;
        this.road = road;
        this.elec = elec;
        this.water = water;
        this.life = life;
        this.flit = flit;
        this.health = health;
        this.prority = prority;
    }

    @NonNull
    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(@NonNull String provinsi) {
        this.provinsi = provinsi;
    }

    public double getNcpr() {
        return ncpr;
    }

    public void setNcpr(double ncpr) {
        this.ncpr = ncpr;
    }

    public double getPov() {
        return pov;
    }

    public void setPov(double pov) {
        this.pov = pov;
    }

    public double getRoad() {
        return road;
    }

    public void setRoad(double road) {
        this.road = road;
    }

    public double getElec() {
        return elec;
    }

    public void setElec(double elec) {
        this.elec = elec;
    }

    public double getWater() {
        return water;
    }

    public void setWater(double water) {
        this.water = water;
    }

    public double getLife() {
        return life;
    }

    public void setLife(double life) {
        this.life = life;
    }

    public double getFlit() {
        return flit;
    }

    public void setFlit(double flit) {
        this.flit = flit;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public int getPrority() {
        return prority;
    }

    public void setPrority(int prority) {
        this.prority = prority;
    }
}
