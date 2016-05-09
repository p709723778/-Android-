package com.soto.genquiz;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

    private Button mCheatButton;

    private boolean mIsCheater;

    private static final String TAG = "QuizActivity";

    private static final String KEY_INDEX = "index";

    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_oceans, true),
            new TrueFalse(R.string.question_mideast, false),
            new TrueFalse(R.string.question_afraic, false),
            new TrueFalse(R.string.question_americas, true),
            new TrueFalse(R.string.question_asia, true),
    };

    private int mCurrentIndexInt = 0;

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndexInt);
    }

    @TargetApi(11)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {

            ActionBar actionBar = getSupportActionBar();
            actionBar.setSubtitle(R.string.app_name);
        }

        mIsCheater = false;

        mCheatButton = (Button) findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, CheatActivity.class);
                boolean answerIsTtre = mQuestionBank[mCurrentIndexInt].isTrueQuestion();
                intent.putExtra(CheatActivity.EXTRA_ANSWER_IS_TRUE, answerIsTtre);
                startActivityForResult(intent, 0);

            }
        });

        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);

        if (savedInstanceState != null) {
            mCurrentIndexInt = savedInstanceState.getInt(KEY_INDEX, 0);
        }
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

        TrueFalse question;
        try {
            question = mQuestionBank[mCurrentIndexInt];
        } catch (ArrayIndexOutOfBoundsException ex) {
            Log.e(TAG, "Index was out of bounds", ex);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        }

        mIsCheater = data.getBooleanExtra(CheatActivity.EXTRA_ANSWER_SHOWN, false);

        checkAnswer(mIsCheater);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndexInt].getQuestion();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressdTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndexInt].isTrueQuestion();

        int messageResId = 0;

        if (mIsCheater) {
            messageResId = R.string.judgment_toast;
        } else {
            if (userPressdTrue == answerIsTrue) {
                messageResId = R.string.correct_toast;
            } else {

                messageResId = R.string.incorrect_toast;
            }
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_quiz, menu);
        return true;
    }


}
