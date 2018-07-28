package com.example.sahil.linearlayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class FourthActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
    }

    public void goBack(View view) {
        finish();
    }
}
