package com.example.sahil.unittestcase;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView mResultTv;
    private EditText mSecondNumberEt;
    private EditText mFirstNumberEt;
    private Calculator mCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirstNumberEt = (EditText)findViewById(R.id.firstnumber_et);
        mSecondNumberEt = (EditText)findViewById(R.id.secondnumber_et);
        mResultTv = (TextView)findViewById(R.id.result_tv);
        mCalc = new Calculator();

    }

    public void addNumbers(View view) {
        int a = Integer.parseInt(mFirstNumberEt.getText().toString());
        int b = Integer.parseInt(mSecondNumberEt.getText().toString());
        int result = mCalc.add(a,b);
        mResultTv.setText(String.valueOf(result));
    }

    public void subNumbers(View view) {
        int a = Integer.parseInt(mFirstNumberEt.getText().toString());
        int b = Integer.parseInt(mSecondNumberEt.getText().toString());
        int result = mCalc.subtract(a,b);
        mResultTv.setText(String.valueOf(result));
    }

    public void multiNumbers(View view) {
        int a = Integer.parseInt(mFirstNumberEt.getText().toString());
        int b = Integer.parseInt(mSecondNumberEt.getText().toString());
        int result = mCalc.multiply(a,b);
        mResultTv.setText(String.valueOf(result));
    }

    public void divideNumbers(View view) {
        int a = Integer.parseInt(mFirstNumberEt.getText().toString());
        int b = Integer.parseInt(mSecondNumberEt.getText().toString());
        int result = mCalc.divide(a,b);
        mResultTv.setText(String.valueOf(result));
    }
}
