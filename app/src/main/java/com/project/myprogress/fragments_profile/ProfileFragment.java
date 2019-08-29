package com.project.myprogress.fragments_profile;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.project.myprogress.R;
import com.project.myprogress.adapters.AdapterProgress;
import com.project.myprogress.interfaces.OnItemClickListener;
import com.project.myprogress.modelclass.Progress;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class ProfileFragment extends Fragment implements AddProgressFragment.OnInputSelected {

    private AdapterProgress adapterProgress;
    private List<Progress> listItems;
    private ImageButton fab;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        fab = (ImageButton) v.findViewById(R.id.fab);


        ArrayList<Progress> progressmodel = new ArrayList<>();


        for (int i = 0; i <= 10; i++) {

            Progress progressModel = new Progress();
            progressModel.setBalls_progress("102890");
            progressModel.setName_progress("Intelligence");
            progressmodel.add(i, progressModel);


        }


        RecyclerView recyclerView = v.findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterProgress = new AdapterProgress(progressmodel, getContext(), new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });

        recyclerView.setAdapter(adapterProgress);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AddProgressFragment dialog = new AddProgressFragment();
                dialog.setTargetFragment(ProfileFragment.this, 1);
                dialog.show(getFragmentManager(), "AddProgressFragment");

               /* if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).VisibleFragmentMainActivity(ADD_PROGRESS_FRAGMENT);
                }*/
            }
        });


        return v;
    }


    @Override
    public void sendInput(String input) {
        Log.d(TAG, "sendInput: found incoming input: " + input);

    }
}
