package com.example.enclaveit.androidreviewapp_week2.app;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by enclaveit on 21/12/2016.
 * Class to filter files which are having .mp3 extension
 */

public class SongManager {

    public static ArrayList<File> findSongs(File root){
        ArrayList<File> al = new ArrayList<>();
        File[] files = root.listFiles();
        for(File singleFile : files){
            if(singleFile.isDirectory() && !singleFile.isHidden()){
               al.addAll(findSongs(singleFile));
            }else{
                if(singleFile.getName().endsWith(".mp3")){
                  al.add(singleFile);
                }
            }
        }
        return al;
    }
}


