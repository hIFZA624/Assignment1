package com.example.adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView list;
    String myTitle[]={"English","اردو","General Science","Poem"};
    String myDescription[]={"Learn Alphabets","حروف تہجی","General Science Description","Poems for Kids"};
    int myImage[]={R.drawable.abc,R.drawable.urdu,R.drawable.sciencekids,R.drawable.kids};
   // ArrayList<String> friendArrayList;
   // EditText editText;
    ListView listView;
    //ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       listView=findViewById(R.id.myListView);
        /*Button button=findViewById(R.id.btnAdd);
        editText=findViewById(R.id.editTextAdd);

         */

       /* String[] friendList={"Ali" ,"Saad" ,"Musa"};
        friendArrayList=new ArrayList<String>();
        friendArrayList.add("Ali");
        friendArrayList.add("Saad");
        friendArrayList.add("Musa");
        friendArrayList.add("Hamza");
        */
        MyAdapter myAdapter=new MyAdapter(this,myTitle,myDescription,myImage);
        listView.setAdapter(myAdapter);

        /*arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,friendArrayList);
        listView.setAdapter(arrayAdapter);

         */

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                if(i==0)
                {
                    Intent intent=new Intent(MainActivity.this,English.class);
                   // intent.putExtra("Friend",friendArrayList.get(i));
                    /*Bundle bundle=new Bundle();
                    bundle.putInt("images",myImage[0]);
                    intent.putExtras(bundle);
                    intent.putExtra("title",myTitle[0]);
                    intent.putExtra("position",""+0);
                     */
                    startActivity(intent);
                }
                if(i==1)
                {
                    Intent intent=new Intent(MainActivity.this,Urdu.class);
                    // intent.putExtra("Friend",friendArrayList.get(i));
                    Bundle bundle=new Bundle();
                    bundle.putInt("images",myImage[1]);
                    intent.putExtras(bundle);
                    intent.putExtra("title",myTitle[1]);
                    intent.putExtra("position",""+1);
                    startActivity(intent);
                }

                if(i==2)
                {

                    Intent intent=new Intent(MainActivity.this,Science.class);
                    // intent.putExtra("Friend",friendArrayList.get(i));

                    /*Bundle bundle=new Bundle();
                    bundle.putInt("images",myImage[2]);
                    intent.putExtras(bundle);
                    intent.putExtra("title",myTitle[2]);
                    intent.putExtra("position",""+2);
                     */
                    startActivity(intent);
                }
                 /*
                if(i==3)
                {
                    Intent intent=new Intent(MainActivity.this,DetailActivity.class);
                    // intent.putExtra("Friend",friendArrayList.get(i));
                    Bundle bundle=new Bundle();
                    bundle.putInt("images",myImage[3]);
                    intent.putExtras(bundle);
                    intent.putExtra("title",myTitle[3]);
                    intent.putExtra("position",""+3);
                    startActivity(intent);
                }

                 */
            }
        });
    }
  /*  public void Add(View view) {
        friendArrayList.add(editText.getText().toString());
       arrayAdapter.notifyDataSetChanged();
    }

   */
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