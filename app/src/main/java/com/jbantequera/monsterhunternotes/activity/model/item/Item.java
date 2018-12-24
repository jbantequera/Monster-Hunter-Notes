package com.jbantequera.monsterhunternotes.activity.model.item;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Item implements Serializable {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("rarity")
    @Expose
    private int rarity;

    @SerializedName("carryLimit")
    @Expose
    private int carryLimit;

    @SerializedName("value")
    @Expose
    private int value;

    public Item(int id, String name, String description, int rarity, int carryLimit, int value) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rarity = rarity;
        this.carryLimit = carryLimit;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getRarity() {
        return rarity;
    }

    public void setRarity(int rarity) {
        this.rarity = rarity;
    }

    public int getCarryLimit() {
        return carryLimit;
    }

    public void setCarryLimit(int carryLimit) {
        this.carryLimit = carryLimit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
