package com.example.fastreg;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.content.ContextCompat;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ServiceGenerator {
    private String mBaseUrl;
    private int mTipeKamera;
    public final int RADIUS = 10;

    private ServiceGenerator(){

    }
    private static ServiceGenerator serviceGenerator=null;
    public static ServiceGenerator getInstance(){
        if (serviceGenerator==null){
            serviceGenerator = new ServiceGenerator();
        }
        return serviceGenerator;
    }
    public static  <S> S createService(Class<S> serviceType, String baseUrl){
        final OkHttpClient okHttpClient = new OkHttpClient.Builder().connectTimeout(20000, TimeUnit.MILLISECONDS)
                .writeTimeout(20000,TimeUnit.MILLISECONDS).readTimeout(30000,TimeUnit.MILLISECONDS).build();
        Retrofit builder = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build();
        return builder.create(serviceType);
    }
    public ProgressDialog generateProgressDialog(Context context, String title, String message){
        ProgressDialog pd = new ProgressDialog(context);
        pd.setCancelable(false);
        pd.setTitle(title);
        pd.setMessage(message);
        return pd;
    }
    public void generateAlertDialog(Context context, String title, String body){
        AlertDialog.Builder ab = new AlertDialog.Builder(context);
        ab.setCancelable(false);
        ab.setNegativeButton("Cancel", null);
        ab.setTitle(title);
        ab.setMessage(body);
        ab.show();
    }


    public boolean isNetworkAvailable(Context context){
        ConnectivityManager coo = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = coo.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }

    public boolean checkPermission(Context context) {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED){
                    if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                        if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
                            if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public String getmBaseUrl() {
        return ServiceGenerator.getInstance().repairDomain(mBaseUrl);
    }

    public void setmBaseUrl(String mBaseUrl) {
        this.mBaseUrl = mBaseUrl;
    }

    public int getmTipeKamera() {
        return mTipeKamera;
    }

    public void setmTipeKamera(int mTipeKamera) {
        this.mTipeKamera = mTipeKamera;
    }

    public String repairDomain(String domain){
        int idx = domain.length()-1;
        if (domain.substring(idx).equals("/")){
            return domain+"pklserver/index.php/api/";
        }else{
            return domain+"/pklserver/index.php/api/";
        }
    }


    public boolean checkUrl(){
        if (mBaseUrl==null || mBaseUrl.equals("")){
            return false;
        }
        return true;
    }
    public int lastDigit(String number) {
        char[] arrayNumString = number.toCharArray();
        int last = Character.getNumericValue(arrayNumString[arrayNumString.length - 1]);
        return last;
    }
}

