package com.example.sit305quizapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Variables
    EditText nameEditText;
    Button startBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find Views
        nameEditText = findViewById(R.id.nameEditText);
        startBtn = findViewById(R.id.btnStart);
    }

    public void startQuiz(View view) {

        if (!nameEditText.getText().toString().isEmpty()) {
            sendQuizData();
        }
        else {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
        }

    }

    public void sendQuizData() {
        Intent intent = new Intent(getApplicationContext(), QuestionActivity.class);
        intent.putExtra("name", nameEditText.getText().toString());
        startActivityForResult(intent, 1);
    }

}