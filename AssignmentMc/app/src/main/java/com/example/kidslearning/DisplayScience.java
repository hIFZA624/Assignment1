package com.example.adapters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class DisplayScience extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_science);
       Intent intent = getIntent();
        String videoname= intent.getStringExtra("videoName");
        VideoView videoView = findViewById(R.id.videoView);
        int video_id = this.getResources().getIdentifier(videoname, "raw",
                    this.getPackageName());


           /* String videoname="fivesenses";
            int video_id = this.getResources().getIdentifier(videoname, "raw",
                    this.getPackageName());
            videoView.setVideoPath("android.resource://" + getPackageName() + "/" +video_id);

            */
 videoView.setVideoPath("android.resource://" + getPackageName() + "/" +video_id);
        MediaController mediaController=new MediaController(this);
        videoView.setMediaController(mediaController);
        videoView.start();
    }
}
