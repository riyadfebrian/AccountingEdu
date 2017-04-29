package com.education.accounting.accountingeducation;

import android.content.ContentValues;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.education.accounting.accountingeducation.database.core.*;
import com.education.accounting.accountingeducation.database.table.user;
import com.education.accounting.accountingeducation.menu.Menuv2;

public class closing extends AppCompatActivity implements View.OnClickListener {

    private Button end;
    private ImageView closing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closing);
        closing = (ImageView) findViewById(R.id.image_closing);

        Glide.with(this).load(R.drawable.closing).into(closing);

        end = (Button) findViewById(R.id.end);

        end.setOnClickListener(this);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();


        UpdateData((String) b.get("HasilPengamatan"), (String) b.get("Pertanyaan"), (String) b.get("Kesimpulan"));
    }


    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == end){
            //starting login activity
            finish();
        }
    }

    private void UpdateData (String hasilpengamatan, String pertanyaan, String kesimpulan) {
        long count;
        SQLiteDatabase mydB = new com.education.accounting.accountingeducation.database.core.DatabaseHelper(this).getWritableDatabase();
        SQLiteDatabase db = new com.education.accounting.accountingeducation.database.core.DatabaseHelper(this).getReadableDatabase();
        try {
            count = DatabaseUtils.queryNumEntries(db, user.table.TABLE_NAME);
        } finally {
            db.close();
        }

        Log.d("sqlite", "kesimpulan udah masuk ke Update data");
        ContentValues contentValues = new ContentValues();
        contentValues.put(user.table.COL_3, hasilpengamatan);
        contentValues.put(user.table.COL_4, pertanyaan);
        contentValues.put(user.table.COL_5, kesimpulan);
        try {
            mydB.update(user.table.TABLE_NAME, contentValues, "ID=" + count,
                    null);
        } finally {
            //It's important to close the statement when you are done with it
            mydB.close();
        }
    }
}
