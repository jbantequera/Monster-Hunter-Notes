package com.jbantequera.monsterhunternotes.activity.network;

import com.jbantequera.monsterhunternotes.activity.model.ArmorSet.ArmorSet;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetArmorSetDataService {
    @GET("armor/sets")
    Call<ArrayList<ArmorSet>> getArmorSetData();
}