package com.example.checkbox

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pizza = findViewById<CheckBox>(R.id.checkPizza)
        val burger = findViewById<CheckBox>(R.id.checkBurger)
        val coffee = findViewById<CheckBox>(R.id.checkCoffee)
        val bill = findViewById<Button>(R.id.btnBill)

        bill.setOnClickListener {

            var total = 0

            if (pizza.isChecked) total += 150
            if (burger.isChecked) total += 120
            if (coffee.isChecked) total += 80

            Toast.makeText(this, "Total Bill = ₹$total", Toast.LENGTH_LONG).show()
        }
    }
}