package com.example.sahil.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity {

    private SecondFragment mSecFrag;
    private ThirdFragment mThirdFrag;
    private FragmentManager mFragManager;
    private FragmentTransaction mFragTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSecFrag = new SecondFragment();
        mThirdFrag = new ThirdFragment();
        mFragManager = getFragmentManager();
        mFragTransaction = mFragManager.beginTransaction();
        mFragTransaction.add(R.id.myframe,mSecFrag);
        mFragTransaction.commit();
    }

    public void change() {
        mFragTransaction = mFragManager.beginTransaction();
        if(mSecFrag.isResumed()){
            mFragTransaction.replace(R.id.myframe,mThirdFrag);
        }
        else {
            mFragTransaction.replace(R.id.myframe,mSecFrag);
        }
        mFragTransaction.commit();
    }
}
