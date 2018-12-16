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
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    TextView textWeloome;
    ImageButton exit;
    Button AboutUs;
    Toolbar toolbar;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textWeloome = findViewById(R.id.welcomeHome);
        toolbar = findViewById(R.id.toolbarHome);
        AboutUs = findViewById(R.id.buttonAbout);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        exit = findViewById(R.id.btnLogout);
        sharedPreferences = getSharedPreferences("dataUser", Context.MODE_PRIVATE);

        textWeloome.setText("Welcome " +sharedPreferences.getString("username", "null"));

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(HomeActivity.this, ItemActivity.class);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", "null");
                editor.commit();
                startActivity(i);
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
}
