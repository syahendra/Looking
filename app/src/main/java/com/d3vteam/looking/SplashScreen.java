package com.d3vteam.looking;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.d3vteam.looking.activity.login;

import gr.net.maroulis.library.EasySplashScreen;

/**
 * Created by Syahbana on 5/18/2017.
 */

public class SplashScreen extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(login.class)
                .withBackgroundColor(Color.parseColor("#26A69A"))
                .withSplashTimeOut(2000)
                .withLogo(R.drawable.logoo)
                .withHeaderText("Selamat Datang")
                .withFooterText("Copyrigth 2017");
        //set Text color
        config.getHeaderTextView().setTextColor(android.graphics.Color.WHITE);
        config.getFooterTextView().setTextColor(android.graphics.Color.WHITE);

        //set to view
        View view = config.create();

        //set view to content view
        setContentView(view);
    }
}



