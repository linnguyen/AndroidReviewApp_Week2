package com.example.enclaveit.androidreviewapp_week2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class MediaPlayer extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_media_player);
    }
}
