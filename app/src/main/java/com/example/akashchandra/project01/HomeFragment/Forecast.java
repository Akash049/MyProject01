package com.example.akashchandra.project01.HomeFragment;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.example.akashchandra.project01.R;
import com.example.akashchandra.project01.circularTranslateAnim;

/**
 * Created by Akash Chandra on 11-11-2016.
 */

public class Forecast extends Fragment{
    private ImageView image;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private Button start;
    int i = 0;
    public Forecast()
    {
        //Empty Constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_forecast,container,false);
        image = (ImageView)view.findViewById(R.id.image);
        image1 = (ImageView)view.findViewById(R.id.image1);
        image2 = (ImageView)view.findViewById(R.id.image2);
        image3 = (ImageView)view.findViewById(R.id.image3);
        start = (Button) view.findViewById(R.id.setAnim);

        final Animation fadeOut = AnimationUtils.loadAnimation(getActivity(), R.anim.fadeout);
        final Animation fadeOut2 = AnimationUtils.loadAnimation(getActivity(), R.anim.fadeout_anim);
        final Animation fadeOut3 = AnimationUtils.loadAnimation(getActivity(), R.anim.fadeout_anim);
        final Animation fadeIn = AnimationUtils.loadAnimation(getActivity(), R.anim.fadein_anim);
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        fadeOut3.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }
            @Override
            public void onAnimationEnd(Animation animation) {
                image3.setVisibility(View.GONE);

            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        fadeOut2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                image2.setVisibility(View.GONE);
                image3.startAnimation(fadeOut3);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        fadeOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                image1.setVisibility(View.GONE);
                image2.startAnimation(fadeOut2);

            }
            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });



        start.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onClick(View v) {
                Animation anim = new circularTranslateAnim(image,300);
                Animation anim2 = new circularTranslateAnim(image2,300);
                anim.setDuration(5000);
               // anim2.setDuration(4000);
                image.startAnimation(anim);
                image1.startAnimation(fadeOut);


            }
        });
        return  view;
    }
}
