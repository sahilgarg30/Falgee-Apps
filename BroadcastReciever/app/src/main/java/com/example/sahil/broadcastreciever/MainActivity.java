package com.example.sahil.broadcastreciever;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends Activity {

    private IntentFilter mIntentFilter;
    private MyReceiver mMyReciever;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMyReciever = new MyReceiver();
        mIntentFilter = new IntentFilter();
        mIntentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        mIntentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        mIntentFilter.addAction("my.own.ACTION");
        registerReceiver(mMyReciever,mIntentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mMyReciever);
    }
}
