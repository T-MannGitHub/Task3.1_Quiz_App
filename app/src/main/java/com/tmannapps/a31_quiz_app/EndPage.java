package com.tmannapps.a31_quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// Tiffany Mann SIT708 Task 3.1 Quiz App Student ID: 221457972
public class EndPage extends AppCompatActivity {
Button myButtonNewQuiz;
TextView myTextViewCongratsName;
TextView myTextViewFinalScore;
Button myButtonFinish;
String nameStartAgain;

    //create final page,
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_page);

        myButtonNewQuiz = findViewById(R.id.buttonNewQuiz);
        myTextViewCongratsName = findViewById(R.id.textViewCongratsName);
        myTextViewFinalScore = findViewById(R.id.textViewFinalScore);
        myButtonFinish = findViewById(R.id.buttonFinish);

        //get name intent from Questions activity
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        myTextViewCongratsName.setText("Congratulations " + name + "!");
        nameStartAgain = name;

        //get score intent from Questions activity
        Intent intent2 = getIntent();
        String score = intent2.getStringExtra("score");
        myTextViewFinalScore.setText("You scored " + score +" out of 3.");

        //send name intent back to the Questions activity on new quiz
        myButtonNewQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(EndPage.this, Questions.class);
            intent.putExtra("username", nameStartAgain);
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