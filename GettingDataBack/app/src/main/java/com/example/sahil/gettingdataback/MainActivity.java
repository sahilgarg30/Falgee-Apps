package com.example.sahil.gettingdataback;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView mPhoneTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPhoneTv = (TextView) findViewById(R.id.phone_tv);
    }

    public void goNext(View view) {
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivityForResult(intent,8);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==8)
        {
            if(resultCode == RESULT_OK)
            {
                String phone = data.getStringExtra(getString(R.string.myphone));
                mPhoneTv.setText(phone);

            }
        }
    }
}
