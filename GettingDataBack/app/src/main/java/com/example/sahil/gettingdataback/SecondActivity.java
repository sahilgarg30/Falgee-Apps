package com.example.sahil.gettingdataback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends Activity {

    private EditText mPhoneEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mPhoneEt = (EditText) findViewById(R.id.phone_et);

    }

    public void sendResult(View view) {
        Intent intent = new Intent();
        String phone = mPhoneEt.getText().toString();
        intent.putExtra(getString(R.string.myphone),phone);
        setResult(RESULT_OK,intent);
        finish();
    }
}
