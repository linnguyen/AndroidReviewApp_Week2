package com.example.enclaveit.androidreviewapp_week2.app;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.enclaveit.androidreviewapp_week2.R;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by enclaveit on 21/12/2016.
 */

public class PlayListActivity extends ListActivity{
    //Song list
    public ArrayList<HashMap<String,String>> songList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);
        File file = new File("/sdcard/music");
//        file.listFiles(new FileFilter() {
//            @Override
//            public boolean accept(File pathname) {
//                return  true;
//            }
//        });
//        ArrayList<HashMap<String, String>> songListData = new ArrayList<>();
//        //get alls song from scard
//        SongManager songManger = new SongManager();
//        //get all songs from sdcard
//        this.songList = songManger.getPlayList();
//        //loop through playlist
//        for (int i=0; i< songList.size(); i++){
//            HashMap<String,String> song = songList.get(i);
//            //adding Hashlist to ArrayList
//            songListData.add(song);
//        }
//        //Adding menuItems to ListView
//        ListAdapter adapter = new SimpleAdapter(this, songListData, R.layout.playlist_item,
//                new String [] {"songTitle"}, new int []{R.id.songTitle});
//        setListAdapter(adapter);
//        ListView lv = getListView();
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });
    }


}
