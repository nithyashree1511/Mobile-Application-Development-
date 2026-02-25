package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var number1EditText: EditText
    lateinit var number2EditText: EditText
    lateinit var resultTextView: TextView

    lateinit var addButton: Button
    lateinit var subtractButton: Button
    lateinit var multiplyButton: Button
    lateinit var divideButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        number1EditText = findViewById(R.id.editTextNumber1)
        number2EditText = findViewById(R.id.editTextNumber2)
        resultTextView = findViewById(R.id.textViewResult)

        addButton = findViewById(R.id.buttonAdd)
        subtractButton = findViewById(R.id.buttonSubtract)
        multiplyButton = findViewById(R.id.buttonMultiply)
        divideButton = findViewById(R.id.buttonDivide)

        addButton.setOnClickListener {
            calculate("+")
        }

        subtractButton.setOnClickListener {
            calculate("-")
        }

        multiplyButton.setOnClickListener {
            calculate("*")
        }

        divideButton.setOnClickListener {
            calculate("/")
        }
    }

    private fun calculate(operator: String) {

        val num1Text = number1EditText.text.toString()
        val num2Text = number2EditText.text.toString()

        if (num1Text.isEmpty() || num2Text.isEmpty()) {
            Toast.makeText(this, "Enter both numbers", Toast.LENGTH_SHORT).show()
            return
        }

        val num1 = num1Text.toDouble()
        val num2 = num2Text.toDouble()

        val result = when (operator) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> {
                if (num2 == 0.0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                    return
                }
                num1 / num2
            }
            else -> 0.0
        }

        resultTextView.text = "Result: $result"
    }
}