package com.example.cp_4282_project

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.TextView
import android.widget.Button
import android.view.View
import android.widget.EditText
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

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

    class MyDatabaseHelper(context: Context) :
        SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

        companion object {
            private const val DATABASE_NAME = "Player.db"
            private const val DATABASE_VERSION = 1
            const val TABLE_NAME = "players"
            const val COL_ID = "id"
            const val COL_NAME = "PlayerName"
        }

        // Called the first time the database is accessed
        override fun onCreate(db: SQLiteDatabase?) {
            val createTableQuery = "CREATE TABLE $TABLE_NAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COL_NAME TEXT)"
            db?.execSQL(createTableQuery)
        }

        // Called when the database version changes
        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
            onCreate(db)
        }

        fun insertUser(context: Context, name: String) {
            val dbHelper = MyDatabaseHelper(context)
            val db = dbHelper.writableDatabase // Open for writing

            val values = ContentValues().apply {
                put(MyDatabaseHelper.COL_NAME, name)
            }

            db.insert(MyDatabaseHelper.TABLE_NAME, null, values)
            db.close() // Always close connections
        }

        fun readUsers(context: Context): List<String> {
            val userList = mutableListOf<String>()
            val dbHelper = MyDatabaseHelper(context)
            val db = dbHelper.readableDatabase // Open for reading

            val cursor = db.rawQuery("SELECT * FROM ${MyDatabaseHelper.TABLE_NAME}", null)

            if (cursor.moveToFirst()) {
                do {
                    val name = cursor.getString(cursor.getColumnIndexOrThrow(MyDatabaseHelper.COL_NAME))
                    userList.add(name)
                } while (cursor.moveToNext())
            }
            cursor.close() // Close the cursor to prevent memory leaks
            db.close()
            return userList
        }

        // Update action
        fun updateUser(context: Context, id: Int, newName: String) {
            val db = MyDatabaseHelper(context).writableDatabase
            val values = ContentValues().apply { put(MyDatabaseHelper.COL_NAME, newName) }

            db.update(MyDatabaseHelper.TABLE_NAME, values, "${MyDatabaseHelper.COL_ID}=?", arrayOf(id.toString()))
            db.close()
        }

        // Delete action
        fun deleteUser(context: Context, id: Int) {
            val db = MyDatabaseHelper(context).writableDatabase
            db.delete(MyDatabaseHelper.TABLE_NAME, "${MyDatabaseHelper.COL_ID}=?", arrayOf(id.toString()))
            db.close()
        }



    }

}