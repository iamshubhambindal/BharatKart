package com.app.bharatcart;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class navactivity extends AppCompatActivity  {
ActionBarDrawerToggle toggle;
    DrawerLayout drawer;
    Button closeDrawer;
    TextView name;
    boolean doubleBackToExitPressedOnce = false;
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navactivity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(null);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        Log.e("ID", "onNavigationItemSelected: " );
        NavigationView navigationView = findViewById(R.id.nav_view);
//        closeDrawer=navigationView.getHeaderView(0).findViewById(R.id.goback_button);
//        closeDrawer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                drawer.closeDrawer(GravityCompat.START);
//            }
//        });
        final SharedPreferences sharedPreferences=getSharedPreferences("Name",0);
        String firstName=sharedPreferences.getString("firstname","First Name").toUpperCase();
        String lastName=sharedPreferences.getString("lastname","Last Name").toUpperCase();
        name=navigationView.getHeaderView(0).findViewById(R.id.navusername);
        name.setText(firstName+" "+lastName);
        toggle = new ActionBarDrawerToggle(this,drawer,toolbar,R.string.Open,R.string.Close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setCheckedItem(R.id.nav_home);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.screen_area, new searchpage_activity());
        ft.commit();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                Log.e("ID", "onNavigationItemSelected: " + item.getItemId());
                Log.e("ID", "onNavigationItemSelected: " + item.getTitle());
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        fragment = new searchpage_activity();
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction ft = fragmentManager.beginTransaction();
                        ft.replace(R.id.screen_area, fragment);
                        ft.commit();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_swadeshi_list:
                        fragment = new swadeshi_list();
                        FragmentManager fragmentManager1 = getSupportFragmentManager();
                        FragmentTransaction ft1 = fragmentManager1.beginTransaction();
                        ft1.replace(R.id.screen_area, fragment);
                        ft1.commit();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_how_to_use:
                        fragment = new how_to_use_page_activity();
                        FragmentManager fragmentManager2 = getSupportFragmentManager();
                        FragmentTransaction ft2 = fragmentManager2.beginTransaction();
                        ft2.replace(R.id.screen_area, fragment);
                        ft2.commit();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_about_us:
                        fragment = new about_page_activity();
                        FragmentManager fragmentManager3 = getSupportFragmentManager();
                        FragmentTransaction ft3 = fragmentManager3.beginTransaction();
                        ft3.replace(R.id.screen_area, fragment);
                        ft3.commit();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_feedback:
                        fragment = new feedback_page_activity();
                        FragmentManager fragmentManager4 = getSupportFragmentManager();
                        FragmentTransaction ft4 = fragmentManager4.beginTransaction();
                        ft4.replace(R.id.screen_area, fragment);
                        ft4.commit();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_contact_us:
                        fragment = new contact_us_activity();
                        FragmentManager fragmentManager5 = getSupportFragmentManager();
                        FragmentTransaction ft5 = fragmentManager5.beginTransaction();
                        ft5.replace(R.id.screen_area, fragment);
                        ft5.commit();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_app_developers:
                        fragment = new developers_page_activity();
                        FragmentManager fragmentManager6 = getSupportFragmentManager();
                        FragmentTransaction ft6 = fragmentManager6.beginTransaction();
                        ft6.replace(R.id.screen_area, fragment);
                        ft6.commit();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_share_app:
                        share();
                        break;
                    case R.id.nav_logout:
                        drawer.closeDrawer(GravityCompat.START);

                        logOut(sharedPreferences);
                        return true;

                }
                /*FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.screen_area, fragment);
                ft.commit();*/
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navactivity, menu);
        return true;
    }

    public void share(){
        Intent sharingIntent = new Intent();
        sharingIntent.setAction(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        StringBuilder sb = new StringBuilder();
        sb.append("Hi, I am using the BharatCart android app \"A Vocal To Local Android Apps\". I like this and" +
                " I nominate you to be a part of PM Narendra Modi\'s initiative \"Vocal For Local\"."+" Download the app from this link.\n");
        sb.append("https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
        sharingIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
        sharingIntent.putExtra(Intent.EXTRA_TEXT, sb.toString());
        startActivity(Intent.createChooser(sharingIntent, "Share App Via...."));
        drawer.closeDrawer(GravityCompat.START);
    }

    private void logOut(final SharedPreferences sharedPreferences) {
        new AlertDialog.Builder(navactivity.this)
                .setTitle("Log Out")
                .setMessage("Are you sure you want to Logout?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.apply();
                        FirebaseAuth.getInstance().signOut();
                        Intent i=new Intent(navactivity.this,otppage_activity.class);
                        startActivity(i);
                        finish();
                    }

                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        else {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);
            ft.replace(R.id.screen_area,new searchpage_activity());
            ft.commit();
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press again to exit.", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);

    }
   /* @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }*/
}