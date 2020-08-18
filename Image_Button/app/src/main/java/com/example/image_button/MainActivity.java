package com.example.image_button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void newImage(View v){
        try {
            EditText newImage = (EditText) findViewById(R.id.editTextNumber);
            Double convert = Double.parseDouble(newImage.getText().toString());
            Double converter = convert/85;
            Toast.makeText(getApplicationContext(), "doller = " + String.format("%.2f", converter), Toast.LENGTH_LONG).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "doller = 0.00", Toast.LENGTH_LONG).show();
        }

    }
}