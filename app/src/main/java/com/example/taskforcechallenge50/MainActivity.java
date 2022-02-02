package com.example.taskforcechallenge50;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.taskforcechallenge50.Database.DatabaseHandler;
import com.example.taskforcechallenge50.Domain.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static com.example.taskforcechallenge50.NewTaskActivity.sqLiteHelper;

public class MainActivity extends AppCompatActivity {

    Button start;
    RecyclerView taskRecyclerView;
    Adapter taskAdapter;

    Adapter getTaskAdapter = null;

    ArrayList<Task> list;


    private List<Task> tasks;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.filer_tf:

                break;
            case R.id.app_bar_search:

                break;

        }
        return true;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportActionBar().hide();

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        tasks = new ArrayList<>();

        start = (Button) findViewById(R.id.start_task_btn);
        taskRecyclerView = (RecyclerView)findViewById(R.id.tasks_recyclerview);
//        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        taskAdapter = new Adapter(this);
//        taskRecyclerView.setAdapter(taskAdapter);

//
//        Task task = new Task();
//        task.setId(1);
//        task.setTitle("do chores");
//        task.setStatus(0);
//
//        tasks.add(task);
//        tasks.add(task);
//        tasks.add(task);
//        tasks.add(task);
//        tasks.add(task);
//
//        taskAdapter.setTasks(tasks);


       // showUsers();

//        list = new ArrayList<>();
//        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//        getTaskAdapter = new Adapter(this);
//        taskRecyclerView.setAdapter(taskAdapter);
//        Cursor cursor = sqLiteHelper.getData("SELECT * FROM TODOS");
//        list.clear();
//
//        while(cursor.moveToNext()){
//            String title = cursor.getString(1);
//            String description = cursor.getString(2);
//            byte[] image = cursor.getBlob(3);
//            int id = cursor.getInt(0);
//            list.add(new Task(title, description, image, id));
//        }
//        getTaskAdapter.notifyDataSetChanged();
//






        FloatingActionButton fab = findViewById(R.id.float_add);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent floatAddIntent = new Intent(getApplicationContext(), NewTaskActivity.class);
                startActivity(floatAddIntent);

            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btnAddIntent = new Intent(getApplicationContext(), NewTaskActivity.class);
                startActivity(btnAddIntent);

            }
        });
        
    }


//    public void showUsers()
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
//                                cursor.getInt(2),
//                                cursor.getString(3),
//                                cursor.getString(4),
//                                cursor.getString(5),
//                                cursor.getString(6),
//                                cursor.getString(7)
//                        ));
//                    }
//
//                    taskAdapter = new Adapter((MainActivity) tasks);
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