package com.project.myprogress;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.project.myprogress.fragments_user.AddProgressFragment;
import com.project.myprogress.fragments_user.AddTaskFragment;
import com.project.myprogress.fragments_user.TaskFragment;
import com.project.myprogress.fragments_user.UserInfoFragment;

public class MainActivity extends AppCompatActivity {

    public enum MyFragmets {USER_INFO_FRAGMENT, ADD_PROGRESS_FRAGMENT, TASK_FRAGMENT, ADD_TASK_FRAGMENT}

    public Fragment user_info_fragment, add_progress_fragment, task_fragment, add_task_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        user_info_fragment = new UserInfoFragment();
        add_progress_fragment = new AddProgressFragment();
        task_fragment = new TaskFragment();
        add_task_fragment = new AddTaskFragment();

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.fragment_container_main, user_info_fragment)
                .commit();

    }
    public void VisibleFragmentMainActivity(MyFragmets visiblefragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();


        switch (visiblefragment) {
            case USER_INFO_FRAGMENT:
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_auth, user_info_fragment)
                        .commit();
                break;
            case ADD_PROGRESS_FRAGMENT:
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_auth, add_progress_fragment)
                        .commit();
                break;
            case TASK_FRAGMENT:
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_auth, task_fragment)
                        .commit();
                break;
            case ADD_TASK_FRAGMENT:
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_auth, add_task_fragment)
                        .commit();
                break;
        }


    }
    }

