
package com.jbantequera.monsterhunternotes.activity.model.Charm;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rank implements Serializable {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("level")
    @Expose
    private Integer level;
    @SerializedName("rarity")
    @Expose
    private Integer rarity;
    @SerializedName("skills")
    @Expose
    private List<Skill> skills = null;
    @SerializedName("crafting")
    @Expose
    private Crafting crafting;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Crafting getCrafting() {
        return crafting;
    }

    public void setCrafting(Crafting crafting) {
        this.crafting = crafting;
    }

}
