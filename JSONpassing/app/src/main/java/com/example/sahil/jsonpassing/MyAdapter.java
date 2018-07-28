package com.example.sahil.jsonpassing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Sahil on 15-06-2017.
 */

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private ArrayList<Contact> mContactList;

    public MyAdapter(Context mContext, ArrayList<Contact> mContactList) {
        this.mContext = mContext;
        this.mContactList = mContactList;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override

    public int getCount() {
        return mContactList.size();
    }

    @Override
    public Object getItem(int position) {
        return mContactList.get(position);
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
        TextView idTv = (TextView) convertView.findViewById(R.id.id_tv);
        TextView nameTv = (TextView) convertView.findViewById(R.id.name_tv);
        TextView emailTv = (TextView) convertView.findViewById(R.id.email_tv);
        TextView addressTv = (TextView) convertView.findViewById(R.id.add_tv);
        TextView genderTv = (TextView) convertView.findViewById(R.id.gender_tv);
        TextView phoneTv = (TextView)convertView.findViewById(R.id.phone_tv);

        idTv.setText(mContactList.get(position).getId());
        nameTv.setText(mContactList.get(position).getName());
        emailTv.setText(mContactList.get(position).getEmail());
        addressTv.setText(mContactList.get(position).getAddress());
        genderTv.setText(mContactList.get(position).getGender());
        phoneTv.setText("Phone: Home - " + mContactList.get(position).getPhone().getHome()
                        + "\n\t\t\t\t\t\t Mobile - " +mContactList.get(position).getPhone().getMobile()
                        + "\n\t\t\t\t\t\t Office - " +mContactList.get(position).getPhone().getOffice());
        return convertView;
    }
}
