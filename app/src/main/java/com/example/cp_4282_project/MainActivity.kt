package com.example.cp_4282_project

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.Button
import android.view.View
import android.widget.EditText


// NOTE: due to the fact that I was unable to do the database part of the project many functionality's could not be done
// such as the validity check and the feedback. also, I could not have more than one entry because of this.

class MainActivity : ComponentActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the layout as the team roster which is the main page.
        setContentView(R.layout.team_roster)
        // Call the two buttons to be used for setting the data and changing the page.
        val button1: Button = findViewById(R.id.teamButton)
        val button2: Button = findViewById(R.id.InfoPage)
        // Set the two buttons for changing between pages.
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
        // This button activates the onClick override
        val button3: Button = findViewById(R.id.updateButton)
        button3.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        // This was an attempt to do the validity check. However, I ran into an issue where it
        // throws an error where it states Int cannot be compared to a Int.Companion and I have no
        // clue what is happening
        // It was supposed to see if the data given was an Int. If it is not then it would return an error.
//        val goals: EditText = findViewById(R.id.player1Goals)
//        val totalMinutes: EditText = findViewById(R.id.player1TotalMinutes)
//        val totalGoals: EditText = findViewById(R.id.player1TotalGoals)
//        val recentForm: EditText = findViewById(R.id.player1RecentForm)
//        val goals1 = goals.text.toString().toInt()
//        val totalMinutes1 = totalMinutes.text.toString().toInt()
//        if (goals1 == Int) {
//            return goals.text = goals
//        } else if (totalMinutes == Int) {
//            return totalMinutes
//        } else if (totalGoals == Int) {
//            return totalGoals
//        } else if (recentForm == Int) {
//            return recentForm
//        }

    }

}