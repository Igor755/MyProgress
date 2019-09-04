package com.project.myprogress.fragments_profile;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    ArrayList<Task> taskmodel_array = new ArrayList<>();
    private String title;
    private int page;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");

        if (page ==0){

            for (int f = 0; f <= 2; f++) {

                Task new_taskModel = new Task();
                new_taskModel.setName("Big_exercise");
                new_taskModel.setDate_create("21.05.1990");
                new_taskModel.setDescription("Every day in elementary school in America begins at 9.20 a.m. " +
                        "Children have classes till 3.15 p.m. At 12 o’clock children have lunch.");
                taskmodel_array.add(f, new_taskModel);
            }

        }else if(page==1){

            for (int f = 0; f <= 5; f++) {

                Task new_taskModel = new Task();
                new_taskModel.setName("Big_exercise");
                new_taskModel.setDate_create("21.05.1990");
                new_taskModel.setDescription("Every day in elementary school in America begins at 9.20 a.m. " +
                        "Children have classes till 3.15 p.m. At 12 o’clock children have lunch.");
                taskmodel_array.add(f, new_taskModel);
            }

        }else{
            for (int f = 0; f <= 1; f++) {

                Task new_taskModel = new Task();
                new_taskModel.setName("Big_exercise");
                new_taskModel.setDate_create("21.05.1990");
                new_taskModel.setDescription("Every day in elementary school in America begins at 9.20 a.m. " +
                        "Children have classes till 3.15 p.m. At 12 o’clock children have lunch.");
                taskmodel_array.add(f, new_taskModel);

        }

    }
    }

    public static TasksFragment newInstance(int page, String title)
    {
        TasksFragment fragmentFirst = new TasksFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_task, container, false);


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

            return v;
        }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_exercize_fragment, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.add_exersize_menu:

                AddTaskFragment dialog_fragment = new AddTaskFragment();
                dialog_fragment.setTargetFragment(TasksFragment.this, 1);
                dialog_fragment.show(getFragmentManager(), "AddProgressFragment");

                return false;
           /* case R.id.action_settings:

                // Do Fragment menu item stuff here
                return true;*/

            default:
                break;
        }

        return false;
    }



    }

