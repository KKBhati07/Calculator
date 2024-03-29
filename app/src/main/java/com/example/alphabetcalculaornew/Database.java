package com.example.alphabetcalculaornew;

//importing required libraries
import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = ValuesDB.class,exportSchema = false,version = 1)

//Setting up database Using ROOM database
public abstract class Database extends RoomDatabase {

//    declaring database name
    private static final String DB_NAME="databaseVal";
    private static Database instance;
    public static synchronized Database getDB(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context,Database.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries().build();
        }
        return instance;
    }
    public abstract ValuesDAO valuesDAO();
}
