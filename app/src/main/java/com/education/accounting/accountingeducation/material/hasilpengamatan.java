package com.education.accounting.accountingeducation.material;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.education.accounting.accountingeducation.MusicBackground;
import com.education.accounting.accountingeducation.R;
import com.education.accounting.accountingeducation.menu.Menuv2;

public class hasilpengamatan extends AppCompatActivity  implements View.OnClickListener{
    private EditText hasil_pengamatan;
    private Button next2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasilpengamatan);

        hasil_pengamatan = (EditText) findViewById(R.id.editText_hasilpengamatan);

        next2 = (Button) findViewById(R.id.next2);
        next2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(hasil_pengamatan.getText().toString().trim().equals("")){
            Toast.makeText(this, "Hasil Pengamatan wajib di isi", Toast.LENGTH_SHORT).show();
        }else if(view == next2){
            //starting to pertanyaan
            Intent data_pengamatan = new Intent (this, pertanyaan.class);
            data_pengamatan.putExtra("HasilPengamatan", hasil_pengamatan.getText().toString());

            finish();
            startActivity(data_pengamatan);
        }
    }

    @Override
    public void onBackPressed() {
        askToClose();
    }

    private void askToClose (){
        AlertDialog.Builder builder = new AlertDialog.Builder(hasilpengamatan.this);
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
}
