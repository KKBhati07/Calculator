package com.example.alphabetcalculaornew;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
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
                if(permissionGranted()){
                    Intent toMainActivityIntent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(toMainActivityIntent);
                    finish();
                }else{
                    Intent toPermissionActivityIntent=new Intent(getApplicationContext(),PermissionActivity.class);
                    startActivity(toPermissionActivityIntent);
                    finish();
                }

            }
        },1200);
        splashIconAnim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.splash_anim);
        splashIcon.startAnimation(splashIconAnim);


    }

    private void initViews() {
        splashIcon=findViewById(R.id.splashIcon);
    }
    private boolean permissionGranted() {
        int check=0;
        int result= ActivityCompat.checkSelfPermission(SplashActivty.this,READ_EXTERNAL_STORAGE);
        if(result== PackageManager.PERMISSION_GRANTED){
            check++;
        }
        int result1=ActivityCompat.checkSelfPermission(SplashActivty.this,WRITE_EXTERNAL_STORAGE);
        if(result==PackageManager.PERMISSION_GRANTED){
            check++;
        }
        return check==2;
    }
}