package com.example.sahil.contentresolver;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getContacts(View view) {
        ContentResolver cr = getContentResolver();
        /*Uri uri = ContactsContract.Contacts.CONTENT_URI;
        Cursor c = cr.query(uri,null,null,null, ContactsContract.Contacts.DISPLAY_NAME + " desc ");
        while(c.moveToNext()){
            Toast.makeText(MainActivity.this, c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)), Toast.LENGTH_SHORT).show();
        }*/

        Uri uri = Uri.parse("content://com.sahilgarg.contentprovider.studentinfo");
        Cursor c = cr.query(uri,null,null,null,null);
        while(c.moveToNext()){
            Toast.makeText(MainActivity.this, c.getString(0)+" "+c.getString(1)+" " + c.getString(2), Toast.LENGTH_SHORT).show();
        }
    }
}
