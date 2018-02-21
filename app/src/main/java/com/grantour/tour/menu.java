package com.grantour.tour;

import android.Manifest;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Network;
import android.net.wifi.ScanResult;
import android.os.ParcelUuid;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PublicKey;

public class menu extends AppCompatActivity {


    private TextView formatTxt, contentTxt;

    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mtoggle;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer);
        mtoggle = new ActionBarDrawerToggle(this, mDrawerlayout, R.string.abrir, R.string.cerrar);
        mDrawerlayout.addDrawerListener(mtoggle);
        NavigationView nvDrawer = (NavigationView) findViewById(R.id.nv);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(nvDrawer);




    }



    public  void selectItemDrawer(MenuItem menuItem){
        android.support.v4.app.Fragment myFragment = null;
        Class fragmentClass;
        switch (menuItem.getItemId()){
            case R.id.idmap:
                fragmentClass = mapa.class;
                break;
            case R.id.idperfil:
                fragmentClass =  miperfil.class;
                break;
            case R.id.idimagenes:
                fragmentClass = MisImagenes.class;
                break;
            case R.id.idajustes:
                fragmentClass = Ajustes.class;
                break;
                default:
                    fragmentClass = mapa.class;

        }
        try{

            myFragment = (android.support.v4.app.Fragment) fragmentClass.newInstance();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.contenedorfragmento,myFragment).commit();
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        mDrawerlayout.closeDrawers();

    }

    private void setupDrawerContent(NavigationView navigationView){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectItemDrawer(item);
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (mtoggle.onOptionsItemSelected(item)){
            return  true;

        }
        return  super.onOptionsItemSelected(item);

    }




}

