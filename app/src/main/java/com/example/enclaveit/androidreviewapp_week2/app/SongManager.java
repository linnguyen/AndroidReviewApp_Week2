package com.example.enclaveit.androidreviewapp_week2.app;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by enclaveit on 21/12/2016.
 */

public class SongManager {
    final String MEDIA_PATH = new String("/sdcard/music");
    private ArrayList<HashMap<String, String>> songList = new ArrayList<>();
    public SongManager(){
    }
    //function to load all mp3 files from sdcard
    //store details in ArrayList
    public ArrayList<HashMap<String, String>> getPlayList(){
        File home = new File(MEDIA_PATH);
        if(home.listFiles(new FileExtensionFilter()).length >0 ){
            for (File file : home.listFiles(new FileExtensionFilter())){
                HashMap<String, String> song = new HashMap<>();
                song.put("songTitle", file.getName()).substring(0, file.getName().length() -4);
                song.put("songPath", file.getPath());
                //Adding each song to SongList
                songList.add(song);
            }
        }
        return songList;
    }
}
//Class to filter files which are having .mp3 extension

