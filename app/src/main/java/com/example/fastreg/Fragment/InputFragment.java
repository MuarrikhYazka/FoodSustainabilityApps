package com.example.fastreg.Fragment;

import android.Manifest;
import android.app.Activity;
import android.arch.lifecycle.ViewModelProviders;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fastreg.R;
import com.example.fastreg.RoomDatabase.Table.Kota;
import com.example.fastreg.RoomDatabase.Table.Provinsi;
import com.example.fastreg.RoomDatabase.ViewModel;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InputFragment extends Fragment {
//    List<Provinsi> provinsi = new LinkedList<Provinsi>();
//    List<Kota> kota = new LinkedList<Kota>();
//    ArrayList<Integer> id_prov = new ArrayList<Integer>();
//    ArrayList<String> nama_prov = new ArrayList<String>();
//    ArrayList<Integer> id_kota = new ArrayList<Integer>();
//    ArrayList<String> nama_kota = new ArrayList<String>();
//    Spinner spinnerProv, spinnerKota;
//
//    Button deteksiProv, deteksiKota;
//    Switch togle;
//    TableRow tableRowKota, tableRowProv;
//    private ViewModel viewModel;

    public String kelahiran_id,tenkes_id,tanggal,jam,jenis_kelamin,jenis_kelahiran,
            kelahiran_ke,berat_lahir,panjang_badan,nama,nama_ibu,umur_ibu,pekerjaan_ibu,no_ktp_ibu,nama_ayah,umur_ayah,pekerjaan_ayah,
            no_ktp_ayah,alamat,kecamatan,kabupaten_kota,scan_ktp_ibu,scan_ktp_ayah,scan_surat_nikah,pdf_skl;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1888;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    Button buttonKtpIbu, buttonKtpAyah, buttonSuratNikah;
    ImageView imgKtpIbu, imgKtpAyah, imgSuratNikah;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input_2, container, false);
        ActivityCompat.requestPermissions(getActivity(), new String[] {Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
//        spinnerProv = view.findViewById(R.id.rst_prov);
//        spinnerKota = view.findViewById(R.id.rst_kota);
//
//        //deteksiKota = view.findViewById(R.id.deteksiKota);
//        deteksiProv = view.findViewById(R.id.deteksiProv);
//        tableRowKota = view.findViewById(R.id.tableRow_kota);
//        tableRowProv = view.findViewById(R.id.tableRow4a);
//        togle = view.findViewById(R.id.switchTogle);
//
//        id_prov.add(0);
//        nama_prov.add("Pilih Salah Satu");

        buttonKtpIbu = (Button) view.findViewById(R.id.scanKtpIbu);
        imgKtpIbu = (ImageView) view.findViewById(R.id.imgKtpIbu);

        buttonKtpIbu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
                startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);



            }
        });







        return view;
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {

                Bitmap bmp = (Bitmap) data.getExtras().get("data");
                ByteArrayOutputStream stream = new ByteArrayOutputStream();

                bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                // convert byte array to Bitmap

                Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0,
                        byteArray.length);

                imgKtpIbu.setImageBitmap(bitmap);

            }
        }


    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        togle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked){
//                    tableRowKota.setVisibility(View.VISIBLE);
//                    spinnerKota.setVisibility(View.VISIBLE);
//                    tableRowProv.setVisibility(View.GONE);
//                    spinnerProv.setVisibility(View.GONE);
//
//                }else {
//                    tableRowKota.setVisibility(View.GONE);
//                    spinnerKota.setVisibility(View.GONE);
//                    tableRowProv.setVisibility(View.VISIBLE);
//                    spinnerProv.setVisibility(View.VISIBLE);
//                    deteksiProv.setOnClickListener(new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            String prov = String.valueOf(spinnerProv.getSelectedItem());
//
//                        }
//                    });
//                }
//            }
//        });
//        viewModel = ViewModelProviders.of(InputFragment.this).get(ViewModel.class);
//        provinsi = viewModel.getProv();
//        for (int i = 0; i< provinsi.size(); i++){
//            id_prov.add(provinsi.get(i).getId_prov());
//            nama_prov.add(provinsi.get(i).getProvinsi());
//            Log.e(provinsi.get(i).getProvinsi(), String.valueOf(provinsi.get(i).getId_prov()));
//
//        }
//
//        spinnerProv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, nama_prov);
//        spinnerProv.setAdapter(adapter);
//
//        nama_kota.add("Pilih Salah Satu");
//        kota = viewModel.getKota();
//        for (int i = 0; i< kota.size(); i++){
//            nama_kota.add(kota.get(i).getKota());
//            Log.e(kota.get(i).getKota(), String.valueOf(kota.get(i).getId_kota()));
//        }
//        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, nama_kota);
//        spinnerKota.setAdapter(adapter2);
//
//
//
//
//    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onResume() {
        super.onResume();

    }

}
