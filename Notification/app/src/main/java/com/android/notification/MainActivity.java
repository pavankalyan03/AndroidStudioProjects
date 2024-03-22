package com.android.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.nio.channels.InterruptedByTimeoutException;

public class MainActivity extends AppCompatActivity {

    Button notice;

    EditText notitext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notice = findViewById(R.id.sign);
        notitext = findViewById(R.id.notificationtext);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
            if(ContextCompat.checkSelfPermission(MainActivity.this,
                    android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.POST_NOTIFICATIONS}, 101);
            }
        }

        notice.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                String channelID = "CHANNEL_ID_NOTIFICATION";
                NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), channelID);
                builder.setSmallIcon(R.drawable.notifications);
                String notify_text = notitext.getText();

                builder.setContentTitle("Notification Title");
                builder.setContentText(notify_text);
                builder.setAutoCancel(true).setPriority(NotificationCompat.PRIORITY_DEFAULT);

                Intent intent = new Intent(getApplicationContext(), notification.class);



                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                intent.putExtra("data",notify_text);

                PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0,intent, PendingIntent.FLAG_MUTABLE);
                builder.setContentIntent(pendingIntent);
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel(channelID);
                    if (notificationChannel == null){
                        int importance = NotificationManager.IMPORTANCE_HIGH;
                        notificationChannel = new NotificationChannel(channelID, "description", importance);
                        notificationChannel.setLightColor(Color.GRAY);
                        notificationChannel.enableVibration(true);
                        notificationManager.createNotificationChannel(notificationChannel);
                    }
                }

                notificationManager.notify(0,builder.build());
            }
        });
    }
}