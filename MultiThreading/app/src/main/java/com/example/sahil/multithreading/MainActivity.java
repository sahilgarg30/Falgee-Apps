package com.example.sahil.multithreading;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView)findViewById(R.id.imageView);

    }

    public void downloadImage(View view) {
        MyTask myTask = new MyTask(MainActivity.this,mImageView);
        myTask.execute("http://dnlyhpqx98dpk.cloudfront.net/wp-content/uploads/tiger-cicle3.png");
    }
}
