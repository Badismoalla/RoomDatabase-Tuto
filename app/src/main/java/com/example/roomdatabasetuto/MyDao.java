package com.example.roomdatabasetuto;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao {
    @Insert
    public void addData(MyDatalist mydatalist);

    @Query("select * from mydatalist")
    public List<MyDatalist> getMyData();


    @Delete
    public void delete(MyDatalist mydatalist);

    @Update
    public void update(MyDatalist mydatalist);

}
