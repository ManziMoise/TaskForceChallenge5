package com.example.taskforcechallenge50.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {
    public SQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }


    public void insertData(String title, String description,String priority, byte[] image){

        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO TODOS VALUES (NULL, ?, ?, ?, ?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();

        statement.bindString(1, title);
        statement.bindString(2, description);
        statement.bindString(3, priority);
//        statement.bindString(4, created);
//        statement.bindString(5, modified);
//        statement.bindString(6, Status);
        statement.bindBlob(4, image);

        statement.executeInsert();

    }

    public Cursor getData(String sql){

        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql,null);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + i);
//        onCreate(sqLiteDatabase);

    }
}
