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
import com.jbantequera.monsterhunternotes.activity.activity.DisplayItemActivity;
import com.jbantequera.monsterhunternotes.activity.model.Charm.Charm;
import com.jbantequera.monsterhunternotes.activity.model.item.Item;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    public static final String EXTRA_ITEM = "com.jbantequera.monsterhunternotes.activity.ITEMDETAILS";

    private ArrayList<Item> dataList;
    private Context context;

    public ItemAdapter(ArrayList<Item> dataList) {
        this.dataList = dataList;
    }

    public void setContext(Context context){
        this.context = context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.item = dataList.get(position);
        holder.itemName.setText(holder.item.getName());
        String price = "Price: " + holder.item.getValue() + " zennies";
        holder.itemPrice.setText(price);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        Item item;
        TextView itemName;
        TextView itemPrice;
        View v;

        ItemViewHolder(View itemView) {
            super(itemView);
            v = itemView;
            itemName = itemView.findViewById(R.id.txt_item_name);
            itemPrice = itemView.findViewById(R.id.txt_item_price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DisplayItemActivity.class);
                    intent.putExtra(EXTRA_ITEM, item);
                    context.startActivity(intent);
                }
            });
        }
    }
}