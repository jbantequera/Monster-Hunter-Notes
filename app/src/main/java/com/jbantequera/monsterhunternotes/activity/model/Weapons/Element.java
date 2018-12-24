
package com.jbantequera.monsterhunternotes.activity.model.Weapons;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Element implements Serializable {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("damage")
    @Expose
    private Integer damage;
    @SerializedName("hidden")
    @Expose
    private Boolean hidden;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDamage() {
        return damage;
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

}
