package com.example.fastcampusandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Activity_01 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) { // savedInstanceState => 사용자가 이전 상태를 복원하거나 저장하기위해 사용되는 파라미터
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_01)
        // 한번만 하면 되는 작업
        Log.d("LifeCycle","onCreate")
    }
    override fun onStart() {
        Log.d("LifeCycle","onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("LifeCycle","onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("LifeCycle","onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("LifeCycle","onStop")
        super.onStop()
        //이때 뭐 예를 들어 백그라운드에서 노래재생을 계속 하게끔 설정 Youtube
    }

    override fun onRestart() {
        Log.d("LifeCycle","onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.d("LifeCycle","onDestroy")
        super.onDestroy()
    }
}