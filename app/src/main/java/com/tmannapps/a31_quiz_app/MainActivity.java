package com.tmannapps.a31_quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button myButtonStart;
    TextView myTextViewTitle;
    TextView myTextViewNameRequest;
    EditText myEditTextEnteredName;

    public void startQuiz () {
        Intent intent = new Intent(this, Questions.class);
        intent.putExtra("username", myEditTextEnteredName.getText().toString());
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTextViewTitle = findViewById(R.id.myTextViewTitle);
        myTextViewNameRequest = findViewById(R.id.myTextViewNameRequest);
        myEditTextEnteredName = findViewById(R.id.myEditTextEnteredName);
        myButtonStart = findViewById(R.id.myButtonStart);

        myButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("Checking", "Button is clicked");
                startQuiz();
            }
        });
        myTextViewTitle.setText(R.string.app_name);
        myTextViewNameRequest.setText(R.string.nameRequestString);
        myButtonStart.setText(R.string.startButton);
        myEditTextEnteredName.setText(R.string.enterName);
        myEditTextEnteredName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myEditTextEnteredName.getText().clear();
            }
        });
    }
}

