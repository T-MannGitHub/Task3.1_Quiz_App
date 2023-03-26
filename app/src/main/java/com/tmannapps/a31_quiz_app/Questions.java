package com.tmannapps.a31_quiz_app;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Questions extends AppCompatActivity {

    TextView myWelcomeName;
    RadioButton myRadioButtonA;
    RadioButton myRadioButtonB;
    RadioButton myRadioButtonC;
    TextView myQuestionText;
    TextView myQuestionNumber;
    Button myButtonSubmit;
    int score = 0;
    int qNum = 0;



    //I need this intent to only happen after the LAST question has been asked
    public void Submit () {
        // progresses to final page
        Intent intent = new Intent(this, EndPage.class);
        intent.putExtra("score", String.valueOf(score));
        startActivity(intent);
        Intent intent2 = getIntent();
        String name = intent2.getStringExtra("username");
        intent2.putExtra("username", name);
    }

    public void CheckAnswers() {
        String qIntro = ": ";

        myQuestionNumber.setText("Question " + (qNum+1));

        List questions = new ArrayList();
        questions.add("How many bones in the adult human body");
        questions.add("How many bones in the adult cat");
        questions.add("What is a duel between three people called");
        questions.add("LAST QUESTION IS NO QUESTION");
        myQuestionText.setText((qIntro) + questions.get(qNum));

        List Q1 = new ArrayList();
        Q1.add("180");
        Q1.add("278");
        Q1.add("206");

        List Q2 = new ArrayList();
        Q2.add("230");
        Q2.add("278");
        Q2.add("260");

        List Q3 = new ArrayList();
        Q3.add("A trial");
        Q3.add("A trallon");
        Q3.add("A truel");

        String correctAnswer = "x";
        String selectedAnswer = "y";
        if (qNum == 0){
            myRadioButtonA.setText(qIntro +(Q1.get(0)));
            myRadioButtonB.setText(qIntro+(Q1.get(1)));
            myRadioButtonC.setText(qIntro+(Q1.get(2)));
            correctAnswer = "206";
        }
        else if (qNum == 1) {
            myRadioButtonA.setText(qIntro +(Q2.get(0)));
            myRadioButtonB.setText(qIntro+(Q2.get(1)));
            myRadioButtonC.setText(qIntro+(Q2.get(2)));
            correctAnswer = "230";
        } else if (qNum == 2){
            myRadioButtonA.setText(qIntro +(Q3.get(0)));
            myRadioButtonB.setText(qIntro+(Q3.get(1)));
            myRadioButtonC.setText(qIntro+(Q3.get(2)));
            correctAnswer = "A truel";}

        if (myRadioButtonA.isSelected()){
            selectedAnswer = (String) myRadioButtonA.getText();
            } else if (myRadioButtonB.isSelected()) {
            selectedAnswer = (String) myRadioButtonB.getText();
            } else if (myRadioButtonC.isSelected()) {
            selectedAnswer = (String) myRadioButtonC.getText();
        }

        if (qNum == 0){
            if (selectedAnswer == correctAnswer){
                myRadioButtonC.setBackgroundColor(Color.GREEN);
                score +=1;
            }
        } else if (qNum == 1) {
                if (selectedAnswer == correctAnswer){
                    myRadioButtonA.setBackgroundColor(Color.GREEN);
                    score +=1;
                }
        } else if (qNum == 2) {
            if (selectedAnswer == correctAnswer){
                myRadioButtonC.setBackgroundColor(Color.GREEN);
                score +=1;
            }
        }
        //if radio button value == answer;
        //radio button green,
        // increment score variable score+=1;
        // otherwise
        //radio button red
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions1);

        myWelcomeName = findViewById(R.id.myWelcomeName);
        myRadioButtonA = findViewById(R.id.myRadioButtonA);
        myRadioButtonB = findViewById(R.id.myRadioButtonB);
        myRadioButtonC = findViewById(R.id.myRadioButtonC);
        myQuestionText = findViewById(R.id.myQuestionText);
        myQuestionNumber = findViewById(R.id.myQuestionNumber);
        myButtonSubmit = findViewById(R.id.myButtonSubmit);
        myButtonSubmit.setText(R.string.submitButton);
        Intent intent = getIntent();
        String name = intent.getStringExtra("username");

        //Intent intentNameToFinal = new Intent(this, EndPage.class);
        //intentNameToFinal.putExtra("usernameToFinal", name);
        //startActivity(intentNameToFinal);*/
        //this needs to be a putExtra thing
        myWelcomeName.setText("Welcome " + name +"!");
        //Update();

        myRadioButtonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        myRadioButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        myRadioButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        CheckAnswers();
        //make a public method here called questionNumber


        //group radio buttons

        //set on click listener for radio buttons

        //set on click listener for submit to do the following:
        // highlight correct answer to green
        //change submit to next
        // update qNum with on next to questions change
        // update progress bar

        myButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myButtonSubmit.setText(R.string.nextQuestion);

                //int i = 0;
                //int max = R.array.questions.length; HELPHUB QUESTION
                //int max = 3;
                //while (i < max) {
                //
                if( qNum > 2) {
                    Submit();
                } else {
                    qNum +=1;
                    CheckAnswers();
                 //   i +=1;
                }}});






                //Submit();
                //qNum +=1;
                //Submit();
            //}
}}





        //onClick for Submit - qNum ++1; ansNum =+1;



        //myRadioButtonA.setText("Hello" + Q1);

        //need to set it up so you can click to select a question, then click to check the question, and while the question counter is </=4, it highlights
        // green if the correct answer or red if incorrect, adds the total correct to a total variable, and then a next button appears to go to the next question
        // I need the next button to then update the question number, and question text, and answer options. use dictionaries to do this or lists? or list array string resources






