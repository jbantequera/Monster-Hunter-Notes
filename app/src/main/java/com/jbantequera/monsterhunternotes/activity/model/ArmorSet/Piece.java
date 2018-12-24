package com.jbantequera.monsterhunternotes.activity.model.ArmorSet;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Piece implements Serializable {
    @SerializedName("assets")
    @Expose
    private Assets assets;

    public Assets getAssets() {
        return assets;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }
}
