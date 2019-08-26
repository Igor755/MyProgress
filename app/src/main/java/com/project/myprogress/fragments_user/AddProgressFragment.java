package com.project.myprogress.fragments_user;


import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.project.myprogress.R;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class AddProgressFragment extends DialogFragment {

    private EditText nameProgress;
    private TextView actionOk, actionCancel;

    public interface OnInputSelected{
        void sendInput(String input);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         View v = inflater.inflate(R.layout.add_progress_fragment, container, false);


        actionOk = v.findViewById(R.id.ok);
        actionCancel = v.findViewById(R.id.cancel);
        nameProgress = v.findViewById(R.id.edit_text_name);

        actionOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        actionCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: closing dialog");
                getDialog().dismiss();
            }
        });
        return v;
    }

}
