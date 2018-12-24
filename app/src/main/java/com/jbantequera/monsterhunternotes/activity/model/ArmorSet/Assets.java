
package com.jbantequera.monsterhunternotes.activity.model.ArmorSet;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Assets implements Serializable {

    @SerializedName("imageMale")
    @Expose
    private String imageMale;
    @SerializedName("imageFemale")
    @Expose
    private String imageFemale;

    public String getImageMale() {
        return imageMale;
    }

    public void setImageMale(String imageMale) {
        this.imageMale = imageMale;
    }

    public String getImageFemale() {
        return imageFemale;
    }

    public void setImageFemale(String imageFemale) {
        this.imageFemale = imageFemale;
    }

}
