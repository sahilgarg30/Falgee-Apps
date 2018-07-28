package com.example.sahil.linearlayout;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ActivityChooserView;
import android.view.View;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

    }

    public void goBack(View view) {
        finish();
    }


    public void goThird(View view) {
        Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
        startActivity(intent);
    }
}
