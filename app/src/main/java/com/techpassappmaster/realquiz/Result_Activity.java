package com.techpassappmaster.realquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shashank.sony.fancytoastlib.FancyToast;

public class Result_Activity extends AppCompatActivity {

    TextView tvRight, tvWrong, tvScore, tvSkip, btnRestart;
    ImageView emoji_ReactionImg;
    int totalScore, correct, wrong, skip;
    boolean isKey;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__result);

        initializeViews();

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }

    @SuppressLint("SetTextI18n")
    private void initializeViews() {

        tvRight = findViewById(R.id.tvright);
        tvWrong = findViewById(R.id.tvwrong);
        tvScore = findViewById(R.id.tvScore);
        tvSkip = findViewById(R.id.tvSkip);
        btnRestart = findViewById(R.id.tvPlayNext);
        emoji_ReactionImg = findViewById(R.id.emoji_ReactionImg);


        totalScore = Play_Activity.score;
        correct = Play_Activity.correct;
        wrong = Play_Activity.wrong;
        skip = Play_Activity.skip;


        isKey = getIntent().getExtras().getBoolean("isKey");

        if (isKey) {
            tvScore.setText("Score: " + totalScore);
            tvRight.setText("Correct: " + correct);
            tvWrong.setText("Wrong: " + wrong);
            tvSkip.setText("Skip: " + skip);

            if (totalScore >= 6) {
                emoji_ReactionImg.setImageResource(R.drawable.smile_img);
                FancyToast.makeText(Result_Activity.this, "Wow Great", FancyToast.LENGTH_LONG, FancyToast.INFO, false).show();
            } else {
                emoji_ReactionImg.setImageResource(R.drawable.angry_img);
                FancyToast.makeText(Result_Activity.this, "Need Improvement", FancyToast.LENGTH_LONG, FancyToast.INFO, false).show();
            }
        }
    }
}
