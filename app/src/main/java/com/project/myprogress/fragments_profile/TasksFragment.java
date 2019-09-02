package com.project.myprogress.fragments_profile;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.project.myprogress.R;
import com.project.myprogress.adapters.AdapterTask;
import com.project.myprogress.interfaces.OnItemClickListener;
import com.project.myprogress.modelclass.Task;

import java.util.ArrayList;


public class TasksFragment extends Fragment {


    private AdapterTask adapterTask;
    private ImageButton fab;

    static ArrayList<Task> taskmodel_array = new ArrayList<>();




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_task, container, false);


        fab = (ImageButton) v.findViewById(R.id.fab);


        for (int f = 0; f <= 2; f++) {

            Task new_taskModel = new Task();
            new_taskModel.setName("Big_exercise");
            new_taskModel.setDate_create("21.05.1990");
            new_taskModel.setDescription("Every day in elementary school in America begins at 9.20 a.m. " +
                    "Children have classes till 3.15 p.m. At 12 o’clock children have lunch.");
            taskmodel_array.add(f, new_taskModel);
        }


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


    }

