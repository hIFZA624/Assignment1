package com.example.adapters;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class DisplayUrdu extends AppCompatActivity {
    MediaPlayer player;
    ListView list;
    ImageView myImg;
    TextView myText;
    String music;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_urdu);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);

        }
        myImg=findViewById(R.id.myimage);
        myText=findViewById(R.id.myTitle);
        Intent intent = getIntent();
        Bundle bundle = this.getIntent().getExtras();
        int pic = bundle.getInt("images");
        String title = intent.getStringExtra("desc");
        music = intent.getStringExtra("audioName");
        myImg.setImageResource(pic);
        myText.setText(title);
    }

    public void play1(View view) {
        int sound_id = this.getResources().getIdentifier(music, "raw",
                this.getPackageName());
        if(player==null)
            player=MediaPlayer.create(this,sound_id);
        player.start();

    }
}