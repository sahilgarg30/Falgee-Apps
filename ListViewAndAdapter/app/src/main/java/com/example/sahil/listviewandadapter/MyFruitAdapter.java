package com.example.sahil.listviewandadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Sahil on 12-06-2017.
 */

public class MyFruitAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> mFruitList;
    private LayoutInflater mLayoutInflater;

    public MyFruitAdapter(Context mContext, ArrayList<String> mFruitList) {
        this.mContext = mContext;
        this.mFruitList = mFruitList;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    public void setmFruitList(ArrayList<String> mFruitList) {
        this.mFruitList = mFruitList;
    }

    @Override
    public int getCount() {
        return mFruitList.size();
    }

    @Override
    public Object getItem(int position) {
        return mFruitList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.item_layout,parent,false);
        }
        TextView fruitTv = (TextView) convertView.findViewById(R.id.textView);
        fruitTv.setText(mFruitList.get(position));
        Log.i("MyFruitAdapter","position" + position);
        return convertView;
    }
}
