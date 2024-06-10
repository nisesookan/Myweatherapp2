package com.example.myweatherapp2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)


            // Handle edge-to-edge after setting content view (if applicable)
            enableEdgeToEdge()

            Handler(Looper.getMainLooper()).postDelayed({
                val intent = Intent(this, Login::class.java)
                startActivity(intent)
                finish() // Close the splash screen activity
            }, 3000) // 3000 milliseconds (3 seconds) delay
        }

        // ... (Your enableEdgeToEdge() function if needed)
    }

    class Login {

    }