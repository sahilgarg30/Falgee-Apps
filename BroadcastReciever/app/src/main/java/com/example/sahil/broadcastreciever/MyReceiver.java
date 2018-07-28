package com.example.sahil.broadcastreciever;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ContentProviderOperation;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        //throw new UnsupportedOperationException("Not yet implemented");
        String title;
        String content;
        int id;
        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            Toast.makeText(context, "Power Connected!", Toast.LENGTH_SHORT).show();
            title = "Power Connected!";
            content = "Charging Now.";
            id =5;
        }
        else if(intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)){
            Toast.makeText(context, "Power Disconnected!", Toast.LENGTH_SHORT).show();
            title = "Power Disconnected!";
            content = "Not Charging Now.";
            id=6;
        }else{
            title = intent.getStringExtra("mytitle");
            content = intent.getStringExtra("mycontent");
            id = 7;
        }

        Notification.Builder mBuilder = new Notification.Builder(context);
        mBuilder.setContentTitle(title);
        mBuilder.setContentText(content);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(id,mBuilder.build());
    }
}
