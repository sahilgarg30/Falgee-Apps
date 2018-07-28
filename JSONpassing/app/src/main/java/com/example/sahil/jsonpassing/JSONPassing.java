package com.example.sahil.jsonpassing;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Sahil on 16-06-2017.
 */

public class JSONPassing extends Application {
    public RequestQueue mRequestQueue;
    public static JSONPassing mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mRequestQueue = getRequestQueue();
        mInstance = this;
    }

    private RequestQueue getRequestQueue() {
        if(mRequestQueue == null){
            mRequestQueue = Volley.newRequestQueue(this);
        }
        return mRequestQueue;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
