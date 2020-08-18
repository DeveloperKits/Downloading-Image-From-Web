package com.example.numbershapes;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {
        int number;

        public boolean isSquare(){
            double squareRoot = Math.sqrt(number);
            //System.out.println("SquareRoot = " + squareRoot);
            //System.out.println("Math.Floor = " + Math.floor(squareRoot));

            if(squareRoot == Math.floor(squareRoot)){
                return true;
            }else{
                return false;
            }
        }

        public boolean isTriangular(){
            int x = 1;
            int triangleNumber = 1;

            while(triangleNumber < number){
                x++;
                triangleNumber = triangleNumber + x;
            }

            if(triangleNumber == number){
                return true;
            }else{
                return false;
            }
        }
    }

    public void textNumber(View v){
        String message;
        EditText userNumber = (EditText) findViewById(R.id.editTextNumber);

        if(userNumber.getText().toString().isEmpty()){
            message = "Please Enter a Message!";
        }else{
            Number mynumber = new Number();
            mynumber.number = Integer.parseInt(userNumber.getText().toString());

            if(mynumber.isSquare() && mynumber.isTriangular()){
                message = mynumber.number + " is both Triangular & Square";
            }else if(mynumber.isSquare()){
                message = mynumber.number + " is Square, but not Triangular";
            }else if(mynumber.isTriangular()){
                message = mynumber.number + " is Triangular, but not Square";
            }else{
                message = mynumber.number + " is not Triangular or not Square";
            }
        }
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}