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

                //TODO: change !isFirstTime to isFirstTime when not debugging
                if (!isFirstTime) {
                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("firstTime",false);
                    editor.apply();

                    Intent intent = new Intent(SplashActivity.this, OnBoardingActivity.class);
                    startActivity(intent);
                    finish();
                }
                else{
                    Intent intent = new Intent(SplashActivity.this, SecondActivity.class);
                    //TODO: also replace SecondActivity with LoginScreen
                    startActivity(intent);
                    finish();
                }
            }
        }, SplashDuration);

    }
}