package com.project.myprogress.modelclass;

import android.graphics.drawable.Icon;
import android.media.Image;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.project.myprogress.R;

import java.util.Arrays;
import java.util.List;


@Entity(tableName = "task_table")
public class Task {

    @PrimaryKey
    private String id_task;
    private TypeTask type;
    private String name;
    private String description;
    private String date_end;
    private String date_create;
    private String state;


    private String id_sphere;

    public Task() {

    }

    public Task(String id_task, TypeTask type, String name, String description, String date_end, String date_create, String state, String id_sphere) {
        this.id_task = id_task;
        this.type = type;
        this.name = name;
        this.description = description;
        this.date_end = date_end;
        this.date_create = date_create;
        this.state = state;
        this.id_sphere = id_sphere;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
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

    public TypeTask getType() {
        return type;
    }

    public void setType(TypeTask type) {
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
