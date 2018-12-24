package com.jbantequera.monsterhunternotes.activity.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jbantequera.monsterhunternotes.R;
import com.jbantequera.monsterhunternotes.activity.adapter.ArmorSetAdapter;
import com.jbantequera.monsterhunternotes.activity.model.ArmorSet.ArmorSet;
import com.jbantequera.monsterhunternotes.activity.model.ArmorSet.Piece;

import org.w3c.dom.Text;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class DisplayArmorSetActivity extends AppCompatActivity {

    ArmorSet armorSet;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_armorset);

        context = this;

        //Get the intent which launched this activity
        Intent intent = getIntent();
        armorSet = (ArmorSet) intent.getSerializableExtra(ArmorSetAdapter.EXTRA_ARMORSET);

        loadData();
    }

    private void loadData(){
        //Armor Name
        TextView armorName = findViewById(R.id.txt_armorset_name);
        armorName.setText(armorSet.getName() + " Set");

        //Pieces
        List<Piece> pieceList = armorSet.getPieces();

        if (!pieceList.isEmpty()) {
            for (int i = 0; i < pieceList.size(); i++) {
                Piece piece = pieceList.get(i);
                new SetImageTask().execute(piece.getAssets().getImageMale());
            }
        }
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
            View pieceView;
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LinearLayout container = (LinearLayout) findViewById(R.id.layout_pieces);

            //Inflate each rank layout
            pieceView = inflater.inflate(R.layout.card_armor_piece, null);

            ImageView pieceImageView = pieceView.findViewById(R.id.img_armor_piece);
            pieceImageView.setImageBitmap(b);
            container.addView(pieceView);
        }
    }
}
