
package com.jbantequera.monsterhunternotes.activity.model.Weapons;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Item implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("rarity")
    @Expose
    private Integer rarity;
    @SerializedName("carryLimit")
    @Expose
    private Integer carryLimit;
    @SerializedName("sellPrice")
    @Expose
    private Integer sellPrice;
    @SerializedName("buyPrice")
    @Expose
    private Integer buyPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }

    public Integer getCarryLimit() {
        return carryLimit;
    }

    public void setCarryLimit(Integer carryLimit) {
        this.carryLimit = carryLimit;
    }

    public Integer getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Integer sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

}
