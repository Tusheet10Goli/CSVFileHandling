package com.example.csvfilehandling;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readData();
        writeFile();
    }

    private ArrayList<Food> list = new ArrayList<Food>();
    private ArrayList<Food> readData() {
        InputStream is = getResources().openRawResource(R.raw.menu);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

        String line = "";
        try {
            while( (line = reader.readLine()) != null) {
                String[] arr = line.split(",");
                Food food = new Food(arr[0], arr[1], arr[2], arr[3]);
                list.add(food);

                Log.d("Activity", "Food item created- " + food);
            }
        } catch (IOException e){
            Log.wtf("Exception Activity", "Error reading data file on line" + line, e);
            e.printStackTrace();
        }
        return list;
    }

    private void writeFile() {
        ArrayList<Food> newList = new ArrayList<Food>();
        newList = readData();

        String FILE_NAME = "restaurant.csv";

        String[] str = new String[4];
        for (int i = 0; i < 4; i++) {
            str[i] = list.get(i).toString();
        }

        try {
            FileOutputStream out = openFileOutput(FILE_NAME, Context.MODE_APPEND);
            for (int i = 0; i < 4; i++) {
                out.write(str[i].getBytes());
            }
            Log.d("Write File", "Written Successfully to file");
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
