package com.app.bharatcart;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.app.bharatcart.Adapters.SlideAdapter;

public class pager extends AppCompatActivity {
    private ViewPager mSlideViewPager;
    private SlideAdapter mslideAdapter;

    static final int MIN_DISTANCE = 150;
    int count=0;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboard_pager);
        mSlideViewPager=findViewById(R.id.SlideViewPager);/*
        dotsLayout = findViewById(R.id.dotsLayout);*/
        mslideAdapter= new SlideAdapter(getApplicationContext());
        mSlideViewPager.setAdapter(mslideAdapter);
        Toast.makeText(getApplicationContext(),"Swipe To Continue",Toast.LENGTH_LONG).show();
        Log.e("TAG", "onCreate: "+mSlideViewPager.getCurrentItem());
        mSlideViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e("Pager", "onPageScrolled: "+position);
                if(position==3)
                {if(count==0)
                {
                    Toast.makeText(getApplicationContext(),"Swipe Again To Continue",Toast.LENGTH_SHORT).show();
                }
                    count+=1;


                    if(count>1)
                    {
                        Intent intent = new Intent(pager.this,otppage_activity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

}
