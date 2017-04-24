package com.education.accounting.accountingeducation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ki extends AppCompatActivity implements View.OnClickListener {

    private Button lanjut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ki);

        lanjut = (Button) findViewById(R.id.lanjut);

        lanjut.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == lanjut){
            //starting login activity
            startActivity(new Intent(this, kd.class));
        }
    }
}
