package com.example.sahil.sqlitedatabase;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText mPhoneEt;
    private EditText mNameEt;
    private MyHelper mMyHelper;
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNameEt = (EditText)findViewById(R.id.editText);
        mPhoneEt = (EditText)findViewById(R.id.editText2);
        mMyHelper = new MyHelper(MainActivity.this, "STUDDB",null,1);
        mDb = mMyHelper.getWritableDatabase();
    }

    public void insertData(View view) {
        ContentValues cv = new ContentValues();
        cv.put("name",mNameEt.getText().toString());
        cv.put("phone",mPhoneEt.getText().toString());
        long id = mDb.insert("studentinfo",null,cv);
        Toast.makeText(MainActivity.this,String.valueOf(id), Toast.LENGTH_LONG).show();
        }

    public void readData(View view) {
        Cursor c = mDb.query("studentinfo",null,null,null,null,null,null);
        while (c.moveToNext())
        {
            Toast.makeText(MainActivity.this,c.getString(1), Toast.LENGTH_SHORT).show();
        }


    }
}
