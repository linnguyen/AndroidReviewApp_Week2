package com.example.enclaveit.androidreviewapp_week2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SharedPreference extends AppCompatActivity {
    TextView txtFont;
    ListView lvFont;
    ArrayList<String> listFont;
    ArrayAdapter<String> fontAdapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        addControls();
        addEvent();
    }
    public void addControls(){

    }
    public void addEvent(){

    }
}
