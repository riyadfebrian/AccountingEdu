package com.education.accounting.accountingeducation;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.education.accounting.accountingeducation.exercise.QuizActivity;
import com.education.accounting.accountingeducation.exercise.ScrollingActivity;
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
            startActivity(new Intent(this, ScrollingActivity.class));
        } else if (view == share) {
           // nope
            Toast.makeText(this, "Coming soon...", Toast.LENGTH_LONG).show();
        } else if (view == about_us) {
            startActivity(new Intent(this, aboutus.class));
        }
    }



    @Override
    public void onBackPressed() {
        askToClose();
    }

    private void askToClose (){
        AlertDialog.Builder builder = new AlertDialog.Builder(Menu.this);
        builder.setMessage("Are you sure you want to quit?");
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                System.gc();
                System.exit(0);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
