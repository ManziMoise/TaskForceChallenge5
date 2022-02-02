package com.example.taskforcechallenge50.Database;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.taskforcechallenge50.Domain.Task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String NAME = "toDoListDatabase";
    private static final String TODO_TABLE = "todo";
    private static final String ID = "id";
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String MODE = "mode";
    private static final String CREATED = "created";
    private static final String MODIFIED = "modified";
    private static final String STATUS = "status";
    private static final String IMAGE = "image";
    private static final String CREATE_TODO_TABLE = "CREATE TABLE " + TODO_TABLE + "("+ ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TITLE + " TEXT, " + DESCRIPTION + "TEXT, " + MODE + "TEXT, " + CREATED + " TEXT, " + MODIFIED +" TEXT, " + IMAGE + " TEXT, " + STATUS +"INTEGER)";
    private SQLiteDatabase db;

    public DatabaseHandler(Context context){
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_TODO_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TODO_TABLE);
        onCreate(db);
    }

    public void openDatabase(){
        db = this.getWritableDatabase();
    }

    public void insertTask(Task task){
        ContentValues contentValues = new ContentValues();
        contentValues.put(TITLE, task.getTitle());
        contentValues.put(DESCRIPTION, task.getDescription());
//        contentValues.put(MODE, task.getMode());
//        contentValues.put(CREATED, String.valueOf(task.getCreated()));
//        contentValues.put(MODIFIED, String.valueOf(task.getModified()));
        contentValues.put(IMAGE, task.getImage());
        contentValues.put(STATUS, 0);


        db.insert(TODO_TABLE, null, contentValues);
    }

//    public List<Task> getAllTasks(){
//        List<Task> taskList = new ArrayList<>();
//        Cursor cursor = null;
//        db.beginTransaction();
//        try{
//            cursor = db.query(TODO_TABLE, null, null, null, null, null, null, null);
//            if (cursor != null) {
//                if(cursor.moveToFirst()){
//                    do {
//                        Task task = new Task();
//                        task.setId(cursor.getInt(0));
//                        task.setTitle(cursor.getString(1));
//                        task.setDescription(cursor.getString(2));
//                        task.setMode(cursor.getString(3));
//                        task.setCreated(cursor.getString(4));
//                        task.setModified(cursor.getString(5));
////                        task.setImage(cursor.getString(6));
//                        task.setStatus(cursor.getInt(7));
//
//
//                    }while(cursor.moveToNext());
//                }
//
//            }
//        }
//        finally {
//            db.endTransaction();
//            cursor.close();
//        }
//        return taskList;
//
//    }

    public void updateStatus(int id, int status){
        ContentValues contentValues = new ContentValues();
        contentValues.put(STATUS, status);
        db.update(TODO_TABLE, contentValues, ID + "=?", new String[]{String.valueOf(id)});
    }

    public void updateTask(int id, String title, String description, String mode, String created, String modified, String image){
        ContentValues contentValues = new ContentValues();
        contentValues.put(TITLE, title);
        contentValues.put(DESCRIPTION, description);
        contentValues.put(MODE, mode);
        contentValues.put(CREATED, created);
        contentValues.put(MODIFIED, modified);
        contentValues.put(IMAGE, image);

        db.update(TODO_TABLE, contentValues, ID + "=?", new String[]{String.valueOf(id)});



    }


    public void deleteTask(int id){
        db.delete(TODO_TABLE, ID + "=?", new String[]{String.valueOf(id)});
    }


    public void insertTaskTrial(String title, String desc) {
    }
}
