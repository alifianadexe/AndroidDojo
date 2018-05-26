package com.quick.androidtrainingdojo.baseactivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.quick.androidtrainingdojo.CardViewActivity;
import com.quick.androidtrainingdojo.R;
import com.quick.androidtrainingdojo.TabLayoutActivity;

/**
 * Created by ditya on 5/22/18.
 */

public abstract class AppBaseActivity extends AppCompatActivity implements MenuItem.OnMenuItemClickListener{

    private FrameLayout view_stub;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Menu drawerMenu;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        super.setContentView(R.layout.app_base_layout);

        view_stub = (FrameLayout) findViewById(R.id.view_stub);
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, 0,0);
        drawerLayout.setDrawerListener(mDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        drawerMenu = navigationView.getMenu();
        for(int i = 0; i < drawerMenu.size(); i++) {
            drawerMenu.getItem(i).setOnMenuItemClickListener(this);
        }
    }


    @Override
    protected void onPostCreate(Bundle savedInstance){
        super.onPostCreate(savedInstance);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration config){
        super.onConfigurationChanged(config);
        mDrawerToggle.onConfigurationChanged(config);
    }




    @Override
    public void setContentView(int resLayoutId){
        if(view_stub != null){
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            View stubView = inflater.inflate(resLayoutId, view_stub, false);
            view_stub.addView(stubView, lp);
        }
    }


    @Override
    public void setContentView(View view){
        if(view_stub != null){
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
            );
            view_stub.addView(view, lp);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(mDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item){
        switch (item.getItemId()){
            case R.id.adexe:
                Snackbar.make(drawerLayout, "Adexe 4u!", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.card_view:
                Intent intent = new Intent(getApplicationContext(), CardViewActivity.class);
                startActivity(intent);
                Snackbar.make(drawerLayout, "Adexe 4u!", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.tab_layout:
                Intent intent1 = new Intent(getApplicationContext(), TabLayoutActivity.class);
                startActivity(intent1);
                Snackbar.make(drawerLayout, "Adexe 4u!", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.snackbar_layout:
                Snackbar.make(drawerLayout, "Adexe 4u!", Snackbar.LENGTH_SHORT).show();
                break;
        }
        return false;
    }

}
