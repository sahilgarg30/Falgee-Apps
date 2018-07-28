package com.example.sahil.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {

    private TextView mScoreTv;
    private SharedPreferences mSp;
    private int mScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mScoreTv = (TextView) findViewById(R.id.score_tv);
        mSp = getSharedPreferences("mysp",MODE_PRIVATE);
        mScore = mSp.getInt("myscore",0);
        mScoreTv.setText(String.valueOf(mScore));
    }
}
