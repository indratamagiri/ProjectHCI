package com.example.madeg.projecthci;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class HomeActivity extends AppCompatActivity {
    TextView textWeloome;
    ImageButton exit;
    Button AboutUs;
    Toolbar toolbar;
    SharedPreferences sharedPreferences;
    ViewFlipper viewFlipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textWeloome = findViewById(R.id.welcomeHome);
        toolbar = findViewById(R.id.toolbarHome);
        AboutUs = findViewById(R.id.buttonAbout);
        viewFlipper = findViewById(R.id.flipper);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        exit = findViewById(R.id.btnLogout);
        sharedPreferences = getSharedPreferences("dataUser", Context.MODE_PRIVATE);

        textWeloome.setText("Welcome " +sharedPreferences.getString("username", "null"));

        int images[] = {R.drawable.crazy_dough_stuffed_bread, R.drawable.french_bread, R.drawable.white_bread, R.drawable.scali_bread};

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", "null");
                editor.commit();
                finish();
            }
        });

        AboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, InfoActivity.class);
                startActivity(i);
            }
        });

        for (int image: images){
            flipperImage(image);
        }
        viewFlipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(HomeActivity.this, ItemActivity.class);
                startActivity(i);
            }
        });
    }

    public void flipperImage(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}
