package com.example.collegeloginvalidation

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()
{

    lateinit var emailEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var validateButton: Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailEditText = findViewById(R.id.editEmail)
        passwordEditText = findViewById(R.id.editPassword)
        validateButton = findViewById(R.id.btnValidate)

        validateButton.setOnClickListener {

            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if(validateInput(email, password))
            {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun validateInput(email: String, password: String): Boolean
    {

        // i) Check empty fields
        if(email.isEmpty())
        {
            emailEditText.error = "Email cannot be empty"
            emailEditText.requestFocus()
            return false
        }

        if(password.isEmpty())
        {
            passwordEditText.error = "Password cannot be empty"
            passwordEditText.requestFocus()
            return false
        }

        // ii) College Email Validation (example: must end with .edu or college domain)
        val collegeEmailPattern = Regex("^[A-Za-z0-9._%+-]+@(.+)\\.edu$")

        if(!collegeEmailPattern.matches(email))
        {
            emailEditText.error = "Enter valid college email id (example@college.edu)"
            emailEditText.requestFocus()
            return false
        }

        // iii) Password Validation
        val passwordPattern =
            Regex("^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#\$%^&+=!]).{12,}$")

        if(!passwordPattern.matches(password))
        {
            passwordEditText.error =
                "Password must be 12 chars, include Uppercase, lowercase, number, special symbol"
            passwordEditText.requestFocus()
            return false
        }

        return true
    }
}