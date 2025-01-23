package com.example.database

import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DataBaseActivity : AppCompatActivity() {

    private lateinit var toolbarTB: Toolbar
    private lateinit var nameET: EditText
    private lateinit var postACTV: AutoCompleteTextView
    private lateinit var numberET: EditText
    private lateinit var saveDataBTN: Button
    private lateinit var getDataBTN: Button
    private lateinit var deleteDataBTN: Button
    private lateinit var nameTitleTV: TextView
    private lateinit var postTitleTV: TextView
    private lateinit var numberTitleTV: TextView
    private lateinit var nameTV: TextView
    private lateinit var postTV: TextView
    private lateinit var numberTV: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_data_base)

        init()



    }

    private fun init() {
        toolbarTB = findViewById(R.id.toolbarDbTB)
        nameET = findViewById(R.id.nameET)
        postACTV = findViewById(R.id.postACTV)
        numberET = findViewById(R.id.numberET)
        saveDataBTN = findViewById(R.id.saveDataBTN)
        getDataBTN = findViewById(R.id.getDataBTN)
        deleteDataBTN = findViewById(R.id.deleteDataBTN)
        nameTitleTV = findViewById(R.id.nameTitleTV)
        postTitleTV = findViewById(R.id.postTitleTV)
        numberTitleTV = findViewById(R.id.numberTitleTV)
        nameTV = findViewById(R.id.nameTV)
        postTV = findViewById(R.id.poatTV)
        numberTV = findViewById(R.id.numberTV)
        setSupportActionBar(toolbarTB)
    }
}