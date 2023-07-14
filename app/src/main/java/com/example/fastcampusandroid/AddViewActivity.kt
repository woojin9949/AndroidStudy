package com.example.fastcampusandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat

class AddViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_view)

        val carList = mutableListOf<Car>()
        for (i in 0..10) {
            carList.add(Car("" + i + "번째 자동차", "" + i + "번째 엔진"))
        }
        val container = findViewById<LinearLayoutCompat>(R.id.container)
        val inflater = LayoutInflater.from(this@AddViewActivity)
        carList.forEach {
            //xml 가져오기
            val carItemView = inflater.inflate(R.layout.car_item, null)
            val carImage = carItemView.findViewById<ImageView>(R.id.carImage)
            val nthCar = carItemView.findViewById<TextView>(R.id.nthCar)
            val nthEngine = carItemView.findViewById<TextView>(R.id.nthEngine)
            carImage.setImageDrawable(resources.getDrawable(R.drawable.dog, this.theme))
            nthCar.text = it.nthCar
            nthEngine.text = it.nthEngine
            container.addView(carItemView)
        }
    }
}

class Car(val nthCar: String, val nthEngine: String) {

}