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

                /*if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).VisibleFragmentMainActivity(ADD_TASK_FRAGMENT);
                }*/

            }
        });


        return v;
    }

}
