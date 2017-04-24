package com.education.accounting.accountingeducation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Instruction extends AppCompatActivity  implements View.OnClickListener {

    private Button mengerti;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        mengerti = (Button) findViewById(R.id.mengerti);

        mengerti.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == mengerti){
            //starting login activity
            startActivity(new Intent(this, ki.class));
        }
    }

}
