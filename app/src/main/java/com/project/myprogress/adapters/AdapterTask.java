package com.project.myprogress.adapters;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.project.myprogress.R;
import com.project.myprogress.interfaces.OnItemClickListener;
import com.project.myprogress.modelclass.Task;

import java.util.List;

public class AdapterTask extends RecyclerView.Adapter<AdapterTask.ViewHolder> {

    private List<Task> listItems;
    public Context mContext;
    private OnItemClickListener itemClickListener;



    public AdapterTask(List<Task> listItems, Context mContext, OnItemClickListener itemClickListener) {
        this.itemClickListener =itemClickListener;
        this.listItems = listItems;
        this.mContext = mContext;
    }

    @Override
    public AdapterTask.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_item_recycler_task, parent, false);
        return new AdapterTask.ViewHolder(v);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        final Task itemList = listItems.get(position);



        holder.name_task.setText(itemList.getName());
        holder.date_create.setText(itemList.getDate_create());
        holder.description.setText(itemList.getDescription());



    }

    public void setTasks(List<Task> listItems){
        this.listItems = listItems;
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name_task;
        TextView date_create;
        TextView description;
        ImageView complete_task;
        ImageView icon_type;

        ViewHolder(View itemView) {
            super(itemView);

            name_task = (TextView) itemView.findViewById(R.id.name_task);
            date_create = (TextView) itemView.findViewById(R.id.date_create);
            description = (TextView) itemView.findViewById(R.id.descriprion);
            complete_task = (ImageView) itemView.findViewById(R.id.complete_task);
            icon_type = (ImageView) itemView.findViewById(R.id.icon_type);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = AdapterTask.ViewHolder.super.getAdapterPosition();
                    itemClickListener.onItemClick(v,pos);

                }
            });
        }
    }

}

