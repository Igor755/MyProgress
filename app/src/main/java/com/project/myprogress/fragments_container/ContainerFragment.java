package com.project.myprogress.fragments_container;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.project.myprogress.R;
import com.project.myprogress.adapters.AdapterProfilePager;


public class ContainerFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_container, container, false);



        ViewPager viewPager = (ViewPager) v.findViewById(R.id.viewpager);

        AdapterProfilePager adapter = new AdapterProfilePager(getChildFragmentManager(), 1,getContext());

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) v.findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);





        return v;
    }

}