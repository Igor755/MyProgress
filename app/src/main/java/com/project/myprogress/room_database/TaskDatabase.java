package com.project.myprogress.room_database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.project.myprogress.R;
import com.project.myprogress.modelclass.Sphere;
import com.project.myprogress.modelclass.Task;
import com.project.myprogress.modelclass.TypeTask;
import com.project.myprogress.modelclass.Users;

@Database(entities = {Task.class}, version = 1, exportSchema = false)

public abstract class TaskDatabase extends RoomDatabase {

    private static TaskDatabase instanse;

    public abstract TaskDao taskDao();

    public static synchronized TaskDatabase getInstance(Context context){
        if (instanse == null){
            instanse = Room.databaseBuilder(context.getApplicationContext(),
                    TaskDatabase.class, "task_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instanse;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase database){
            super.onCreate(database);
            new PopulateDbAsyncTask(instanse).execute();
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void , Void>{


        private TaskDao taskDao;

        private  PopulateDbAsyncTask(TaskDatabase taskDatabase){
            taskDao = taskDatabase.taskDao();
        }



        @Override
        protected Void doInBackground(Void... voids) {

           // taskDao.insert(new Task("kkk", TypeTask.Type1,"kjkj","jijii","jiji","jjjj","kkkk","jiji"));
            return null;
        }
    }

}
