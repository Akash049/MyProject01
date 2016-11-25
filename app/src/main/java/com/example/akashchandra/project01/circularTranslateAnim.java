package com.example.akashchandra.project01;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by Akash Chandra on 17-11-2016.
 */

public class circularTranslateAnim  extends Animation {
    private View view;
    private View pview;
    private View altView;
    private float cx, cy;           // center x,y position of circular path
    private float prevX, prevY;     // previous x,y position of image during animation
    private float r;                // radius of circle
    private float prevDx, prevDy;


    /**
     * @param view - View that will be animated
     * @param r - radius of circular path
     */
    public circularTranslateAnim(View view, float r) {
        this.view = view;
        this.r = r;
    }

    @Override
    public boolean willChangeBounds() {
        return true;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        // calculate position of image center
        int cxImage = width / 2;
        int cyImage = height / 2;
        cx = view.getLeft() + cxImage;
        cy = view.getTop() + cyImage;

        // set previous position to center
        prevX = cx+r;
        prevY = cy; // To set the previous position as the starting position of the loop
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        if(interpolatedTime == 0){
            t.getMatrix().setTranslate(prevDx, prevDy);
            return;
        }

        //Here change the value of angle "180f" t0 set the amount of movement
        float angleDeg = (interpolatedTime * 180f ) % 360;
        float angleRad = (float) Math.toRadians(angleDeg);



        // r = radius, cx and cy = center point, a = angle (radians)
        float x = (float) (cx + r * Math.cos(angleRad));
        float y = (float) (cy + r * Math.sin(angleRad));


        float dx = prevX - x;
        float dy = prevY - y;

        //prevX = x;
        //prevY = y;

        prevDx = dx;
        prevDy = dy;


        t.getMatrix().setTranslate(dx, dy);

        prevX = dx ;
        prevY = dy;


    }
}
