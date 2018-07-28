package com.example.sahil.activitystateloss;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends Activity {

    private EditText mNumber2;
    private EditText mNumber1;
    private TextView mSumTv;
    private int c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mNumber1 = (EditText) findViewById(R.id.editText2);
        mNumber2 = (EditText) findViewById(R.id.editText3);
        mSumTv = (TextView) findViewById(R.id.textView2);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("sum",c);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState != null){
            c = savedInstanceState.getInt("sum",0);
            mSumTv.setText(String.valueOf(c));
        }
    }

    public void addTwoNumbers(View view) {
        String number1 = mNumber1.getText().toString();
        String number2 = mNumber2.getText().toString();
        int a = Integer.parseInt(number1);
        int b = Integer.parseInt(number2);
        c = a+b;
        mSumTv.setText(String.valueOf(c));
    }
}
