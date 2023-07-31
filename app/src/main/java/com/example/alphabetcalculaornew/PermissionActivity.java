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


//ACTIVITY PAGE TO GET STORAGE PERMISSION OF THE DEVICE FROM USER
public class PermissionActivity extends AppCompatActivity {
    //declaring request code
    private static final int REQ_CODE=100;
    Intent main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setting up the layout
        setContentView(R.layout.activity_permission);
        main=new Intent(PermissionActivity.this,MainActivity.class);

        //if the permission is granted
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
                    Database database=Database.getDB(this);
                    database.valuesDAO().addValue(new ValuesDB("0"));
//                    redirecting to the main activity of the app
                    startActivity(main);
                }else{
                    //notifying the user with Toast
                    Toast.makeText(this, "Permission Denied, SHUTTING DOWN!", Toast.LENGTH_LONG).show();
                    Handler handler=new Handler();
                    //exiting the app after 5secs
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
//        calling the super function
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    //method to check the permission is granted or not
    private boolean permissionGranted() {
        //variable to check for each permission
        boolean readPermission=false, writePermission=false;

        //FOR READ PERMISSION
        int getReadPermission=ActivityCompat.checkSelfPermission(PermissionActivity.this,READ_EXTERNAL_STORAGE);
        if(getReadPermission== PackageManager.PERMISSION_GRANTED) readPermission=true;

        //FOR WRITE PERMISSION
        int getWritePermission=ActivityCompat.checkSelfPermission(PermissionActivity.this,WRITE_EXTERNAL_STORAGE);
        if(getWritePermission==PackageManager.PERMISSION_GRANTED) writePermission=true;

        return readPermission && writePermission;
    }
}