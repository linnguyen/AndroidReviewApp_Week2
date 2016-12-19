package com.example.enclaveit.androidreviewapp_week2.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.enclaveit.androidreviewapp_week2.GridViewGallery;
import com.example.enclaveit.androidreviewapp_week2.R;
import com.example.enclaveit.androidreviewapp_week2.model.ImageItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by enclaveit on 19/12/2016.
 */

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private final String [] web;
    private final int [] imageId;
    public GridViewAdapter(Context c, String[] web, int[] imageID){
        this.context = c;
        this.imageId = imageID;
        this.web = web;
    }
    @Override
    public int getCount() {
        return web.length;
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
        View grid;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (view == null){
            grid = new View(context);
            grid = inflater.inflate(R.layout.grid_item_layout, null);
            TextView textView = (TextView) grid.findViewById(R.id.imageTitle);
            ImageView imageView = (ImageView) grid.findViewById(R.id.image);
        } else {
            grid = (View) view;
        }
        return grid;
    }
}
