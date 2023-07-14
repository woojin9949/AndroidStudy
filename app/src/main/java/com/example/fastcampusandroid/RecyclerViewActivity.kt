package com.example.fastcampusandroid

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        val carList = mutableListOf<Car>()
        for (i in 0..100) {
            carList.add(Car("" + i + "번째 자동차", "" + i + "번째 엔진"))
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        //리사이클러뷰에 어답터 장착
        recyclerView.adapter = RecyclerViewAdapter(carList, LayoutInflater.from(this), this)
        //리사이클러뷰에 레이아웃매니저 장착
        recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        //recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        //recyclerView.layoutManager = GridLayoutManager(this, 3)

    }
}

//ViewHolder 사용 강제
class RecyclerViewAdapter(
    var carList: MutableList<Car>,
    val inflater: LayoutInflater,
    val context: Context
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //inner Class
        //아이템 뷰의 상세 뷰 컴포넌트 홀드
        val carImage: ImageView
        val nthCar: TextView
        val nthEngine: TextView

        init {
            carImage = itemView.findViewById(R.id.carImage)
            nthCar = itemView.findViewById(R.id.nthCar)
            nthEngine = itemView.findViewById(R.id.nthEngine)
            itemView.setOnClickListener {
                val position: Int = adapterPosition
                val car = carList.get(position)
                Log.d("testt", car.nthCar)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //아이템뷰를 리턴
        val view = inflater.inflate(R.layout.car_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //데이터를 아이템뷰의 뷰컴포넌트와 묶는다
        holder.nthCar.text = carList.get(position).nthCar
        holder.nthEngine.text = carList.get(position).nthEngine
        holder.carImage.setImageDrawable(
            context.resources.getDrawable(
                R.drawable.dog, context.theme
            )
        )
    }

    override fun getItemCount(): Int {
        return carList.size
    }
}