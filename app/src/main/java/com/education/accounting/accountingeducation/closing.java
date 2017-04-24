package com.education.accounting.accountingeducation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class closing extends AppCompatActivity implements View.OnClickListener {

    private Button end;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closing);

        end = (Button) findViewById(R.id.end);

        end.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == end){
            //starting login activity
            finish();
            startActivity(new Intent(this, Menu.class));
        }
    }
}
