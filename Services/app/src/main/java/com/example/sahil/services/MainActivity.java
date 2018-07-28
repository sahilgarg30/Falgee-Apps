package com.example.sahil.services;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createService(View view) {
        intent = new Intent(MainActivity.this,MyService.class);
        startService(intent);
    }

    public void destroyService(View view) {
        stopService(intent);
    }
}
