package com.project.myprogress.adapters;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;


import com.project.myprogress.fragments_user.TaskFragment;
import com.project.myprogress.fragments_user.UserInfoFragment;



public class UserFragmentPagerAdapter extends FragmentPagerAdapter {


    public UserFragmentPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                UserInfoFragment userInfoFragment = new UserInfoFragment();
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
