package com.example.alphabetcalculaornew;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class PermissionActivity extends AppCompatActivity {
    private static final int REQ_CODE=100;
    Intent main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission);
        main=new Intent(PermissionActivity.this,MainActivity.class);

        if(permissionGranted()){
            startActivity(main);
        }else{
            ActivityCompat.requestPermissions(PermissionActivity.this,new String[]{READ_EXTERNAL_STORAGE,WRITE_EXTERNAL_STORAGE},REQ_CODE);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode==REQ_CODE){
            if(grantResults.length>0){
                int readPermission=grantResults[0];
                int writePermission=grantResults[1];
                boolean checkRead=readPermission==PackageManager.PERMISSION_GRANTED;
                boolean checkWrite=writePermission==PackageManager.PERMISSION_GRANTED;
                if(checkRead&&checkWrite){
                    startActivity(main);
                }else{
                    Toast.makeText(this, "Permission Denied, SHUTTING DOWN!", Toast.LENGTH_LONG).show();
                    Handler handler=new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            android.os.Process.killProcess(android.os.Process.myPid());
                            System.exit(0);
                        }
                    },5000);
                }
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private boolean permissionGranted() {
        int check=0;
        int result=ActivityCompat.checkSelfPermission(PermissionActivity.this,READ_EXTERNAL_STORAGE);
        if(result== PackageManager.PERMISSION_GRANTED){
            check++;
        }
        int result1=ActivityCompat.checkSelfPermission(PermissionActivity.this,WRITE_EXTERNAL_STORAGE);
        if(result==PackageManager.PERMISSION_GRANTED){
            check++;
        }
        return check==2;
    }
}