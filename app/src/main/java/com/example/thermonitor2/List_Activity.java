package com.example.thermonitor2;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class List_Activity extends AppCompatActivity {
    String [] OS;
    int [] images;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_);

        OS = new String[]{"Android", "iPhone", "Windows", "Blackberry", "Linux"};
        images= new int[]{R.drawable.android,
                R.drawable.apple,
                R.drawable.windows,
                R.drawable.blackberry_logo,
                R.drawable.linux};
        ArrayAdapter adapter= new ArrayAdapter<String>(com.example.thermonitor2.List_Activity.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.OS));
        final ListView theListView= (ListView) findViewById(R.id.theListView);
        //theListView.setAdapter(adapter);

        com.example.thermonitor2.List_Activity.CustomAdaptor customAdaptor = new com.example.thermonitor2.List_Activity.CustomAdaptor();
        theListView.setAdapter(customAdaptor);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(com.example.thermonitor2.List_Activity.this, com.example.thermonitor2.DeviceDetailActivity.class);

                startActivity(intent);


            }
        });
    }
    class CustomAdaptor extends BaseAdapter{

        @Override
        public int getCount() {

            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view= getLayoutInflater().inflate(R.layout.customlayout, null);
            ImageView mImageView= view.findViewById(R.id.imageView);
            TextView mTextView= view.findViewById(R.id.textView);
            mImageView.setImageResource(images[position]);
            mTextView.setText(OS[position]);
            return view;
        }
    }

}

