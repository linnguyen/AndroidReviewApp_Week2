package com.example.enclaveit.androidreviewapp_week2.app;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.enclaveit.androidreviewapp_week2.R;
import com.example.enclaveit.androidreviewapp_week2.adapter.SongAdapter;
import com.example.enclaveit.androidreviewapp_week2.model.Song;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class MediaPlayerApp extends AppCompatActivity  {
    MediaPlayer mp3;
    ImageButton btPlay, btFF, btFB, btNxt, btPv;
    ImageButton btPlaylist;
    ArrayList<File> songList;
    TextView songTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);

        addControls();
        addEvent();

        Intent i = getIntent();
        Bundle b = i.getExtras();
        ArrayList<File> mySongs = (ArrayList) b.getParcelableArrayList("songlist");
        int position = b.getInt("pos",0);

        Uri u = Uri.parse(mySongs.get(position).toString());
        Toast.makeText(getApplicationContext(), u.toString(), Toast.LENGTH_SHORT).show();
        mp3 = MediaPlayer.create(getApplicationContext(), u);
        mp3.start();

        //set Title for song
        songTitle.setText(mySongs.get(position).getName().toString());
    }
    public void addControls(){
        btPlay = (ImageButton) findViewById(R.id.btnPlay);
        btFF = (ImageButton) findViewById(R.id.btnFordward);
        btFB = (ImageButton) findViewById(R.id.btnBackward);
        btNxt = (ImageButton) findViewById(R.id.btnNext);
        btPv = (ImageButton) findViewById(R.id.btnPrevious);

        btPlaylist = (ImageButton) findViewById(R.id.btnPlaylist);

        songTitle = (TextView) findViewById(R.id.songTitle);

        songList = new ArrayList<>();
        songList = SongManager.findSongs(Environment.getExternalStorageDirectory());

        playSong(0);
    }
    public void addEvent(){
        btPlaylist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PlayListActivity.class);
                startActivityForResult(intent, 100);
            }
        });

        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp3.isPlaying()){
                    if(mp3!=null){
                        mp3.pause();
                        btPlay.setImageResource(R.drawable.btn_play);
                    }
                }else{
                    if(mp3!=null){
                        mp3.start();
                        btPlay.setImageResource(R.drawable.btn_pause);
                    }
                }
            }
        });
    }
    public void playSong(int songIndex){
        try {
            mp3.reset();
            mp3.setDataSource(songList.get(songIndex).getPath());
            mp3.prepare();
            mp3.start();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
//    /**
//     * Called when a view has been clicked.
//     *
//     * @param v The view that was clicked.
//     */
//    @Override
//    public void onClick(View v) {
//        int id = v.getId();
//        switch (id){
//            case R.id.btnPlay:
//                if(mp3.isPlaying()){
//                    mp3.pause();
//                }else{
//                    mp3.start();
//                }
//                break;
//            case R.id.btnFordward:
//               // mp3.seekTo(mp3);
//                break;
//        }
//    }
}
