package com.example.fastcampusandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        val currentThread = Thread.currentThread()
        Log.d("testt", "" + currentThread)

//        Thread {
//            for (a in 1..50) {
//                Log.d("testt", "A" + a)
//            }
//        }.start()
//
//        Thread {
//            for (a in 1..50) {
//                Log.d("testt", "B" + a)
//            }
//        }.start()

        Thread {
            val currentThread = Thread.currentThread()
            Log.d("testt", "A" + currentThread)
            //findViewById<TextView>(R.id.text1).text = "changed"
            //UI관련 작업을 메인Thread가 아닌 다른 Thread에서 하려고하면 해당 작업 메인Thread의 Queue로 들어간다
            // -> 에러가 발생하지 않을 수 있다
            runOnUiThread {
                findViewById<TextView>(R.id.text1).text = "changed"
            }
        }.start()
    }
}