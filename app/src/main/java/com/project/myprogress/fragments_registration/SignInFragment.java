package com.project.myprogress.fragments_registration;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.project.myprogress.AuthActivity;
import com.project.myprogress.ProfileActivity;
import com.project.myprogress.R;

import static com.project.myprogress.AuthActivity.MyFragmets.REGISTRATION_FRAGMENT;


public class SignInFragment extends Fragment {

    public TextView btnRegister;
    public Button btnSignIn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_sign_in, container, false);


        btnRegister = (TextView) v.findViewById(R.id.btn_registration);
        btnSignIn = (Button) v.findViewById(R.id.btn_sign_in);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getActivity() instanceof AuthActivity) {
                    ((AuthActivity) getActivity()).VisibleFragmentAuthActivity(REGISTRATION_FRAGMENT);
                }
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }


}