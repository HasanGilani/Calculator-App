package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val number1EditText: EditText = findViewById(R.id.number1)
        val number2EditText: EditText = findViewById(R.id.number2)
        val operationSpinner: Spinner = findViewById(R.id.operation)
        val calculateButton: Button = findViewById(R.id.calculate)
        val resultTextView: TextView = findViewById(R.id.result)

        calculateButton.setOnClickListener {
            val number1 = number1EditText.text.toString().toDoubleOrNull()
            val number2 = number2EditText.text.toString().toDoubleOrNull()
            val operation = operationSpinner.selectedItem.toString()

            if (number1 != null && number2 != null) {
                val result = when (operation) {
                    "Addition" -> number1 + number2
                    "Subtraction" -> number1 - number2
                    "Multiplication" -> number1 * number2
                    "Division" -> {
                        if (number2 != 0.0) {
                            number1 / number2
                        } else {
                            "Cannot divide by zero"
                        }
                    }
                    else -> "Invalid operation"
                }
                resultTextView.text = result.toString()
            } else {
                resultTextView.text = "Please enter valid numbers"
            }
        }
    }
}