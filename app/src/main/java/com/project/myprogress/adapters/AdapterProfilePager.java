package com.project.myprogress.adapters;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.project.myprogress.R;
import com.project.myprogress.fragments_profile.TasksFragment;


public class AdapterProfilePager extends FragmentPagerAdapter {

    private Context mContext;

    public AdapterProfilePager(@NonNull FragmentManager fm, int behavior, Context context) {
        super(fm, behavior);
        mContext = context;


    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            return new TasksFragment();
        } else if (position == 1) {
            return new TasksFragment();
        } else   {
            return new TasksFragment();

        }


    }

    @Override
    public int getCount() {
        return 3;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.all);
            case 1:
                return mContext.getString(R.string.process);
            case 2:
                return mContext.getString(R.string.complete);

            default:
                return null;
        }    }



}
