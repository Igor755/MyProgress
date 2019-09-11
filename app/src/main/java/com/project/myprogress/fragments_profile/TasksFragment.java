package com.project.myprogress.fragments_profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.project.myprogress.R;
import com.project.myprogress.adapters.AdapterTask;
import com.project.myprogress.fragments_detail.DetailTaskFragment;
import com.project.myprogress.modelclass.Task;
import com.project.myprogress.viewmodel.TaskViewModel;

import java.util.ArrayList;
import java.util.List;


public class TasksFragment extends Fragment {


    private AdapterTask adapterTask;
    ArrayList<Task> taskmodel_array = new ArrayList<>();
    private TaskViewModel taskViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        int page;
        String title;

        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");

      /*  if (page ==0){

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

    }*/
    }

    public static TasksFragment newInstance(int page, String title) {
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

        View v = inflater.inflate(R.layout.fragment_task, container, false);


        RecyclerView recyclerView = v.findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        final AdapterTask adapterTask = new AdapterTask();
        recyclerView.setAdapter(adapterTask);


        taskViewModel = ViewModelProviders.of(this).get(TaskViewModel.class);
        taskViewModel.getAllTask().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(List<Task> tasks) {

                //update RecyclerVIew
                adapterTask.setTasks(tasks);
                System.out.println("dwdw");

            }
        });

        adapterTask.setOnItemClickListener(new AdapterTask.OnItemClickListener() {
            @Override
            public void onItemClick(Task task) {

                System.out.println(task);


                DetailTaskFragment dialog_fragment = DetailTaskFragment.newInstance(task);



                Bundle bundle = new Bundle();
                bundle.putSerializable("task_click", task);
                dialog_fragment.setArguments(bundle);

                dialog_fragment.setTargetFragment(TasksFragment.this, 2);
                dialog_fragment.show(getFragmentManager(), "DetailTaskFragment");

            }
        });



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

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            Bundle bundle = data.getExtras();


            String id_task = data.getStringExtra("id_task");
            int type = data.getIntExtra("type", 0);
            String name = data.getStringExtra("name");
            String description = data.getStringExtra("description");
            String date_end = data.getStringExtra("date_end");
            String date_create = data.getStringExtra("date_create");
            int state = data.getIntExtra("state", 1);
            String sphere = data.getStringExtra("sphere_name");


            Task task = new Task(id_task, type, name, description, date_create, date_end, state, sphere);

            taskViewModel.insert(task);


        }
    }
}

