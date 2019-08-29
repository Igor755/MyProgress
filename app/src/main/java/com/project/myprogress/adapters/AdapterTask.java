package com.project.myprogress.adapters;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
    private AlertDialog builder;



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

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        final Task itemList = listItems.get(position);



        holder.name.setText(itemList.getName());
        holder.date_create.setText(itemList.getDate_create());
        holder.icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                builder = new AlertDialog.Builder(v.getRootView().getContext()).create();
                builder.setTitle("Delete Item?");
                builder.setMessage("You seriosly?");
                builder.setButton(Dialog.BUTTON_POSITIVE, mContext.getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {



                        Toast.makeText(mContext, R.string.delete, Toast.LENGTH_LONG).show();



                    }
                });
                builder.setButton(Dialog.BUTTON_NEGATIVE, mContext.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(mContext, mContext.getResources().getString(R.string.cancel), Toast.LENGTH_LONG).show();


                    }
                });

                builder.show();


            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView date_create;
        ImageButton icon;

        ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            date_create = (TextView) itemView.findViewById(R.id.date_create);
            icon = (ImageButton) itemView.findViewById(R.id.txt_menu_places);

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

