package com.project.myprogress.fragments_profile;

import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerTitleStrip;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.project.myprogress.R;
import com.project.myprogress.adapters.AdapterProfilePager;
import com.project.myprogress.adapters.AdapterTask;
import com.project.myprogress.interfaces.OnItemClickListener;
import com.project.myprogress.modelclass.Task;

import java.util.ArrayList;


public class TasksFragment extends Fragment {


    private AdapterTask adapterTask;
    private ImageButton fab;

    AdapterProfilePager userFragmentPagerAdapter;

    TabItem profile, tasks;
    TabLayout tabLayout;

    public static final String CAT_NAMES = "cats_names";


    public TasksFragment(){

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_task, container, false);


        fab = (ImageButton) v.findViewById(R.id.fab);

        ArrayList<Task> taskmodel_array = new ArrayList<>();


        for (int i = 0; i <= 10; i++) {

            Task new_taskModel = new Task();
            new_taskModel.setName("Big_exercise");
            new_taskModel.setDate_create("21.05.1990");
            taskmodel_array.add(i, new_taskModel);


        }

        Bundle arguments = getArguments();
        if (arguments != null) {

            displayValues(v, taskmodel_array);
        }

       ViewPager viewPager = (ViewPager) v.findViewById(R.id.viewpager);
       // tabLayout = (TabLayout) v.findViewById(R.id.sliding_tabs);

       /* userFragmentPagerAdapter = new AdapterProfilePager(getFragmentManager(),1,getContext());
        viewPager.setAdapter(userFragmentPagerAdapter);*/
        //tabLayout.setupWithViewPager(viewPager);



        RecyclerView recyclerView = v.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterTask = new AdapterTask(taskmodel_array, getContext(), new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                DetailTaskFragment dialog_fragment = new DetailTaskFragment();
                dialog_fragment.setTargetFragment(TasksFragment.this, 1);
                dialog_fragment.show(getFragmentManager(), "DetailTaskFragment");


            }
        });

        recyclerView.setAdapter(adapterTask);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddTaskFragment dialog_fragment = new AddTaskFragment();
                dialog_fragment.setTargetFragment(TasksFragment.this, 1);
                dialog_fragment.show(getFragmentManager(), "AddProgressFragment");



                }



        });


        return v;
    }
    private void displayValues(View v, ArrayList<Task> taskmodel_array2) {




        RecyclerView recyclerView = v.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterTask = new AdapterTask(taskmodel_array2, getContext(), new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                DetailTaskFragment dialog_fragment = new DetailTaskFragment();
                dialog_fragment.setTargetFragment(TasksFragment.this, 1);
                dialog_fragment.show(getFragmentManager(), "DetailTaskFragment");


            }
        });
        recyclerView.setAdapter(adapterTask);

    }

}

