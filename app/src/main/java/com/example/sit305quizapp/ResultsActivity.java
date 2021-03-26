package com.example.sit305quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    TextView congratulationsTextView, scoreTextView;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        setUpWidgets();
        displayData();
    }

    private void setUpWidgets() {
        congratulationsTextView = findViewById(R.id.congratulationsTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
    }

    private void displayData() {
        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        int score = intent.getIntExtra("score", 0);

        congratulationsTextView.setText("Congratulations " + name);
        scoreTextView.setText(score + " / 5");
    }

    public void takeNewQuiz(View view) {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }

    public void finish(View view) {
        this.finishAffinity();
    }
}