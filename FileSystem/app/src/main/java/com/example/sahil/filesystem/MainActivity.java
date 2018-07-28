package com.example.sahil.filesystem;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createFile(View view) {
        try{
            File f = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),"myfile.txt");
            if(!f.exists()){
                f.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(f);
            String s = "Android File System";
            byte[] b = s.getBytes();
            fos.write(b);
            fos.flush();
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
