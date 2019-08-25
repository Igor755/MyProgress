package com.project.myprogress.fragments_user;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.myprogress.R;
import com.project.myprogress.adapters.AdapterProgress;
import com.project.myprogress.interfaces.OnItemClickListener;
import com.project.myprogress.modelclass.ProgressModel;

import java.util.ArrayList;
import java.util.List;


public class UserInfoFragment extends Fragment {

    private AdapterProgress adapterProgress;
    private List<ProgressModel> listItems;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.user_info_fragment, container, false);


        ArrayList<ProgressModel> progressmodel = new ArrayList<>();


       for (int i = 0; i <= 10; i++){

            ProgressModel progressModel = new ProgressModel();
            progressModel.setBalls_progress("102890");
            progressModel.setName_progress("Intelligence");
            progressmodel.add(i,progressModel);


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




        return v;
    }


}
