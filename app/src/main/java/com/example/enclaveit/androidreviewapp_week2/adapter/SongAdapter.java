package com.example.enclaveit.androidreviewapp_week2.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.enclaveit.androidreviewapp_week2.R;
import com.example.enclaveit.androidreviewapp_week2.model.Song;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by enclaveit on 20/12/2016.
 */

public class SongAdapter extends ArrayAdapter {
   Activity context;
    int resource;
    List<String> listSongs;
    /**
     * Constructor
     *
     * @param context  The current context.
     * @param resource The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     * @param objects  The objects to represent in the ListView.
     */
    public SongAdapter(Activity context, int resource, List objects) {
        super(context, resource, objects);
        this.resource = resource;
        this.listSongs = objects;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.context.getLayoutInflater();
        View row = inflater.inflate(this.resource, null);
        //reference to song title
        TextView txtsongTitle = (TextView) row.findViewById(R.id.songTitle);
        // get title song from list song
        final String songTitle = this.listSongs.get(position);
        txtsongTitle.setText(songTitle);

        return row;
    }
}
