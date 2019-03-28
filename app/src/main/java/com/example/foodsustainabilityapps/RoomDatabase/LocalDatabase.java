package com.example.foodsustainabilityapps.RoomDatabase;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.foodsustainabilityapps.RoomDatabase.Dao.DataKotaDao;
import com.example.foodsustainabilityapps.RoomDatabase.Dao.DataProvinsiDao;
import com.example.foodsustainabilityapps.RoomDatabase.Dao.KotaDao;
import com.example.foodsustainabilityapps.RoomDatabase.Dao.ProvinsiDao;
import com.example.foodsustainabilityapps.RoomDatabase.Table.DataKota;
import com.example.foodsustainabilityapps.RoomDatabase.Table.DataProvinsi;
import com.example.foodsustainabilityapps.RoomDatabase.Table.Kota;
import com.example.foodsustainabilityapps.RoomDatabase.Table.Provinsi;

@Database(entities = {Provinsi.class, Kota.class, DataProvinsi.class, DataKota.class}, version = 2, exportSchema = false)
public abstract class LocalDatabase extends RoomDatabase {
    private static LocalDatabase mLocalDatabase;
    public abstract ProvinsiDao provinsiDao();
    public abstract KotaDao kotaDao();
    public abstract DataKotaDao dataKotaDao();
    public abstract DataProvinsiDao dataProvinsiDao();

    public LocalDatabase() {
    }

    public static synchronized LocalDatabase getLocalDatabase(Context context){
        if (mLocalDatabase == null){
            mLocalDatabase = Room.databaseBuilder(context.getApplicationContext(),LocalDatabase.class,"localdb")
                    .fallbackToDestructiveMigration()
                    .addCallback(mRoomCallback)
                    .build();
        }
        return mLocalDatabase;
    }
    private static RoomDatabase.Callback mRoomCallback = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateProvAsync(mLocalDatabase).execute();
            new PopulateKotaAsync(mLocalDatabase).execute();
            new PopulateDataProvAsync(mLocalDatabase).execute();
            new PopulateDataKotaAsync(mLocalDatabase).execute();
        }
    };

    private static class PopulateProvAsync extends AsyncTask<Void, Void, Void> {
        private ProvinsiDao provinsiDao;
        private PopulateProvAsync(LocalDatabase ldb){
            provinsiDao = ldb.provinsiDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            provinsiDao.insertAllProv(new Provinsi(1,"Aceh"));
            provinsiDao.insertAllProv(new Provinsi(2,"Sumatera Utara"));
            provinsiDao.insertAllProv(new Provinsi(3,"Sumatera Barat"));
            provinsiDao.insertAllProv(new Provinsi(4,"Riau"));
            provinsiDao.insertAllProv(new Provinsi(5,"Jambi"));
            provinsiDao.insertAllProv(new Provinsi(6,"Sumatera Selatan"));
            provinsiDao.insertAllProv(new Provinsi(7,"Bengkulu"));
            provinsiDao.insertAllProv(new Provinsi(8,"Lampung"));
            provinsiDao.insertAllProv(new Provinsi(9,"Jagung"));
            provinsiDao.insertAllProv(new Provinsi(10,"Kepulauan Bangka Belitung"));
            provinsiDao.insertAllProv(new Provinsi(11,"Kepulauan Riau"));
            provinsiDao.insertAllProv(new Provinsi(12,"Jawa Barat"));
            provinsiDao.insertAllProv(new Provinsi(12,"Jawa Tengah"));
            provinsiDao.insertAllProv(new Provinsi(13,"DI. Yogyakarta"));
            provinsiDao.insertAllProv(new Provinsi(14,"Jawa Timur"));
            provinsiDao.insertAllProv(new Provinsi(15,"Banten"));
            provinsiDao.insertAllProv(new Provinsi(16,"Bali"));
            provinsiDao.insertAllProv(new Provinsi(17,"Nusa Tenggara Barat"));
            provinsiDao.insertAllProv(new Provinsi(18,"Nusa Tenggara Timur"));
            provinsiDao.insertAllProv(new Provinsi(19,"Kalimantan Barat"));
            provinsiDao.insertAllProv(new Provinsi(20,"Kalimantan Tengah"));
            provinsiDao.insertAllProv(new Provinsi(21,"Kalimantan Selatan"));
            provinsiDao.insertAllProv(new Provinsi(22,"Kalimantan Timur"));
            provinsiDao.insertAllProv(new Provinsi(23,"Sulawesi Utara"));
            provinsiDao.insertAllProv(new Provinsi(24,"Sulawesi Tengah"));
            provinsiDao.insertAllProv(new Provinsi(25,"Sulawesi Selatan"));
            provinsiDao.insertAllProv(new Provinsi(26,"Sulawesi Tenggara"));
            provinsiDao.insertAllProv(new Provinsi(27,"Gorontalo"));
            provinsiDao.insertAllProv(new Provinsi(28,"Sulawesi Barat"));
            provinsiDao.insertAllProv(new Provinsi(29,"Maluku"));
            provinsiDao.insertAllProv(new Provinsi(30,"Maluku Utara"));
            provinsiDao.insertAllProv(new Provinsi(31,"Papua Barat"));
            provinsiDao.insertAllProv(new Provinsi(32,"Papua"));


            return null;
        }
    }

    private static class PopulateKotaAsync extends AsyncTask<Void, Void, Void>{
        private KotaDao kotaDao;
        private PopulateKotaAsync(LocalDatabase ldb){
            kotaDao = ldb.kotaDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            kotaDao.insertAllKota(new Kota(1,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(2,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(3,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(4,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(5,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(6,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(7,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(8,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(9,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(10,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(11,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(12,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(13,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(14,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(15,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(16,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(17,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(18,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(19,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(20,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(1,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(2,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(3,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(4,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(5,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(6,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(7,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(8,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(9,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(10,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(11,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(12,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(13,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(14,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(15,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(16,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(17,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(18,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(19,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(20,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(1,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(2,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(3,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(4,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(5,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(6,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(7,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(8,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(9,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(10,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(11,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(12,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(13,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(14,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(15,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(16,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(17,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(18,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(19,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(20,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(1,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(2,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(3,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(4,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(5,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(6,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(7,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(8,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(9,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(10,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(11,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(12,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(13,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(14,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(15,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(16,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(17,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(18,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(19,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(20,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(1,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(2,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(3,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(4,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(5,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(6,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(7,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(8,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(9,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(10,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(11,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(12,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(13,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(14,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(15,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(16,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(17,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(18,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(19,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(20,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(1,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(2,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(3,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(4,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(5,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(6,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(7,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(8,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(9,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(10,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(11,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(12,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(13,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(14,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(15,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(16,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(17,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(18,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(19,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(20,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(1,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(2,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(3,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(4,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(5,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(6,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(7,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(8,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(9,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(10,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(11,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(12,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(13,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(14,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(15,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(16,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(17,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(18,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(19,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(20,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(1,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(2,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(3,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(4,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(5,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(6,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(7,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(8,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(9,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(10,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(11,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(12,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(13,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(14,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(15,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(16,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(17,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(18,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(19,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(20,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(1,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(2,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(3,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(4,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(5,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(6,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(7,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(8,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(9,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(10,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(11,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(12,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(13,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(14,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(15,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(16,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(17,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(18,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(19,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(20,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(1,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(2,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(3,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(4,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(5,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(6,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(7,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(8,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(9,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(10,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(11,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(12,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(13,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(14,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(15,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(16,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(17,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(18,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(19,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(20,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(1,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(2,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(3,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(4,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(5,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(6,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(7,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(8,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(9,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(10,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(11,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(12,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(13,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(14,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(15,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(16,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(17,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(18,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(19,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(20,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(1,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(2,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(3,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(4,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(5,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(6,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(7,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(8,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(9,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(10,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(11,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(12,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(13,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(14,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(15,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(16,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(17,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(18,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(19,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(20,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(1,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(2,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(3,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(4,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(5,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(6,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(7,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(8,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(9,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(10,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(11,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(12,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(13,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(14,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(15,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(16,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(17,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(18,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(19,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(20,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(1,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(2,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(3,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(4,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(5,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(6,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(7,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(8,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(9,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(10,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(11,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(12,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(13,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(14,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(15,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(16,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(17,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(18,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(19,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(20,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(1,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(2,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(3,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(4,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(5,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(6,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(7,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(8,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(9,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(10,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(11,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(12,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(13,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(14,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(15,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(16,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(17,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(18,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(19,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(20,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(1,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(2,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(3,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(4,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(5,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(6,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(7,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(8,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(9,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(10,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(11,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(12,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(13,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(14,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(15,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(16,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(17,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(18,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(19,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(20,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(1,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(2,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(3,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(4,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(5,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(6,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(7,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(8,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(9,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(10,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(11,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(12,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(13,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(14,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(15,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(16,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(17,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(18,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(19,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(20,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(1,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(2,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(3,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(4,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(5,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(6,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(7,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(8,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(9,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(10,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(11,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(12,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(13,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(14,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(15,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(16,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(17,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(18,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(19,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(20,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(1,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(2,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(3,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(4,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(5,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(6,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(7,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(8,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(9,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(10,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(11,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(12,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(13,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(14,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(15,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(16,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(17,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(18,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(19,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(20,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(1,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(2,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(3,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(4,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(5,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(6,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(7,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(8,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(9,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(10,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(11,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(12,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(13,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(14,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(15,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(16,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(17,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(18,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(19,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(20,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(1,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(2,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(3,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(4,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(5,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(6,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(7,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(8,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(9,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(10,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(11,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(12,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(13,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(14,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(15,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(16,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(17,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(18,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(19,"Vegetatif"));
            kotaDao.insertAllKota(new Kota(20,"Vegetatif"));
            return null;
        }
    }

    private static class PopulateDataProvAsync extends AsyncTask<Void, Void, Void> {
        private DataProvinsiDao dataProvinsiDao;

        private PopulateDataProvAsync(LocalDatabase ldb) {
            dataProvinsiDao = ldb.dataProvinsiDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dataProvinsiDao.insertDataProv(new DataProvinsi("Aceh",0.36,17.72,4.79,2.75,38.56,69.4,4.94,1.6,5));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Sumatera Utara",0.3,10.39,11.94,4.45,33.55,69.9,3.2,4.83,5));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Sumatera Barat",0.22,7.56,3.23,5.85,32.47,70.09,3.6,0.96,5));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Riau",1.48,8.42,18.75,5.82,25.98,71.73,3.06,1.42,6));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Jambi",0.71,8.41,7.87,4.74,38.13,69.61,4.89,0.64,4));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Sumatera Selatan",0.29,14.06,8.22,5.39,42.37,70.1,3.99,0.9,4));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Bengkulu",0.37,17.75,3.98,4.85,63.1,70.44,5.62,1.04,4));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Lampung",0.15,14.39,4.9,3.9,46.24,70.09,6.33,0.65,4));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Kepulauan Bangka Belitung",6.42,5.25,1.57,2.6,35.28,69.46,5.06,0,6));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Kepulauan Riau",16.35,6.35,8.19,1.77,24.52,69.97,3.17,1.93,6));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Jawa Barat",0.45,9.61,1.39,0.28,33.68,68.84,4.91,0.3,5));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Jawa Tengah",0.34,14.44,0.58,0.25,26.62,71.97,12.62,0.06,6));
            dataProvinsiDao.insertDataProv(new DataProvinsi("DI. Yogyakarta",0.31,15.03,0,0.33,20.63,73.62,10.94,0,6));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Jawa Timur",0.27,12.73,0.68,0.3,27.03,70.37,13.92,0.02,6));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Banten",0.67,5.89,2.06,0.52,35.05,65.47,5.11,1.55,3));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Bali",0.56,4.49,0.56,0.57,8.71,71.2,14.26,0,6));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Nusa Tenggara Barat",0.25,17.25,1.67,3.03,29.57,63.21,19.41,0,3));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Nusa Tenggara Timur",0.4,20.24,7.71,29.33,44.2,68.05,11.31,3.55,2));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Kalimantan Barat",0.42,8.74,20.44,15.06,35.78,67.4,12.79,5.64,3));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Kalimantan Tengah",0.5,6.23,17.91,12.52,48.89,71.47,3.09,5.54,4));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Kalimantan Selatan",0.24,4.76,8.37,2.24,39.4,64.82,4.66,1.34,3));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Kalimantan Timur",0.65,6.38,8.58,4.02,20.53,71.78,3.62,4.09,6));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Sulawesi Utara",0.23,8.5,3.05,2.06,30.11,72.62,1.08,3.16,5));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Sulawesi Tengah",0.34,14.32,8.76,11.9,42.27,67.21,5.13,2.47,4));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Sulawesi Selatan",0.17,10.32,5.08,4.82,31.18,70.6,12.01,0.59,6));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Sulawesi Tenggara",0.49,13.73,6.6,8.88,28.17,68.56,10.45,4.05,5));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Gorontalo",0.19,18,3.94,10.28,45.99,67.54,2.9,1.09,4));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Sulawesi Barat",0.36,12.23,16.98,14.92,37.56,68.34,11.94,2.93,4));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Maluku",1.26,19.27,27.11,18.88,32.76,67.88,2.85,12.41,2));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Maluku Utara",0.85,7.64,16.72,14.04,39.91,66.97,3.63,9.62,4));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Papua Barat",2.54,27.14,21.31,18.83,33.46,69.14,6.59,26.23,2));
            dataProvinsiDao.insertDataProv(new DataProvinsi("Papua",1.63,31.52,57.11,54.38,55.61,69.13,39.84,37.04,1));

            return null;

        }
    }

    private static class PopulateDataKotaAsync extends AsyncTask<Void, Void, Void> {
        private DataKotaDao dataKotaDao;

        private PopulateDataKotaAsync(LocalDatabase ldb) {
            dataKotaDao = ldb.dataKotaDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            //dataKotaDao.insertDataKota();
            return null;

        }
    }

}
