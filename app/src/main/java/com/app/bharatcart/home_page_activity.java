package com.app.bharatcart;

import android.app.Activity;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;

import com.app.bharatcart.R;

public class home_page_activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchpage);
    }
}
