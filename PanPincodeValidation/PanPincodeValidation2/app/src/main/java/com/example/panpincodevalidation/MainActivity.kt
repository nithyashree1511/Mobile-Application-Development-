package com.example.panpincodevalidation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var panEditText: EditText
    lateinit var pincodeEditText: EditText
    lateinit var validateButton: Button
    lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        panEditText = findViewById(R.id.editTextPAN)
        pincodeEditText = findViewById(R.id.editTextPincode)
        validateButton = findViewById(R.id.buttonValidate)
        resultTextView = findViewById(R.id.textViewResult)

        validateButton.setOnClickListener {

            val pan = panEditText.text.toString().trim()
            val pincode = pincodeEditText.text.toString().trim()

            // Check empty fields
            if (pan.isEmpty() || pincode.isEmpty()) {
                resultTextView.text = "Fields cannot be empty"
                return@setOnClickListener
            }

            // PAN validation: exactly 10 alphanumeric characters
            val panPattern = Regex("^[A-Za-z0-9]{10}$")
            if (!panPattern.matches(pan)) {
                resultTextView.text = "Invalid PAN Card Number"
                return@setOnClickListener
            }

            // Pincode validation: exactly 6 digits
            val pinPattern = Regex("^[0-9]{6}$")
            if (!pinPattern.matches(pincode)) {
                resultTextView.text = "Invalid Pincode"
                return@setOnClickListener
            }

            // If both valid
            resultTextView.text = "PAN and Pincode are valid"
        }
    }
}