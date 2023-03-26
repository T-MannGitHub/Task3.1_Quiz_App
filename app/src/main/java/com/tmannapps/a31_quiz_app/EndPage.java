package com.tmannapps.a31_quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndPage extends AppCompatActivity {
Button myButtonNewQuiz;
TextView myTextViewCongratsName;
TextView myTextViewFinalScore;
Button myButtonFinish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_page);

        myButtonNewQuiz = findViewById(R.id.buttonNewQuiz);
        myTextViewCongratsName = findViewById(R.id.textViewCongratsName);
        myTextViewFinalScore = findViewById(R.id.textViewFinalScore);
        myButtonFinish = findViewById(R.id.buttonFinish);

        Intent intent = getIntent();
        String name = intent.getStringExtra("username");
        myTextViewCongratsName.setText("Congratulations " + name);
        Intent intent2 = getIntent();
        String score = intent2.getStringExtra("score");
        myTextViewFinalScore.setText("You scored " + score +" out of 3.");



        myButtonNewQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(EndPage.this, Questions.class);
            startActivity(intent);

            }
        });

        myButtonFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              finishAffinity();
            }
        });



    }
}