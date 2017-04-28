package com.education.accounting.accountingeducation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.education.accounting.accountingeducation.menu.Menuv2;

public class closing extends AppCompatActivity implements View.OnClickListener {

    private Button end;
    private ImageView closing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_closing);

        end = (Button) findViewById(R.id.end);
        closing = (ImageView) findViewById(R.id.image_closing);

        Glide.with(this).load(R.drawable.closing).into(closing);
        end.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == end){
            //starting login activity
            finish();
        }
    }
}
