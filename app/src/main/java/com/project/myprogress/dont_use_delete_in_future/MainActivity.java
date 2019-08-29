package com.project.myprogress.dont_use_delete_in_future;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.project.myprogress.R;
import com.project.myprogress.adapters.AdapterProfilePager;
import com.project.myprogress.fragments_profile.AddProgressFragment;
import com.project.myprogress.fragments_profile.AddTaskFragment;
import com.project.myprogress.fragments_profile.TasksFragment;
import com.project.myprogress.fragments_profile.ProfileFragment;

public class MainActivity extends AppCompatActivity {

   /* public enum MyFragmets {USER_INFO_FRAGMENT, ADD_PROGRESS_FRAGMENT, TASK_FRAGMENT, ADD_TASK_FRAGMENT}

    public Fragment user_info_fragment, add_progress_fragment, task_fragment, add_task_fragment;

    AdapterProfilePager userFragmentPagerAdapter;

    TabItem profile, tasks;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        user_info_fragment = new ProfileFragment();
        add_progress_fragment = new AddProgressFragment();
        task_fragment = new TasksFragment();
        add_task_fragment = new AddTaskFragment();

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.fragment_container_main, user_info_fragment)
                .commit();

*//*
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);

        userFragmentPagerAdapter = new AdapterProfilePager(getSupportFragmentManager(),1);
        viewPager.setAdapter(userFragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);*//*




    }


    public void VisibleFragmentMainActivity(MyFragmets visiblefragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();


        switch (visiblefragment) {
            case USER_INFO_FRAGMENT:
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_main, user_info_fragment)
                        .commit();
                break;
            case ADD_PROGRESS_FRAGMENT:
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_main, add_progress_fragment)
                        .commit();
                break;
            case TASK_FRAGMENT:
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_main, task_fragment)
                        .commit();
                break;
            case ADD_TASK_FRAGMENT:
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_main, add_task_fragment)
                        .commit();
                break;
        }


    }*/
    }

