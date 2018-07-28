package com.example.sahil.jsonpassing;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Sahil on 15-06-2017.
 */

public class MyContactAsync extends AsyncTask<String,String,String> {

    private Context mContext;
    private ListView mListView;
    private ProgressDialog mProgressDialog;
    private MyAdapter mMyAdapter;

    public MyContactAsync(Context mContext, ListView mListView) {
        this.mContext = mContext;
        this.mListView = mListView;
        this.mProgressDialog = new ProgressDialog(mContext);
    }

    @Override
    protected String doInBackground(String... params) {
        //Heavy task, downloads JSON file from network and may take more than 5 seconds to function
        String line=null;
        StringBuilder sb=new StringBuilder();
        try{
            publishProgress("Url created...");
            Thread.sleep(2000);
            URL url=new URL(params[0]);
            HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
            httpURLConnection.connect();
            publishProgress("Server connected...");
            Thread.sleep(2000);
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            while ((line=bufferedReader.readLine())!=null){
                sb.append(line);
            }
            publishProgress("Response recieved...","Connection closed...");
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        line=sb.toString();
        return line;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray jsonArray = jsonObject.getJSONArray("contacts");
            ArrayList<Contact> mContactList = new ArrayList<>();
            for(int i=0;i<jsonArray.length();i++){
                Contact contact = new Contact();
                contact.setId(jsonArray.getJSONObject(i).getString("id"));
                contact.setName(jsonArray.getJSONObject(i).getString("name"));
                contact.setEmail(jsonArray.getJSONObject(i).getString("email"));
                contact.setAddress(jsonArray.getJSONObject(i).getString("address"));
                contact.setGender(jsonArray.getJSONObject(i).getString("gender"));

                Phone phone = new Phone();
                phone.setHome(jsonArray.getJSONObject(i).getJSONObject("phone").getString("home"));
                phone.setMobile(jsonArray.getJSONObject(i).getJSONObject("phone").getString("mobile"));
                phone.setOffice(jsonArray.getJSONObject(i).getJSONObject("phone").getString("office"));
                contact.setPhone(phone);

                mContactList.add(contact);
            }
            mMyAdapter = new MyAdapter(mContext,mContactList);
            mListView.setAdapter(mMyAdapter);
            mProgressDialog.dismiss();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        mProgressDialog.setMessage(values[0]);

    }

}
