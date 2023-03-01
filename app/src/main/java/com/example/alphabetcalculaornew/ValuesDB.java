package com.example.alphabetcalculaornew;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "data")
public class ValuesDB {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "values")
    private String value;

    public ValuesDB(int id,String value){
        //this is the main constructor
        //and will be user for updation, deletion and fetching
        this.id=id;
        this.value=value;
    }
    @Ignore
    public ValuesDB(String value){
//        this will be used for the insertion of data
        this.value=value;
    }

    //GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
