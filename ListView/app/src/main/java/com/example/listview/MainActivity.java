package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listview);
        //ArrayList<String> myFriends = new ArrayList<String>(asList("Tasib", "Arafat", "Ohi");  Another way of ArrayList
        final ArrayList<String> myFriends = new ArrayList<String>();
        myFriends.add("Tasib");
        myFriends.add("Saikot");
        myFriends.add("Arafat");
        myFriends.add("Nihan");
        myFriends.add("Ohi");
        myFriends.add("Arpita");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_selectable_list_item, myFriends);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "You Click " + myFriends.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }
}