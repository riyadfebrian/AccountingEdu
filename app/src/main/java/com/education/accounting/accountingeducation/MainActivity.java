package com.education.accounting.accountingeducation;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.education.accounting.accountingeducation.database.core.DatabaseHelper;
import com.education.accounting.accountingeducation.exercise.Result;
import com.education.accounting.accountingeducation.menu.*;
import com.education.accounting.accountingeducation.menu.Menu;


public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;

    private SQLiteDatabase mydB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // make new database
        try {
        mydB = new DatabaseHelper(this).getWritableDatabase();
            Log.d("sqlite", "mydB instance berjalan");
        } finally {
            mydB.close();
            Log.d("sqlite", "mydB closed");
        }


        new Handler().postDelayed(new Runnable() {

            @Override
            public void run () {

                Intent homeIntent = new Intent(MainActivity.this, nama.class);
                startActivity(homeIntent);
                finish();

            }
        },SPLASH_TIME_OUT);
    }
}
