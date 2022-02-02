package com.example.taskforcechallenge50;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.taskforcechallenge50.Database.DatabaseHandler;
import com.example.taskforcechallenge50.Database.SQLiteHelper;
import com.example.taskforcechallenge50.Domain.Task;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

public class NewTaskActivity extends AppCompatActivity {

    EditText titleED, descED;
    Button saveBtn, imgPicker;
    Spinner spinner;
    ImageView imageView;
   // DatabaseHandler db;

    String mode;

    ArrayList<String> priorities;
    ArrayAdapter<String> arrayAdapter_priorities;

    public static SQLiteHelper sqLiteHelper;
    final  int REQUEST_CODE_GALLERY = 999;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    //    db = new DatabaseHandler(this);
        titleED = (EditText)findViewById(R.id.title_ed);
        descED = (EditText)findViewById(R.id.desc_ed);
        saveBtn = (Button)findViewById(R.id.create_taskBtn);
        imgPicker = (Button)findViewById(R.id.imagePicker);
        imageView = (ImageView)findViewById(R.id.image_viewer);
        spinner= (Spinner)findViewById(R.id.prio_spinner);



        priorities =  new ArrayList<>();
        priorities.add("High");
        priorities.add("Medium");
        priorities.add("Low");

        arrayAdapter_priorities = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, priorities);
        spinner.setAdapter(arrayAdapter_priorities);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                String priority = parent.getSelectedItem().toString();
//
//                Toast.makeText(NewTaskActivity.this,parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        sqLiteHelper = new SQLiteHelper(this, "TodosDB2.sqlite", null, 1);
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS TODOS (Id INTEGER PRIMARY KEY AUTOINCREMENT, title VARCHAR, description VARCHAR, priority VARCHAR, image BLOG)");


imgPicker.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        ActivityCompat.requestPermissions(

                NewTaskActivity.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                REQUEST_CODE_GALLERY
        );
    }
});




        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mode = "High";
                String created = "2/2/22";
                String modified = "2/22/22";
                int status = 0;


                try {
                    sqLiteHelper.insertData(
                            titleED.getText().toString().trim(),
                            descED.getText().toString().trim(),
                            spinner.getSelectedItem().toString(),


                            imageViewToByte(imageView)
                    );
                    Toast.makeText(getApplicationContext(), "successfully added", Toast.LENGTH_SHORT).show();
                    titleED.setText("");
                    descED.setText("");


                    imageView.setImageResource(R.mipmap.ic_launcher);
                }

                catch (Exception e) {
                    e.printStackTrace();
                }






//                db.openDatabase();
//                boolean isUpdate = false;
//
//                Task task = new Task();
//                String title = titleED.getText().toString();
//                String desc = descED.getText().toString();
//                String prio = "High";
//                String created = "2/2/22";
//                String modified = "2/2/22";
//                String img = "image";
//                int status = 0;
//
////                if (isUpdate){
////                    db.updateTask();
////                }
//                task.setTitle(title);
//                task.setDescription(desc);
//                task.setMode(prio);
//                task.setCreated(created);
//                task.setModified(modified);
//                task.setStatus(status);
//
//                task.setImage(img);
//
//
//                db.insertTask(task);

            }
        });



    }




    private byte[] imageViewToByte( ImageView image) {

        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == REQUEST_CODE_GALLERY){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            }
            else{
                Toast.makeText(getApplicationContext(), "you don't have permission to access ", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();
            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}