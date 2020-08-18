package com.example.appbriantrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    // Declare Global Variable
    ArrayList<Integer> answer = new ArrayList<>();
    MediaPlayer myPlayer;
    TextView Ans;
    TextView Marks;
    TextView Questions;
    TextView Timer;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button PlayAgainButton;
    int Score = 0;
    int positionOfCorrectAnswer;
    int NumberOfQuestions = 0;
    Boolean buttonIsStop = false;
    // End

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Questions = (TextView) findViewById(R.id.Questions);
        Marks = (TextView) findViewById(R.id.Marks);
        Ans = (TextView) findViewById(R.id.Ans);
        Timer = (TextView) findViewById(R.id.Timer);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        PlayAgainButton = (Button) findViewById(R.id.PlayAgainButton);


        // Transfer view PlayAgain Method. Please Saw New CountDownTimer on PlayAgain Method. There Also Generate New Questions
        PlayAgain(findViewById(R.id.PlayAgainButton));
        // End
    }


    // Choose Answer From GridLayout Button & Show Answer
    @SuppressLint("SetTextI18n")
    public void ChooseAnswer(View view) {
        //Toast.makeText(getApplicationContext(), Integer.toString(positionOfCorrectAnswer), Toast.LENGTH_SHORT).show();  // For Saw Which Button Generated Correct Number.

        if (!buttonIsStop) {
            if (view.getTag().toString().equals(Integer.toString(positionOfCorrectAnswer))) {
                Score++;
                Ans.setText("Correct!");
            } else {
                Ans.setText("Wrong!");
            }
            NumberOfQuestions++;
            Marks.setText(Integer.toString(Score) + "/" + Integer.toString(NumberOfQuestions));

            // Generate Question Again. Create Random Number For Questions Text & SetText There. Then Create GirdLayout button & Set Answer For click. Please Saw the GeneRatedQuestion Function
            generatedQuestion();
            // End
        }
    }
    // End


    // It's Call on the override onCreate Method. Please Saw There
    @SuppressLint("SetTextI18n")
    public void generatedQuestion(){
            Random random = new Random();
            int a = random.nextInt(21);
            int b = random.nextInt(21);
            Questions.setText(Integer.toString(a) + " + " + Integer.toString(b));

            answer.clear(); // If GirdLayout Button Answer Already Created Then It Delete & Again Set Answer There.

            // Create GirdLayout button & Set Answer For click
            positionOfCorrectAnswer = random.nextInt(4);
            int inCorrectAnswer;

            for (int i = 0; i < 4; i++) {

                if (i == positionOfCorrectAnswer) {
                    answer.add(a + b);
                } else {
                    inCorrectAnswer = random.nextInt(41);
                    while (inCorrectAnswer == (a + b)) {
                        inCorrectAnswer = random.nextInt(41);
                    }
                    answer.add(inCorrectAnswer);
                }

            }

            // Set Answer GridLayout Button
            button1.setText(Integer.toString(answer.get(0)));
            button2.setText(Integer.toString(answer.get(1)));
            button3.setText(Integer.toString(answer.get(2)));
            button4.setText(Integer.toString(answer.get(3)));
            // End

    }
    // End


    // If Click Play Again Button Then Refresh All And You Play Again
    @SuppressLint("SetTextI18n")
    public void PlayAgain(View view) {
        buttonIsStop = false;
        Score = 0;
        NumberOfQuestions = 0;
        Timer.setText("30s");
        Marks.setText("0/0");
        Ans.setText("");
        PlayAgainButton.setVisibility(View.INVISIBLE);
        myPlayer = new MediaPlayer();


        // Create Random Number For Questions Text & SetText There. Then Create GirdLayout button & Set Answer For click. Please Saw the GeneRatedQuestion Function
        generatedQuestion();
        // End

        // Time Changer For New CountDownTimer
        new CountDownTimer(30000, 1000) {

            @SuppressLint("SetTextI18n")
            @Override
            public void onTick(long l) {
                Timer.setText(String.valueOf(l / 1000) + "s");
            }
            @SuppressLint("SetTextI18n")
            @Override
            public void onFinish() {
                buttonIsStop = true;
                PlayAgainButton.setVisibility(View.VISIBLE);
                Ans.setText("Your Score : " + Integer.toString(Score) + "/" + Integer.toString(NumberOfQuestions));
                myPlayer = MediaPlayer.create(getApplicationContext(), R.raw.air_horn);
                myPlayer.start();
            }

        }.start();
        // End

    }
    // End
}