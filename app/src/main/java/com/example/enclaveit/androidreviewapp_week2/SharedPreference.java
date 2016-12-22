package com.example.enclaveit.androidreviewapp_week2;

import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class SharedPreference extends AppCompatActivity {
    TextView txtFont;
    ListView lvFont;
    ArrayList<String> listFont;
    ArrayAdapter<String> fontAdapters;

    String nameStored = "nameStored";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        try {
            addControls();
        } catch (IOException e) {
            e.printStackTrace();
        }
        addEvent();
    }
    public void addControls() throws IOException {
       txtFont = (TextView) findViewById(R.id.txtFont);
        lvFont = (ListView) findViewById(R.id.lvFont);
        listFont = new ArrayList<>();
        fontAdapters = new ArrayAdapter<String>(
                SharedPreference.this,
                android.R.layout.simple_list_item_1,
                listFont
        );
        lvFont.setAdapter(fontAdapters);
        try{
            AssetManager assetManager = getAssets();
            String [] arrFontName = assetManager.list("font");
            listFont.addAll(Arrays.asList(arrFontName));
            fontAdapters.notifyDataSetChanged();

            SharedPreferences preferences = getSharedPreferences(nameStored, MODE_PRIVATE);
            String font = preferences.getString("FONTCHU","");
            if (font.length()>0){
                Typeface typeface = Typeface.createFromAsset(getAssets(),font);
                //txtFont.setTypeface(typeface);
            }
        }catch (Exception ex){
            Log.e("Font Error",ex.toString());
        }

    }
    public void addEvent(){
       lvFont.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               processChangeFont(i);
           }
       });
    }

    private void processChangeFont(int i) {
        Typeface typeface = Typeface.createFromAsset(getAssets(), "font/"+listFont.get(i));
        txtFont.setTypeface(typeface);

        SharedPreferences preference = getSharedPreferences(nameStored, MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putString("FONTCHU","font/"+listFont.get(i));
        editor.commit();
    }
}
