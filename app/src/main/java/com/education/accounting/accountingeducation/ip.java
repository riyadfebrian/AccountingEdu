package com.education.accounting.accountingeducation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ip extends AppCompatActivity implements View.OnClickListener {

    private Button lanjut_menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip);

        lanjut_menu = (Button) findViewById(R.id.lanjut_menu);

        lanjut_menu.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == lanjut_menu){
            //starting login activity
            finish();
            startActivity(new Intent(this, Menu.class));
        }
    }
}
