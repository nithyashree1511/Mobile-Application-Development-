package com.example.randomnumbers

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity()
{
    lateinit var minEdit: EditText
    lateinit var maxEdit: EditText
    lateinit var generateBtn: Button
    lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        minEdit = findViewById(R.id.editMin)
        maxEdit = findViewById(R.id.editMax)
        generateBtn = findViewById(R.id.btnGenerate)
        resultText = findViewById(R.id.textResult)

        generateBtn.setOnClickListener {

            val minStr = minEdit.text.toString()
            val maxStr = maxEdit.text.toString()

            if (minStr.isEmpty() || maxStr.isEmpty())
            {
                Toast.makeText(this, "Please enter both values", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val min = minStr.toInt()
            val max = maxStr.toInt()

            if (min >= max)
            {
                Toast.makeText(this, "Min must be less than Max", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val randomNumber = Random.nextInt(min, max + 1)

            resultText.text = "Random Number: $randomNumber"
        }
    }
}