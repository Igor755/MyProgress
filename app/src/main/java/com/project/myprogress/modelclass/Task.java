package com.project.myprogress.modelclass;


import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


@Entity(tableName = "task_table")
public class Task implements Serializable {

    @PrimaryKey
    @NonNull
    @SerializedName("id_task")
    @Expose
    private String id_task;

    //@TypeConverters(ProfileTypeConverter::class)
    @SerializedName("type")
    @Expose
    private int type;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("date_end")
    @Expose
    private String date_end;
    @SerializedName("date_create")
    @Expose
    private String date_create;
    @SerializedName("state")
    @Expose
    private int state;
    @SerializedName("id_sphere")
    @Expose
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

   /* protected Task(Parcel in) {
        id_task = in.readString();
        type = in.readInt();
        name = in.readString();
        description = in.readString();
        date_end = in.readString();
        date_create = in.readString();
        state = in.readInt();
        id_sphere = in.readString();
    }
*/
 /*   public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };*/

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

   /* @Override
    public int describeContents() {
        return 0;
    }*/

/*    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeInt(type);
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(date_end);
        dest.writeString(date_create);
        dest.writeInt(state);
        dest.writeString(id_sphere);

    }
    private void readFromParcel(Parcel in) {


        type = in.readInt();
        name = in.readString();
        description = in.readString();
        date_end = in.readString();
        date_create = in.readString();
        state = in.readInt();
        id_sphere = in.readString();
    }*/
}
