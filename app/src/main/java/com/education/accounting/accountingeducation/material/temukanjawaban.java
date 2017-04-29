package com.education.accounting.accountingeducation.material;

import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.education.accounting.accountingeducation.R;
import com.education.accounting.accountingeducation.closing;
import com.education.accounting.accountingeducation.database.core.DatabaseHelper;
import com.education.accounting.accountingeducation.database.table.user;
import com.education.accounting.accountingeducation.openWeb;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class temukanjawaban extends AppCompatActivity implements View.OnClickListener {

    private Button next4;
    private Button btn_bukaBlog, btn_bukaPPT, btn_bukaPDF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temukanjawaban);

        next4 = (Button) findViewById(R.id.next4);
        btn_bukaBlog = (Button) findViewById(R.id.btn_bukaBlog);
        btn_bukaPPT = (Button) findViewById(R.id.btn_bukaPPT);
        btn_bukaPDF = (Button) findViewById(R.id.btn_bukaPDF);

        next4.setOnClickListener(this);
        btn_bukaBlog.setOnClickListener(this);
        btn_bukaPPT.setOnClickListener(this);
        btn_bukaPDF.setOnClickListener(this);


    }

    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }

    private void CopyReadAssets(String pilihan) {
        AssetManager assetManager = getAssets();
        String direktori, datatype;

        if (pilihan == "ppt") {
            direktori = "powerpoint.pptx";
            datatype = "application/vnd.ms-powerpoint";
        } else {
            direktori = "file.pdf";
            datatype = "application/pdf";
        }

        InputStream in = null;
        OutputStream out = null;
        File file = new File(getFilesDir(), direktori);
        try {
            in = assetManager.open(direktori);
            out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
        } catch (Exception e) {
            Log.e("tag", e.getMessage());
        }

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(
                Uri.parse("file://" + getFilesDir() + "/"+direktori),
                datatype);

        startActivity(intent);
    }


    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == next4){
            //starting login activity


            Intent iin= getIntent();
            Bundle b = iin.getExtras();

            Intent data_transfer = new Intent (this, kesimpulan.class);
            data_transfer.putExtra("HasilPengamatan", (String) b.get("HasilPengamatan"));
            data_transfer.putExtra("Pertanyaan", (String) b.get("Pertanyaan"));

            finish();
            startActivity(data_transfer);
        } else if (view == btn_bukaBlog) {
            startActivity(new Intent(this, openWeb.class));
        } else if (view == btn_bukaPPT) {
            CopyReadAssets("ppt");
        } else if (view == btn_bukaPDF) {
            CopyReadAssets("pdf");
        }
    }


}
