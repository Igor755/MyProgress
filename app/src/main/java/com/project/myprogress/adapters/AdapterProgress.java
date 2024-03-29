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
import com.project.myprogress.interfaces.OnItemClickListenerProgress;
import com.project.myprogress.modelclass.Sphere;

import java.util.List;

public class AdapterProgress extends RecyclerView.Adapter<AdapterProgress.ViewHolder> {

    private List<Sphere> listItems;
    public Context mContext;
    private OnItemClickListenerProgress itemClickListener;
    private AlertDialog builder;


    public AdapterProgress(List<Sphere> listItems, Context mContext, OnItemClickListenerProgress itemClickListener) {
        this.itemClickListener =itemClickListener;
        this.listItems = listItems;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_item_recycler_progress, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        final Sphere itemList = listItems.get(position);



        holder.name_progress.setText(itemList.getName_progress());
        // holder.point.setText(itemList.getBalls_progress());
        holder.delete_progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                builder = new AlertDialog.Builder(v.getRootView().getContext()).create();
                builder.setTitle("Delete Sphere?");
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

        TextView name_progress;
       // TextView point;
        ImageButton delete_progress;

        ViewHolder(View itemView) {
            super(itemView);

            name_progress = (TextView) itemView.findViewById(R.id.name_progress);
            //point = (TextView) itemView.findViewById(R.id.point);
            delete_progress = (ImageButton) itemView.findViewById(R.id.delete_progress);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    itemClickListener.onItemClick(v,pos);

                }
            });
        }
    }

}