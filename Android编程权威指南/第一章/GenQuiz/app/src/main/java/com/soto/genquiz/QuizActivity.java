package com.soto.genquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private Button mTrue_button;

    private Button mFalse_button;

    private ImageButton mNextButton;

    private ImageButton mPrevButton;

    private TextView mQuestionTextView;

    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_oceans, true),
            new TrueFalse(R.string.question_mideast, false),
            new TrueFalse(R.string.question_afraic, false),
            new TrueFalse(R.string.question_americas, true),
            new TrueFalse(R.string.question_asia, true),
    };

    private int mCurrentIndexInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);


        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        updateQuestion();

        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndexInt = (mCurrentIndexInt + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });


        mPrevButton = (ImageButton) findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndexInt = (mCurrentIndexInt - 1) % mQuestionBank.length;
                mCurrentIndexInt = (mCurrentIndexInt < 0) ? mQuestionBank.length - 1 : mCurrentIndexInt;
                updateQuestion();
            }
        });

        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndexInt = (mCurrentIndexInt + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        mTrue_button = (Button) findViewById(R.id.true_button);
        mTrue_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkAnswer(true);
//                Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
            }
        });

        mFalse_button = (Button) findViewById(R.id.flase_button);
        mFalse_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                checkAnswer(false);
//                Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_LONG).show();
            }
        });

    }

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndexInt].getQuestion();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressdTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndexInt].isTrueQuestion();

        int messageResId = 0;

        if (userPressdTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {

            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_quiz, menu);
        return true;
    }


}
