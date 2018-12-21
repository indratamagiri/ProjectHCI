package com.example.madeg.projecthci;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class ViewAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater inflater;
    private int[] imageId = {R.drawable.scali_bread, R.drawable.white_bread, R.drawable.french_bread, R.drawable.crazy_dough_stuffed_bread, R.drawable.garlic_bread};


    public ViewAdapter(Context context) {
        this.context = context;
    }


    @Override
    public int getCount() {
        return imageId.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return (view == o);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.image_curosel, null);
        ImageView imageView = v.findViewById(R.id.imageView);
        imageView.setImageResource(imageId[position]);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ItemActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        ViewPager viewPager;
        viewPager = (ViewPager) container;
        viewPager.addView(v);
        return v;
    }



    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        View view = (View) object;
        ViewPager viewPager = (ViewPager) container;
        viewPager.removeView(view);
    }




}
