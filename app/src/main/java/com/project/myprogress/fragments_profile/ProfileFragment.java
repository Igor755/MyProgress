package com.project.myprogress.fragments_profile;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.project.myprogress.R;
import com.project.myprogress.adapters.AdapterProgress;
import com.project.myprogress.fragments_detail.DetailProgressFragment;
import com.project.myprogress.interfaces.OnItemClickListener;
import com.project.myprogress.modelclass.Progress;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;


public class ProfileFragment extends Fragment implements AddProgressFragment.OnInputSelected {

    private AdapterProgress adapterProgress;
    private List<Progress> listItems;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        ArrayList<Progress> progressmodel = new ArrayList<>();


        for (int i = 0; i <= 5; i++) {

            Progress progressModel = new Progress();
            progressModel.setBalls_progress("102890");
            progressModel.setName_progress("Intelligence");
            progressmodel.add(i, progressModel);


        }


        RecyclerView recyclerView = v.findViewById(R.id.recycler_view_progress);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterProgress = new AdapterProgress(progressmodel, getContext(), new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                DetailProgressFragment dialog_fragment = new DetailProgressFragment();
                dialog_fragment.setTargetFragment(ProfileFragment.this, 1);
                dialog_fragment.show(getFragmentManager(), "DetailTaskFragment");

            }
        });

        recyclerView.setAdapter(adapterProgress);

        return v;
    }


    @Override
    public void sendInput(String input) {
        Log.d(TAG, "sendInput: found incoming input: " + input);

    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.menu_profile_fragment, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.add_progress_menu:

                AddProgressFragment dialog = new AddProgressFragment();
                dialog.setTargetFragment(ProfileFragment.this, 1);
                dialog.show(getFragmentManager(), "AddProgressFragment");

                return false;

           /* case R.id.action_settings:

                // Do Fragment menu item stuff here
                return true;*/

            default:
                break;
        }

        return false;
    }
}
