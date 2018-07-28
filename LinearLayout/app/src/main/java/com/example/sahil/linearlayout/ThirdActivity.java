package com.example.sahil.linearlayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ThirdActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

    }

    public void goBack(View view) {
        finish();
    }

    public void goNext(View view) {
        Intent intent = new Intent(ThirdActivity.this,FourthActivity.class);
        startActivity(intent);
    }
}
