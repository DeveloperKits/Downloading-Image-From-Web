package com.example.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView TimesTableListView;

    public void GeneratedTimeTable(int TimeTable){
        ArrayList<String> number = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            number.add(Integer.toString(i * TimeTable));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, number);
        TimesTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final SeekBar TimesTableSeekBar = (SeekBar) findViewById(R.id.TimesTableSeekBar);
        TimesTableListView = (ListView) findViewById(R.id.TimeTableListView);

        TimesTableSeekBar.setMax(20);
        TimesTableSeekBar.setProgress(10);
        TimesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int TimesTable;

                if(i < min){
                    TimesTable = min;
                    // For Fix There
                    //TimesTableSeekBar.setProgress(min);
                }else {
                    TimesTable = i;
                }
                GeneratedTimeTable(TimesTable);
                Log.i("SeekBar Value  =  ", Integer.toString(TimesTable));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        GeneratedTimeTable(10);
    }
}