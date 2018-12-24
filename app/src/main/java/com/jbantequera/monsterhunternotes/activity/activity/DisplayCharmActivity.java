package com.jbantequera.monsterhunternotes.activity.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jbantequera.monsterhunternotes.R;
import com.jbantequera.monsterhunternotes.activity.adapter.CharmAdapter;
import com.jbantequera.monsterhunternotes.activity.model.Charm.Charm;
import com.jbantequera.monsterhunternotes.activity.model.Charm.Item;
import com.jbantequera.monsterhunternotes.activity.model.Charm.Rank;
import com.jbantequera.monsterhunternotes.activity.model.Charm.Skill;

import java.util.List;

public class DisplayCharmActivity extends AppCompatActivity {

    Charm charm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_charm);

        //Get the intent which launched this activity
        Intent intent = getIntent();
        charm = (Charm) intent.getSerializableExtra(CharmAdapter.EXTRA_CHARM);

        loadData();
    }

    private void loadData() {
        //Charm Name
        TextView charmName = findViewById(R.id.txt_charm_name);
        charmName.setText(charm.getName());

        //Ranks
        List<Rank> rankList = charm.getRanks();

        if (!rankList.isEmpty()) {
            View charmRank;
            LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LinearLayout container = (LinearLayout) findViewById(R.id.layout_ranks);

            for (int i = 0; i < rankList.size(); i++) {
                //Inflate each rank layout
                charmRank = inflater.inflate(R.layout.row_charm_details, null);

                //Modify the layout
                Rank rank = rankList.get(i);
                TextView rankName = charmRank.findViewById(R.id.txt_charm_rank_name);
                TextView rankMaterials = charmRank.findViewById(R.id.txt_charm_rank_materials);
                TextView materialTitle = charmRank.findViewById(R.id.txt_charm_rank_materialtitle);

                rankName.setText(rank.getName());

                //Skills
                if (!rank.getSkills().isEmpty()){
                    TextView rankSkill = charmRank.findViewById(R.id.txt_charm_rank_skilllist);
                    String skillList = "";

                    for (int j = 0; j < rank.getSkills().size(); j++){
                        if (j != 0)
                            skillList += "\n";

                        Skill skill = rank.getSkills().get(j);
                        skillList += skill.getSkillName() + "(" + skill.getLevel() + ")";
                    }

                    rankSkill.setText(skillList);
                }

                //Craftable
                String craftable;
                if (rank.getCrafting().getCraftable()) {
                    craftable = "Materials";
                    String materialList = "";
                    for (int j = 0; j < rank.getCrafting().getMaterials().size(); j++) {
                        if (j != 0)
                            materialList += "\n";

                        Item item = rank.getCrafting().getMaterials().get(j).getItem();
                        int quantity = rank.getCrafting().getMaterials().get(j).getQuantity();
                        materialList += item.getName() + " (x" + quantity + ")";
                    }

                    materialTitle.setText(craftable);
                    rankMaterials.setText(materialList);
                }else {
                    craftable = "Can't be crafted";
                    materialTitle.setText(craftable);
                }

                //Add the layout to the LinearLayout
                container.addView(charmRank);
            }
        }
    }
}