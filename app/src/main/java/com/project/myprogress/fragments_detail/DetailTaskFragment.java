package com.project.myprogress.fragments_detail;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.myprogress.R;
import com.project.myprogress.modelclass.Task;
import com.project.myprogress.modelclass.TypeTask;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class DetailTaskFragment extends DialogFragment {


    private TextView actionOk, actionCancel;
    private ImageView completeBtn, failBtn;
    boolean flagCompleteBtn = true;
    boolean flagFailBtn = true;
    private Task task_from_tasks_fragment;

    private TextView type_task_name;
    private ImageView type_task_icon;
    private EditText edit_text_name;
    private EditText edit_text_description;
    private EditText edit_text_date_end;
    private EditText edit_text_progress;
    private EditText edit_text_date_create;



    public static DetailTaskFragment newInstance(Task task_from_tasks_fragment) {

        DetailTaskFragment detailTaskFragment = new DetailTaskFragment();
        Bundle args = new Bundle();
        args.getSerializable("task_click");
        detailTaskFragment.setArguments(args);
        return detailTaskFragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_dialog_detail_task, container, false);


        task_from_tasks_fragment = (Task) getArguments().getSerializable("task_click");

        actionOk = v.findViewById(R.id.ok);
        actionCancel = v.findViewById(R.id.cancel);
        failBtn = v.findViewById(R.id.fail);
        completeBtn = v.findViewById(R.id.state);

        type_task_name = v.findViewById(R.id.type_task_name);
        type_task_icon = v.findViewById(R.id.type_task_icon);
        edit_text_name = v.findViewById(R.id.edit_text_name);
        edit_text_description = v.findViewById(R.id.edit_text_description);
        edit_text_date_end = v.findViewById(R.id.edit_text_date_end);
        edit_text_progress = v.findViewById(R.id.edit_text_progress);
        edit_text_date_create = v.findViewById(R.id.edit_text_date_create);


        type_task_name.setText(TypeTask.getByName(task_from_tasks_fragment.getType()));
        type_task_icon.setImageResource(task_from_tasks_fragment.getType());
        edit_text_name.setText(task_from_tasks_fragment.getName());
        edit_text_description.setText(task_from_tasks_fragment.getDescription());
        edit_text_date_end.setText(task_from_tasks_fragment.getDate_end());
        edit_text_progress.setText(task_from_tasks_fragment.getId_sphere());
        edit_text_date_create.setText(task_from_tasks_fragment.getDate_create());

        if (task_from_tasks_fragment.getState() == R.drawable.galochka_green24)
            completeBtn.setImageResource(R.drawable.galochka_green40);
        else
            completeBtn.setImageResource(R.drawable.galochka_grey40);


        actionOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if ((completeBtn.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.galochka_grey40).getConstantState()) &&
                        (failBtn.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.krest_on_red40).getConstantState())) {

                    task_from_tasks_fragment.setState(R.drawable.white_on_red24);

                } else if ((completeBtn.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.galochka_green40).getConstantState()) &&
                        (failBtn.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.krest_grey_40).getConstantState())) {

                    task_from_tasks_fragment.setState(R.drawable.galochka_green24);

                } else if ((completeBtn.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.galochka_grey40).getConstantState()) &&
                        (failBtn.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.krest_grey_40).getConstantState())) {

                    task_from_tasks_fragment.setState(R.drawable.galochka_grey24);

                } else{
                    task_from_tasks_fragment.setState(R.drawable.galochka_grey24);
                }


                Intent intent = new Intent();

                intent.putExtra("id_task",task_from_tasks_fragment.getId_task());
                intent.putExtra("type",task_from_tasks_fragment.getType());
                intent.putExtra("name",task_from_tasks_fragment.getName());
                intent.putExtra("description",task_from_tasks_fragment.getDescription());
                intent.putExtra("date_end",task_from_tasks_fragment.getDate_end());
                intent.putExtra("date_create",task_from_tasks_fragment.getDate_create());
                intent.putExtra("state", task_from_tasks_fragment.getState());
                intent.putExtra("sphere_name",task_from_tasks_fragment.getId_sphere());



                getTargetFragment().onActivityResult(getTargetRequestCode(), 2, intent );
                dismiss();
            }
        });

        actionCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: closing dialog");
                getDialog().dismiss();
            }
        });

        completeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flagCompleteBtn)
                    completeBtn.setImageResource(R.drawable.galochka_grey40);
                else
                    completeBtn.setImageResource(R.drawable.galochka_green40);
                flagCompleteBtn = !flagCompleteBtn;

            }
        });

        failBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flagFailBtn)
                    failBtn.setImageResource(R.drawable.krest_on_red40);
                else
                    failBtn.setImageResource(R.drawable.krest_grey_40);
                completeBtn.setImageResource(R.drawable.galochka_grey40);
                flagFailBtn = !flagFailBtn;

            }
        });

        return v;
    }


}
