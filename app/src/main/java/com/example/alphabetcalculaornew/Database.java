package com.example.alphabetcalculaornew;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private static final String DB_NAME="previous_values";
    private static final int DB_VERSION=1;
    private static final String TABLE_NAME="value";
    private static final String VALUE_DATA="entry";
    private static final String PRIMARY_KEY="id";

    public Database(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table " +TABLE_NAME+"("+PRIMARY_KEY+" INTEGER PRIMARY KEY AUTOINCREMENT,"+VALUE_DATA+" VARCHAR(50))");
        ContentValues cv=new ContentValues();
        cv.put(VALUE_DATA,"0");
        db.insert(TABLE_NAME,null,cv);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);//WHILE UPGRADING THE DATABASE
        onCreate(db);

    }
    public void updateValues(int id,String val){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(VALUE_DATA,val);
        db.update(TABLE_NAME,cv,PRIMARY_KEY+" = "+id,null);
    }
    public String fetchValues(){
        SQLiteDatabase db=this.getReadableDatabase();
        String s="99";
        Cursor cursor=db.rawQuery("select * from "+TABLE_NAME,null);
//        s=cursor.getString(1);
        while (cursor.moveToNext()){
            int i=cursor.getInt(0);
            s=cursor.getString(1);
        }
        return s;
    }
}
