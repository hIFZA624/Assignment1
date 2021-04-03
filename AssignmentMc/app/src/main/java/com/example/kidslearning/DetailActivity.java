package com.example.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    MediaPlayer player;
    ListView list;
    ImageView myImg;
    TextView myText;
    int position;
    String myTitle[]={"Body Parts","Five Senses","Animals","Plants"};
    String myDescription[]={"Body Parts Description","Five Senses Description","Animals Description","Plants Description"};
    String myTitle2[]={"Science","English","Urdu","Poem"};
    String myDescription2[]={"Science Description","Learn Alphabets","Urdu Stories and Words","Poems for Kids"};
    int myImage2[]={R.drawable.sciencekids,R.drawable.abc,R.drawable.urdu,R.drawable.kids};
    int myImage[]={R.drawable.body,R.drawable.senses,R.drawable.animal,R.drawable.animal};
    ArrayList<String> friendArrayList;
    EditText editText;
    ListView listView;
    String music;
    String musicPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //Intent intent=getIntent();
        // Log.d("checking",intent.getStringExtra("Friend"));
        //TextView textView=findViewById(R.id.textViewDetail);
        //Intent intent=getIntent();

       // textView.setText(intent.getStringExtra("Friend"));
        listView=findViewById(R.id.myListView);

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
         String title = intent.getStringExtra("title");
         music = intent.getStringExtra("desc");
         myImg.setImageResource(pic);
         myText.setText(title);
        /*Button button=findViewById(R.id.btnAdd);
        editText=findViewById(R.id.editTextAdd);

         */
    }

    public void play(View view) {
        int sound_id = this.getResources().getIdentifier(music, "raw",
                this.getPackageName());
        if(player==null)
            player=MediaPlayer.create(this,sound_id);

        player.start();

    }

    public class MyAdapter extends ArrayAdapter<String>
    {
        private final Activity context;
        private final String rtitle[];
        private final String rDescription[];
        private final  int rimgs[];
        public MyAdapter(Activity context,String title[],String description[],int img[])
        {
            super(context,R.layout.row,title);
            this.context=context;
            this.rtitle=title;
            this.rDescription=description;
            this.rimgs=img;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=context.getLayoutInflater();
            View row=layoutInflater.inflate(R.layout.row,null,true);
            ImageView imageView=row.findViewById(R.id.image);
            TextView title=row.findViewById(R.id.title);
            TextView description=row.findViewById(R.id.subtitle);
            imageView.setImageResource(rimgs[position]);
            title.setText(rtitle[position]);
            description.setText(rDescription[position]);
            return row;
        }
    }
}