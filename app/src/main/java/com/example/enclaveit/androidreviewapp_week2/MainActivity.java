package com.example.enclaveit.androidreviewapp_week2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.example.enclaveit.androidreviewapp_week2.app.MediaPlayerApp;
import com.example.enclaveit.androidreviewapp_week2.app.PlayListActivity;

public class MainActivity extends AppCompatActivity {
    Intent intent;

    ListView lvTopic;
    TextView tvTopic;
    ArrayAdapter<String> arrayAdapter;
    String [] arrTopic = {"Gallary using adapter", "media", "Music Streaming App", "sqlite "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvent();
    }

    private void addEvent() {
        lvTopic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        intent = new Intent(MainActivity.this, GridViewGallery.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this, MediaPlayer.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, PlayListActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
    private void addControls(){
        lvTopic =(ListView)findViewById(R.id.lvTopPic);
        tvTopic =(TextView) findViewById(R.id.tvTopPic);
        arrayAdapter = new ArrayAdapter<String>(MainActivity.this, R.layout.row, R.id.tvTopPic, arrTopic);
        lvTopic.setAdapter(arrayAdapter);
    }


}
