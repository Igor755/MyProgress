package com.project.myprogress.room_database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.project.myprogress.modelclass.Sphere;
import com.project.myprogress.modelclass.Task;
import com.project.myprogress.modelclass.TypeTask;
import com.project.myprogress.modelclass.Users;

@Database(entities = {Users.class, Task.class, Sphere.class, TypeTask.class}, version = 1, exportSchema = false)

public abstract class ProgressDatabase extends RoomDatabase {

    public abstract UsersDao usersDao();
    public abstract SphereDao sphereDao();
    public abstract TaskDao taskDao();

}
