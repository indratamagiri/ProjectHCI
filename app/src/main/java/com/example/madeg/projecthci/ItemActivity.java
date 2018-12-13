package com.example.madeg.projecthci;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


public class ItemActivity extends AppCompatActivity {

   TabLayout tabLayout;
    ViewPager viewPager;
    viewPagerAdapter adapter;
    ImageButton btnBack;
//
//    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_item);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        btnBack = findViewById(R.id.btnBack);
        adapter = new viewPagerAdapter(getSupportFragmentManager());

        adapter.add(new AllBreadFragment(), "All Bread");
        adapter.add(new PopularFragment(), "Popular Bread");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //@Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    //@Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.login:
//                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
//
//                i.putExtra("message", "Hello");
//                startActivity(i);
//                break;
//            case R.id.tost:
//                Toast.makeText(getApplicationContext(), "Menu Clicked", Toast.LENGTH_SHORT).show();
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
