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
import android.widget.TextView;

public class Urdu extends AppCompatActivity {
    String myTitle[]={"ا","ب","پ","ت","ٹ","ث"};
    String myDescription[]={"ا۔  انار","ب۔ بلی","پ۔ پتنگ","ت۔ تتلی","ٹ۔ ٹوپی","ث۔ ثمر"};
    String audioName[]={"alif","be","pay","te","tay","se"};
    int myImage[]={R.drawable.anar,R.drawable.billi,R.drawable.patang,R.drawable.titli,R.drawable.topi,R.drawable.samar};
    ListView listView;
    ImageView myImg;
    TextView myText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urdu);
        listView=findViewById(R.id.myListView);
        myImg=findViewById(R.id.myimage);
        myText=findViewById(R.id.myTitle);
        MyAdapter myAdapter=new MyAdapter(this,myTitle,myDescription,myImage);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                Intent intent=new Intent(Urdu.this,DisplayUrdu.class);
                Bundle bundle=new Bundle();
                bundle.putInt("images",myImage[i]);
                intent.putExtras(bundle);
                intent.putExtra("title",myTitle[i]);
                intent.putExtra("desc",myDescription[i]);
                intent.putExtra("audioName",audioName[i]);
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