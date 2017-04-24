package com.education.accounting.accountingeducation.material;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.education.accounting.accountingeducation.R;

public class youtube extends AppCompatActivity  implements View.OnClickListener {
    Button click;
    VideoView video;
    MediaController mediaC;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);

        click = (Button) findViewById(R.id.tombol_play);
        video = (VideoView) findViewById(R.id.videoView);
        mediaC = new MediaController(this);


        next = (Button) findViewById(R.id.next);

        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == next){
            //starting login activity
            startActivity(new Intent(this, hasilpengamatan.class));
        }
    }


    public void videoplay(View v) {
        String videopath = "android.resource://com.education.accounting.accountingeducation/"+R.raw.samplevideo;
        Uri uri = Uri.parse(videopath);
        video.setVideoURI(uri);
        video.setMediaController(mediaC);
        mediaC.setAnchorView(video);
        video.start();
    }


}
