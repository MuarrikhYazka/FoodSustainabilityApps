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
import java.util.concurrent.ExecutionException;

public class Repository {
    private static final String TAG = "Repository";
    private ProvinsiDao provinsiDao;
    private KotaDao kotaDao;
    private DataProvinsiDao dataProvinsiDao;
    private DataKotaDao dataKotaDao;

    private List<Provinsi> allProvinsi;
    private List<Kota> allKota;
    private List<DataProvinsi> allDataProvinsi;
    private List<DataKota> allDataKota;

    public Repository(Application application){
        LocalDatabase localDatabase = LocalDatabase.getInstance(application);
        provinsiDao = localDatabase.provinsiDao();
        kotaDao = localDatabase.kotaDao();
        dataKotaDao = localDatabase.dataKotaDao();
        dataProvinsiDao = localDatabase.dataProvinsiDao();

//        allProvinsi = provinsiDao.getAllProv();
//        allKota = kotaDao.getAllKota();
//        allDataProvinsi = dataProvinsiDao.getAllDataProv();
//        allDataKota = dataKotaDao.getAllDataKota();
    }

    private static class InsertProvAsync extends AsyncTask<Provinsi,Void,Void>{
        private ProvinsiDao provinsiDao;

        public InsertProvAsync(ProvinsiDao provinsiDao) {
            this.provinsiDao = provinsiDao;
        }

        @Override
        protected Void doInBackground(Provinsi... provinsis) {
            provinsiDao.insertAllProv(provinsis[0]);
            return null;
        }
    }

    private static class InsertKotaAsync extends AsyncTask<Kota, Void, Void>{
        private KotaDao kotaDao;

        public InsertKotaAsync(KotaDao kotaDao) {
            this.kotaDao = kotaDao;
        }

        @Override
        protected Void doInBackground(Kota... kotas) {
            kotaDao.insertAllKota(kotas[0]);
            return null;
        }
    }

    private static class InsertDataProvAsync extends AsyncTask<DataProvinsi, Void, Void>{
        private DataProvinsiDao dataProvinsiDao;

        public InsertDataProvAsync(DataProvinsiDao dataProvinsiDao) {
            this.dataProvinsiDao = dataProvinsiDao;
        }

        @Override
        protected Void doInBackground(DataProvinsi... dataProvinsis) {
            dataProvinsiDao.insertDataProv(dataProvinsis[0]);
            return null;
        }
    }

    private static class IsertDataKotaAsync extends AsyncTask<DataKota,Void,Void>{
        private DataKotaDao dataKotaDao;

        public IsertDataKotaAsync(DataKotaDao dataKotaDao) {
            this.dataKotaDao = dataKotaDao;
        }

        @Override
        protected Void doInBackground(DataKota... dataKotas) {
            dataKotaDao.insertDataKota(dataKotas[0]);
            return null;
        }
    }

    public void insertProvinsi(Provinsi provinsi){new InsertProvAsync(provinsiDao).execute(provinsi);}
    public void insertKota(Kota kota){new InsertKotaAsync(kotaDao).execute(kota);}
    public void insertDataProv(DataProvinsi dataProvinsi){
        new InsertDataProvAsync(dataProvinsiDao).execute(dataProvinsi);
    }
    public void insertDataKota(DataKota dataKota){new IsertDataKotaAsync(dataKotaDao).execute(dataKota);}

    public static class getAllKotaAsync extends AsyncTask<Void,Void,List<Kota>>{
        private KotaDao kotaDao;

        public getAllKotaAsync(KotaDao kotaDao) {
            this.kotaDao = kotaDao;
        }

        @Override
        protected List<Kota> doInBackground(Void... voids) {
            return kotaDao.getAllKota();
        }
    }

    public static class getAllProvAsync extends AsyncTask<Void,Void,List<Provinsi>>{
        private ProvinsiDao provinsiDao;

        public getAllProvAsync(ProvinsiDao provinsiDao) {
            this.provinsiDao = provinsiDao;
        }

        @Override
        protected List<Provinsi> doInBackground(Void... voids) {
            return provinsiDao.getAllProv();
        }
    }

    public static class getAllDataProvinsiAsync extends AsyncTask<Void,Void,List<DataProvinsi>>{
        private DataProvinsiDao dataProvinsiDao;

        public getAllDataProvinsiAsync(DataProvinsiDao dataProvinsiDao) {
            this.dataProvinsiDao = dataProvinsiDao;
        }

        @Override
        protected List<DataProvinsi> doInBackground(Void... voids) {
            return dataProvinsiDao.getAllDataProv();
        }
    }

    public static class getAllDataKotaAsync extends AsyncTask<Void,Void,List<DataKota>>{
        private DataKotaDao dataKotaDao;

        public getAllDataKotaAsync(DataKotaDao dataKotaDao) {
            this.dataKotaDao = dataKotaDao;
        }

        @Override
        protected List<DataKota> doInBackground(Void... voids) {
            return dataKotaDao.getAllDataKota();
        }
    }

    public List<Provinsi> getAllProvinsiLocal(){
        try {
            return new  getAllProvAsync(provinsiDao).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }
    public List<Kota> getAllKotaLocal(){
        try {
            return new getAllKotaAsync(kotaDao).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<DataProvinsi> getAllDataProvinsiLocal(){
        try {
            return  new getAllDataProvinsiAsync(dataProvinsiDao).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }return null;
    }

    public List<DataKota> getAllDataKotaLocal(){
        try {
            return  new getAllDataKotaAsync(dataKotaDao).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }return null;

    }

    public static class getPriorProvAsync extends AsyncTask<String,Void, Integer>{
        private DataProvinsiDao dataProvinsiDao;

        public getPriorProvAsync(DataProvinsiDao dataProvinsiDao) {
            this.dataProvinsiDao = dataProvinsiDao;
        }

        @Override
        protected Integer doInBackground(String... strings) {
            return dataProvinsiDao.getPriorityProvByProv(strings[0]);

        }
    }

    public static class getPriorKotaAsync extends AsyncTask<String,Void, Integer>{
        private DataKotaDao dataKotaDao;

        public getPriorKotaAsync(DataKotaDao dataKotaDao) {
            this.dataKotaDao = dataKotaDao;
        }

        @Override
        protected Integer doInBackground(String... strings) {
            return dataKotaDao.getPriorityKotaByKota(strings[0]);

        }
    }

    public int getPriorProv(String prov){
        try {
            return new getPriorProvAsync(dataProvinsiDao).execute(prov).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }return Integer.parseInt(null);
    }
    public int getPriorKota(String kota){
        try {
            return new getPriorKotaAsync(dataKotaDao).execute(kota).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }return Integer.parseInt(null);
    }



}
