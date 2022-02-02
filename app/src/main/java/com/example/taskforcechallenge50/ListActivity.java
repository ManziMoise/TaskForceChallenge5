package com.example.taskforcechallenge50;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.example.taskforcechallenge50.Database.DatabaseHandler;
import com.example.taskforcechallenge50.Domain.Task;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    RecyclerView taskRecyclerView;
    Adapter taskAdapter;
    ArrayList<Task> tasks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        tasks = new ArrayList<>();
        taskRecyclerView = (RecyclerView)findViewById(R.id.tasks_recyclerviews);

//        taskRecyclerView = (RecyclerView)findViewById(R.id.tasks_recyclerview);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new Adapter(tasks);
        taskRecyclerView.setAdapter(taskAdapter);


        Task task = new Task();
        task.setId(1);
        task.setTitle("do chores");
       // task.setStatus(0);

        tasks.add(task);
        tasks.add(task);
        tasks.add(task);
        tasks.add(task);
        tasks.add(task);

        taskAdapter.setTasks(tasks);



  //      showTasks();

    }


//    public void showTasks()
//    {
//        try {
//            DatabaseHandler handler= new DatabaseHandler(this);
//            SQLiteDatabase sqLiteDatabase= handler.getReadableDatabase();
//            if (sqLiteDatabase!=null)
//            {
//                Cursor cursor = sqLiteDatabase.rawQuery("select * from todos", null);
//
//                if (cursor.getCount()==0)
//                {
//                    Toast.makeText(this, "no data returned", Toast.LENGTH_SHORT).show();
//                }
//                else
//                {
//                    while(cursor.moveToNext())
//                    {
//                        tasks.add(new Task(cursor.getInt(0),
//                                cursor.getString(1),
//                                cursor.getString(2),
//                                cursor.getString(3),
//                                cursor.getBlob(4)
//
//                        ));
//                    }
//
//                    taskAdapter = new Adapter(tasks);
//                    taskRecyclerView.hasFixedSize();
//                    taskRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//                    taskRecyclerView.setAdapter(taskAdapter);
//
//                }
//            }
//            else
//            {
//                Toast.makeText(this, "Database is full", Toast.LENGTH_SHORT).show();
//            }
//        }
//        catch (Exception e)
//        {
//            Toast.makeText(this, "show message from db "+e.getMessage(), Toast.LENGTH_SHORT).show();
//        }
//
//    }
}