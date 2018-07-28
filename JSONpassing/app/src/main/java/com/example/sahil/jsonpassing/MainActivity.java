package com.example.sahil.jsonpassing;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView mListView;
    private MyContactAsync mMyAsync;
    private JsonObjectRequest mJsonRequest;
    private MyAdapter mMyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView)findViewById(R.id.listview);
        //done using our own AsyncTask
       /* mMyAsync = new MyContactAsync(MainActivity.this,mListView);
        mMyAsync.execute("http://api.androidhive.info/contacts/");*/

       //done using GSON and Volley Library
        final ProgressDialog mProgressDialog = new ProgressDialog(MainActivity.this);
       mJsonRequest = new JsonObjectRequest("http://api.androidhive.info/contacts/", new Response.Listener<JSONObject>() {
           @Override
           public void onResponse(JSONObject response) {
               Gson gson = new Gson();
               ContactsInfo contactsInfo = gson.fromJson(response.toString(),ContactsInfo.class);
               mMyAdapter = new MyAdapter(MainActivity.this,(ArrayList<Contact>)contactsInfo.getContacts());
               mListView.setAdapter(mMyAdapter);
               mProgressDialog.dismiss();
           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {

           }
       });
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();
        JSONPassing.mInstance.mRequestQueue.add(mJsonRequest);
    }
}
