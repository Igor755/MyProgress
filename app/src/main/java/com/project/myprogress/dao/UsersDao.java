package com.project.myprogress.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.project.myprogress.modelclass.Users;

@Dao
public interface UsersDao {

    @Insert
    void insert (Users user);

    @Update
    void update (Users user);

    @Delete
    void delete (Users user);



}
