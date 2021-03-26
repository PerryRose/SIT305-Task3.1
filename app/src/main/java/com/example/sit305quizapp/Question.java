package com.example.sit305quizapp;

public class Question {

    String question, details, answer1, answer2, answer3, correctAnswer;

    public Question(String question, String details, String answer1, String answer2,
                    String answer3, String correctAnswer) {
        this.question = question;
        this.details = details;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.correctAnswer = correctAnswer;
    }

}
