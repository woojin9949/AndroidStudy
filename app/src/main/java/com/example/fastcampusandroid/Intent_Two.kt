package com.example.fastcampusandroid

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class Intent_Two : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_two)
        title = "dd"
        // Intent_Two 액티비티를 호출한 Activity의 intent이다
        val intent = intent
        val data: String? = intent.extras?.getString("extra")
        if (data != null) {
            Log.d("dataa", data)
        }
        val data2: Int? = intent.extras?.getInt("dd")
        
        (findViewById<TextView>(R.id.finish)).apply {
            setOnClickListener {
                val intent: Intent = Intent()
                intent.putExtra("result", "success")
                setResult(RESULT_OK, intent)
                //Intent 종료하면 다시 main으로 돌아감
                finish()
            }
        }

        val imageView: ImageView = findViewById<ImageView>(R.id.imageView)
        val uri: Uri
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            uri = Uri.parse(
                intent.getParcelableExtra(Intent.EXTRA_STREAM, Parcelable::class.java).toString()
            )
        } else {
            uri = Uri.parse(
                intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM).toString()
            )
        }
        imageView.setImageURI(uri)
    }
}