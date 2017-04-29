package com.education.accounting.accountingeducation.material;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.education.accounting.accountingeducation.R;
import com.education.accounting.accountingeducation.database.core.DatabaseHelper;
import com.education.accounting.accountingeducation.database.table.user;
import com.education.accounting.accountingeducation.menu.Menuv2;

public class pertanyaan extends AppCompatActivity implements View.OnClickListener {

    private EditText pertanyaan;
    private Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertanyaan);

        pertanyaan = (EditText) findViewById(R.id.editText_pertanyaan);


        btn_next = (Button) findViewById(R.id.next3);

        btn_next.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(pertanyaan.getText().toString().trim().equals("")){
            Toast.makeText(this, "Pertanyaan wajib di isi", Toast.LENGTH_SHORT).show();
        }else if(view == btn_next){
            //starting update database

            Intent iin= getIntent();
            Bundle b = iin.getExtras();

            Intent data_transfer = new Intent (this, temukanjawaban.class);
            data_transfer.putExtra("HasilPengamatan", (String) b.get("HasilPengamatan"));
            data_transfer.putExtra("Pertanyaan", pertanyaan.getText().toString());


//            UpdateData((String) b.get("HasilPengamatan"));

            finish();
            startActivity(data_transfer);
//            startActivity(new Intent(this, temukanjawaban.class));
        }


    }

    @Override
    public void onBackPressed() {
        askToClose();
    }

    private void askToClose (){
        AlertDialog.Builder builder = new AlertDialog.Builder(pertanyaan.this);
        builder.setMessage("Apakah anda yakin akan kembali ? Data-data yang telah anda masukkan akan hilang");
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
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

//    private void UpdateData (String hasilpengamatan) {
//        long count;
//        SQLiteDatabase mydB = new DatabaseHelper(this).getWritableDatabase();
//        SQLiteDatabase db = new DatabaseHelper(this).getReadableDatabase();
//        try {
//            count = DatabaseUtils.queryNumEntries(db, user.table.TABLE_NAME);
//        } finally {
//            db.close();
//        }
//
//        Log.d("sqlite", "udah masuk ke Update data");
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(user.table.COL_3, hasilpengamatan);
//        contentValues.put(user.table.COL_4, pertanyaan.getText().toString());
//        contentValues.put(user.table.COL_5, 0);
//        contentValues.put(user.table.COL_6, 0);
//        try {
//            mydB.update(user.table.TABLE_NAME, contentValues, "ID=" + count,
//                    null);
//        } finally {
//            //It's important to close the statement when you are done with it
//            mydB.close();
//        }
//    }


}
