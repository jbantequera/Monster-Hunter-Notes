package com.jbantequera.monsterhunternotes.activity.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.jbantequera.monsterhunternotes.R;
import com.jbantequera.monsterhunternotes.activity.adapter.ArmorSetAdapter;
import com.jbantequera.monsterhunternotes.activity.adapter.CharmAdapter;
import com.jbantequera.monsterhunternotes.activity.adapter.ItemAdapter;
import com.jbantequera.monsterhunternotes.activity.model.ArmorSet.ArmorSet;
import com.jbantequera.monsterhunternotes.activity.model.Charm.Charm;
import com.jbantequera.monsterhunternotes.activity.model.Weapons.Weapon;
import com.jbantequera.monsterhunternotes.activity.adapter.WeaponAdapter;
import com.jbantequera.monsterhunternotes.activity.model.item.Item;
import com.jbantequera.monsterhunternotes.activity.network.GetArmorSetDataService;
import com.jbantequera.monsterhunternotes.activity.network.GetCharmDataService;
import com.jbantequera.monsterhunternotes.activity.network.GetItemDataService;
import com.jbantequera.monsterhunternotes.activity.network.GetWeaponDataService;
import com.jbantequera.monsterhunternotes.activity.network.RetrofitInstance;

import java.io.IOException;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private WeaponAdapter weaponAdapter;
    private ArmorSetAdapter armorSetAdapter;
    private CharmAdapter charmAdapter;
    private ItemAdapter itemAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_list);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_weapons);
        generateWeaponList();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_info) {
            Toast.makeText(MainActivity.this, "Made by Javier Blanco Antequera", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        //Clear the recyclerview data
        recyclerView.setAdapter(null);

        if (id == R.id.nav_weapons) {
            generateWeaponList();
        } else if (id == R.id.nav_armorsets) {
            generateArmorSetList();
        } else if (id == R.id.nav_charms) {
            generateCharmList();
        } else if (id == R.id.nav_items) {
            generateItemList();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void generateWeaponList(){
        GetWeaponDataService weaponDataService = RetrofitInstance.getRetrofitInstance().create(GetWeaponDataService.class);
        Call<ArrayList<Weapon>> call = weaponDataService.getWeaponData();

        call.enqueue(new Callback<ArrayList<Weapon>>() {
            @Override
            public void onResponse(Call<ArrayList<Weapon>> call, Response<ArrayList<Weapon>> response) {
                //Store the data into an ArrayList
                ArrayList <Weapon> weaponDataList = response.body();

                //Set the adapter for the weapon list
                weaponAdapter = new WeaponAdapter(weaponDataList);
                weaponAdapter.setContext(MainActivity.this);

                //Set the recycler view properties.
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(weaponAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Weapon>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try again later", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateArmorSetList(){
        GetArmorSetDataService armorSetDataService = RetrofitInstance.getRetrofitInstance().create(GetArmorSetDataService.class);
        Call<ArrayList<ArmorSet>> call = armorSetDataService.getArmorSetData();

        call.enqueue(new Callback<ArrayList<ArmorSet>>() {
            @Override
            public void onResponse(Call<ArrayList<ArmorSet>> call, Response<ArrayList<ArmorSet>> response) {
                //Store the data into an ArrayList
                ArrayList <ArmorSet> armorSetDataList = response.body();

                //Set the adapter for the armorSet list
                armorSetAdapter = new ArmorSetAdapter(armorSetDataList);
                armorSetAdapter.setContext(MainActivity.this);

                //Set the recycler view properties.
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(armorSetAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<ArmorSet>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try again later", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateCharmList(){
        GetCharmDataService charmDataService = RetrofitInstance.getRetrofitInstance().create(GetCharmDataService.class);
        Call<ArrayList<Charm>> call = charmDataService.getCharmData();

        call.enqueue(new Callback<ArrayList<Charm>>() {
            @Override
            public void onResponse(Call<ArrayList<Charm>> call, Response<ArrayList<Charm>> response) {
                //Store the data into an ArrayList
                ArrayList <Charm> charmDataList = response.body();

                //Set the adapter for the charm list
                charmAdapter = new CharmAdapter(charmDataList);
                charmAdapter.setContext(MainActivity.this);

                //Set the recycler view properties.
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(charmAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Charm>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try again later", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateItemList(){
        GetItemDataService itemDataService = RetrofitInstance.getRetrofitInstance().create(GetItemDataService.class);
        Call<ArrayList<Item>> call = itemDataService.getItemData();

        call.enqueue(new Callback<ArrayList<Item>>() {
            @Override
            public void onResponse(Call<ArrayList<Item>> call, Response<ArrayList<Item>> response) {
                //Store the data into an ArrayList
                ArrayList <Item> itemDataList = response.body();

                //Set the adapter for the charm list
                itemAdapter = new ItemAdapter(itemDataList);
                itemAdapter.setContext(MainActivity.this);

                //Set the recycler view properties.
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(itemAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<Item>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong...Please try again later", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
