package com.example.sit305quizapp;

public class Questions {

    private Question questions[] = new Question[5];

    public Questions() {
        questions[0] = new Question(
                "Question 1",
                "Question 1 details",
                "Answer 1",
                "Answer 2",
                "Answer 3",
                "Answer 2");

        questions[1] = new Question(
                "Question 2",
                "Question 2 details",
                "Answer 1",
                "Answer 2",
                "Answer 3",
                "Answer 2");

        questions[2] = new Question(
                "Question 3",
                "Question 3 details",
                "Answer 1",
                "Answer 2",
                "Answer 3",
                "Answer 2");

        questions[3] = new Question(
                "Question 4",
                "Question 4 details",
                "Answer 1",
                "Answer 2",
                "Answer 3",
                "Answer 2");

        questions[4] = new Question(
                "Question 5",
                "Question 5 details",
                "Answer 1",
                "Answer 2",
                "Answer 3",
                "Answer 2");
    }

    public Question[] getQuestions() {
        return questions;
    }
}
