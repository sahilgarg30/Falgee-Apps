package com.example.sahil.bindservice;

import android.app.Activity;
import android.app.IntentService;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ServiceConnection mServiceConnection;
    private MyService mMyService;
    private boolean isServiceConnected;
    private TextView mResultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mResultTv = (TextView)findViewById(R.id.textView);

        mServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder iBinder) {
                mMyService = ((MyService.LocalBinder)iBinder).getService();
                isServiceConnected = true;
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
    }

    public void connectService(View view) {
        Intent intent = new Intent(MainActivity.this,MyService.class);
        bindService(intent,mServiceConnection,BIND_AUTO_CREATE);
    }

    public void disconnectService(View view) {
        if(isServiceConnected){
            unbindService(mServiceConnection);
            isServiceConnected = false;
        }else{
            Toast.makeText(MainActivity.this, "Service Not Connected.", Toast.LENGTH_SHORT).show();
        }

    }

    public void getResult(View view) {
        if(isServiceConnected){
            double result = mMyService.getSQRT(8);
            mResultTv.setText(String.valueOf(result));
        }
        else{
            Toast.makeText(MainActivity.this, "Service Not Connected.", Toast.LENGTH_SHORT).show();
        }
    }
}
