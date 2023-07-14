package com.example.fastcampusandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Report_AddViewSecond : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_add_view_second)
        val intent = intent
        val nthPerson: String? = intent.extras?.getString("nthPerson")
        val nthNumber: String? = intent.extras?.getString("nthNumber")
        (findViewById<TextView>(R.id.mainText)).text = nthPerson + "\n" + nthNumber
    }
}