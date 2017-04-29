package com.education.accounting.accountingeducation.material;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.education.accounting.accountingeducation.MusicBackground;
import com.education.accounting.accountingeducation.R;
import com.education.accounting.accountingeducation.status_counter;

import static com.education.accounting.accountingeducation.status_counter.fabIsEnable;
import static com.education.accounting.accountingeducation.status_counter.lihatVideo;

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

            if (lihatVideo) {
                if (status_counter.isPlaying || fabIsEnable) {
                    startService(new Intent(getBaseContext(), MusicBackground.class));
                }

                lihatVideo = false;
                //starting login activity
                finish();
                startActivity(new Intent(this, hasilpengamatan.class));
            } else {
                Toast.makeText(youtube.this,"Lihat dulu Video Materi",Toast.LENGTH_LONG).show();


            }
        }
    }


    public void videoplay(View v) {
        lihatVideo = true;
        if (status_counter.isPlaying || fabIsEnable) {
            stopService(new Intent(getBaseContext(), MusicBackground.class));
        }


        String videopath = "android.resource://com.education.accounting.accountingeducation/"+R.raw.samplevideo;
        Uri uri = Uri.parse(videopath);
        video.setVideoURI(uri);
        video.setMediaController(mediaC);
        mediaC.setAnchorView(video);
        video.start();
    }


}
