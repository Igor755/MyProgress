package com.project.myprogress.fragments_registration;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.myprogress.R;


public class ForgotPasswordFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_forgot_password, container, false);
    }

    public static Fragment newInstance()
    {
        ForgotPasswordFragment myFragment = new ForgotPasswordFragment();
        return myFragment;
    }

}


