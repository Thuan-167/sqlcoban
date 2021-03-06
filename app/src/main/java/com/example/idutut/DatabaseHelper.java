package com.example.idutut;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="IDU.db";
    public static final String TABLE_NAME="IDU";

    public static final String COL_1="ID";
    public static final String COL_2="name";
    public static final String COL_3="address";
    public static final String COL_4="phone";
    public static final String COL_5="email";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " +TABLE_NAME+ "(ID INTERGER PRIMARY KEY AUTOINCREMENT, name TEXT, address TEXT, phone TEXT, email TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }
}
