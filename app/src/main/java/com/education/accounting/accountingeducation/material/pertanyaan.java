package com.education.accounting.accountingeducation.material;

import android.content.ContentValues;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
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

            UpdateData((String) b.get("HasilPengamatan"));

            finish();
            startActivity(new Intent(this, temukanjawaban.class));
        }
    }

    private void UpdateData (String hasilpengamatan) {
        long count;
        SQLiteDatabase mydB = new DatabaseHelper(this).getWritableDatabase();
        SQLiteDatabase db = new DatabaseHelper(this).getReadableDatabase();
        try {
            count = DatabaseUtils.queryNumEntries(db, user.table.TABLE_NAME);
        } finally {
            db.close();
        }

        Log.d("sqlite", "udah masuk ke Update data");
        ContentValues contentValues = new ContentValues();
        contentValues.put(user.table.COL_3, hasilpengamatan);
        contentValues.put(user.table.COL_4, pertanyaan.getText().toString());
        contentValues.put(user.table.COL_5, 0);
        contentValues.put(user.table.COL_6, 0);
        try {
            mydB.update(user.table.TABLE_NAME, contentValues, "ID=" + count,
                    null);
        } finally {
            //It's important to close the statement when you are done with it
            mydB.close();
        }





    }


}
