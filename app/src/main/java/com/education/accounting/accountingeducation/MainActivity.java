package com.education.accounting.accountingeducation;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.education.accounting.accountingeducation.database.core.DatabaseHelper;

import com.education.accounting.accountingeducation.database.core.*;

public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SQLiteDatabase mydB = new DatabaseHelper(this).getWritableDatabase();
        Log.d("sqlite", "mydB instance berjalan");
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run () {

                Intent homeIntent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(homeIntent);
                finish();

            }
        },SPLASH_TIME_OUT);
    }
}
