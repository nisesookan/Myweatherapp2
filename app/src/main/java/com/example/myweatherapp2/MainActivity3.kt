package com.example.myweatherapp2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity



    class MainActivity3 : AppCompatActivity() {

        private lateinit var temperatureInputs: DoubleArray
        private lateinit var backButton: Button
        private lateinit var temperatureTextView: TextView
        private lateinit var averageTemperatureTextView: TextView

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContentView(R.layout.activity_main3)

            backButton = findViewById(R.id.backButton)
            temperatureTextView = findViewById(R.id.temperatureTextView)
            averageTemperatureTextView = findViewById(R.id.averageTemperatureTextView)

            // Fetch temperatureInputs from intent (only once)
            temperatureInputs = intent.getDoubleArrayExtra("screen_times") ?: DoubleArray(7)


            displayDetails()

            backButton.setOnClickListener {
                finish()
            }
        }

        private fun displayDetails() {
            val days = arrayOf(
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
            )


            temperatureTextView.text = buildString {
                // Use the actual temperatureInputs array
                for (i in temperatureInputs.indices) {
                    append("${days[i]}: ${temperatureInputs[i]}°C\n")
                }
            }

            val averageTemperature = temperatureInputs.average()
            averageTemperatureTextView.text =
                getString(R.string.average_screen_time_2f_hours_day).format(averageTemperature)
        }
    }
