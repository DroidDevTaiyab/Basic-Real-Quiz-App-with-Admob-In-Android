package com.techpassappmaster.realquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.shashank.sony.fancytoastlib.FancyToast;

public class Result_Activity extends AppCompatActivity {

    private TextView tvright, tvwrong, tvScore,tvSkip,btnRestart;

    private ImageView worng_img;

    private boolean isL1,isL2,isL3;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__result);

        tvright = findViewById(R.id.tvright);
        tvwrong = findViewById(R.id.tvwrong);
        tvScore = findViewById(R.id.tvScore);
        tvSkip = findViewById(R.id.tvSkip);

        btnRestart =  findViewById(R.id.tvPlayNext);
        worng_img=findViewById(R.id.wrong_emg);

        isL1 = getIntent().getExtras().getBoolean("isKey");

        if (isL1)
        {
            tvright.setText("Correct: " + Play_Activity.correct );
            tvwrong.setText("Wrong: " + Play_Activity.wrong);
            tvScore.setText("Score: " + Play_Activity.score);
            tvSkip.setText("Skip: " + Play_Activity.skip);

            Play_Activity.correct =0;
            Play_Activity.wrong =0;

            int all= Play_Activity.score;

            if (all>=6)
            {
                worng_img.setImageResource(R.drawable.smile_img);
                FancyToast.makeText(Result_Activity.this,"Wow Great",FancyToast.LENGTH_LONG,FancyToast.INFO,false).show();
            }
            else
            {
                worng_img.setImageResource(R.drawable.angry_img);
                FancyToast.makeText(Result_Activity.this,"Need Improvement",FancyToast.LENGTH_LONG,FancyToast.INFO,false).show();
            }
        }

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });


    }
}
