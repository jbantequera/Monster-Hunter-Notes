package com.jbantequera.monsterhunternotes.activity.network;

import com.jbantequera.monsterhunternotes.activity.model.Weapons.Weapon;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetWeaponDataService {
    @GET("weapons")
    Call<ArrayList<Weapon>> getWeaponData();
}
