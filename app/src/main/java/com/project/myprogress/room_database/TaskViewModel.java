package com.project.myprogress.room_database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.project.myprogress.modelclass.Task;

import java.util.List;

public class TaskViewModel extends AndroidViewModel {

    private TaskRepository taskRepository;
    private LiveData<List<Task>> allTask;


    public TaskViewModel(@NonNull Application application) {
        super(application);

        taskRepository = new TaskRepository(application);
        allTask = taskRepository.getAllTask();

    }

    public void insert(Task task){
        taskRepository.insert(task);
    }

    public void update(Task task){
        taskRepository.update(task);
    }
    public void delete(Task task){
        taskRepository.delete(task);
    }

    public LiveData<List<Task>> getAllTask() {
        return allTask;
    }
}
