package com.example.sahil.sharedpreferences;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView mCountTv;
    private int mScore;
    private SharedPreferences mSp;
    private SharedPreferences.Editor mEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCountTv = (TextView) findViewById(R.id.count_tv);
        mSp = getSharedPreferences("mysp",MODE_PRIVATE);
        mEdit = mSp.edit();
        mScore = mSp.getInt("myscore",0);
        mCountTv.setText(String.valueOf(mScore));

    }

    public void increaseScore(View view) {
        mScore++;
        mCountTv.setText(String.valueOf(mScore));
        mEdit.putInt("myscore",mScore);
        mEdit.commit();
    }

    public void goNext(View view) {
        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }
}
