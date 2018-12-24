
package com.jbantequera.monsterhunternotes.activity.model.Weapons;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weapon implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("rarity")
    @Expose
    private Integer rarity;
    @SerializedName("attack")
    @Expose
    private Attack attack;
    @SerializedName("slots")
    @Expose
    private List<Slot> slots = null;
    @SerializedName("elements")
    @Expose
    private List<Element> elements = null;
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    @SerializedName("crafting")
    @Expose
    private Crafting crafting;
    @SerializedName("assets")
    @Expose
    private Assets assets;
    @SerializedName("sharpness")
    @Expose
    private Sharpness sharpness;
    @SerializedName("durability")
    @Expose
    private List<Durability> durability = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }

    public Attack getAttack() {
        return attack;
    }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public void setSlots(List<Slot> slots) {
        this.slots = slots;
    }

    public List<Element> getElements() {
        return elements;
    }

    public void setElements(List<Element> elements) {
        this.elements = elements;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public Crafting getCrafting() {
        return crafting;
    }

    public void setCrafting(Crafting crafting) {
        this.crafting = crafting;
    }

    public Assets getAssets() {
        return assets;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public Sharpness getSharpness() {
        return sharpness;
    }

    public void setSharpness(Sharpness sharpness) {
        this.sharpness = sharpness;
    }

    public List<Durability> getDurability() {
        return durability;
    }

    public void setDurability(List<Durability> durability) {
        this.durability = durability;
    }

}
