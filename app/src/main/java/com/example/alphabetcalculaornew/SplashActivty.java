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

//    getting the views
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
//                checking for storage permissions
                if(permissionGranted()){
                    Intent toMainActivityIntent=new Intent(getApplicationContext(),MainActivity.class);
//                    redirecting to main activity
                    startActivity(toMainActivityIntent);
                    //removing current activity from the stack
                    finish();
                }else{
                    Intent toPermissionActivityIntent=new Intent(getApplicationContext(),PermissionActivity.class);
//                    redirecting to permission activity
                    startActivity(toPermissionActivityIntent);
                    //removing current activity from the stack
                    finish();
                }

            }
        },1200);
        //displaying the animation
        splashIconAnim=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.splash_anim);
        splashIcon.startAnimation(splashIconAnim);


    }
    //initializing the views
    private void initViews() {
        splashIcon=findViewById(R.id.splashIcon);
    }

    //method to check permissions are granted or not
    private boolean permissionGranted() {
        boolean readPermission=false, writePermission=false;

        //FOR READ PERMISSION
        int getReadPermission= ActivityCompat.checkSelfPermission(SplashActivty.this,READ_EXTERNAL_STORAGE);
        if(getReadPermission== PackageManager.PERMISSION_GRANTED) readPermission=true;

        //FOR WRITE PERMISSION
        int getWritePermission=ActivityCompat.checkSelfPermission(SplashActivty.this,WRITE_EXTERNAL_STORAGE);
        if(getWritePermission==PackageManager.PERMISSION_GRANTED) writePermission=true;

        return readPermission && writePermission;
    }
}