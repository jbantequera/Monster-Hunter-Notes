
package com.jbantequera.monsterhunternotes.activity.model.Weapons;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Slot implements Serializable {

    @SerializedName("rank")
    @Expose
    private Integer rank;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

}
