package com.example.cp_4282_project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class UserGuide : ComponentActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the layout.
        setContentView(R.layout.activity_user_guide)
        // Set the buttons and their actions.
        val button4: Button = findViewById(R.id.userBackButton)
        button4.setOnClickListener {
            val intent = Intent()
            intent.setClass(this, MainActivity::class.java)
            startActivity(intent)
        }
        // This button is supposed to send the feedback to the database if there was one.
        val button5: Button = findViewById(R.id.feedBackButton)
        button5.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        // This is supposed to send the data to the database. Currently, it does nothing.
        val feedback: EditText = findViewById(R.id.userFeedbackdata)
        val feedbackSave: TextView = findViewById(R.id.userFeedbackConfirm)
        feedback.text.toString()
        feedbackSave.text = ("Thank you for your feedback!")

    }
}