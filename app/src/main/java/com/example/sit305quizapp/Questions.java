package com.example.sit305quizapp;

public class Questions {

    private Question questions[] = new Question[5];

    public Questions() {
        questions[0] = new Question(
                "Which widget is responsible for sending a message to the user?",
                "This is the small alert that can appear at the bottom of your screen.",
                "Bread",
                "Toast",
                "Loaf",
                "Answer 2");

        questions[1] = new Question(
                "Which function allows you to programmatically access a widget?",
                "Once a widget has been placed in an xml activity file, how can you access it via code?",
                "findWidgetById();",
                "findFromActivity();",
                "findViewById();",
                "Answer 3");

        questions[2] = new Question(
                "What class is responsible for passing data between Activities?",
                "Which class do you need to instantiate to pass data to another screen?",
                "Intent",
                "DataHandler",
                "Activity",
                "Answer 1");

        questions[3] = new Question(
                "What function must be called to give data to an Intent?",
                "Which of Intent's functions is used to pass data?",
                "Pass();",
                "Give();",
                "PutExtra();",
                "Answer 3");

        questions[4] = new Question(
                "What does a result code with the value of -1 from an Activity equate to?",
                "If an Activity returns -1 to OnActivityResult(), what does it mean?",
                "RESULT_CANCELLED",
                "RESULT_OKAY",
                "RESULT_FIRST_USER",
                "Answer 2");
    }

    public Question[] getQuestions() {
        return questions;
    }
}
