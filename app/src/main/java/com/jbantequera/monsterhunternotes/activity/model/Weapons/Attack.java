
package com.jbantequera.monsterhunternotes.activity.model.Weapons;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Attack implements Serializable {

    @SerializedName("display")
    @Expose
    private Integer display;
    @SerializedName("raw")
    @Expose
    private Integer raw;

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public Integer getRaw() {
        return raw;
    }

    public void setRaw(Integer raw) {
        this.raw = raw;
    }

}
