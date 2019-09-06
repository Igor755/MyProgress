package com.project.myprogress.modelclass;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "type_task_table")
public class TypeTask {

    @PrimaryKey
    private String id_type_task;
    private String name;
    private int icon;

    private String id_task;

    public TypeTask(String id_type_task, String name, int icon, String id_task) {
        this.id_type_task = id_type_task;
        this.name = name;
        this.icon = icon;
        this.id_task = id_task;
    }

    public String getId_type_task() {
        return id_type_task;
    }

    public void setId_type_task(String id_type_task) {
        this.id_type_task = id_type_task;
    }

    public String getId_task() {
        return id_task;
    }

    public void setId_task(String id_task) {
        this.id_task = id_task;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
