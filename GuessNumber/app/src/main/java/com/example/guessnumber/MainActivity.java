package com.example.guessnumber;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int randomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random random = new Random();
        randomNumber = random.nextInt(10) + 1;
    }

    public void guess(View v){
        try {
            EditText guessNumber = (EditText) findViewById(R.id.editTextNumber);
            int guessInt = Integer.parseInt(guessNumber.getText().toString());

            if(randomNumber > guessInt){
                ToastText("Lower!");
            }else if(randomNumber < guessInt){
                ToastText("Higher!");
            }else{
                ToastText("Congratulation you win! Try again.");

                Random random = new Random();
                randomNumber = random.nextInt(10) + 1;

            }
        }catch (Exception e){

        }
    }

    public void ToastText(String string){
        Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT).show();
    }


}