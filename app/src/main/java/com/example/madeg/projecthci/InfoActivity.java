package com.example.madeg.projecthci;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toolbar;

public class InfoActivity extends AppCompatActivity {
    android.support.v7.widget.Toolbar toolbar;
    ImageButton exit, back;
    Button feedback;
    EditText inputFeedback;
    AlertDialog.Builder alertBuilder;
    String mes="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        toolbar = findViewById(R.id.toolbarAbout);
        exit = findViewById(R.id.btnLogout);
        back = findViewById(R.id.btnBack);
        feedback = findViewById(R.id.BtnFeedBack);
        inputFeedback = findViewById(R.id.edit_text);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = inputFeedback.getText().toString();
                if (input.length() < 25){
                    mes = "Feedback more that 25";
                }else{
                    mes = "Thank you for your feedback";
                }

                alertBuilder = new AlertDialog.Builder(InfoActivity.this);
                alertBuilder.setMessage(mes);
                alertBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertBuilder.show();
            }
        });
    }
}
