package com.example.periodbuddy;


import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LandingPage extends AppCompatActivity {

    private ActionBarDrawerToggle actionBarDrawerToggle;
    TextView textView;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);





        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(LandingPage.this, drawerLayout, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigationView);
        View view = navigationView.inflateHeaderView(R.layout.navigation_header);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                UserItemSelected(item);
                return false;
            }
        });
    }


    private void UserItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.share:

                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                String shareBody = "http://play.google.com/store/apps/details?id="+getPackageName();
                String shareSub = " Thanks for Sharing";
                myIntent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
                myIntent.putExtra(Intent.EXTRA_TEXT,shareBody);
                startActivity(Intent.createChooser(myIntent,"Share using"));
                break;

            case R.id.History:
                startActivity(new Intent(LandingPage.this,History.class));


                break;

            case R.id.Hygiene:


                break;

            case R.id.FAQ:


                break;

            case R.id.Buddy:

                break;

            case R.id.Support:
                startActivity(new Intent(LandingPage.this,BeTheSupport.class));
                break;


        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }

        else if (item.getItemId()==R.id.about){

            startActivity(new Intent(LandingPage.this,AboutUs.class));

        }
        else if (item.getItemId()==R.id.setting){

            //startActivity(new Intent(LandingPage.this,AboutUs.class));

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.action_bar_menu,menu);
        return super.onCreateOptionsMenu(menu);


    }
}


