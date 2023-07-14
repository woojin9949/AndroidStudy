package com.example.fastcampusandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat

class Report_addView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_add_view)
        val personList = mutableListOf<Person>()
        for (i in 0..20) {
            personList.add(Person("" + i + "번째사람", "010-1111-111${i}"))
        }
        val container = findViewById<LinearLayoutCompat>(R.id.container)
        val inflater = LayoutInflater.from(this@Report_addView)
        personList.forEach {
            val personItemView = inflater.inflate(R.layout.report_addview, null)
            val personImage = personItemView.findViewById<ImageView>(R.id.personImage)
            personImage.setImageDrawable(resources.getDrawable(R.drawable.dog, this.theme))
            val nthPerson = personItemView.findViewById<TextView>(R.id.nthPerson)
            val nthNumber = personItemView.findViewById<TextView>(R.id.nthNumber)
            nthPerson.text = it.nthPerson
            nthNumber.text = it.nthNumber
            container.addView(personItemView)
            personItemView.setOnClickListener {
                val intent = Intent(this@Report_addView, Report_AddViewSecond::class.java)
                intent.putExtra("nthPerson", nthPerson.text)
                intent.putExtra("nthNumber", nthNumber.text)
                startActivity(intent)
            }
        }
    }
}

class Person(val nthPerson: String, val nthNumber: String)