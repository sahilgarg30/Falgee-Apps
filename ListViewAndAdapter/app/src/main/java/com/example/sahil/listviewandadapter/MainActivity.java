package com.example.sahil.listviewandadapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView mListview;
    private ArrayList<String> mFruitsList;
    private MyFruitAdapter mMyFruitAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListview = (ListView) findViewById(R.id.listview);
        mFruitsList = new ArrayList<String>();
        mFruitsList.add("Jack Fruit");
        mFruitsList.add("Mango");
        mFruitsList.add("Banana");
        mFruitsList.add("Orange");
        mFruitsList.add("Grapes");
        mFruitsList.add("Jack Fruit");
        mFruitsList.add("Mango");
        mFruitsList.add("Banana");
        mFruitsList.add("Orange");
        mFruitsList.add("Grapes");
        mFruitsList.add("Jack Fruit");
        mFruitsList.add("Mango");
        mFruitsList.add("Banana");
        mFruitsList.add("Orange");
        mFruitsList.add("Grapes");
        mFruitsList.add("Jack Fruit");
        mFruitsList.add("Mango");
        mFruitsList.add("Banana");
        mFruitsList.add("Orange");
        mFruitsList.add("Grapes");
        mFruitsList.add("Jack Fruit");
        mFruitsList.add("Mango");
        mFruitsList.add("Banana");
        mFruitsList.add("Orange");
        mFruitsList.add("Grapes");
        mFruitsList.add("Jack Fruit");
        mFruitsList.add("Mango");
        mFruitsList.add("Banana");
        mFruitsList.add("Orange");
        mFruitsList.add("Grapes");
        mMyFruitAdapter = new MyFruitAdapter(MainActivity.this,mFruitsList);
        mListview.setAdapter(mMyFruitAdapter);
        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mFruitsList.remove(position);
                mMyFruitAdapter.setmFruitList(mFruitsList);
                mMyFruitAdapter.notifyDataSetChanged();
            }
        });
    }


    public void addAnimals(View view) {
        mFruitsList.add("Tiger");
        mFruitsList.add("Lion");
        mFruitsList.add("Cat");
        mFruitsList.add("Dog");
        mMyFruitAdapter.setmFruitList(mFruitsList);
        mMyFruitAdapter.notifyDataSetChanged();
    }
}
