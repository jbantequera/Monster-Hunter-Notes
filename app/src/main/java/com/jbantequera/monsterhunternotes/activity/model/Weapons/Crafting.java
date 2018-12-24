
package com.jbantequera.monsterhunternotes.activity.model.Weapons;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Crafting implements Serializable {

    @SerializedName("craftable")
    @Expose
    private Boolean craftable;
    @SerializedName("previous")
    @Expose
    private Integer previous;
    @SerializedName("branches")
    @Expose
    private List<Integer> branches = null;
    @SerializedName("craftingMaterials")
    @Expose
    private List<UpgradeMaterial> craftingMaterials = null;
    @SerializedName("upgradeMaterials")
    @Expose
    private List<UpgradeMaterial> upgradeMaterials = null;

    public Boolean getCraftable() {
        return craftable;
    }

    public void setCraftable(Boolean craftable) {
        this.craftable = craftable;
    }

    public Integer getPrevious() {
        return previous;
    }

    public void setPrevious(Integer previous) {
        this.previous = previous;
    }

    public List<Integer> getBranches() {
        return branches;
    }

    public void setBranches(List<Integer> branches) {
        this.branches = branches;
    }

    public List<UpgradeMaterial> getCraftingMaterials() {
        return craftingMaterials;
    }

    public void setCraftingMaterials(List<UpgradeMaterial> craftingMaterials) {
        this.craftingMaterials = craftingMaterials;
    }

    public List<UpgradeMaterial> getUpgradeMaterials() {
        return upgradeMaterials;
    }

    public void setUpgradeMaterials(List<UpgradeMaterial> upgradeMaterials) {
        this.upgradeMaterials = upgradeMaterials;
    }

}
