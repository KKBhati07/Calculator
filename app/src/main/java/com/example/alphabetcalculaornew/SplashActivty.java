package com.example.alphabetcalculaornew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivty extends AppCompatActivity {
    ImageView splashIcon;
    Animation splashIconAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_activty);

        //finding the views
        initViews();

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent toMainActivityIntent=new Intent(getApplicationContext(),PermissionActivity.class);
                startActivity(toMainActivityIntent);
                finish();
            }
        },1200);
        splashIconAnim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.splash_anim);
        splashIcon.startAnimation(splashIconAnim);


    }

    private void initViews() {
        splashIcon=findViewById(R.id.splashIcon);
    }
}