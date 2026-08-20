package com.example.cp_4282_project

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.TextView
import android.widget.Button
import android.view.View
import android.widget.EditText

class MainActivity : ComponentActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.team_roster)
        val button1: Button = findViewById(R.id.teamButton)
        val button2: Button = findViewById(R.id.InfoPage)
        button1.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, PlayerCard::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, UserGuide::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(v: View?) {

    }
}