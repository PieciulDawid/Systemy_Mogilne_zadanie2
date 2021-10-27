package com.example.zadanie_1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.ref.ReferenceQueue;

public class PromptActivity extends AppCompatActivity {

    private boolean correctAnswer;
    private Button answerButton;
    private TextView answerTextViwe;
    public static final String KEY_EXTRA_ANSWER_SHOWN = "answerShown";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prompt);

        answerTextViwe  = findViewById(R.id.answer_text_view);
        answerButton    = findViewById(R.id.answer_button);

        correctAnswer   = getIntent().getBooleanExtra(MainActivity.KEY_EXTRA_ANSWER, true);

        answerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int answer = correctAnswer ? R.string.button_true : R.string.button_flase;
                answerTextViwe.setText(answer);
                setAnswerShownResult(true);
            }
            private void setAnswerShownResult(boolean answerWasShown) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra(KEY_EXTRA_ANSWER_SHOWN, answerWasShown);
                setResult(RESULT_OK, resultIntent);
            }
        });
    }


}