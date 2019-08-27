package com.project.myprogress.adapters;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.project.myprogress.fragments_profile.TaskFragment;
import com.project.myprogress.fragments_profile.ProfileFragment;



public class AdapterProfilePager extends FragmentPagerAdapter {


    public AdapterProfilePager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ProfileFragment userInfoFragment = new ProfileFragment();
                return userInfoFragment;
            case 1:
                TaskFragment taskFragment = new TaskFragment();
                return taskFragment;

        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Profile";
            case 1:
                return "Tasks";
        }
        return null;
    }

}
