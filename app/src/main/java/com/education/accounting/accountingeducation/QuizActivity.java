package com.education.accounting.accountingeducation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.education.accounting.accountingeducation.exercise.QuestionBank;

public class QuizActivity extends AppCompatActivity {

    private QuestionBank mQuestionLibrary = new QuestionBank();
    private TextView mScoreView;   // view for current total score
    private TextView mQuestionView;  //current question to answer
    private Button mButtonChoice1; // multiple choice 1 for mQuestionView
    private Button mButtonChoice2; // multiple choice 2 for mQuestionView
    private Button mButtonChoice3; // multiple choice 3 for mQuestionView
    private Button mButtonChoice4; // multiple choice 4 for mQuestionView
    private Button mButtonChoice5;

    private String mAnswer;  // correct answer for question in mQuestionView
    private int mScore = 0;  // current total score
    private int mQuestionNumber = 0; // current question number

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        // setup screen for the first question with four alternative to answer
        mScoreView = (TextView)findViewById(R.id.score);
        mQuestionView = (TextView)findViewById(R.id.question);
        mButtonChoice1 = (Button)findViewById(R.id.choice1);
        mButtonChoice2 = (Button)findViewById(R.id.choice2);
        mButtonChoice3 = (Button)findViewById(R.id.choice3);
        mButtonChoice4 = (Button)findViewById(R.id.choice4);
        mButtonChoice5 = (Button)findViewById(R.id.choice5);
//        updateQuestion();
//        // show current total score for the user
//        updateScore(mScore);
    }

//    private void updateQuestion(){
//        // check if we are not outside array bounds for questions
//        if(mQuestionNumber<mQuestionLibrary.getLength() ){
//            // set the text for new question, and new 4 alternative to answer on four buttons
//            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
//            mButtonChoice1.setText(mQuestionLibrary.getChoice(mQuestionNumber, 1));
//            mButtonChoice2.setText(mQuestionLibrary.getChoice(mQuestionNumber, 2));
//            mButtonChoice3.setText(mQuestionLibrary.getChoice(mQuestionNumber, 3));
//            mButtonChoice4.setText(mQuestionLibrary.getChoice(mQuestionNumber,4));
//            mButtonChoice5.setText(mQuestionLibrary.getChoice(mQuestionNumber,5));
//            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
//            mQuestionNumber++;
//       }
//        else {
//            Toast.makeText(QuizActivity.this, "It was the last question!", Toast.LENGTH_SHORT).show();
////            Intent intent = new Intent(QuizActivity.this, HighestScoreActivity.class);
////            intent.putExtra("score", mScore); // pass the current score to the second screen
////            startActivity(intent);
//        }
//    }
//
//    // show current total score for the user
//    private void updateScore(int point) {
//        mScoreView.setText("" + mScore+"/"+mQuestionLibrary.getLength());
//    }
//
//    public void onClick(View view) {
//        //all logic for all answers buttons in one method
//        Button answer = (Button) view;
//        // if the answer is correct, increase the score
//        if (answer.getText() == mAnswer){
//            mScore = mScore + 3;
//             Toast.makeText(QuizActivity.this, "Jawaban Anda Benar!", Toast.LENGTH_SHORT).show();
//        }else
//            Toast.makeText(QuizActivity.this, "Jawaban Anda Salah!", Toast.LENGTH_SHORT).show();
//        // show current total score for the user
//        updateScore(mScore);
//        // once user answer the question, we move on to the next one, if any
//        updateQuestion();
//    }
 }