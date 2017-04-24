package com.education.accounting.accountingeducation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.education.accounting.accountingeducation.material.youtube;

public class Menu extends AppCompatActivity implements View.OnClickListener {


    private Button home;
    private Button material;
    private Button forum;
    private Button exercise;
    private Button share;
    private Button about_us;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        home = (Button) findViewById(R.id.home);
        material = (Button) findViewById(R.id.material);
        forum = (Button) findViewById(R.id.forum);
        exercise = (Button) findViewById(R.id.exercise);
        share = (Button) findViewById(R.id.share);
        about_us = (Button) findViewById(R.id.about_us);



        home.setOnClickListener(this);
        material.setOnClickListener(this);
        forum.setOnClickListener(this);
        exercise.setOnClickListener(this);
        share.setOnClickListener(this);
        about_us.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == home){
            //starting login activity
            startActivity(new Intent(this, Instruction.class));
        } else if (view == material) {
            startActivity(new Intent(this, youtube.class));
        } else if (view == forum) {
            // nope
            Toast.makeText(this, "Coming soon...", Toast.LENGTH_LONG).show();
        } else if (view == exercise) {
           // nopes
            startActivity(new Intent(this, QuizActivity.class));
        } else if (view == share) {
           // nope
            Toast.makeText(this, "Coming soon...", Toast.LENGTH_LONG).show();
        } else if (view == about_us) {
            startActivity(new Intent(this, aboutus.class));
        }
    }
}
