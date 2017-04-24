package com.education.accounting.accountingeducation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class aboutus extends AppCompatActivity implements View.OnClickListener {

    private TextView aboutus;
    private Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);

        aboutus = (TextView) findViewById(R.id.text_aboutus);
        aboutus.setMovementMethod(new ScrollingMovementMethod());
        aboutus.setMovementMethod(LinkMovementMethod.getInstance());

        ok = (Button) findViewById(R.id.btn_ok);

        ok.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == ok){
            //starting login activity
            finish();

        }
    }
}
