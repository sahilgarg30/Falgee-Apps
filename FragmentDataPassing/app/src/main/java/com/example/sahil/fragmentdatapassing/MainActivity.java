package com.example.sahil.fragmentdatapassing;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity {

    private SecondFragment mSecFrag;
    private ThirdFragment mThirdFrag;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    private FirstFragment mFirstFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSecFrag = new SecondFragment();
        mThirdFrag = new ThirdFragment();
        mFragmentManager = getFragmentManager();
        mFirstFrag = (FirstFragment) mFragmentManager.findFragmentById(R.id.fragment);
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.myframe,mSecFrag);
        mFragmentTransaction.commit();

    }

    public void change() {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        if(mSecFrag.isResumed())
            mFragmentTransaction.replace(R.id.myframe,mThirdFrag);
        else
            mFragmentTransaction.replace(R.id.myframe,mSecFrag);
        mFragmentTransaction.addToBackStack(null);
        mFragmentTransaction.commit();
    }

    public void send(String s) {
        if(mSecFrag.isResumed())
        {
            mSecFrag.senddata(s);
        }
        else
            mThirdFrag.senddata(s);
    }

    public void sendPhone(String s) {
            mFirstFrag.sendPhone(s);
    }

    public void sendname1(String s) {
        mFirstFrag.sendname(s);
    }
}
