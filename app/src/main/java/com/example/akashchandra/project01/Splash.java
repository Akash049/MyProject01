package com.example.akashchandra.project01;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by Akash Chandra on 13-11-2016.
 */

public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash);
        Typeface newfont = Typeface.createFromAsset(getAssets(),"font/courgette_regular.ttf");

        TextView appName = (TextView)findViewById(R.id.app_name);
        appName.setTypeface(newfont);
        Thread timer = new Thread()
        {
            public void run()
            {
                try{
                    // This is to make the thread sleep for 3sec
                    sleep(2000);

                    //Then start the activity
                    startActivity(new Intent(Splash.this,MainActivity.class));

                    // Remove this activity
                    finish();

                }
                catch (Exception e){

                }
            }
        };
        timer.start();
    }

    @Override
    protected void onPause() {
        finish();
    }
}

