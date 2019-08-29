package com.project.myprogress.fragments_profile;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.myprogress.R;

public class DetailTaskFragment extends DialogFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v =  inflater.inflate(R.layout.fragment_dialog_detail_task, container, false);

        return v;
    }


}
