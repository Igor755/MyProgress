package com.project.myprogress.modelclass;

import android.graphics.drawable.Icon;
import android.media.Image;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.project.myprogress.R;

import java.util.Arrays;
import java.util.List;


@Entity(tableName = "task_table")
public class Task {

    @PrimaryKey
    @NonNull
    private String id_task;

    //@TypeConverters(ProfileTypeConverter::class)
    private int type;
    private String name;
    private String description;
    private String date_end;
    private String date_create;
    private int state;
    private String id_sphere;

    public Task() {

    }


    @Ignore
    public Task(String id_task, int type, String name, String description, String date_end, String date_create, int state, String id_sphere) {
        this.id_task = id_task;
        this.type = type;
        this.name = name;
        this.description = description;
        this.date_end = date_end;
        this.date_create = date_create;
        this.state = state;
        this.id_sphere = id_sphere;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getId_task() {
        return id_task;
    }

    public void setId_task(String id_task) {
        this.id_task = id_task;
    }

    public String getId_sphere() {
        return id_sphere;
    }

    public void setId_sphere(String id_sphere) {
        this.id_sphere = id_sphere;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public String getSelect_progress() {
        return id_sphere;
    }

    public void setSelect_progress(String select_progress) {
        this.id_sphere = select_progress;
    }

    public String getDate_create() {
        return date_create;
    }

    public void setDate_create(String date_create) {
        this.date_create = date_create;
    }

    @Override
    public String toString() {
        return "Task{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date_end='" + date_end + '\'' +
                ", select_progress='" + id_sphere + '\'' +
                ", date_create='" + date_create + '\'' +
                '}';
    }
}
