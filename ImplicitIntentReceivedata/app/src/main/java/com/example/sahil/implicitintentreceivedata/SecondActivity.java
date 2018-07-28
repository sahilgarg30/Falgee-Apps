package com.example.sahil.implicitintentreceivedata;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends Activity {

    private TextView mNameTv;
    private EditText mAddEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mNameTv = (TextView) findViewById(R.id.name_tv);
        mAddEt = (EditText) findViewById(R.id.address_et);
    }

    @Override
    protected void onStart() {
        super.onStart();
        String name = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        mNameTv.setText(name);

    }

    public void sendData(View view) {
        Intent intent = new Intent();
        String address = mAddEt.getText().toString();
        intent.putExtra("myadd",address);
        setResult(RESULT_OK,intent);
        finish();
    }
}
