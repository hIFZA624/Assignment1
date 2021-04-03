package com.example.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;

public class Science extends AppCompatActivity {
    String myTitle[]={"Body Parts","Five Senses","Animals","Plants","Food","Corona Virus"};
    String Description[]={"Body Parts Description","Five Senses Description","Different Kinds of Animals","Parts of a Plant","Different Kinds of Food","Learn about Corona Virus"};
    String myDescription[]={"bodyparts","fivesenses","animals","plants","food","corona"};
    int myImage[]={R.drawable.body,R.drawable.senses,R.drawable.animal,R.drawable.plants,R.drawable.foodkids,R.drawable.corona};
    ListView listView;
    ImageView myImg;
    TextView myText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_science);
        listView=findViewById(R.id.myListView);
        myImg=findViewById(R.id.myimage);
        myText=findViewById(R.id.myTitle);
        MyAdapter myAdapter=new MyAdapter(this,myTitle,Description,myImage);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent=new Intent(Science.this,DisplayScience.class);
                    intent.putExtra("videoName",myDescription[i]);
                    intent.putExtra("position",""+i);


                startActivity(intent);
            }
        });
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