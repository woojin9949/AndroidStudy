package com.example.fastcampusandroid

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log

class MasterApplication : Application() {
    //앱이 살아있는동안 유지되므로 관리하고 싶은것들을 진행하면 좋다 (Manifest에서 설정) 복잡한 프로젝트에서 사용하면좋음
    val userId: Int = 1000
    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(p0: Activity, p1: Bundle?) {
                Log.d("testt", "onActivityCreated")
            }

            override fun onActivityStarted(p0: Activity) {
                Log.d("testt", "onActivityStarted")
            }

            override fun onActivityResumed(p0: Activity) {
                Log.d("testt", "onActivityResumed")
            }

            override fun onActivityPaused(p0: Activity) {
                Log.d("testt", "onActivityPaused")
            }

            override fun onActivityStopped(p0: Activity) {
                Log.d("testt", "onActivityStopped")
            }

            override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
                Log.d("testt", "onActivitySaveInstanceState")
            }

            override fun onActivityDestroyed(p0: Activity) {
                Log.d("testt", "onActivityDestroyed")
            }
        })


    }

    fun methodFromApplication() {
        Log.d("testt", "methodFromApplication")
    }
}