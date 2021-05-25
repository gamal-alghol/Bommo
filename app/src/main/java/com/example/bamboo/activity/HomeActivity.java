package com.example.bamboo.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bamboo.R;
import com.example.bamboo.fragment.CategoriesFragment;
import com.example.bamboo.fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        createNavigationView();
    }
    private void createNavigationView() {
        navigationView=findViewById(R.id.bottom_navigation);
        navigationView.performClick();

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_home,new HomeFragment()).commit();
                        return true;

                    case R.id.action_categories:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_home,new CategoriesFragment(HomeActivity.this)).commit();
                        return true;

                }
                return false;
            }
        });
        navigationView.setSelectedItemId(R.id.action_home);

    }

}