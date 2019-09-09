package com.project.myprogress.fragments_profile;


import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.project.myprogress.R;
import com.project.myprogress.adapters.AdapterTypeTaskSpinner;
import com.project.myprogress.customview.MultiSelectionSpinner;
import com.project.myprogress.modelclass.TypeTask;
import com.project.myprogress.room_database.TaskViewModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;


//////////DIALOG FRAGMENT


public class AddTaskFragment extends DialogFragment implements MultiSelectionSpinner.OnMultipleItemsSelectedListener{

    private TextView actionOkButton, actionCancelButton;
    private TextView etmDisplayDate;
    private ImageButton addDateButton;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private TextView edit_text_name;
    private TextView edit_text_description;

    //multiselection_spinner_progress
    private TaskViewModel taskViewModel;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_dialog_add_task, container, false);

        actionOkButton = v.findViewById(R.id.ok);
        actionCancelButton = v.findViewById(R.id.cancel);
        addDateButton = v.findViewById(R.id.datePicker);

        etmDisplayDate = v.findViewById(R.id.tvDate);
        edit_text_name = v.findViewById(R.id.edit_text_name);
        edit_text_description = v.findViewById(R.id.edit_text_description);

        taskViewModel = ViewModelProviders.of(this).get(TaskViewModel.class);






        Spinner spinner_type = (Spinner) v.findViewById(R.id.spinner_type);
        AdapterTypeTaskSpinner adapterTypeTaskSpinner = new AdapterTypeTaskSpinner(getContext());
        spinner_type.setAdapter(adapterTypeTaskSpinner);



        String[] array = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        MultiSelectionSpinner multiSelectionSpinner = (MultiSelectionSpinner) v.findViewById(R.id.multiselection_spinner_progress);
        multiSelectionSpinner.setItems(array);
        multiSelectionSpinner.setSelection(new int[]{2, 6});
        multiSelectionSpinner.setListener(this);


        addDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog dialog = new DatePickerDialog(
                        getContext(),
                        R.style.Theme_MaterialComponents_Light_Dialog,/*AppCompatDialogStyle, */ /*AlertDialog.THEME_HOLO_DARK*/
                        mDateSetListener,
                        year, month, day);
                // dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.green(2)));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = day + "." + month + "." + year;
                etmDisplayDate.setText(date);
            }
        };


        actionOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        actionCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: closing dialog");
                getDialog().dismiss();
            }
        });


        return v;
    }

    @Override
    public void selectedIndices(List<Integer> indices) {

    }

    @Override
    public void selectedStrings(List<String> strings) {

    }
}
