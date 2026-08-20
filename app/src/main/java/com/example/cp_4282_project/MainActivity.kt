package com.example.cp_4282_project

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.Button
import android.view.View

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.team_roster)
        val button1: Button = findViewById(R.id.teamButton)
        val button2: Button = findViewById(R.id.InfoPage)
        button1.setOnClickListener {
            val intent1 = Intent()
            intent1.setClass(this, PlayerCard::class.java)
            startActivity(intent1)
        }
        button2.setOnClickListener {
            val intent2 = Intent()
            intent2.setClass(this, UserGuide::class.java)
            startActivity(intent2)
        }
    }
//    @Entity(tableName = "players")
//    data class Player {
//        @PrimaryKey(autoGenerate = true) val _name: String,
//        @ColumnInfo(goals = "goals") val goals: Int,
//                val name: String
//    @Dao
//    interface PlayersDao {
//        @Query("SELECT * FROM players")
//        fun getALL(): Array<Player>
//
//        @Insert
//        fun insert(vararg player : Player)
//
//        @Update
//        fun update(color: Player)
//
//        @Delete
//        fun delete(player: Player)
//
//    }
}
