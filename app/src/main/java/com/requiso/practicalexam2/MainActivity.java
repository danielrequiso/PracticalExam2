package com.requiso.practicalexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    CheckBox[] checkBox = new CheckBox[8];
    EditText comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkBox[0] = findViewById(R.id.checkBox);
        checkBox[1] = findViewById(R.id.checkBox2);
        checkBox[2]= findViewById(R.id.checkBox3);
        checkBox[3] = findViewById(R.id.checkBox4);
        checkBox[4] = findViewById(R.id.checkBox5);
        checkBox[5] = findViewById(R.id.checkBox6);
        checkBox[6] = findViewById(R.id.checkBox7);
        checkBox[7] = findViewById(R.id.checkBox8);
        comment = findViewById(R.id.editText4);
    }
    public void save(View v) {
        FileOutputStream writer = null;
        String input = checkBox[0].getText().toString() + ",";
        String input2 = checkBox[1].getText().toString() + ",";
        String input3 = checkBox[2].getText().toString() + ",";
        String input4 = checkBox[3].getText().toString() + ",";
        String input5 = checkBox[4].getText().toString() + ",";
        String input6 = checkBox[5].getText().toString() + ",";
        String input7 = checkBox[6].getText().toString() + ",";
        String input8 = checkBox[7].getText().toString();

        try {
            writer = openFileOutput("data.txt", MODE_APPEND);
            writer.write(input.getBytes());
            writer.write(input2.getBytes());
            writer.write(input3.getBytes());
            writer.write(input4.getBytes());
            writer.write(input5.getBytes());
            writer.write(input6.getBytes());
            writer.write(input7.getBytes());
            writer.write(input8.getBytes());
        }catch (IOException e){
            Log.d("error", "IOException");
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                Log.d("error", "File not found 2");
            }
        }
        Toast.makeText(this, "Data Saved", Toast.LENGTH_LONG).show();

    }

    public void next(View v){
        Intent intent = new Intent(MainActivity.this, Confirmation.class);
        startActivity(intent);
    }
}
