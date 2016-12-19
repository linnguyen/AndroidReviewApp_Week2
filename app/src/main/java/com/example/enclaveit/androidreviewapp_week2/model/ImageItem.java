package com.example.enclaveit.androidreviewapp_week2.model;

import android.graphics.Bitmap;

/**
 * Created by enclaveit on 19/12/2016.
 */

public class ImageItem  {
    private Bitmap image;
    private String title;

    public ImageItem(Bitmap image, String title) {
        this.image = image;
        this.title = title;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
