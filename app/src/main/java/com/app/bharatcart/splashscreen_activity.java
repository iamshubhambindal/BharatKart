package com.app.bharatcart;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.app.bharatcart.R;

public class splashscreen_activity extends AppCompatActivity {

    int SPLASH_TIME = 1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do any action here. Now we are moving to next page
                Intent mySuperIntent = new Intent(splashscreen_activity.this, pager.class);
                Boolean isFirstRun0 = getSharedPreferences("PREFERENCE0", MODE_PRIVATE)
                        .getBoolean("isFirstRun0", true);
                if (isFirstRun0) {
                    startActivity(mySuperIntent);
                }
                Boolean isSecondRun0 = getSharedPreferences("PREFERENCE00", MODE_PRIVATE)
                        .getBoolean("isSecondRun0", false);
                if(isSecondRun0) {
                    Intent mySuperIntent1 = new Intent(splashscreen_activity.this, otppage_activity.class);
                    startActivity(mySuperIntent1);
                }
                getSharedPreferences("PREFERENCE0", MODE_PRIVATE).edit()
                        .putBoolean("isFirstRun0", false).commit();
                getSharedPreferences("PREFERENCE00", MODE_PRIVATE).edit()
                        .putBoolean("isSecondRun0", true).commit();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();

            }
        }, SPLASH_TIME);
    }


}
