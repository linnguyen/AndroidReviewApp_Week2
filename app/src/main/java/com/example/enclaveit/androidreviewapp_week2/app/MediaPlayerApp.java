package com.example.enclaveit.androidreviewapp_week2.app;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.enclaveit.androidreviewapp_week2.R;
import com.example.enclaveit.androidreviewapp_week2.adapter.SongAdapter;
import com.example.enclaveit.androidreviewapp_week2.model.Song;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MediaPlayerApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);
    }

}
