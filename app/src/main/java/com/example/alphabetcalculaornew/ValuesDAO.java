package com.example.alphabetcalculaornew;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ValuesDAO {
    @Query("select `values` from data where id=1")
    String getValue();

    @Insert
    void addValue(ValuesDB valuesDB);

    @Update
    void updateValue(ValuesDB valuesDB);

    @Delete
    void deleteValue(ValuesDB valuesDB);
}
