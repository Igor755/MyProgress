package com.project.myprogress.fragments_detail;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.project.myprogress.R;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class DetailProgressFragment extends DialogFragment {

    private TextView actionOk;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =  inflater.inflate(R.layout.fragment_dialog_detail_progress, container, false);


        actionOk = v.findViewById(R.id.ok);


        actionOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: closing dialog");
                getDialog().dismiss();

            }
        });




        return v;
    }


}


