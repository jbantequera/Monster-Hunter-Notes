package com.jbantequera.monsterhunternotes.activity.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jbantequera.monsterhunternotes.R;
import com.jbantequera.monsterhunternotes.activity.activity.DisplayArmorSetActivity;
import com.jbantequera.monsterhunternotes.activity.activity.MainActivity;
import com.jbantequera.monsterhunternotes.activity.model.ArmorSet.ArmorSet;

import java.util.ArrayList;

public class ArmorSetAdapter extends RecyclerView.Adapter<ArmorSetAdapter.ArmorSetViewHolder> {

    public static final String EXTRA_ARMORSET = "com.jbantequera.monsterhunternotes.activity.ARMORSETDETAILS";

    private ArrayList<ArmorSet> dataList;
    private Context context;

    public ArmorSetAdapter(ArrayList<ArmorSet> dataList) {
        this.dataList = dataList;
    }

    public void setContext(Context context){
        this.context = context;
    }

    @Override
    public ArmorSetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_armorset, parent, false);
        return new ArmorSetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArmorSetViewHolder holder, int position) {
        holder.armorSet = dataList.get(position);
        holder.txtArmorSetName.setText(holder.armorSet.getName() + " Set");
        holder.txtArmorSetRank.setText("Rank: " + holder.armorSet.getRank());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ArmorSetViewHolder extends RecyclerView.ViewHolder {

        ArmorSet armorSet;
        TextView txtArmorSetName;
        TextView txtArmorSetRank;
        View v;

        ArmorSetViewHolder(View itemView) {
            super(itemView);
            v = itemView;
            txtArmorSetName = itemView.findViewById(R.id.txt_armorset_name);
            txtArmorSetRank = itemView.findViewById(R.id.txt_armorset_rank);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (!armorSet.getPieces().isEmpty()) {
                        Intent intent = new Intent(context, DisplayArmorSetActivity.class);
                        intent.putExtra(EXTRA_ARMORSET, armorSet);
                        context.startActivity(intent);
                    } else {
                        Toast.makeText(context, "This armor isn't available", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}