package com.example.uservalidationapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username = findViewById<EditText>(R.id.editUsername)
        val id = findViewById<EditText>(R.id.editID)
        val button = findViewById<Button>(R.id.buttonValidate)

        button.setOnClickListener {

            val name = username.text.toString()
            val userId = id.text.toString()

            if (name.isEmpty() || userId.isEmpty())
                Toast.makeText(this,"Fields cannot be empty",Toast.LENGTH_SHORT).show()

            else if (!name.matches(Regex("^[a-zA-Z]+$")))
                Toast.makeText(this,"Name must contain alphabets only",Toast.LENGTH_SHORT).show()

            else if (!userId.matches(Regex("^\\d{4}$")))
                Toast.makeText(this,"ID must be exactly 4 digits",Toast.LENGTH_SHORT).show()

            else
                Toast.makeText(this,"Validation Successful",Toast.LENGTH_SHORT).show()
        }
    }
}