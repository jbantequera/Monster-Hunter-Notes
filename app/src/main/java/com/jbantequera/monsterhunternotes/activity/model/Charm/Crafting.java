
package com.jbantequera.monsterhunternotes.activity.model.Charm;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Crafting implements Serializable {

    @SerializedName("craftable")
    @Expose
    private Boolean craftable;
    @SerializedName("materials")
    @Expose
    private List<Material> materials = null;

    public Boolean getCraftable() {
        return craftable;
    }

    public void setCraftable(Boolean craftable) {
        this.craftable = craftable;
    }

    public List<Material> getMaterials() {
        return materials;
    }

    public void setMaterials(List<Material> materials) {
        this.materials = materials;
    }

}
