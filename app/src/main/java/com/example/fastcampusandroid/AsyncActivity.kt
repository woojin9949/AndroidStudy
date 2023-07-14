package com.example.fastcampusandroid

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView

class AsyncActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)
        var count: Int = 0
        val backgroundTask = BackgroundAsyncTask(
            findViewById(R.id.progressBar), findViewById(R.id.progressBarText)
        )
        findViewById<TextView>(R.id.start).setOnClickListener {
            backgroundTask.execute()
        }
        findViewById<TextView>(R.id.stop).setOnClickListener {
            backgroundTask.cancel(true)
        }
        findViewById<TextView>(R.id.shoot).setOnClickListener {
            count++
            Log.d("testt", "" + count)
            findViewById<TextView>(R.id.shoot).text = count.toString()
        }
    }
}

class BackgroundAsyncTask(
    val progressBar: ProgressBar, val progressText: TextView
) : AsyncTask<Int, Int, Int>() {
    //Params, Progress, Result
    //Params -> doInBackground에서 사용할 타입
    //Progress -> onProgressUpdate에서 사용할 타입
    //Result -> onPostExecute에서 사용할 타입

    //deprecated
    // RxJava, coroutine
    // 코루틴 -> 멀티 태스킹, 동기/ 비동기 처리
    var percent: Int = 0

    override fun doInBackground(vararg p0: Int?): Int {
        while (isCancelled() == false) {
            percent++
            if (percent > 100) break
            else {
                publishProgress(percent)
            }
            Thread.sleep(100)
        }
        return percent
    }

    override fun onPreExecute() {
        percent = 0
        progressBar.progress = percent
    }

    override fun onPostExecute(result: Int?) {
        progressText.text = "작업이 완료되었습니다"
    }

    override fun onProgressUpdate(vararg values: Int?) {
        progressBar.progress = values[0] ?: 0 //non-null일경우 values[0], null일경우 0 리턴
        progressText.text = "퍼센트 : " + values[0]
        super.onProgressUpdate(*values)
    }

    override fun onCancelled() {
        progressBar.progress = 0
        progressText.text = "작업이 취소되었습니다."
    }
}