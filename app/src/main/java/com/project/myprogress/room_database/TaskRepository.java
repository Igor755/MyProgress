package com.project.myprogress.room_database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.project.myprogress.modelclass.Task;

import java.util.List;

public class TaskRepository {

    private TaskDao taskDao;
    private LiveData<List<Task>> allTask;


    public TaskRepository(Application aplication){

        TaskDatabase database = TaskDatabase.getInstance(aplication);
        taskDao = database.taskDao();
        allTask = taskDao.getAllTask();

    }
    public void insert (Task task) {
        new InsertTaskAsyncTask(taskDao).execute(task);

    }

    public void update (Task task){

        new UpdateTaskAsyncTask(taskDao).execute(task);

    }
    public void delete (Task task){

        new DeleteTaskAsyncTask(taskDao).execute(task);

    }
    public LiveData<List<Task>> getAllTask(){
        return allTask;
    }

    private static class InsertTaskAsyncTask extends AsyncTask<Task, Void, Void>{

        private TaskDao taskDao;

        private InsertTaskAsyncTask(TaskDao taskDao){
            this.taskDao = taskDao;
        }

        @Override
        protected Void doInBackground(Task... tasks) {

            taskDao.insert(tasks[0]);

            return null;
        }
    }
    private static class UpdateTaskAsyncTask extends AsyncTask<Task, Void, Void>{

        private TaskDao taskDao;

        private UpdateTaskAsyncTask(TaskDao taskDao){
            this.taskDao = taskDao;
        }

        @Override
        protected Void doInBackground(Task... tasks) {

            taskDao.update(tasks[0]);

            return null;
        }
    }
    private static class DeleteTaskAsyncTask extends AsyncTask<Task, Void, Void>{

        private TaskDao taskDao;

        private DeleteTaskAsyncTask(TaskDao taskDao){
            this.taskDao = taskDao;
        }

        @Override
        protected Void doInBackground(Task... tasks) {

            taskDao.delete(tasks[0]);

            return null;
        }
    }
}
