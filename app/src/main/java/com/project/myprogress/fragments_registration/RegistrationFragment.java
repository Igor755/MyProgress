package com.project.myprogress.fragments_registration;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.project.myprogress.R;



public class RegistrationFragment extends Fragment {

    public TextView btnRegister;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }
    public static Fragment newInstance()
    {
        RegistrationFragment myFragment = new RegistrationFragment();
        return myFragment;
    }


}