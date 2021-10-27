package com.example.zadanie_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String QUIZ_TAG = "MainActivity";
    private static final String KEY_CURRENT_INDEX = "currentIndex";
    private Button trueButton;
    private Button falaseButton;
    private Button nextButton;
    private TextView questionTextView;
    private Question[] questions = new Question[]{
            new Question(R.string.pytanie1, true),
            new Question(R.string.pytanie2, true),
            new Question(R.string.pytanie3, true),
            new Question(R.string.pytanie4, true),
            new Question(R.string.pytanie5, true),
            new Question(R.string.pytanie6, false),
            new Question(R.string.pytanie7, false),
            new Question(R.string.pytanie8, false),
            new Question(R.string.pytanie9, false),
    };

    private int currentIndex = 0;
    private void checkAnswerCorrectness (boolean useerAnswer){
        boolean correctAnswer = questions[currentIndex].isTrueAnswer();
        int resultMessageId = 0;
        if (useerAnswer == correctAnswer) {
            resultMessageId = R.string.correct_answer;
        }else {
            resultMessageId = R.string.incorrect_answer;
        }
        Toast.makeText(this, resultMessageId, Toast.LENGTH_SHORT).show();
    }

    private void setNextQuestion(){
        questionTextView.setText(questions[currentIndex].getQuestionId());
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        Log.d(QUIZ_TAG, "Wywołana została metoda cyklu życia: onSaveInstanceState");
        outState.putInt(KEY_CURRENT_INDEX, currentIndex);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(QUIZ_TAG, "Wywołana została metoda cyklu życia: onCreate");
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            currentIndex = savedInstanceState.getInt(KEY_CURRENT_INDEX);
        }

        setContentView(R.layout.activity_main);
        trueButton       = findViewById(R.id.true_button);
        falaseButton     = findViewById(R.id.false_button);
        nextButton       = findViewById(R.id.next_button);
        questionTextView = findViewById(R.id.question_text_view);
        setNextQuestion();
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                checkAnswerCorrectness(true);
            }
        });
        falaseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                checkAnswerCorrectness(false);
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                currentIndex = (currentIndex + 1)%questions.length;
                setNextQuestion();
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(QUIZ_TAG, "Wywołana została metoda cyklu życia: onStart");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(QUIZ_TAG, "Wywołana została metoda cyklu życia: onResume");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(QUIZ_TAG, "Wywołana została metoda cyklu życia: onPause");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(QUIZ_TAG, "Wywołana została metoda cyklu życia: onStop");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(QUIZ_TAG, "Wywołana została metoda cyklu życia: onDestroy");
    }
}