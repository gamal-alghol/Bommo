package com.example.bamboo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bamboo.R;
import com.example.bamboo.fragment.MobileNumberFragment;

public class RegstrationActivity extends AppCompatActivity {
MobileNumberFragment mobileNumberFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regstration);
mobileNumberFragment=new MobileNumberFragment();


        getSupportFragmentManager().beginTransaction().replace(R.id.frame_login,mobileNumberFragment)
                .setCustomAnimations(R.anim.fromleft,R.anim.fromright)
                .commit();
    }
}