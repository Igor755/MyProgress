package com.project.myprogress.modelclass;

import android.graphics.drawable.Icon;
import android.media.Image;

public class Task {

    private Icon type;
    private String name;
    private String description;
    private String date_end;
    private String select_progress;
    private String date_create;

    public Task() {

    }

    public Task(Icon type, String name, String description, String date_end, String select_progress, String date_create) {
        this.type = type;
        this.name = name;
        this.description = description;
        this.date_end = date_end;
        this.select_progress = select_progress;
        this.date_create = date_create;
    }

    public Icon getType() {
        return type;
    }

    public void setType(Icon type) {
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
        return select_progress;
    }

    public void setSelect_progress(String select_progress) {
        this.select_progress = select_progress;
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
                ", select_progress='" + select_progress + '\'' +
                ", date_create='" + date_create + '\'' +
                '}';
    }
}
