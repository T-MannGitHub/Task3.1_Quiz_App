package com.tmannapps.a31_quiz_app;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

// Tiffany Mann SIT708 Task 3.1 Quiz App Student ID: 221457972
public class Questions extends AppCompatActivity {

    TextView myWelcomeName;
    RadioButton myRadioButtonA;
    RadioButton myRadioButtonB;
    RadioButton myRadioButtonC;
    TextView myQuestionText;
    TextView myQuestionNumber;
    Button myButtonSubmit;
    RadioGroup myRGroupQuestions;
    ProgressBar myProgressBar;
    int score = 0;
    int qNum = 0;
    int submitClicks = 0;
    int buttonSelected;
    String correctAnswer = "x";
    String selectedAnswer = "y";
    String nameEnd;

    //get name from either MainActivity or EndPage activity for instance of a new quiz, set to a global variable
public void getName ()
{
    Intent intent = getIntent();
    String name = intent.getStringExtra("username");
    nameEnd = name;
    myWelcomeName.setText("Welcome " + name +"!");
}

    // final submit of the last question to the final score page
    public void submit() {
        // progresses to final page
        Intent intent = new Intent(this, EndPage.class);
        intent.putExtra("score", String.valueOf(score));
        intent.putExtra("name", nameEnd);
        startActivity(intent);
    }

        //create questions and answers in lists. Set up radio buttons
    public void showQuestions() {
        String qIntro = "";
        List questions = new ArrayList();
        questions.add("How many bones in the adult human body");
        questions.add("How many bones in the adult cat");
        questions.add("What is a duel between three people called");

        myQuestionNumber.setText("Question " + (qNum+1));
        myQuestionText.setText((qIntro) + questions.get(qNum));

        //set up radio buttons so need only one activity, and questions update on submit/next
        //tried for may hours to use a .json file, but couldn't get it to work. Would like to learn how to do this.
        //also tried to establish these lists in the strings resource, but couldn't get that to work either, so they are in here.
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

        //this wouldn't work without concatenating a string - unsure why.
        if (qNum == 0){
            myRadioButtonA.setText(qIntro +(Q1.get(0)));
            myRadioButtonB.setText(qIntro+(Q1.get(1)));
            myRadioButtonC.setText(qIntro+(Q1.get(2)));
            correctAnswer = (String) myRadioButtonC.getText().toString();
        }
        else if (qNum == 1) {
            myRadioButtonA.setText(qIntro +(Q2.get(0)));
            myRadioButtonB.setText(qIntro+(Q2.get(1)));
            myRadioButtonC.setText(qIntro+(Q2.get(2)));
            correctAnswer = (String) myRadioButtonA.getText().toString();
        } else if (qNum == 2){
            myRadioButtonA.setText(qIntro +(Q3.get(0)));
            myRadioButtonB.setText(qIntro+(Q3.get(1)));
            myRadioButtonC.setText(qIntro+(Q3.get(2)));
            correctAnswer = (String) myRadioButtonC.getText().toString();}
    }

    //setting the correct answer based on the question number, to the radio button value
    public void setAnswers()
    {
        myRadioButtonA.setOnClickListener(new View.OnClickListener() {
            @Override
        public void onClick(View view) {
            selectedAnswer = (String) myRadioButtonA.getText().toString();
        }
    });
        myRadioButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = (String) myRadioButtonB.getText().toString();
            }
        });
        myRadioButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedAnswer = (String) myRadioButtonC.getText().toString();
            }
        });
    }

    //change radiobutton background to green or red depending on answer selected
    public void revealAnswers()
    {
        buttonSelected = myRGroupQuestions.getCheckedRadioButtonId();
        RadioButton rbAnswerSelected = (RadioButton) findViewById(buttonSelected);
        //check if it is correct
        try {
        if (qNum == 0){
            if (selectedAnswer == correctAnswer) {
                myRadioButtonC.setBackgroundColor(Color.GREEN);
            }
            else if (selectedAnswer != correctAnswer) {
                rbAnswerSelected.setBackgroundColor(Color.RED);
            }
        } else if (qNum == 1) {
            if (selectedAnswer == correctAnswer){
                myRadioButtonA.setBackgroundColor(Color.GREEN);
            } else if (selectedAnswer != correctAnswer) {
            rbAnswerSelected.setBackgroundColor(Color.RED);
            }
        } else if (qNum == 2) {
            if (selectedAnswer == correctAnswer){
                myRadioButtonC.setBackgroundColor(Color.GREEN);
            } else if (selectedAnswer != correctAnswer) {
            rbAnswerSelected.setBackgroundColor(Color.RED);
        }} }
        catch (Exception exception){
            Toast.makeText(Questions.this, "Please make a selection", Toast.LENGTH_SHORT).show();
            submitClicks -=1;
        }
        submitClicks +=1;
    }

    //clear radio button selection and background colour moving to the next question
    public void clearButton()
    {
        //Source for setup of radio group https://stackoverflow.com/questions/15821334/unchecking-a-radio-button#:~:text=You%20need%20to%20put%20the%20button%20in%20a,one%20option%20in%20a%20group%20is%20always%20checked.
        buttonSelected = myRGroupQuestions.getCheckedRadioButtonId();
        RadioButton rbClearSelected = (RadioButton) findViewById(buttonSelected);
        if (rbClearSelected != null)
        {
            myRGroupQuestions.clearCheck();
            rbClearSelected.setBackgroundColor(Color.WHITE);
        }
    }

    // increment score - used this method as I wanted 2 seperate clicks to reveal answer and progress to next question, which was doubling the score
    public void addScore ()
    {
        if (selectedAnswer == correctAnswer)
        {
            score +=1;
        }
    }

    //increment question number
    public void nextQuestion()
    {
           if (qNum >= 2) {
               submit();
           } else {
               qNum += 1;
               showQuestions();
           }
           myProgressBar.incrementProgressBy(33);
    }

    // create the question page using above functions
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
        myProgressBar = findViewById(R.id.myProgressBar);
        myRGroupQuestions = findViewById(R.id.myRGroupQuestions);
        myButtonSubmit.setText(R.string.submitButton);

        getName();
        showQuestions();
        setAnswers();

        myButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myButtonSubmit.setText(R.string.nextQuestion);
                //check if answer is correct and increment click value
                revealAnswers();

                if (submitClicks == 2) {
                    addScore();
                    clearButton();
                    nextQuestion();
                    submitClicks = 0;
                    myButtonSubmit.setText(R.string.submitButton);
                }
            }});
}}


