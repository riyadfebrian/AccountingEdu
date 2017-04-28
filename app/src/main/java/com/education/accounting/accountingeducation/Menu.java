package com.education.accounting.accountingeducation;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.education.accounting.accountingeducation.database.core.*;
import com.education.accounting.accountingeducation.database.core.DatabaseHelper;
import com.education.accounting.accountingeducation.database.table.user;
import com.education.accounting.accountingeducation.exercise.QuizActivity;
import com.education.accounting.accountingeducation.exercise.ScrollingActivity;
import com.education.accounting.accountingeducation.material.youtube;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Menu extends AppCompatActivity implements View.OnClickListener {


    private Button home;
    private Button material;
//    private Button forum;
    private Button exercise;
    private Button share;
    private Button about_us;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        home = (Button) findViewById(R.id.home);
        material = (Button) findViewById(R.id.material);
//        forum = (Button) findViewById(R.id.forum);
        exercise = (Button) findViewById(R.id.exercise);
        share = (Button) findViewById(R.id.share);
        about_us = (Button) findViewById(R.id.about_us);




        home.setOnClickListener(this);
        material.setOnClickListener(this);
//        forum.setOnClickListener(this);
        exercise.setOnClickListener(this);
        share.setOnClickListener(this);
        about_us.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == home){
            //starting login activity
            startActivity(new Intent(this, Instruction.class));
        } else if (view == material) {
            startActivity(new Intent(this, youtube.class));
//        } else if (view == forum) {
//            // nope
//            Toast.makeText(this, "Coming soon...", Toast.LENGTH_LONG).show();
        } else if (view == exercise) {
           // nopes
            startActivity(new Intent(this, ScrollingActivity.class));
        } else if (view == share) {

            SQLiteDatabase db = new DatabaseHelper(this).getReadableDatabase();
//            long count = DatabaseUtils.queryNumEntries(db, user.table.TABLE_NAME);
            String query = "SELECT * FROM " + user.table.TABLE_NAME + " ORDER BY column DESC LIMIT 1";
            Cursor cursor = db.query(user.table.TABLE_NAME, null, null, null, null, null, null);
            cursor.moveToLast();
            try {
                        createPdf (cursor.getInt(cursor.getColumnIndex("ID")),
                        cursor.getString(cursor.getColumnIndex("nama")),
                        cursor.getString(cursor.getColumnIndex("hasil_pengamatan")),
                        cursor.getString(cursor.getColumnIndex("pertanyaan")),
                        cursor.getInt(cursor.getColumnIndex("skor_pg")),
                        cursor.getInt(cursor.getColumnIndex("skor_tf")));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (DocumentException e) {
                e.printStackTrace();
            }
            db.close();

        } else if (view == about_us) {
            startActivity(new Intent(this, aboutus.class));
        }
    }



    @Override
    public void onBackPressed() {
        askToClose();
    }

    private void askToClose (){
        AlertDialog.Builder builder = new AlertDialog.Builder(Menu.this);
        builder.setMessage("Are you sure you want to quit?");
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                System.gc();
                System.exit(0);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }



    private void createPdf(int ID, String nama, String hasilpengamatan, String pertanyaan, int skor_pg, int skor_tf) throws FileNotFoundException, DocumentException {

        File pdfFolder = new File(Environment.getExternalStorageDirectory(), "AccountingEdu");
        if (!pdfFolder.exists()) {
            pdfFolder.mkdir();
            Log.i("sqlite", "Pdf Directory created "+ pdfFolder);
        }



        Date date = new Date() ;
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(date);

        File myFile = new File(pdfFolder + "_" + timeStamp + "_" + String.valueOf(ID) + ".pdf");

        OutputStream output = new FileOutputStream(myFile);

        Document doc = new Document(PageSize.A4);

        PdfWriter.getInstance(doc, output);

        doc.open();

        doc.add(new Paragraph("Nama : " + nama));
            doc.add(new Paragraph("Hasil Pengamatan : " + hasilpengamatan));
            doc.add(new Paragraph ("Pertanyaan : " + pertanyaan));
            doc.add(new Paragraph("Skor Pilihan Ganda : " + String.valueOf(skor_pg)));
            doc.add(new Paragraph("Skor Benar Salah : " + String.valueOf(skor_tf)));
            doc.close();


        viewPdf(myFile);

    }


    private void viewPdf(File myFile){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setDataAndType(Uri.fromFile(myFile), "application/pdf");
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(myFile));
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(Intent.createChooser(intent, "Kirim melalui..."));
    }


}
