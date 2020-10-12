package com.example.notificationtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice=(Button)findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.send_notice:
                        Intent intent=new Intent(MainActivity.this, NotificationActivity.class);
                        PendingIntent pi=PendingIntent.getActivities(MainActivity.this,0, new Intent[]{intent},0);
                        NotificationManager manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                        Notification notification=new NotificationCompat.Builder(MainActivity.this,"default")
                                .setContentTitle("This is content title")
                                .setContentText("This is content text")
                                .setWhen(System.currentTimeMillis())
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                                .setContentIntent(pi)
                                .setAutoCancel(true)
                                .setStyle(new NotificationCompat.BigTextStyle().bigText("Learn how to build notifications,send and sync data,and use voice actions.Get the official Android IDE and developer tools to build apps for Android."))
                                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background)))
                                .setPriority(NotificationCompat.PRIORITY_MAX)
                                .build();
                        manager.notify(1,notification);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}