package com.example.splashes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    private static final int SplashDuration = 2000;

    ImageView logo;
    Animation sideAnim;

    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // get the logo
        logo = findViewById(R.id.bluelogo);

        //animations
        sideAnim = AnimationUtils.loadAnimation(this,R.anim.side_anim);

        logo.setAnimation(sideAnim);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                onBoardingScreen = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
                boolean isFirstTime = onBoardingScreen.getBoolean("firstTime",true);

                //you can change this Boolean to be !isFirstTime when debugging, or just ignore the boolean condition entirely
                if (isFirstTime) {
                    //on first launch, show splashes, and also keep a note that we have seen this before
                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("firstTime",false);
                    editor.apply();

                    Intent intent = new Intent(SplashActivity.this, OnBoardingActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    // if not go straight to login
                    Intent intent = new Intent(SplashActivity.this, SecondActivity.class);
                    //TODO: Replace SecondActivity.class with actual Login screen class upon merge.
                    startActivity(intent);
                    finish();
                }
            }
        }, SplashDuration);

    }
}