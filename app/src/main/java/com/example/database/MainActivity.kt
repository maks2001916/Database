package com.example.database

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var titleTV: TextView
    private lateinit var startBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        init()

        startBTN.setOnClickListener {
            var intent = Intent(this, DataBaseActivity::class.java)
            startActivity(intent)
         }

    }

    //Инициализация объектов
    private fun init() {
        titleTV = findViewById(R.id.appNameTV)
        startBTN = findViewById(R.id.openDbBTN)
    }
}