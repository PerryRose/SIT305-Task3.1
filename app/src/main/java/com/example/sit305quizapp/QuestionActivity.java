package com.example.sit305quizapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity {

    // Variables
    TextView welcomeTextView, progressTextView, questionTitleTextView, questionDetailsTextView;
    ProgressBar progressBar;
    Button answer1Button, answer2Button, answer3Button, nextButton;
    String name;

    int currentQuestionNumber = 1;
    int progress = 20;
    int correctAnswers = 0;
    int maxQuestions = 5;

    Question[] questions = new Questions().getQuestions();
    Question currentQuestion = questions[currentQuestionNumber - 1];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        setUpWidgets();
        displayQuestionData();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    private void setUpWidgets() {
        welcomeTextView = findViewById(R.id.welcomeTextView);
        progressTextView = findViewById(R.id.progressTextView);
        questionTitleTextView = findViewById(R.id.questionTitleTextView);
        questionDetailsTextView = findViewById(R.id.questionDetailsTextView);
        progressBar = findViewById(R.id.progressBar);
        answer1Button = findViewById(R.id.btnAnswer1);
        answer2Button = findViewById(R.id.btnAnswer2);
        answer3Button = findViewById(R.id.btnAnswer3);
        nextButton = findViewById(R.id.btnNext);
    }

    private void displayQuestionData() {
        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        welcomeTextView.setText("Welcome " + name);

        progressTextView.setText(currentQuestionNumber + "/ 5");
        progressBar.setProgress(progress, true);

        questionTitleTextView.setText(currentQuestion.question);
        questionDetailsTextView.setText(currentQuestion.details);

        answer1Button.setText(currentQuestion.answer1);
        answer2Button.setText(currentQuestion.answer2);
        answer3Button.setText(currentQuestion.answer3);
    }

    public void nextQuestion(View view) {
        resetButtonColors();

        if (currentQuestionNumber < maxQuestions) {
            currentQuestion = questions[currentQuestionNumber++];
            progress += 20;
            displayQuestionData();

            // Remove welcome text view after first question
            if (welcomeTextView.getVisibility() == View.VISIBLE) welcomeTextView.setVisibility(View.GONE);
        }
        else {
            Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("score", correctAnswers);
            startActivityForResult(intent, 1);
        }
    }

    public void checkAnswer(View view) {
        switch (view.getId()) {
            case R.id.btnAnswer1:
                if (currentQuestion.correctAnswer == "Answer 1") {
                    correctAnswers++;
                    answer1Button.setBackgroundColor(Color.GREEN);
                }
                else {
                    answer1Button.setBackgroundColor(Color.RED);
                    setCorrectAnswerButtonColor();
                }
                break;
            case R.id.btnAnswer2:
                if (currentQuestion.correctAnswer == "Answer 2") {
                    correctAnswers++;
                    answer2Button.setBackgroundColor(Color.GREEN);
                }
                else {
                    answer2Button.setBackgroundColor(Color.RED);
                    setCorrectAnswerButtonColor();
                }
                break;
            case R.id.btnAnswer3:
                if (currentQuestion.correctAnswer == "Answer 3") {
                    correctAnswers++;
                    answer3Button.setBackgroundColor(Color.GREEN);
                }
                else {
                    answer3Button.setBackgroundColor(Color.RED);
                    setCorrectAnswerButtonColor();
                }
                break;
            default: break;
        }
    }

    public void setCorrectAnswerButtonColor() {
        switch (currentQuestion.correctAnswer) {
            case "Answer 1": answer1Button.setBackgroundColor(Color.GREEN); break;
            case "Answer 2": answer2Button.setBackgroundColor(Color.GREEN); break;
            case "Answer 3": answer3Button.setBackgroundColor(Color.GREEN); break;
            default: break;
        }
    }

    public void resetButtonColors() {
        answer1Button.setBackgroundColor(Color.parseColor("#9E9E9E"));
        answer2Button.setBackgroundColor(Color.parseColor("#9E9E9E"));
        answer3Button.setBackgroundColor(Color.parseColor("#9E9E9E"));
    }
}