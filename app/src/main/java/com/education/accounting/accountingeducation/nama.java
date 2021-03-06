package com.education.accounting.accountingeducation;


import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.education.accounting.accountingeducation.database.core.DatabaseHelper;
import com.education.accounting.accountingeducation.database.table.user;
import com.education.accounting.accountingeducation.menu.*;
import com.education.accounting.accountingeducation.menu.Menu;


public class nama extends AppCompatActivity implements View.OnClickListener {
//    DatabaseHelper mydB;
    private EditText nama;
    private Button login;
    private ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nama);

        logo = (ImageView) findViewById(R.id.img_logo_nama);
        Glide.with(this).load(R.drawable.logo).into(logo);

        Intent music = new Intent();
        music.setClass(this,MusicBackground.class);
        startService(music);



        nama = (EditText) findViewById(R.id.editText_nama);
        login = (Button) findViewById(R.id.btn_nama);


        login.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {

        if(nama.getText().toString().trim().equals("")){
            Toast.makeText(this, "Nama wajib di isi", Toast.LENGTH_SHORT).show();
        }else if(view == login){
            // Inisialisasi Database
//           mydB = new DatabaseHelper(this).getWritableDatabase();
            Log.d("sqlite", "mydB instance berjalan");

               AddData();

            //starting login activity
            finish();
            startActivity(new Intent(this, Menuv2.class));
        }
    }


    private void AddData () {
        SQLiteDatabase mydB = new DatabaseHelper(this).getWritableDatabase();
        Log.d("sqlite", "udah masuk ke AddData");
        ContentValues contentValues = new ContentValues();
        contentValues.put(user.table.COL_2, nama.getText().toString());
        contentValues.put(user.table.COL_3, "");
        contentValues.put(user.table.COL_4, "");
        contentValues.put(user.table.COL_5, "");
        contentValues.put(user.table.COL_6, 0);
        contentValues.put(user.table.COL_7, 0);

        try {
            mydB.insert(user.table.TABLE_NAME,null ,contentValues);
        } finally {
            mydB.close();
        }

    }

//    private void addData () {
//        boolean isInserted = mydB.inisialisasi(nama.getText().toString());
//        if(isInserted == true)
//            Toast.makeText(nama.this,"Data Inserted",Toast.LENGTH_LONG).show();
//        else
//            Toast.makeText(nama.this,"Data not Inserted",Toast.LENGTH_LONG).show();
//    }
//
//    public  void AddData() {
//        login.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//
//                        Log.d("sqlite", "Intent pindah");
//                        finish();
//                        startActivity(new Intent(this, Menu.class));
//                    }
//                }
//        );
//
//
//    }

}
