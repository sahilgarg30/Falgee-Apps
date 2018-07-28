package com.example.sahil.sendbroadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendAction(View view) {
        Intent intent = new Intent();
        intent.setAction("my.own.ACTION");
        intent.putExtra("mytitle","Welcome!");
        intent.putExtra("mycontent","Notified successfully.");
        sendBroadcast(intent);
    }
}
