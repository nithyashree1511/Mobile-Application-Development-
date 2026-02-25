package com.example.tempconv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TempConverterApp()
        }
    }
}

@Composable
fun TempConverterApp() {

    // These variables remember what the user typed and the result
    var inputTemp by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf("Result will appear here") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF0F4F8)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // Title
            Text(
                text = "🌡️ Temperature Converter",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1A237E),
                modifier = Modifier.padding(bottom = 32.dp)
            )

            // Input Field
            OutlinedTextField(
                value = inputTemp,
                onValueChange = { inputTemp = it },
                label = { Text("Enter temperature") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                singleLine = true
            )

            // Celsius to Fahrenheit Button
            Button(
                onClick = {
                    val input = inputTemp.toDoubleOrNull()
                    if (input == null) {
                        resultText = "⚠️ Please enter a valid number!"
                    } else {
                        val fahrenheit = (input * 9 / 5) + 32
                        resultText = "%.2f °C  =  %.2f °F".format(input, fahrenheit)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1565C0))
            ) {
                Text("Celsius → Fahrenheit", fontSize = 16.sp)
            }

            // Fahrenheit to Celsius Button
            Button(
                onClick = {
                    val input = inputTemp.toDoubleOrNull()
                    if (input == null) {
                        resultText = "⚠️ Please enter a valid number!"
                    } else {
                        val celsius = (input - 32) * 5 / 9
                        resultText = "%.2f °F  =  %.2f °C".format(input, celsius)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0277BD))
            ) {
                Text("Fahrenheit → Celsius", fontSize = 16.sp)
            }

            // Result Card
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Text(
                    text = resultText,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1B5E20),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                )
            }
        }
    }
}