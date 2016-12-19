package com.example.enclaveit.androidreviewapp_week2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.example.enclaveit.androidreviewapp_week2.adapter.GridViewAdapter;

public class GridViewGallery extends AppCompatActivity {
    GridView gridView;
    GridViewAdapter gridAdapter;
    String[] web = {
            "Google",
            "Github",
            "Instagram",
            "Facebook",
            "Flickr",
            "Quora",
            "Twiter",
            "Vimeo",
            "WordPress",
            "Blogger"
    };
    int [] imageId = {
            R.drawable.play,
            R.drawable.play,
            R.drawable.play,
            R.drawable.play,
            R.drawable.play,
            R.drawable.play,
            R.drawable.play
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_gallery);

        GridViewAdapter gridViewAdapter = new GridViewAdapter(GridViewGallery.this, web, imageId);
        gridView =  (GridView) findViewById(R.id.gvGallery);
        gridView.setAdapter(gridViewAdapter);
    }
}
