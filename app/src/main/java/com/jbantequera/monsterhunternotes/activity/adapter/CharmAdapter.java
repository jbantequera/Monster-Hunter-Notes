package com.jbantequera.monsterhunternotes.activity.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jbantequera.monsterhunternotes.R;
import com.jbantequera.monsterhunternotes.activity.activity.DisplayCharmActivity;
import com.jbantequera.monsterhunternotes.activity.model.Charm.Charm;

import java.util.ArrayList;

public class CharmAdapter extends RecyclerView.Adapter<CharmAdapter.CharmViewHolder> {

    public static final String EXTRA_CHARM = "com.jbantequera.monsterhunternotes.activity.CHARMDETAILS";

    private ArrayList<Charm> dataList;
    private Context context;

    public CharmAdapter(ArrayList<Charm> dataList) {
        this.dataList = dataList;
    }

    public void setContext(Context context){
        this.context = context;
    }

    @Override
    public CharmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_charm, parent, false);
        return new CharmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CharmViewHolder holder, int position) {
        holder.charm = dataList.get(position);
        holder.charmName.setText(holder.charm.getName());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class CharmViewHolder extends RecyclerView.ViewHolder {

        Charm charm;
        TextView charmName;
        View v;

        CharmViewHolder(View itemView) {
            super(itemView);
            v = itemView;
            charmName = itemView.findViewById(R.id.txt_charm_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DisplayCharmActivity.class);
                    intent.putExtra(EXTRA_CHARM, charm);
                    context.startActivity(intent);
                }
            });
        }
    }
}