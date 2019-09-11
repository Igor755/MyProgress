package com.project.myprogress.room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.project.myprogress.dao.TaskDao;
import com.project.myprogress.modelclass.Task;

@Database(entities = {Task.class}, version = 2, exportSchema = false)

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

            System.out.println("ppop");
          //  taskDao.insert(new Task("kkk", TypeTask.Type1.getIcon(),"kjkj","jijii","jiji","jjjj",123,"jiji"));
            return null;
        }
    }

}
