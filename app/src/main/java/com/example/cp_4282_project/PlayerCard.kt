package com.example.cp_4282_project

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class PlayerCard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the layout for this page.
        setContentView(R.layout.activity_player_card)
        // Set the value for the button and have it return to the main page.
        val button3: Button = findViewById(R.id.playerBackButton)
        button3.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}