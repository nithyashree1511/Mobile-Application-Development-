package com.example.togglebutton

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toggle = findViewById<ToggleButton>(R.id.toggleButton)
        val message = findViewById<TextView>(R.id.textMessage)

        toggle.setOnCheckedChangeListener { _, isChecked ->

            if (isChecked) {
                message.visibility = View.VISIBLE
            } else {
                message.visibility = View.GONE
            }

        }
    }
}