package com.project.myprogress.fragments_detail;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.project.myprogress.R;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class DetailTaskFragment extends DialogFragment {


    private TextView actionOk, actionCancel;
    private ImageButton completeBtn,failBtn;
    boolean flagCompleteBtn = true;
    boolean flagFailBtn = true;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =  inflater.inflate(R.layout.fragment_dialog_detail_task, container, false);


        actionOk = v.findViewById(R.id.ok);
        actionCancel = v.findViewById(R.id.cancel);
        completeBtn = v.findViewById(R.id.complete);
        failBtn = v.findViewById(R.id.fail);


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
