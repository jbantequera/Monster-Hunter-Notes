package com.jbantequera.monsterhunternotes.activity.network;

import com.jbantequera.monsterhunternotes.activity.model.Charm.Charm;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetCharmDataService {
    @GET("charms")
    Call<ArrayList<Charm>> getCharmData();
}
