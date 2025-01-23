package com.example.database

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.annotation.SuppressLint
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginTop

class DataBaseActivity : AppCompatActivity() {

    private val db = DBHelper(this, null)

    private var postList = mutableListOf(
        "Начальник производства",
        "Главный инженер",
        "Главный технолог",
        "Главный механик",
        "Главный энергетик",
        "Главный сварщик",
        "Начальник участка",
        "Начальник цеха (участка)",
        "Производитель работ (прораб)",
        "Бригадир на производстве"
    )

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

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_data_base)

        init()

        saveDataBTN.setOnClickListener {
            val name = nameET.text.toString()
            val post = postACTV.text.toString()
            val number = numberET.text.toString()
            db.addName(name, post, number)
            Toast.makeText(this, "$name, $post и $number добавлены в базу данных", Toast.LENGTH_LONG).show()
            nameET.text.clear()
            postACTV.text.clear()
            numberET.text.clear()
        }
        getDataBTN.setOnClickListener {
            val cursor = db.getInfo()
            if (cursor != null && cursor.moveToFirst()) {
                cursor.moveToFirst()
                nameTV.append(cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME)) + "\n")
                postTV.append(cursor.getString(cursor.getColumnIndex(DBHelper.KEY_POST)) + "\n")
                numberTV.append(cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NUMBER)) + "\n")
            }
            while (cursor!!.moveToNext()) {
                nameTV.append(cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NAME)) + "\n")
                postTV.append(cursor.getString(cursor.getColumnIndex(DBHelper.KEY_POST)) + "\n")
                numberTV.append(cursor.getString(cursor.getColumnIndex(DBHelper.KEY_NUMBER)) + "\n")
            }
            cursor.close()
        }
        deleteDataBTN.setOnClickListener {
            db.removeAll()
            nameTV.text = ""
            postTV.text = ""
            numberTV.text = ""
        }

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
        var adapter = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            postList
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        postACTV.setAdapter(adapter)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.db_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {R.id.exit -> finishAffinity() }
        return super.onOptionsItemSelected(item)
    }
}