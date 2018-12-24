package com.jbantequera.monsterhunternotes.activity.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jbantequera.monsterhunternotes.R;
import com.jbantequera.monsterhunternotes.activity.adapter.ItemAdapter;
import com.jbantequera.monsterhunternotes.activity.model.item.Item;

public class DisplayItemActivity extends AppCompatActivity {

    Item item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_item);

        //Get the intent which launched this activity
        Intent intent = getIntent();
        item = (Item) intent.getSerializableExtra(ItemAdapter.EXTRA_ITEM);

        loadData();
    }

    private void loadData(){
        TextView itemName = findViewById(R.id.txt_item_details_name);
        TextView itemDescript = findViewById(R.id.txt_item_description);
        TextView itemRarity = findViewById(R.id.txt_item_rarity);
        TextView itemCarryLimit = findViewById(R.id.txt_item_carrylimit);
        TextView itemPrice = findViewById(R.id.txt_item_price);

        itemName.setText(item.getName());
        itemDescript.setText(item.getDescription());
        itemRarity.setText(itemRarity.getText() + " " + item.getRarity());
        itemCarryLimit.setText(itemCarryLimit.getText() + " " + item.getCarryLimit());
        itemPrice.setText(itemPrice.getText() + " " + item.getValue() + " zennies");
    }
}
