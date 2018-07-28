package com.example.sahil.passingdata;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class secondActivity extends Activity {

    private TextView mNameTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String name = intent.getStringExtra(getString(R.string.myname));
        mNameTv = (TextView) findViewById(R.id.name_tv);
        String phone = intent.getStringExtra("myphone");
        String add = intent.getStringExtra("myadd");
        mNameTv.setText("Name : \n" + name +"\nContact No : \n"+phone +"\nAddress : \n" + add + " .");
    }
}
