package com.example.proyectoandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class DataHelper extends SQLiteOpenHelper {
    public DataHelper(@Nullable Context context,
                      @Nullable String name,
                      @Nullable SQLiteDatabase.CursorFactory factory,
                      int version){
        super(context, name, factory, version);
    }
    //Creacion de las Tablas
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE luces(id INTEGER PRIMARY KEY, nombre TEXT)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS luces");
        db.execSQL("CREATE TABLE luces(id INTEGER PRIMARY KEY, nombre TEXT)");
    }
}