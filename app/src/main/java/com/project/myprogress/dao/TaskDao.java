package com.project.myprogress.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.project.myprogress.modelclass.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Insert
    void insert (Task task);

    @Update
    void update (Task task);

    @Delete
    void delete (Task task);


    @Query("SELECT * FROM task_table")
    LiveData<List<Task>> getAllTask();

    @Query("SELECT * FROM task_table WHERE id_sphere=3")
    LiveData<List<Task>> getShere();

}
