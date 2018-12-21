package com.example.madeg.projecthci;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {
    TextView textWeloome;
    ImageButton exit;
    Button AboutUs;
    Toolbar toolbar;
    SharedPreferences sharedPreferences;
    ViewPager viewPager;
    ViewAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textWeloome = findViewById(R.id.welcomeHome);
        toolbar = findViewById(R.id.toolbarHome);
        AboutUs = findViewById(R.id.buttonAbout);
        viewPager = findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewAdapter(getApplicationContext());
        viewPager.setAdapter(viewPagerAdapter);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTask(), 3000, 3000);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        exit = findViewById(R.id.btnLogout);
        sharedPreferences = getSharedPreferences("dataUser", Context.MODE_PRIVATE);

        textWeloome.setText("Welcome " +sharedPreferences.getString("username", "null"));


        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", "null");
                editor.commit();
                finishAffinity();
            }
        });

        AboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, InfoActivity.class);
                startActivity(i);
            }
        });


    }

    class MyTask extends TimerTask {

        @Override
        public void run() {
            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                    }else if(viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                    }else if(viewPager.getCurrentItem() == 2){
                        viewPager.setCurrentItem(3);
                    }else if(viewPager.getCurrentItem() == 3){
                        viewPager.setCurrentItem(4);
                    }else {
                        viewPager.setCurrentItem(0);
                    }

                }
            });
        }
    }
}
