package com.app.bharatcart.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.app.bharatcart.R;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public SlideAdapter(Context context){

        this.context=context;
    }
    public int[] slide_images={
            R.drawable.local_for_vocal,
            R.drawable.onboard1,
            R.drawable.onboard2,
            R.drawable.onboard3
    };


    @Override
    public int getCount() {
        return slide_images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == (RelativeLayout) o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout,container,false);
        ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        slideImageView.setImageResource(slide_images[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem( ViewGroup container, int position, Object object) {
        container.removeView((RelativeLayout)object);
    }
}
