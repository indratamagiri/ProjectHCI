package com.example.madeg.projecthci;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView name, des;
    ImageView imageView;
    ImageButton btnBack, logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        name = findViewById(R.id.DetailName);
        des = findViewById(R.id.DetailDes);
        imageView = findViewById(R.id.DetailImage);
        btnBack = findViewById(R.id.btnBack);
        logout = findViewById(R.id.btnLogout);

        Intent intent = getIntent();
        String itemName = intent.getStringExtra("NAME_ITEM") ;
        name.setText(itemName);
        Integer image = intent.getIntExtra("ITEM_IMAGE", 0);
        imageView.setImageResource(image);
        String detail = intent.getStringExtra("ITEM_DES");
        des.setText(detail);

        final SharedPreferences sharedPreferences = getSharedPreferences("dataUser", Context.MODE_PRIVATE);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", "null");
                editor.commit();
                Intent i = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
