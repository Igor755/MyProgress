package com.project.myprogress.modelclass;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "sphere_table")
public class Sphere {


    @PrimaryKey
    private String id_sphere;
    private String name_progress;
    private String point;

    public Sphere() {
    }

    public Sphere(String id_sphere, String name_progress, String point) {
        this.id_sphere = id_sphere;
        this.name_progress = name_progress;
        this.point = point;
    }

    public String getId_sphere() {
        return id_sphere;
    }

    public void setId_sphere(String id_sphere) {
        this.id_sphere = id_sphere;
    }

    public String getName_progress() {
        return name_progress;
    }

    public void setName_progress(String name_progress) {
        this.name_progress = name_progress;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }
}
