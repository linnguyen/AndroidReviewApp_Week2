package com.example.enclaveit.androidreviewapp_week2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.enclaveit.androidreviewapp_week2.model.Shop;

/**
 * Created by enclaveit on 20/12/2016.
 */

public class DBHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    //database name
    private static final String TABLE_SHOPS = "shops";
    //shops table columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_ADDRESS = "shop_address";

    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_SHOPS + "("
                + KEY_ID + " INTERGER PRIMARY KEY, " + KEY_NAME + " TEXT, "
                + KEY_ADDRESS + "TEXT" + ")";
        sqLiteDatabase.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addShop(Shop shop) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, shop.getName());
        values.put(KEY_ADDRESS, shop.getAddress());
        //inserting row
        db.insert(TABLE_SHOPS, null, values);
        db.close();
    }

    public Shop getShop(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_SHOPS, new String[]{KEY_ID, KEY_NAME, KEY_ADDRESS}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            Shop contact = new Shop(Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1), cursor.getString(2));
            return contact;
        }
        return null;
    }
}

