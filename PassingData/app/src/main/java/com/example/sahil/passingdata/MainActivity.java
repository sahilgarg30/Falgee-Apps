package com.example.sahil.passingdata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText mNameEt;
    private EditText mPhoneEt;
    private EditText mAddEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNameEt = (EditText) findViewById(R.id.name_et);
        mPhoneEt = (EditText) findViewById(R.id.phone_et);
        mAddEt = (EditText) findViewById(R.id.add_et);
    }

    public void goNext(View view) {
        Intent intent = new Intent(MainActivity.this,secondActivity.class);
        String name = mNameEt.getText().toString();
        String phone = mPhoneEt.getText().toString();
        String add = mAddEt.getText().toString();
        intent.putExtra("myphone",phone);
        intent.putExtra(getString(R.string.myname),name);
        intent.putExtra("myadd",add);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
            super.onBackPressed();
    }
}
