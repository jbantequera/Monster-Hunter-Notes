package com.jbantequera.monsterhunternotes.activity.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jbantequera.monsterhunternotes.R;
import com.jbantequera.monsterhunternotes.activity.activity.DisplayWeaponActivity;
import com.jbantequera.monsterhunternotes.activity.model.Weapons.Element;
import com.jbantequera.monsterhunternotes.activity.model.Weapons.Weapon;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class WeaponAdapter extends RecyclerView.Adapter<WeaponAdapter.WeaponViewHolder> {

    private ArrayList<Weapon> dataList;

    public static final String EXTRA_WEAPON = "com.jbantequera.monsterhunternotes.activity.WEAPONDETAILS";
    public WeaponAdapter(ArrayList<Weapon> dataList) {
        this.dataList = dataList;
    }
    private Context context;
    private Bitmap imageIcon;

    public void setContext(Context context){
        this.context = context;
    }

    @Override
    public WeaponViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_weapon, parent, false);
        return new WeaponViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WeaponViewHolder holder, int position) {
        holder.weapon = dataList.get(position);
        holder.txtWeaponName.setText(holder.weapon.getName());
        holder.setWeaponIcon();
        holder.txtWeaponRawDmg.setText(holder.weapon.getAttack().getDisplay().toString());
        holder.setWeaponEleDmg();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class WeaponViewHolder extends RecyclerView.ViewHolder {

        Weapon weapon;
        TextView txtWeaponName;
        TextView txtWeaponRawDmg;
        TextView txtWeaponEleDmg;
        ImageView imgWeaponIcon;
        View v;

        WeaponViewHolder(View itemView) {
            super(itemView);
            v = itemView;
            txtWeaponName = (TextView) itemView.findViewById(R.id.txt_weapon_name);
            imgWeaponIcon = (ImageView) itemView.findViewById(R.id.img_weapon_icon);
            txtWeaponRawDmg = (TextView) itemView.findViewById(R.id.txt_weapon_rawdmg);
            txtWeaponEleDmg = (TextView) itemView.findViewById(R.id.txt_weapon_eledmg);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DisplayWeaponActivity.class);
                    intent.putExtra(EXTRA_WEAPON, weapon);
                    context.startActivity(intent);
                }
            });
        }

        void setWeaponIcon(){
            new SetIconTask().execute(weapon.getAssets().getIcon());
        }

        void setWeaponEleDmg(){
            if (!weapon.getElements().isEmpty()) {
                Element element = weapon.getElements().get(0);
                String eleType = element.getType();
                String elementalDamage = element.getDamage().toString() + " " + eleType;
                txtWeaponEleDmg.setText(elementalDamage.toUpperCase());

                if (element.getHidden())
                    txtWeaponEleDmg.setText("(" + txtWeaponEleDmg.getText() + ")");
            }
        }

        class SetIconTask extends AsyncTask<String, Void, Bitmap> {

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
                imgWeaponIcon.setImageBitmap(b);
            }
        }
    }
}