package com.techpassappmaster.realquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class Splash_Screen extends AppCompatActivity {

    Animation lefttoright;
    ImageView icon_anim;
    private InterstitialAd mInterstitialAd;
    private AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        icon_anim = findViewById(R.id.icon_anim);
        // simple animation
        lefttoright=AnimationUtils.loadAnimation(this,R.anim.left_to_right);
        icon_anim.setAnimation(lefttoright);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent=new Intent(Splash_Screen.this, Main_Activity.class);
                startActivity(intent);
                finish();


            }
        }, 5000);


    }
}
