package com.project.myprogress.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.project.myprogress.modelclass.Sphere;

import java.util.List;

@Dao
public interface SphereDao {

    @Insert
    void insert (Sphere sphere);

    @Update
    void update (Sphere sphere);

    @Delete
    void delete (Sphere sphere);

    @Query("DELETE FROM sphere_table WHERE id_sphere = 'id_sphere'")
    LiveData<List<Sphere>> deleteSphere();


}
