package com.project.myprogress.modelclass;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users_table")
public class Users {

    @PrimaryKey
    private String id_user;

    private String name;
    private String last_name;
    private String email;
    private String url_image;

    private String id_sphere;

    public Users(String id_user, String name, String last_name, String email, String url_image, String id_sphere) {
        this.id_user = id_user;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.url_image = url_image;
        this.id_sphere = id_sphere;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl_image() {
        return url_image;
    }

    public void setUrl_image(String url_image) {
        this.url_image = url_image;
    }

    public String getId_sphere() {
        return id_sphere;
    }

    public void setId_sphere(String id_sphere) {
        this.id_sphere = id_sphere;
    }
}
