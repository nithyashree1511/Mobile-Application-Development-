package com.example.moviedetails;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

    Button btnBasic, btnAdditional;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBasic = findViewById(R.id.btnBasic);
        btnAdditional = findViewById(R.id.btnAdditional);

        btnBasic.setOnClickListener(v -> loadFragment(new MovieBasicFragment()));

        btnAdditional.setOnClickListener(v -> loadFragment(new MovieAdditionalFragment()));
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }
}