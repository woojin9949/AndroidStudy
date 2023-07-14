package com.example.fastcampusandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class GildeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gilde)
        val image = findViewById<ImageView>(R.id.image)
        Glide.with(this)
            .load("https://upload.wikimedia.org/wikipedia/commons/6/65/Matterhorn-EastAndNorthside-viewedFromZermatt_landscapeformat-2.jpg")
            .fitCenter()
            .into(image)

    }
}