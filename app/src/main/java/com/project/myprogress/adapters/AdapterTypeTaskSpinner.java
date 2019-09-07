package com.project.myprogress.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.myprogress.R;
import com.project.myprogress.modelclass.TypeTask;

import java.util.ArrayList;

public class AdapterTypeTaskSpinner extends ArrayAdapter<TypeTask> {


    private LayoutInflater layoutInflater;
    private ArrayList<TypeTask> typeTaskModels;


    public AdapterTypeTaskSpinner(Context context) {



       super(context,0, TypeTask.values());

    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        @SuppressLint("ViewHolder")
        View view = LayoutInflater.from(getContext()).inflate(R.layout.one_item_spiner_type,parent,false);
                //layoutInflater.inflate(R.layout.one_item_spiner_type, parent, false);

        //TypeTask typeTaskModel = (TypeTask) getItem(position);

        TextView name_type = (TextView) view.findViewById(R.id.name_type);
        name_type.setText(getItem(position).getName());

        ImageView icon_type = (ImageView) view.findViewById(R.id.icon_type);
        icon_type.setImageResource(getItem(position).getIcon());


        return view;
    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        @SuppressLint("ViewHolder")
        View view = LayoutInflater.from(getContext()).inflate(R.layout.one_item_spiner_type,parent,false);
        //layoutInflater.inflate(R.layout.one_item_spiner_type, parent, false);

        //TypeTask typeTaskModel = (TypeTask) getItem(position);

        TextView name_type = (TextView) view.findViewById(R.id.name_type);
        name_type.setText(getItem(position).getName());

        ImageView icon_type = (ImageView) view.findViewById(R.id.icon_type);
        icon_type.setImageResource(getItem(position).getIcon());

        return view;

    }
}
