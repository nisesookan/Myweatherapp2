package com.example.myweatherapp2

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var clearButton: Button
    private lateinit var nextButton: Button
    private lateinit var mondayWeather: EditText
    private lateinit var tuesdayWeather: EditText
    private lateinit var wednesdayWeather: EditText
    private lateinit var thursdayWeather: EditText
    private lateinit var fridayWeather: EditText
    private lateinit var saturdayWeather: EditText
    private lateinit var sundayWeather: EditText

    private lateinit var inputs: Array<EditText>
    private var temperatureInputs: DoubleArray = DoubleArray(7)

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)

        clearButton = findViewById(R.id.clearButton)
        nextButton = findViewById(R.id.nextButton)
        mondayWeather = findViewById(R.id.mondayWeather)
        tuesdayWeather = findViewById(R.id.tuesdayWeather)
        wednesdayWeather = findViewById(R.id.wednesdayWeather)
        thursdayWeather = findViewById(R.id.thursdayWeather)
        fridayWeather = findViewById(R.id.fridayWeather)
        saturdayWeather = findViewById(R.id.saturdayWeather)
        sundayWeather = findViewById(R.id.sundayWeather)

        inputs = arrayOf(
            mondayWeather,
            tuesdayWeather,
            wednesdayWeather,
            thursdayWeather,
            fridayWeather,
            saturdayWeather,
            sundayWeather
        )

        clearButton.setOnClickListener {
            clearInputs()
        }

        nextButton.setOnClickListener {
            if (validateInputs()) {
                temperatureInputs = inputs.map { it.text.toString().toDouble() }.toDoubleArray()

                val intent = Intent(this, MainActivity3::class.java)
                intent.putExtra("temperatureInputs", temperatureInputs)
                startActivity(intent)

            } else {
                Toast.makeText(this, "Please enter valid numbers for all days.", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }


    private fun clearInputs() {
        inputs.forEach { it.text.clear() }
    }

    private fun validateInputs(): Boolean {
        return !inputs.any { it.text.isEmpty() || it.text.toString().toDoubleOrNull() == null }
    }
}

