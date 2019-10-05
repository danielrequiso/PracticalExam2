package com.requiso.practicalexam2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Confirmation extends AppCompatActivity {
    String data = "";
    String[] dataArray;
    String[] editText5, editText6, editText7,  editText8, editText9, editText10, editText11, editText12;
    EditText edit1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        editText5 = findViewById(R.id.editText5);
        editText6  = findViewById(R.id.editText6);
        editText7 = findViewById(R.id.editText5);
        editText8 = findViewById(R.id.editText6);
        editText9 = findViewById(R.id.editText5);
        editText10 = findViewById(R.id.editText6);
        editText11 = findViewById(R.id.editText5);
        editText12 = findViewById(R.id.editText6);

    }
    public void onStart() {
        super.onStart();
        try {
            FileInputStream reader = openFileInput("data.txt");
            int token;
            while ((token = reader.read()) != -1) {
                data = data + (char) token;
            }
        } catch (FileNotFoundException e) {
            Log.d("error", "File not found");
        } catch (IOException e) {
            Log.d("error", "IOException");
        }
        dataArray = data.split(",");
        for (int i = 0; i < 8; i++) {
           
        }

    }


    public void send(View v) {
        FileInputStream reader = null;
        String data = "";
        try {
            reader = openFileInput("data1.txt");
            int token;
            while ((token = reader.read()) != -1) {
                data = data + (char) token;

            }
        } catch (FileNotFoundException e) {
            Log.d("error", "file not found...");
        } catch (IOException e) {
            Log.d("error", "IO error...");
        }
        Toast.makeText(this, data, Toast.LENGTH_LONG).show();
    }



    public void previous(View v){
        Intent intent = new Intent(Confirmation.this, MainActivity.class);
        startActivity(intent);
    }
}
