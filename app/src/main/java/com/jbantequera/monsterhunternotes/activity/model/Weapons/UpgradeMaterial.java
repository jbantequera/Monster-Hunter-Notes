
package com.jbantequera.monsterhunternotes.activity.model.Weapons;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UpgradeMaterial implements Serializable {

    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("item")
    @Expose
    private Item item;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
