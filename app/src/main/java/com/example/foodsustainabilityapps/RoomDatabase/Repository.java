package com.example.foodsustainabilityapps.RoomDatabase;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import com.example.foodsustainabilityapps.RoomDatabase.Dao.DataKotaDao;
import com.example.foodsustainabilityapps.RoomDatabase.Dao.DataProvinsiDao;
import com.example.foodsustainabilityapps.RoomDatabase.Dao.KotaDao;
import com.example.foodsustainabilityapps.RoomDatabase.Dao.ProvinsiDao;
import com.example.foodsustainabilityapps.RoomDatabase.Table.DataKota;
import com.example.foodsustainabilityapps.RoomDatabase.Table.DataProvinsi;
import com.example.foodsustainabilityapps.RoomDatabase.Table.Kota;
import com.example.foodsustainabilityapps.RoomDatabase.Table.Provinsi;

import java.util.List;

public class Repository {
    private static final String TAG = "Repository";
    private ProvinsiDao provinsiDao;
    private KotaDao kotaDao;
    private DataProvinsiDao dataProvinsiDao;
    private DataKotaDao dataKotaDao;

    public Repository(Application application) {
        LocalDatabase ldb = LocalDatabase.getLocalDatabase(application);
        this.provinsiDao = ldb.provinsiDao();
        this.kotaDao = ldb.kotaDao();
        this.dataProvinsiDao = ldb.dataProvinsiDao();
        this.dataKotaDao = ldb.dataKotaDao();

    }

    public static class getListFase_ProvLokalAsync extends AsyncTask<Void, Void, List<Provinsi>> {
        private ProvinsiDao provinsiDao;

        public getListFase_ProvLokalAsync(ProvinsiDao provinsiDao) {
            this.provinsiDao = provinsiDao;
        }

        @Override
        protected List<Provinsi> doInBackground(Void... voids) {
            return provinsiDao.getAllProv();
        }
    }
    public List<Provinsi> getListProvinsidarilokal() {
        try {
            return new getListFase_ProvLokalAsync(provinsiDao).execute().get();
        } catch (Exception e) {
            Log.d(TAG, "prov: " + e.getMessage());
        }
        return null;
    }

    public static class getListKotaLokalAsync extends AsyncTask<Void, Void, List<Kota>> {
        private KotaDao kotaDao;

        public getListKotaLokalAsync(KotaDao kotaDao) {
            this.kotaDao = kotaDao;
        }

        @Override
        protected List<Kota> doInBackground(Void... voids) {
            return kotaDao.getAllKota();
        }
    }
    public List<Kota> getListKotadarilokal() {
        try {
            return new getListKotaLokalAsync(kotaDao).execute().get();
        } catch (Exception e) {
            Log.d(TAG, "kota: " + e.getMessage());
        }
        return null;
    }

    public static class getDataProvbyProvlocalAsync extends AsyncTask<String, Void, DataProvinsi> {
        private DataProvinsiDao dataProvinsiDao;

        private getDataProvbyProvlocalAsync(DataProvinsiDao dao) {
            dataProvinsiDao = dao;
        }

        @Override
        protected DataProvinsi doInBackground(String... strings) {
            return dataProvinsiDao.getDataProvByProv(strings[0]);
        }
    }

    public DataProvinsi getdataProvbyProvlocal(String prov) {
        try {
            return new getDataProvbyProvlocalAsync(dataProvinsiDao).execute(prov).get();
        } catch (Exception e) {
            Log.d(TAG, "getSubSegmenbysegmenlocal: " + e.getMessage());
            return null;
        }
    }

    public static class getDataKotabykotalocalAsync extends AsyncTask<String, Void, DataKota> {
        private DataKotaDao dataKotaDao;

        private getDataKotabykotalocalAsync(DataKotaDao dao) {
            dataKotaDao = dao;
        }

        @Override
        protected DataKota doInBackground(String... strings) {
            return dataKotaDao.getDataKotaByKota(strings[0]);
        }
    }

    public DataKota getdataKotabyKotalocal(String kota) {
        try {
            return new getDataKotabykotalocalAsync(dataKotaDao).execute(kota).get();
        } catch (Exception e) {
            Log.d(TAG, "getSubSegmenbysegmenlocal: " + e.getMessage());
            return null;
        }
    }
}
