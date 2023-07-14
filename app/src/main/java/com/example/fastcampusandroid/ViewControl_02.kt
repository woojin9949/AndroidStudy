package com.example.fastcampusandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class ViewControl_02 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_control02)

        val text1: TextView = findViewById(R.id.text1)
        val button1: Button = findViewById(R.id.button1)

        //Log.d("testt", text1.text.toString())

        //Listener 사용법
        button1.setOnClickListener {
            //버튼이 클릭되었을때 동작할 코드
            Log.d("testt", "버튼 클릭!!!")
        }

        //위에 람다식 사용하기 전 원형 형태 Full Version
        /*
        val clickListener = object : View.OnClickListener {
            override fun onClick(p0: View?) {
                Log.d("testt","버튼클릭!!")
            }
        }
        button1.setOnClickListener(clickListener)*/

        // 축약버전 1(익명함수)
        button1.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                Log.d("testt","버튼클릭!!")
            }
        })

        // 축약버전 2(람다버전)
        button1.setOnClickListener {
            Log.d("testt","버튼클릭!!")
        }
    }
}