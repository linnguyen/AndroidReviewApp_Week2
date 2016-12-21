package com.example.enclaveit.androidreviewapp_week2.app;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by enclaveit on 21/12/2016.
 */

public class FileExtensionFilter implements FilenameFilter{

    /**
     * Tests if a specified file should be included in a file list.
     *
     * @param dir  the directory in which the file was found.
     * @param name the name of the file.
     * @return <code>true</code> if and only if the name should be
     * included in the file list; <code>false</code> otherwise.
     */
    @Override
    public boolean accept(File dir, String name) {
        return (name.endsWith(".mp3") || name.endsWith(".MP3"));
    }
}
