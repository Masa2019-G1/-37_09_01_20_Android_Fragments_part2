package com.telran.a09_01_20_cw_part2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WelcomeFragment fragment = new WelcomeFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.root,fragment,"WELCOME")
                .commit();
    }
}
