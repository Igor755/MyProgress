package com.project.myprogress;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.project.myprogress.adapters.UserFragmentPagerAdapter;
import com.project.myprogress.fragments_user.AddProgressFragment;
import com.project.myprogress.fragments_user.AddTaskFragment;
import com.project.myprogress.fragments_user.TaskFragment;
import com.project.myprogress.fragments_user.UserInfoFragment;

public class MainActivity extends AppCompatActivity {

    public enum MyFragmets {USER_INFO_FRAGMENT, ADD_PROGRESS_FRAGMENT, TASK_FRAGMENT, ADD_TASK_FRAGMENT}

    public Fragment user_info_fragment, add_progress_fragment, task_fragment, add_task_fragment;

    UserFragmentPagerAdapter userFragmentPagerAdapter;

    TabItem profile, tasks;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);


        user_info_fragment = new UserInfoFragment();
        add_progress_fragment = new AddProgressFragment();
        task_fragment = new TaskFragment();
        add_task_fragment = new AddTaskFragment();

       /* FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.fragment_container_main, user_info_fragment)
                .commit();
*/

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);

        userFragmentPagerAdapter = new UserFragmentPagerAdapter(getSupportFragmentManager(),1);
        viewPager.setAdapter(userFragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);




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


    }
    }

