package com.example.enclaveit.androidreviewapp_week2.app;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.enclaveit.androidreviewapp_week2.MediaPlayer;
import com.example.enclaveit.androidreviewapp_week2.R;
import com.example.enclaveit.androidreviewapp_week2.adapter.SongAdapter;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by enclaveit on 21/12/2016.
 * Class to show list song
 */
public class PlayListActivity extends Activity{
    ListView lvPlaylist;
    ArrayList<String> items;
    SongAdapter songAdapter;
    //public ArrayList<HashMap<String,String>> songList = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);
        lvPlaylist = (ListView) findViewById(R.id.lvPlaylist);

        final ArrayList<File> mySongs = SongManager.findSongs(Environment.getExternalStorageDirectory());
        items = new ArrayList<>();
        for (int i=0; i<mySongs.size(); i++){
            //toast(mySongs.get(i).getName().toString());
            items.add(mySongs.get(i).getName().toString().replace(".mp3",""));
        }
        songAdapter = new SongAdapter(PlayListActivity.this, R.layout.playlist_item, items);
        lvPlaylist.setAdapter(songAdapter);

        //Navigate to Player
        lvPlaylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PlayListActivity.this, MediaPlayerApp.class);
                intent.putExtra("pos", position);
                intent.putExtra("songlist", mySongs);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    //    public void toast(String text){
//        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
//    }


}
