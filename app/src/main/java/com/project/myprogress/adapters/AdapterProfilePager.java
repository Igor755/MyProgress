package com.project.myprogress.adapters;


import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


import com.project.myprogress.R;
import com.project.myprogress.fragments_profile.TasksFragment;
import com.project.myprogress.fragments_profile.ProfileFragment;
import com.project.myprogress.modelclass.Task;


public class AdapterProfilePager extends FragmentPagerAdapter {

    private String[] mCatNames;




    public AdapterProfilePager(@NonNull FragmentManager fm, int behavior, Context context) {
        super(fm, behavior);


        Resources resources = context.getResources();
        mCatNames = resources.getStringArray(R.array.TaskTitles);
    }

    @Override
    public Fragment getItem(int position) {

        Bundle arguments = new Bundle();
        arguments.putString(TasksFragment.CAT_NAMES, mCatNames[position]);


        TasksFragment catsFragment = new TasksFragment();
        catsFragment.setArguments(arguments);

        return catsFragment;


    }

    @Override
    public int getCount() {
        return mCatNames.length;
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mCatNames[position];
    }



}
