package com.example.studentfragmentapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btnBasic: Button
    lateinit var btnMark: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBasic = findViewById(R.id.btnBasic)
        btnMark = findViewById(R.id.btnMark)

        btnBasic.setOnClickListener {

            val fragment = StudentBasicFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }

        btnMark.setOnClickListener {

            val fragment = StudentMarkFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
        }
    }
}