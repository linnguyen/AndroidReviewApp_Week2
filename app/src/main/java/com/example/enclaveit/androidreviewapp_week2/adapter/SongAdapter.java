package com.example.enclaveit.androidreviewapp_week2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.enclaveit.androidreviewapp_week2.R;
import com.example.enclaveit.androidreviewapp_week2.model.Song;

import java.util.ArrayList;

/**
 * Created by enclaveit on 20/12/2016.
 */

public class SongAdapter extends BaseAdapter {
    private ArrayList<Song> songs;
    private LayoutInflater songInf;

    public SongAdapter(Context c, ArrayList<Song> songs) {
        this.songs = songs;
        this.songInf = LayoutInflater.from(c);
    }

    @Override
    public int getCount() {
        return songs.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //map to song layout
        LinearLayout songLay = (LinearLayout) songInf.inflate(R.layout.song, viewGroup, false);
       // get title and artist news
        TextView songView = (TextView) songLay.findViewById(R.id.song_title);
        TextView artistView = (TextView) songLay.findViewById(R.id.song_artist);
        //get song using position
        Song curSong = songs.get(i);
        //get title and artist strings
        songView.setText(curSong.getTitle());
        artistView.setText(curSong.getArtist());

        songLay.setTag(i);
        return songLay;
    }
}
