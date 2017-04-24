package com.education.accounting.accountingeducation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class kd extends AppCompatActivity implements View.OnClickListener {

    private Button lanjutkemenu;
    private TextView kd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kd);

        kd = (TextView) findViewById(R.id.text_kd);
        kd.setMovementMethod(new ScrollingMovementMethod());

        lanjutkemenu = (Button) findViewById(R.id.lanjutkemenu);
        lanjutkemenu.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if(view == lanjutkemenu){
            //starting login activity
            finish();
            startActivity(new Intent(this, ip.class));
        }
    }



}
