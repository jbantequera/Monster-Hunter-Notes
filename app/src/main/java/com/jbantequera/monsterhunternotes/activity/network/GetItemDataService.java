package com.jbantequera.monsterhunternotes.activity.network;

import com.jbantequera.monsterhunternotes.activity.model.item.Item;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetItemDataService {
    @GET("items")
    Call<ArrayList<Item>> getItemData();
}
