package com.example.quizzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class QuizSplashActivity extends AppCompatActivity {
    private static String LAST_LAUNCH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences lastTime = getSharedPreferences(LAST_LAUNCH, MODE_PRIVATE);
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat ("EEE dd MMM yyyy HH:mm:ss zzz", Locale.ITALY);
        Log.i(this.getClass().getSimpleName(), "Running");
        if (lastTime.contains("dateTime") == true) {
            String dateTime = lastTime.getString("dateTime", "Default");
            Log.i(this.getClass().getSimpleName(), "Running " + dateTime);
        }
        SharedPreferences.Editor dateEditor = lastTime.edit();
        dateEditor.putString("dateTime",sdf.format(d));
        dateEditor.commit();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_splash);
        ImageView iv = findViewById(R.id.imageView);
        Animation splash = AnimationUtils.loadAnimation(this, R.anim.splashanim);
        iv.startAnimation(splash);
        splash.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) { }
            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(QuizSplashActivity.this, MainActivity.class));
                QuizSplashActivity.this.finish();
            }
            public void onAnimationRepeat(Animation animation) { }
        });
    }
}
