package com.example.enclaveit.androidreviewapp_week2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;


public class MediaPlayer extends Activity {
  android.media.MediaPlayer Song;
    int pause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_media_player);
    }
    public void play(View view){
        if (Song == null) {
            Song = android.media.MediaPlayer.create(this, R.raw.uocmongotngao);
            Song.start();
        } else if (!Song.isPlaying()) {
           Song.seekTo(pause);
            Song.start();
        }
    }
    public void pause(View view){
         if (Song!=null) {
             Song.pause();
             pause = Song.getCurrentPosition();
         }
    }
    public void stop(View view){
        Song.stop();
        Song = null;
    }
}
