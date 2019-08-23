package com.project.myprogress;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.project.myprogress.fragments_registration.RegistrationFragment;
import com.project.myprogress.fragments_registration.SignInFragment;

public class AuthActivity extends AppCompatActivity {


    public enum MyFragmets {SIGN_IN_FRAGMENT, REGISTRATION_FRAGMENT}

    public Fragment sign_in_fragment, registration_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auth_activity);


        sign_in_fragment = new SignInFragment();
        registration_fragment = new RegistrationFragment();

        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.fragment_container_auth, sign_in_fragment)
                .commit();

    }
    public void VisibleFragment(MyFragmets visiblefragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();


        switch (visiblefragment) {
            case SIGN_IN_FRAGMENT:
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_auth, sign_in_fragment)
                        .commit();
                break;
            case REGISTRATION_FRAGMENT:
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container_auth, registration_fragment)
                        .commit();
                break;
        }


    }
}
