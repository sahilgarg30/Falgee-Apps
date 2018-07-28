package com.example.sahil.implicitintent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText mNameEt;
    private TextView mAddTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNameEt = (EditText) findViewById(R.id.name_et);
        mAddTv = (TextView) findViewById(R.id.textView2);

    }

    public void shareData(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        String name = mNameEt.getText().toString();
        intent.putExtra(Intent.EXTRA_TEXT,name);
        intent.setType("text/plain");
        startActivityForResult(intent,77);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 77)
        {
            if(resultCode == RESULT_OK)
            {
                String address = data.getStringExtra("myadd");
                mAddTv.setText(address);
                Toast.makeText(MainActivity.this, address,Toast.LENGTH_LONG).show();
            }
        }
    }
}
