package com.jbantequera.monsterhunternotes.activity.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jbantequera.monsterhunternotes.R;
import com.jbantequera.monsterhunternotes.activity.adapter.WeaponAdapter;
import com.jbantequera.monsterhunternotes.activity.model.Weapons.Durability;
import com.jbantequera.monsterhunternotes.activity.model.Weapons.Item;
import com.jbantequera.monsterhunternotes.activity.model.Weapons.UpgradeMaterial;
import com.jbantequera.monsterhunternotes.activity.model.Weapons.Weapon;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Set;

public class DisplayWeaponActivity extends AppCompatActivity {

    Weapon weapon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_weapon);

        //Get the intent which launched this activity
        Intent intent = getIntent();
        weapon = (Weapon) intent.getSerializableExtra(WeaponAdapter.EXTRA_WEAPON);

        loadData();
    }

    private void loadData(){
        //Weapon Name
        TextView weaponName = findViewById(R.id.txt_weapon_name);
        weaponName.setText(weapon.getName());

        //WeaponImage
        new SetImageTask().execute(weapon.getAssets().getImage());

        //Raw Damage
        TextView rawDamage = findViewById(R.id.txt_weapon_rawdmg);
        rawDamage.setText(weapon.getAttack().getDisplay().toString());
        rawDamage.setText(rawDamage.getText() + " BASE");

        //Elemental Damage
        if (!weapon.getElements().isEmpty()) {
            TextView eleDamage = findViewById(R.id.txt_weapon_eledmg);
            eleDamage.setText(weapon.getElements().get(0).getDamage().toString());
            eleDamage.setText(eleDamage.getText() + " " + weapon.getElements().get(0).getType().toUpperCase());
        }

        //Slots
        if (!weapon.getSlots().isEmpty()) {
            TextView slots = findViewById(R.id.txt_weapon_slots);
            String txt_slots = "";
            //Level 3 Slots
            int n_3slot = 0;
            int n_2slot = 0;
            int n_1slot = 0;

            for (int i = 0; i < weapon.getSlots().size(); i++){
                if (weapon.getSlots().get(i).getRank() == 3)
                    n_3slot++;
                else if (weapon.getSlots().get(i).getRank() == 2)
                    n_2slot++;
                else if (weapon.getSlots().get(i).getRank() == 1)
                    n_1slot++;
            }

            if (n_1slot != 0) {
                txt_slots += "Level 1 (x" + n_1slot + ")";

                if ((n_2slot != 0) || (n_3slot != 0))
                    txt_slots += "\n";
            }
            if (n_2slot != 0) {
                txt_slots += "Level 2 (x" + n_2slot + ")";

                if (n_3slot != 0)
                    txt_slots += "\n";
            }
            if (n_3slot != 0)
                txt_slots += "Level 3 (x" + n_3slot + ")";

            slots.setText(txt_slots);
        }

        //Materials
        if (!weapon.getCrafting().getCraftingMaterials().isEmpty()){
            TextView materialList = findViewById(R.id.txt_weapon_materials);
            String txt_materials = "";

            for (int i = 0; i < weapon.getCrafting().getCraftingMaterials().size(); i++){
                UpgradeMaterial material = weapon.getCrafting().getCraftingMaterials().get(i);
                txt_materials += material.getItem().getName() + " (x" + material.getQuantity().toString() + ")\n";
            }

            materialList.setText(txt_materials);
        } else if (!weapon.getCrafting().getUpgradeMaterials().isEmpty()){
            TextView materialList = findViewById(R.id.txt_weapon_materials);
            String txt_materials = "";

            for (int i = 0; i < weapon.getCrafting().getUpgradeMaterials().size(); i++){
                UpgradeMaterial material = weapon.getCrafting().getUpgradeMaterials().get(i);
                txt_materials += material.getItem().getName() + " (x" + material.getQuantity().toString() + ")\n";
            }

            materialList.setText(txt_materials);
        }

        //Sharpness
        Durability sharpness = weapon.getDurability().get(0);
        LinearLayout bar = findViewById(R.id.sharpness_bar);
        View red = findViewById(R.id.sharpness_red);
        View orange = findViewById(R.id.sharpness_orange);
        View yellow = findViewById(R.id.sharpness_yellow);
        View green = findViewById(R.id.sharpness_green);
        View blue = findViewById(R.id.sharpness_blue);
        View white = findViewById(R.id.sharpness_white);

        //Calculate the width of each bar
        ViewGroup.LayoutParams redparams = red.getLayoutParams();
        redparams.width = (int) ((sharpness.getRed() * 1.0 / 400.0) * redparams.width);
        red.setLayoutParams(redparams);

        ViewGroup.LayoutParams orangeparams = orange.getLayoutParams();
        orangeparams.width = (int) ((sharpness.getOrange() * 1.0 / 400.0) * orangeparams.width);
        orange.setLayoutParams(orangeparams);

        ViewGroup.LayoutParams yellowparams = yellow.getLayoutParams();
        yellowparams.width = (int) ((sharpness.getYellow() * 1.0 / 400.0) * yellowparams.width);
        yellow.setLayoutParams(yellowparams);

        ViewGroup.LayoutParams greenparams = green.getLayoutParams();
        greenparams.width = (int) ((sharpness.getGreen() * 1.0 / 400.0) * greenparams.width);
        green.setLayoutParams(greenparams);

        ViewGroup.LayoutParams blueparams = blue.getLayoutParams();
        blueparams.width = (int) ((sharpness.getBlue() * 1.0 / 400.0) * blueparams.width);
        blue.setLayoutParams(blueparams);

        ViewGroup.LayoutParams whiteparams = white.getLayoutParams();
        whiteparams.width = (int) ((sharpness.getWhite() * 1.0 / 400.0) * whiteparams.width);
        white.setLayoutParams(whiteparams);

        /*orange.getLayoutParams().width = sharpness.getOrange() / 400 * 100;
        yellow.getLayoutParams().width = sharpness.getYellow() / 400 * 100;
        green.getLayoutParams().width = sharpness.getGreen() / 400 * 100;
        blue.getLayoutParams().width = sharpness.getBlue() / 400 * 100;
        white.getLayoutParams().width = sharpness.getWhite() / 400 * 100;
        */
    }

    private class SetImageTask extends AsyncTask<String, Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap b = null;
            try {
                URL url = new URL(strings[0]);
                InputStream is = new BufferedInputStream(url.openStream());
                b = BitmapFactory.decodeStream(is); //Drawable.createFromStream(is, "src name");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return b;
        }

        @Override
        protected void onPostExecute(Bitmap b){
            ImageView weaponImageView = findViewById(R.id.weaponImageView);
            weaponImageView.setImageBitmap(b);
        }
    }
}
