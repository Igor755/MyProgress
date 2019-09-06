package com.project.myprogress.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.myprogress.R;
import com.project.myprogress.modelclass.TypeTask;

import java.util.ArrayList;

public class AdapterTypeTaskSpinner extends BaseAdapter {


  /*  public enum TypeTask {

        Icon_1("цель", R.drawable.icon_type_goal_1),
        Icon_2("2", R.drawable.icon_type_sub_goal_2),
        Icon_3(3, R.drawable.icon_type_3);

        private String value;
        private int image;

        private TypeTask(String value, int drawableId) {
            this.value = value;
            this.image = drawableId;
        }

        public int getImage() {
            return image;
        }

        ///coinView.setImageResource(coinArray[x].getImage());

    }*/


    private LayoutInflater layoutInflater;
    private ArrayList<TypeTask> typeTaskModels;

    public AdapterTypeTaskSpinner(Context context, ArrayList<TypeTask> typeTaskModels) {

        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.typeTaskModels = typeTaskModels;


    }

    @Override
    public int getCount() {
        return typeTaskModels.size();
    }

    @Override
    public Object getItem(int position) {

        return typeTaskModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = layoutInflater.inflate(R.layout.one_item_spiner_type, parent, false);

        TypeTask typeTaskModel = (TypeTask) getItem(position);

        TextView name_type = (TextView) view.findViewById(R.id.name_type);
        name_type.setText(typeTaskModel.getName());

        ImageView icon_type = (ImageView) view.findViewById(R.id.icon_type);
        icon_type.setImageResource(typeTaskModel.getIcon());


        return view;
    }
}
