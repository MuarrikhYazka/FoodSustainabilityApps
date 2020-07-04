package com.example.fastreg.RoomDatabase;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.fastreg.RoomDatabase.Dao.DataKotaDao;
import com.example.fastreg.RoomDatabase.Dao.DataProvinsiDao;
import com.example.fastreg.RoomDatabase.Dao.KotaDao;
import com.example.fastreg.RoomDatabase.Dao.ProvinsiDao;
import com.example.fastreg.RoomDatabase.Table.DataKota;
import com.example.fastreg.RoomDatabase.Table.DataProvinsi;
import com.example.fastreg.RoomDatabase.Table.Kota;
import com.example.fastreg.RoomDatabase.Table.Provinsi;

@Database(entities = {Provinsi.class, Kota.class, DataProvinsi.class, DataKota.class}, version = 2, exportSchema = false)
public abstract class LocalDatabase extends RoomDatabase {
    private static LocalDatabase instance;
    public abstract  KotaDao kotaDao();
    public abstract ProvinsiDao provinsiDao();
    public abstract DataProvinsiDao dataProvinsiDao();
    public abstract DataKotaDao dataKotaDao();

    public LocalDatabase() {
    }

    public static synchronized LocalDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    LocalDatabase.class, "localDatabase")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
            new PopulateKotaAsync(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private ProvinsiDao provinsiDao;

        private PopulateDbAsyncTask(LocalDatabase db) {
            provinsiDao = db.provinsiDao();
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
            kotaDao.insertAllKota(new Kota(1,"Simeuleu"));
            kotaDao.insertAllKota(new Kota(2,"Aceh Singkil"));
            kotaDao.insertAllKota(new Kota(3,"Aceh Selatan"));
            kotaDao.insertAllKota(new Kota(4,"Aceh Tenggara"));
            kotaDao.insertAllKota(new Kota(5,"Aceh Timur"));
            kotaDao.insertAllKota(new Kota(6,"Aceh Tengah"));
            kotaDao.insertAllKota(new Kota(7,"Aceh Barat"));
            kotaDao.insertAllKota(new Kota(8,"Aceh Besar"));
            kotaDao.insertAllKota(new Kota(9,"Pidie"));
            kotaDao.insertAllKota(new Kota(10,"Bireuen"));
            kotaDao.insertAllKota(new Kota(11,"Aceh Utara"));
            kotaDao.insertAllKota(new Kota(12,"Aceh Barat Daya"));
            kotaDao.insertAllKota(new Kota(13,"Gayo Lues"));
            kotaDao.insertAllKota(new Kota(14,"Aceh Tamiang"));
            kotaDao.insertAllKota(new Kota(15,"Nagan Raya"));
            kotaDao.insertAllKota(new Kota(16,"Aceh Jaya"));
            kotaDao.insertAllKota(new Kota(17,"Bener Meriah"));
            kotaDao.insertAllKota(new Kota(18,"Pidie Jaya"));
            kotaDao.insertAllKota(new Kota(19,"Nias"));
            kotaDao.insertAllKota(new Kota(20,"Mandailing Natal"));
            kotaDao.insertAllKota(new Kota(21,"Tapanuli Selatan\n"));
            kotaDao.insertAllKota(new Kota(22,"Tapanuli Tengah\n"));
            kotaDao.insertAllKota(new Kota(23,"Tapanuli Utara\n"));
            kotaDao.insertAllKota(new Kota(24,"Toba Samosir\n"));
            kotaDao.insertAllKota(new Kota(25,"Labuhanbatu\n"));
            kotaDao.insertAllKota(new Kota(26,"Asahan\n"));
            kotaDao.insertAllKota(new Kota(27,"Simalungun\n"));
            kotaDao.insertAllKota(new Kota(28,"Dairi\n"));
            kotaDao.insertAllKota(new Kota(29,"Karo\n"));
            kotaDao.insertAllKota(new Kota(30,"Deli Serdang\n"));
            kotaDao.insertAllKota(new Kota(31,"Langkat\n"));
            kotaDao.insertAllKota(new Kota(32,"Nias Selatan\n"));
            kotaDao.insertAllKota(new Kota(33,"Humbang Hasundutan\n"));
            kotaDao.insertAllKota(new Kota(34,"Pakpak Barat\n"));
            kotaDao.insertAllKota(new Kota(35,"Samosir\n"));
            kotaDao.insertAllKota(new Kota(36,"Serdang Bedagai\n"));
            kotaDao.insertAllKota(new Kota(37,"Batu Bara\n"));
            kotaDao.insertAllKota(new Kota(38,"Padang Lawas Utara\n"));
            kotaDao.insertAllKota(new Kota(39,"Padang Lawas\n"));
            kotaDao.insertAllKota(new Kota(40,"Labuhanbatu Selatan\n"));
            kotaDao.insertAllKota(new Kota(41,"Labuhanbatu Utara\n"));
            kotaDao.insertAllKota(new Kota(42,"Nias Utara\n"));
            kotaDao.insertAllKota(new Kota(43,"Nias Barat\n"));
            kotaDao.insertAllKota(new Kota(44,"Kepulauan Mentawai\n"));
            kotaDao.insertAllKota(new Kota(45,"Pesisir Selatan\n"));
            kotaDao.insertAllKota(new Kota(46,"Solok\n"));
            kotaDao.insertAllKota(new Kota(47,"Sijunjung\n"));
            kotaDao.insertAllKota(new Kota(48,"Tanah Datar\n"));
            kotaDao.insertAllKota(new Kota(49,"Padang Pariaman\n"));
            kotaDao.insertAllKota(new Kota(50,"Agam\n"));
            kotaDao.insertAllKota(new Kota(51,"Lima Puluh Kota\n"));
            kotaDao.insertAllKota(new Kota(52,"Pasaman\n"));
            kotaDao.insertAllKota(new Kota(53,"Solok Selatan\n"));
            kotaDao.insertAllKota(new Kota(54,"Dharmasraya\n"));
            kotaDao.insertAllKota(new Kota(55,"Pasaman Barat\n"));
            kotaDao.insertAllKota(new Kota(56,"Kuantan Singingi\n"));
            kotaDao.insertAllKota(new Kota(57,"Indragiri Hulu\n"));
            kotaDao.insertAllKota(new Kota(58,"Indragiri Hilir\n"));
            kotaDao.insertAllKota(new Kota(59,"Pelalawan\n"));
            kotaDao.insertAllKota(new Kota(60,"Siak\n"));
            kotaDao.insertAllKota(new Kota(61,"Kampar\n"));
            kotaDao.insertAllKota(new Kota(62,"Rokan Hulu\n"));
            kotaDao.insertAllKota(new Kota(63,"Bengkalis\n"));
            kotaDao.insertAllKota(new Kota(64,"Rokan Hilir\n"));
            kotaDao.insertAllKota(new Kota(65,"Kepulauan Meranti\n"));
            kotaDao.insertAllKota(new Kota(66,"Kerinci\n"));
            kotaDao.insertAllKota(new Kota(67,"Merangin\n"));
            kotaDao.insertAllKota(new Kota(68,"Sarolangun\n"));
            kotaDao.insertAllKota(new Kota(69,"Batang Hari\n"));
            kotaDao.insertAllKota(new Kota(70,"Muaro Jambi\n"));
            kotaDao.insertAllKota(new Kota(71,"Tanjung Jabung Timur\n"));
            kotaDao.insertAllKota(new Kota(72,"Tanjung Jabung Barat\n"));
            kotaDao.insertAllKota(new Kota(73,"Tebo\n"));
            kotaDao.insertAllKota(new Kota(74,"Bungo\n"));
            kotaDao.insertAllKota(new Kota(75,"Ogan Komering Ulu\n"));
            kotaDao.insertAllKota(new Kota(76,"Ogan Komering Ilir\n"));
            kotaDao.insertAllKota(new Kota(77,"Muara Enim\n"));
            kotaDao.insertAllKota(new Kota(78,"Lahat\n"));
            kotaDao.insertAllKota(new Kota(79,"Musi Rawas\n"));
            kotaDao.insertAllKota(new Kota(80,"Musi Banyuasin\n"));
            kotaDao.insertAllKota(new Kota(81,"Banyu Asin\n"));
            kotaDao.insertAllKota(new Kota(82,"Ogan Komering Ulu Selatan\n"));
            kotaDao.insertAllKota(new Kota(83,"Ogan Komering Ulu Timur\n"));
            kotaDao.insertAllKota(new Kota(84,"Ogan Ilir\n"));
            kotaDao.insertAllKota(new Kota(85,"Empat Lawang\n"));
            kotaDao.insertAllKota(new Kota(86,"Bengkulu Selatan\n"));
            kotaDao.insertAllKota(new Kota(87,"Rejang Lebong\n"));
            kotaDao.insertAllKota(new Kota(88,"Bengkulu Utara\n"));
            kotaDao.insertAllKota(new Kota(89,"Kaur\n"));
            kotaDao.insertAllKota(new Kota(90,"Seluma\n"));
            kotaDao.insertAllKota(new Kota(91,"Mukomuko\n"));
            kotaDao.insertAllKota(new Kota(92,"Lebong\n"));
            kotaDao.insertAllKota(new Kota(93,"Kepahiang\n"));
            kotaDao.insertAllKota(new Kota(94,"Bengkulu Tengah\n"));
            kotaDao.insertAllKota(new Kota(95,"Lampung Barat\n"));
            kotaDao.insertAllKota(new Kota(96,"Tanggamus\n"));
            kotaDao.insertAllKota(new Kota(97,"Lampung Selatan\n"));
            kotaDao.insertAllKota(new Kota(98,"Lampung Timur\n"));
            kotaDao.insertAllKota(new Kota(99,"Lampung Tengah\n"));
            kotaDao.insertAllKota(new Kota(100,"Lampung Utara\n"));
            kotaDao.insertAllKota(new Kota(101,"Way Kanan\n"));
            kotaDao.insertAllKota(new Kota(102,"Tulangbawang\n"));
            kotaDao.insertAllKota(new Kota(103,"Pesawaran\n"));
            kotaDao.insertAllKota(new Kota(104,"Pringsewu\n"));
            kotaDao.insertAllKota(new Kota(105,"Mesuji\n"));
            kotaDao.insertAllKota(new Kota(106,"Tulang Bawang Barat\n"));
            kotaDao.insertAllKota(new Kota(107,"Bangka\n"));
            kotaDao.insertAllKota(new Kota(108,"Belitung\n"));
            kotaDao.insertAllKota(new Kota(109,"Bangka Barat\n"));
            kotaDao.insertAllKota(new Kota(110,"Bangka Tengah\n"));
            kotaDao.insertAllKota(new Kota(111,"Bangka Selatan\n"));
            kotaDao.insertAllKota(new Kota(112,"Belitung Timur\n"));
            kotaDao.insertAllKota(new Kota(113,"Karimun\n"));
            kotaDao.insertAllKota(new Kota(114,"Bintan\n"));
            kotaDao.insertAllKota(new Kota(115,"Natuna\n"));
            kotaDao.insertAllKota(new Kota(116,"Lingga\n"));
            kotaDao.insertAllKota(new Kota(117,"Kepulauan Anambas\n"));
            kotaDao.insertAllKota(new Kota(118,"Bogor\n"));
            kotaDao.insertAllKota(new Kota(119,"Sukabumi\n"));
            kotaDao.insertAllKota(new Kota(120,"Cianjur\n"));
            kotaDao.insertAllKota(new Kota(121,"Bandung\n"));
            kotaDao.insertAllKota(new Kota(122,"Garut\n"));
            kotaDao.insertAllKota(new Kota(123,"Tasikmalaya\n"));
            kotaDao.insertAllKota(new Kota(124,"Ciamis\n"));
            kotaDao.insertAllKota(new Kota(125,"Kuningan\n"));
            kotaDao.insertAllKota(new Kota(126,"Cirebon\n"));
            kotaDao.insertAllKota(new Kota(127,"Majalengka\n"));
            kotaDao.insertAllKota(new Kota(128,"Sumedang\n"));
            kotaDao.insertAllKota(new Kota(129,"Indramayu\n"));
            kotaDao.insertAllKota(new Kota(130,"Subang\n"));
            kotaDao.insertAllKota(new Kota(131,"Purwakarta\n"));
            kotaDao.insertAllKota(new Kota(132,"Karawang\n"));
            kotaDao.insertAllKota(new Kota(133,"Bekasi\n"));
            kotaDao.insertAllKota(new Kota(134,"Bandung Barat\n"));
            kotaDao.insertAllKota(new Kota(135,"Cilacap\n"));
            kotaDao.insertAllKota(new Kota(136,"Banyumas\n"));
            kotaDao.insertAllKota(new Kota(137,"Purbalingga\n"));
            kotaDao.insertAllKota(new Kota(138,"Banjarnegara\n"));
            kotaDao.insertAllKota(new Kota(139,"Kebumen\n"));
            kotaDao.insertAllKota(new Kota(140,"Purworejo\n"));
            kotaDao.insertAllKota(new Kota(141,"Wonosobo\n"));
            kotaDao.insertAllKota(new Kota(142,"Magelang\n"));
            kotaDao.insertAllKota(new Kota(143,"Boyolali\n"));
            kotaDao.insertAllKota(new Kota(144,"Klaten\n"));
            kotaDao.insertAllKota(new Kota(145,"Sukoharjo\n"));
            kotaDao.insertAllKota(new Kota(146,"Wonogiri\n"));
            kotaDao.insertAllKota(new Kota(147,"Karanganyar\n"));
            kotaDao.insertAllKota(new Kota(148,"Sragen\n"));
            kotaDao.insertAllKota(new Kota(149,"Grobogan\n"));
            kotaDao.insertAllKota(new Kota(150,"Blora\n"));
            kotaDao.insertAllKota(new Kota(151,"Rembang\n"));
            kotaDao.insertAllKota(new Kota(152,"Pati\n"));
            kotaDao.insertAllKota(new Kota(153,"Kudus\n"));
            kotaDao.insertAllKota(new Kota(154,"Jepara\n"));
            kotaDao.insertAllKota(new Kota(155,"Demak\n"));
            kotaDao.insertAllKota(new Kota(156,"Semarang\n"));
            kotaDao.insertAllKota(new Kota(157,"Temanggung\n"));
            kotaDao.insertAllKota(new Kota(158,"Kendal\n"));
            kotaDao.insertAllKota(new Kota(159,"Batang\n"));
            kotaDao.insertAllKota(new Kota(160,"Pekalongan\n"));
            kotaDao.insertAllKota(new Kota(161,"Pemalang\n"));
            kotaDao.insertAllKota(new Kota(162,"Tegal\n"));
            kotaDao.insertAllKota(new Kota(163,"Brebes\n"));
            kotaDao.insertAllKota(new Kota(164,"Kulon Progo\n"));
            kotaDao.insertAllKota(new Kota(165,"Bantul\n"));
            kotaDao.insertAllKota(new Kota(166,"Gunung Kidul\n"));
            kotaDao.insertAllKota(new Kota(167,"Sleman\n"));
            kotaDao.insertAllKota(new Kota(168,"Pacitan\n"));
            kotaDao.insertAllKota(new Kota(169,"Ponorogo\n"));
            kotaDao.insertAllKota(new Kota(170,"Trenggalek\n"));
            kotaDao.insertAllKota(new Kota(171,"Tulungagung\n"));
            kotaDao.insertAllKota(new Kota(172,"Blitar\n"));
            kotaDao.insertAllKota(new Kota(173,"Kediri\n"));
            kotaDao.insertAllKota(new Kota(174,"Malang\n"));
            kotaDao.insertAllKota(new Kota(175,"Lumajang\n"));
            kotaDao.insertAllKota(new Kota(176,"Jember\n"));
            kotaDao.insertAllKota(new Kota(177,"Banyuwangi\n"));
            kotaDao.insertAllKota(new Kota(178,"Bondowoso\n"));
            kotaDao.insertAllKota(new Kota(179,"Situbondo\n"));
            kotaDao.insertAllKota(new Kota(180,"Probolinggo\n"));
            kotaDao.insertAllKota(new Kota(181,"Pasuruan\n"));
            kotaDao.insertAllKota(new Kota(182,"Sidoarjo\n"));
            kotaDao.insertAllKota(new Kota(183,"Mojokerto\n"));
            kotaDao.insertAllKota(new Kota(184,"Jombang\n"));
            kotaDao.insertAllKota(new Kota(185,"Nganjuk\n"));
            kotaDao.insertAllKota(new Kota(186,"Madiun\n"));
            kotaDao.insertAllKota(new Kota(187,"Magetan\n"));
            kotaDao.insertAllKota(new Kota(188,"Ngawi\n"));
            kotaDao.insertAllKota(new Kota(189,"Bojonegoro\n"));
            kotaDao.insertAllKota(new Kota(190,"Tuban\n"));
            kotaDao.insertAllKota(new Kota(191,"Lamongan\n"));
            kotaDao.insertAllKota(new Kota(192,"Gresik\n"));
            kotaDao.insertAllKota(new Kota(193,"Bangkalan\n"));
            kotaDao.insertAllKota(new Kota(194,"Sampang\n"));
            kotaDao.insertAllKota(new Kota(195,"Pamekasan\n"));
            kotaDao.insertAllKota(new Kota(196,"Sumenep\n"));
            kotaDao.insertAllKota(new Kota(197,"Pandeglang\n"));
            kotaDao.insertAllKota(new Kota(198,"Lebak\n"));
            kotaDao.insertAllKota(new Kota(199,"Tangerang\n"));
            kotaDao.insertAllKota(new Kota(200,"Serang\n"));
            kotaDao.insertAllKota(new Kota(201,"Jembrana\n"));
            kotaDao.insertAllKota(new Kota(202,"Tabanan\n"));
            kotaDao.insertAllKota(new Kota(203,"Badung\n"));
            kotaDao.insertAllKota(new Kota(204,"Gianyar\n"));
            kotaDao.insertAllKota(new Kota(205,"Klungkung\n"));
            kotaDao.insertAllKota(new Kota(206,"Bangli\n"));
            kotaDao.insertAllKota(new Kota(207,"Karangasem\n"));
            kotaDao.insertAllKota(new Kota(208,"Buleleng\n"));
            kotaDao.insertAllKota(new Kota(209,"Lombok Barat\n"));
            kotaDao.insertAllKota(new Kota(210,"Lombok Tengah\n"));
            kotaDao.insertAllKota(new Kota(211,"Lombok Timur\n"));
            kotaDao.insertAllKota(new Kota(212,"Sumbawa\n"));
            kotaDao.insertAllKota(new Kota(213,"Dompu\n"));
            kotaDao.insertAllKota(new Kota(214,"Bima\n"));
            kotaDao.insertAllKota(new Kota(215,"Sumbawa Barat\n"));
            kotaDao.insertAllKota(new Kota(216,"Lombok Utara\n"));
            kotaDao.insertAllKota(new Kota(217,"Sumba Barat\n"));
            kotaDao.insertAllKota(new Kota(218,"Sumba Timur\n"));
            kotaDao.insertAllKota(new Kota(219,"Kupang\n"));
            kotaDao.insertAllKota(new Kota(220,"Timor Tengah Selatan\n"));
            kotaDao.insertAllKota(new Kota(221,"Timor Tengah Utara\n"));
            kotaDao.insertAllKota(new Kota(222,"Belu\n"));
            kotaDao.insertAllKota(new Kota(223,"Alor\n"));
            kotaDao.insertAllKota(new Kota(224,"Lembata\n"));
            kotaDao.insertAllKota(new Kota(225,"Flores Timur\n"));
            kotaDao.insertAllKota(new Kota(226,"Sikka\n"));
            kotaDao.insertAllKota(new Kota(227,"Ende\n"));
            kotaDao.insertAllKota(new Kota(228,"Ngada\n"));
            kotaDao.insertAllKota(new Kota(229,"Manggarai\n"));
            kotaDao.insertAllKota(new Kota(230,"Rote Ndao\n"));
            kotaDao.insertAllKota(new Kota(231,"Manggarai Barat\n"));
            kotaDao.insertAllKota(new Kota(232,"Sumba Tengah\n"));
            kotaDao.insertAllKota(new Kota(233,"Sumba Barat Daya\n"));
            kotaDao.insertAllKota(new Kota(234,"Nagekeo\n"));
            kotaDao.insertAllKota(new Kota(235,"Manggarai Timur\n"));
            kotaDao.insertAllKota(new Kota(236,"Sabu Raijua\n"));
            kotaDao.insertAllKota(new Kota(237,"Sambas\n"));
            kotaDao.insertAllKota(new Kota(238,"Bengkayang\n"));
            kotaDao.insertAllKota(new Kota(239,"Landak\n"));
            kotaDao.insertAllKota(new Kota(240,"Pontianak\n"));
            kotaDao.insertAllKota(new Kota(241,"Sanggau\n"));
            kotaDao.insertAllKota(new Kota(242,"Ketapang\n"));
            kotaDao.insertAllKota(new Kota(243,"Sintang\n"));
            kotaDao.insertAllKota(new Kota(244,"Kapuas Hulu\n"));
            kotaDao.insertAllKota(new Kota(245,"Sekadau\n"));
            kotaDao.insertAllKota(new Kota(246,"Melawi\n"));
            kotaDao.insertAllKota(new Kota(247,"Kayong Utara\n"));
            kotaDao.insertAllKota(new Kota(248,"Kubu Raya\n"));
            kotaDao.insertAllKota(new Kota(249,"Kotawaringin Barat\n"));
            kotaDao.insertAllKota(new Kota(250,"Kotawaringin Timur\n"));
            kotaDao.insertAllKota(new Kota(251,"Kapuas\n"));
            kotaDao.insertAllKota(new Kota(252,"Barito Selatan\n"));
            kotaDao.insertAllKota(new Kota(253,"Barito Utara\n"));
            kotaDao.insertAllKota(new Kota(254,"Sukamara\n"));
            kotaDao.insertAllKota(new Kota(255,"Lamandau\n"));
            kotaDao.insertAllKota(new Kota(256,"Seruyan\n"));
            kotaDao.insertAllKota(new Kota(257,"Katingan\n"));
            kotaDao.insertAllKota(new Kota(258,"Pulang Pisau\n"));
            kotaDao.insertAllKota(new Kota(259,"Gunung Mas\n"));
            kotaDao.insertAllKota(new Kota(260,"Barito Timur\n"));
            kotaDao.insertAllKota(new Kota(261,"Murung Raya\n"));
            kotaDao.insertAllKota(new Kota(262,"Tanah Laut\n"));
            kotaDao.insertAllKota(new Kota(263,"Kota Baru\n"));
            kotaDao.insertAllKota(new Kota(264,"Banjar\n"));
            kotaDao.insertAllKota(new Kota(265,"Barito Kuala\n"));
            kotaDao.insertAllKota(new Kota(266,"Tapin\n"));
            kotaDao.insertAllKota(new Kota(267,"Hulu Sungai Selatan\n"));
            kotaDao.insertAllKota(new Kota(268,"Hulu Sungai Tengah\n"));
            kotaDao.insertAllKota(new Kota(269,"Hulu Sungai Utara\n"));
            kotaDao.insertAllKota(new Kota(270,"Tabalong\n"));
            kotaDao.insertAllKota(new Kota(271,"Tanah Bumbu\n"));
            kotaDao.insertAllKota(new Kota(272,"Balangan\n"));
            kotaDao.insertAllKota(new Kota(273,"Paser\n"));
            kotaDao.insertAllKota(new Kota(274,"Kutai Barat\n"));
            kotaDao.insertAllKota(new Kota(275,"Kutai Kartanegara\n"));
            kotaDao.insertAllKota(new Kota(276,"Kutai Timur\n"));
            kotaDao.insertAllKota(new Kota(277,"Berau\n"));
            kotaDao.insertAllKota(new Kota(278,"Malinau\n"));
            kotaDao.insertAllKota(new Kota(279,"Bulungan\n"));
            kotaDao.insertAllKota(new Kota(280,"Nunukan\n"));
            kotaDao.insertAllKota(new Kota(281,"Penajam Paser Utara\n"));
            kotaDao.insertAllKota(new Kota(282,"Tana Tidung\n"));
            kotaDao.insertAllKota(new Kota(283,"Bolaang Mongondow\n"));
            kotaDao.insertAllKota(new Kota(284,"Minahasa\n"));
            kotaDao.insertAllKota(new Kota(285,"Kepulauan Sangihe\n"));
            kotaDao.insertAllKota(new Kota(286,"Kepulauan Talaud\n"));
            kotaDao.insertAllKota(new Kota(287,"Minahasa Selatan\n"));
            kotaDao.insertAllKota(new Kota(288,"Minahasa Utara\n"));
            kotaDao.insertAllKota(new Kota(289,"Bolaang Mongondow Utara\n"));
            kotaDao.insertAllKota(new Kota(290,"Siau Tagulandang Biaro\n"));
            kotaDao.insertAllKota(new Kota(291,"Minahasa Tenggara\n"));
            kotaDao.insertAllKota(new Kota(292,"Bolaang Mongondow Selatan\n"));
            kotaDao.insertAllKota(new Kota(293,"Bolaang Mongondow Timur\n"));
            kotaDao.insertAllKota(new Kota(294,"Banggai Kepulauan\n"));
            kotaDao.insertAllKota(new Kota(295,"Banggai\n"));
            kotaDao.insertAllKota(new Kota(296,"Morowali\n"));
            kotaDao.insertAllKota(new Kota(297,"Poso\n"));
            kotaDao.insertAllKota(new Kota(298,"Donggala\n"));
            kotaDao.insertAllKota(new Kota(299,"Toli-Toli\n"));
            kotaDao.insertAllKota(new Kota(300,"Buol\n"));
            kotaDao.insertAllKota(new Kota(301,"Parigi Moutong\n"));
            kotaDao.insertAllKota(new Kota(302,"Tojo Una-Una\n"));
            kotaDao.insertAllKota(new Kota(303,"Sigi\n"));
            kotaDao.insertAllKota(new Kota(304,"Kepulauan Selayar\n"));
            kotaDao.insertAllKota(new Kota(305,"Bulukumba\n"));
            kotaDao.insertAllKota(new Kota(306,"Bantaeng\n"));
            kotaDao.insertAllKota(new Kota(307,"Jeneponto\n"));
            kotaDao.insertAllKota(new Kota(308,"Takalar\n"));
            kotaDao.insertAllKota(new Kota(309,"Gowa\n"));
            kotaDao.insertAllKota(new Kota(310,"Sinjai\n"));
            kotaDao.insertAllKota(new Kota(311,"Maros\n"));
            kotaDao.insertAllKota(new Kota(312,"Pangkajene Dan Kepulauan\n"));
            kotaDao.insertAllKota(new Kota(313,"Barru\n"));
            kotaDao.insertAllKota(new Kota(314,"Bone\n"));
            kotaDao.insertAllKota(new Kota(315,"Soppeng\n"));
            kotaDao.insertAllKota(new Kota(316,"Wajo\n"));
            kotaDao.insertAllKota(new Kota(317,"Sidenreng Rappang\n"));
            kotaDao.insertAllKota(new Kota(318,"Pinrang\n"));
            kotaDao.insertAllKota(new Kota(319,"Enrekang\n"));
            kotaDao.insertAllKota(new Kota(320,"Luwu\n"));
            kotaDao.insertAllKota(new Kota(321,"Tana Toraja\n"));
            kotaDao.insertAllKota(new Kota(322,"Luwu Utara\n"));
            kotaDao.insertAllKota(new Kota(323,"Luwu Timur\n"));
            kotaDao.insertAllKota(new Kota(324,"Toraja Utara\n"));
            kotaDao.insertAllKota(new Kota(325,"Buton\n"));
            kotaDao.insertAllKota(new Kota(326,"Muna\n"));
            kotaDao.insertAllKota(new Kota(327,"Konawe\n"));
            kotaDao.insertAllKota(new Kota(328,"Kolaka\n"));
            kotaDao.insertAllKota(new Kota(329,"Konawe Selatan\n"));
            kotaDao.insertAllKota(new Kota(330,"Bombana\n"));
            kotaDao.insertAllKota(new Kota(331,"Wakatobi\n"));
            kotaDao.insertAllKota(new Kota(332,"Kolaka Utara\n"));
            kotaDao.insertAllKota(new Kota(333,"Buton Utara\n"));
            kotaDao.insertAllKota(new Kota(334,"Konawe Utara\n"));
            kotaDao.insertAllKota(new Kota(335,"Boalemo\n"));
            kotaDao.insertAllKota(new Kota(336,"Gorontalo\n"));
            kotaDao.insertAllKota(new Kota(337,"Pohuwato\n"));
            kotaDao.insertAllKota(new Kota(338,"Bone Bolango\n"));
            kotaDao.insertAllKota(new Kota(339,"Gorontalo Utara\n"));
            kotaDao.insertAllKota(new Kota(340,"Majene\n"));
            kotaDao.insertAllKota(new Kota(341,"Polewali Mandar\n"));
            kotaDao.insertAllKota(new Kota(342,"Mamasa\n"));
            kotaDao.insertAllKota(new Kota(343,"Mamuju"));
            kotaDao.insertAllKota(new Kota(344,"Mamuju Utara\n"));
            kotaDao.insertAllKota(new Kota(345,"Maluku Tenggara Barat\n"));
            kotaDao.insertAllKota(new Kota(346,"Maluku Tenggara\n"));
            kotaDao.insertAllKota(new Kota(347,"Maluku Tengah\n"));
            kotaDao.insertAllKota(new Kota(348,"Buru\n"));
            kotaDao.insertAllKota(new Kota(349,"Kepulauan Aru\n"));
            kotaDao.insertAllKota(new Kota(350,"Seram Bagian Barat\n"));
            kotaDao.insertAllKota(new Kota(351,"Seram Bagian Timur\n"));
            kotaDao.insertAllKota(new Kota(352,"Maluku Barat Daya\n"));
            kotaDao.insertAllKota(new Kota(353,"Buru Selatan\n"));
            kotaDao.insertAllKota(new Kota(354,"Halmahera Barat\n"));
            kotaDao.insertAllKota(new Kota(355,"Halmahera Tengah\n"));
            kotaDao.insertAllKota(new Kota(356,"Kepulauan Sula\n"));
            kotaDao.insertAllKota(new Kota(357,"Halmahera Selatan\n"));
            kotaDao.insertAllKota(new Kota(358,"Halmahera Utara\n"));
            kotaDao.insertAllKota(new Kota(359,"Halmahera Timur\n"));
            kotaDao.insertAllKota(new Kota(360,"Pulau Morotai\n"));
            kotaDao.insertAllKota(new Kota(361,"Fakfak\n"));
            kotaDao.insertAllKota(new Kota(362,"Kaimana\n"));
            kotaDao.insertAllKota(new Kota(363,"Teluk Wondama\n"));
            kotaDao.insertAllKota(new Kota(364,"Teluk Bintuni\n"));
            kotaDao.insertAllKota(new Kota(365,"Manokwari\n"));
            kotaDao.insertAllKota(new Kota(366,"Sorong Selatan\n"));
            kotaDao.insertAllKota(new Kota(367,"Sorong\n"));
            kotaDao.insertAllKota(new Kota(368,"Raja Ampat\n"));
            kotaDao.insertAllKota(new Kota(369,"Tambrauw\n"));
            kotaDao.insertAllKota(new Kota(370,"Maybrat\n"));
            kotaDao.insertAllKota(new Kota(371,"Merauke\n"));
            kotaDao.insertAllKota(new Kota(372,"Jayawijaya\n"));
            kotaDao.insertAllKota(new Kota(373,"Jayapura\n"));
            kotaDao.insertAllKota(new Kota(374,"Nabire\n"));
            kotaDao.insertAllKota(new Kota(375,"Kepulauan Yapen\n"));
            kotaDao.insertAllKota(new Kota(376,"Biak Numfor\n"));
            kotaDao.insertAllKota(new Kota(377,"Paniai\n"));
            kotaDao.insertAllKota(new Kota(378,"Puncak Jaya\n"));
            kotaDao.insertAllKota(new Kota(379,"Mimika\n"));
            kotaDao.insertAllKota(new Kota(380,"Boven Digoel\n"));
            kotaDao.insertAllKota(new Kota(381,"Mappi\n"));
            kotaDao.insertAllKota(new Kota(382,"Asmat\n"));
            kotaDao.insertAllKota(new Kota(383,"Yahukimo\n"));
            kotaDao.insertAllKota(new Kota(384,"Pegunungan Bintang\n"));
            kotaDao.insertAllKota(new Kota(385,"Tolikara\n"));
            kotaDao.insertAllKota(new Kota(386,"Sarmi\n"));
            kotaDao.insertAllKota(new Kota(387,"Keerom\n"));
            kotaDao.insertAllKota(new Kota(388,"Waropen\n"));
            kotaDao.insertAllKota(new Kota(389,"Supiori\n"));
            kotaDao.insertAllKota(new Kota(390,"Mamberamo Raya\n"));
            kotaDao.insertAllKota(new Kota(391,"Nduga\n"));
            kotaDao.insertAllKota(new Kota(392,"Lanny Jaya\n"));
            kotaDao.insertAllKota(new Kota(393,"Mamberamo Tengah\n"));
            kotaDao.insertAllKota(new Kota(394,"Yalimo\n"));
            kotaDao.insertAllKota(new Kota(395,"Puncak\n"));
            kotaDao.insertAllKota(new Kota(396,"Dogiyai\n"));
            kotaDao.insertAllKota(new Kota(397,"Intan Jaya\n"));
            kotaDao.insertAllKota(new Kota(398,"Deiyai\n"));
        return null;
        }
    }

//    private static class PopulateDataProvAsync extends AsyncTask<Void, Void, Void> {
//        private DataProvinsiDao dataProvinsiDao;
//
//        private PopulateDataProvAsync(LocalDatabase ldb) {
//            dataProvinsiDao = ldb.dataProvinsiDao();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Aceh",0.36,17.72,4.79,2.75,38.56,69.4,4.94,1.6,5));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Sumatera Utara",0.3,10.39,11.94,4.45,33.55,69.9,3.2,4.83,5));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Sumatera Barat",0.22,7.56,3.23,5.85,32.47,70.09,3.6,0.96,5));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Riau",1.48,8.42,18.75,5.82,25.98,71.73,3.06,1.42,6));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Jambi",0.71,8.41,7.87,4.74,38.13,69.61,4.89,0.64,4));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Sumatera Selatan",0.29,14.06,8.22,5.39,42.37,70.1,3.99,0.9,4));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Bengkulu",0.37,17.75,3.98,4.85,63.1,70.44,5.62,1.04,4));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Lampung",0.15,14.39,4.9,3.9,46.24,70.09,6.33,0.65,4));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Kepulauan Bangka Belitung",6.42,5.25,1.57,2.6,35.28,69.46,5.06,0,6));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Kepulauan Riau",16.35,6.35,8.19,1.77,24.52,69.97,3.17,1.93,6));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Jawa Barat",0.45,9.61,1.39,0.28,33.68,68.84,4.91,0.3,5));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Jawa Tengah",0.34,14.44,0.58,0.25,26.62,71.97,12.62,0.06,6));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("DI. Yogyakarta",0.31,15.03,0,0.33,20.63,73.62,10.94,0,6));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Jawa Timur",0.27,12.73,0.68,0.3,27.03,70.37,13.92,0.02,6));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Banten",0.67,5.89,2.06,0.52,35.05,65.47,5.11,1.55,3));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Bali",0.56,4.49,0.56,0.57,8.71,71.2,14.26,0,6));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Nusa Tenggara Barat",0.25,17.25,1.67,3.03,29.57,63.21,19.41,0,3));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Nusa Tenggara Timur",0.4,20.24,7.71,29.33,44.2,68.05,11.31,3.55,2));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Kalimantan Barat",0.42,8.74,20.44,15.06,35.78,67.4,12.79,5.64,3));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Kalimantan Tengah",0.5,6.23,17.91,12.52,48.89,71.47,3.09,5.54,4));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Kalimantan Selatan",0.24,4.76,8.37,2.24,39.4,64.82,4.66,1.34,3));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Kalimantan Timur",0.65,6.38,8.58,4.02,20.53,71.78,3.62,4.09,6));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Sulawesi Utara",0.23,8.5,3.05,2.06,30.11,72.62,1.08,3.16,5));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Sulawesi Tengah",0.34,14.32,8.76,11.9,42.27,67.21,5.13,2.47,4));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Sulawesi Selatan",0.17,10.32,5.08,4.82,31.18,70.6,12.01,0.59,6));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Sulawesi Tenggara",0.49,13.73,6.6,8.88,28.17,68.56,10.45,4.05,5));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Gorontalo",0.19,18,3.94,10.28,45.99,67.54,2.9,1.09,4));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Sulawesi Barat",0.36,12.23,16.98,14.92,37.56,68.34,11.94,2.93,4));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Maluku",1.26,19.27,27.11,18.88,32.76,67.88,2.85,12.41,2));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Maluku Utara",0.85,7.64,16.72,14.04,39.91,66.97,3.63,9.62,4));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Papua Barat",2.54,27.14,21.31,18.83,33.46,69.14,6.59,26.23,2));
//            dataProvinsiDao.insertDataProv(new DataProvinsi("Papua",1.63,31.52,57.11,54.38,55.61,69.13,39.84,37.04,1));
//            return null;
//
//        }
//    }
//
//    private static class PopulateDataKotaAsync extends AsyncTask<Void, Void, Void> {
//        private DataKotaDao dataKotaDao;
//
//        private PopulateDataKotaAsync(LocalDatabase ldb) {
//            dataKotaDao = ldb.dataKotaDao();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            dataKotaDao.insertDataKota(new DataKota("Simeulue",0.66,20.57,5.8,4.28,43.72,63.32,0.37,0,3));
//            return null;
//        }
//    }

}
