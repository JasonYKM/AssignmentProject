package com.example.assignmentproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final View logo = findViewById(R.id.splashLogo);
        final Animation rotateAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        final Animation logoFadeOutAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.logo_fade_out);
        logoFadeOutAnimation.setInterpolator(new AccelerateDecelerateInterpolator());

        logoFadeOutAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                logo.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });

        logo.startAnimation(rotateAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                logo.startAnimation(logoFadeOutAnimation);

                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);

                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                finish();
            }
        }, 3000);
    }
}
