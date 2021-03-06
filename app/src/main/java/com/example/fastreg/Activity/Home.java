package com.example.fastreg.Activity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fastreg.R;


public class Home extends AppCompatActivity {
    TextView deteksi, peta, list, ketDeteksi, ketPeta, ketList;
    private LinearLayout linearDeteksi, linearPeta, linearList;
    private ImageView logoDeteksi, logoPeta, logoList;
    private Button mulaiBtn;


    @Override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        deteksi = findViewById(R.id.tv_deteksi);
//        ketDeteksi = findViewById(R.id.tv_ketDeteksi);
        peta = findViewById(R.id.tv_peta);
//        ketPeta = findViewById(R.id.tv_ketPeta);
        list = findViewById(R.id.tv_list);
//        ketList = findViewById(R.id.tv_ketList);
        logoDeteksi = findViewById(R.id.im_deteksi);
        logoList = findViewById(R.id.im_list);
        logoPeta = findViewById(R.id.im_peta);
        linearDeteksi = findViewById(R.id.linear_deteksi);
        linearPeta = findViewById(R.id.linear_peta);
        linearList = findViewById(R.id.linear_list);
//        mulaiBtn = findViewById(R.id.mulaideteksi);


        if (Preferences.getStatusNotifikasi(this)) {
            showNotif();
            Preferences.setStatusNotifkasi(this, false);
        }


        linearList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, MainActivity.class);
                startActivity(intent);
            }
        });

        linearDeteksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }

    public void showNotif() {
        String NOTIFICATION_CHANNEL_ID = "channel_androidnotif";
        Context context = this.getApplicationContext();
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelName = "Android Notif Channel";
            int importance = NotificationManager.IMPORTANCE_HIGH;

            NotificationChannel mChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, channelName, importance);
            notificationManager.createNotificationChannel(mChannel);
        }

        Intent mIntent = new Intent(this, MainActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("fromnotif", "notif");
        mIntent.putExtras(bundle);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, mIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);
        builder.setContentIntent(pendingIntent)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setLargeIcon(BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_launcher_foreground))
                .setTicker("notif starting")
                .setAutoCancel(true)
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000})
                .setLights(Color.RED, 3000, 3000)
                .setDefaults(Notification.DEFAULT_SOUND)
                .setContentTitle("Mari Kita Sukseskan Pembangunan")
                .setContentText("Segera lakukan registrasi penduduk");

        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(115, builder.build());
    }
}
