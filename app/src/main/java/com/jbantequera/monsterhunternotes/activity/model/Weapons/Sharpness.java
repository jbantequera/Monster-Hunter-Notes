
package com.jbantequera.monsterhunternotes.activity.model.Weapons;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Sharpness implements Serializable {

    @SerializedName("red")
    @Expose
    private Integer red;
    @SerializedName("orange")
    @Expose
    private Integer orange;
    @SerializedName("yellow")
    @Expose
    private Integer yellow;
    @SerializedName("green")
    @Expose
    private Integer green;
    @SerializedName("blue")
    @Expose
    private Integer blue;
    @SerializedName("white")
    @Expose
    private Integer white;

    public Integer getRed() {
        return red;
    }

    public void setRed(Integer red) {
        this.red = red;
    }

    public Integer getOrange() {
        return orange;
    }

    public void setOrange(Integer orange) {
        this.orange = orange;
    }

    public Integer getYellow() {
        return yellow;
    }

    public void setYellow(Integer yellow) {
        this.yellow = yellow;
    }

    public Integer getGreen() {
        return green;
    }

    public void setGreen(Integer green) {
        this.green = green;
    }

    public Integer getBlue() {
        return blue;
    }

    public void setBlue(Integer blue) {
        this.blue = blue;
    }

    public Integer getWhite() {
        return white;
    }

    public void setWhite(Integer white) {
        this.white = white;
    }

}
