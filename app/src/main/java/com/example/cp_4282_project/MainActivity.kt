package com.example.cp_4282_project

import android.annotation.SuppressLint
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
//        setContentView(R.layout.player_card)
//        setContentView(R.layout.user_guide)
        val button1: Button = findViewById(R.id.teamButton)
        button1.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

    }
}