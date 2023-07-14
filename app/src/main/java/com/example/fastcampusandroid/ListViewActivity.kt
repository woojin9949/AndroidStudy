package com.example.fastcampusandroid

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ListViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        //데이터 준비
        var carList = mutableListOf<Car>()
        for (i in 0..100) {
            carList.add(Car("" + i + "번째 차", "" + i + "번째 엔진"))
        }
        //어댑터 준비
        val adapter = ListViewAdapter(carList, LayoutInflater.from(this), this)
        // 어댑터 장착 방법
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = adapter
        //리스너 장착방법
        listView.setOnItemClickListener { parent, view, position, id ->
            val car = adapter.carList.get(position)
            val nthCar = car.nthCar
            val nthEngine = car.nthEngine

            Toast.makeText(this, nthCar + "   " + nthEngine, Toast.LENGTH_LONG).show()
        }
        findViewById<TextView>(R.id.addCar).setOnClickListener {
            adapter.carList.add(Car("안녕 나는 차", "안녕 나는 엔진"))
            adapter.notifyDataSetChanged()
        }
    }
}

class ListViewAdapter(
    val carList: MutableList<Car>,
    val layoutInflater: LayoutInflater,
    val context: Context
) : BaseAdapter() {

    override fun getCount(): Int {
        //전체 데이터의 크기(갯수)
        return carList.size
    }

    override fun getItem(position: Int): Any {
        // 전체 데이터 중 해당번째(position)의 데이터 리턴
        return carList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder
        if (convertView == null) {
            //재활용 불가능
            view = layoutInflater.inflate(R.layout.car_item, null)
            holder = ViewHolder()
            holder.carImage = view.findViewById(R.id.carImage)
            holder.nthCar = view.findViewById(R.id.nthCar)
            holder.nthEngine = view.findViewById(R.id.nthEngine)

            view.tag = holder
        } else {
            //재활용 가능
            //이때는 view가 convertView로 전환되어 들어옴
            holder = convertView.tag as ViewHolder
            view = convertView
        }
        val car = carList.get(position)
        holder.carImage?.setImageDrawable(
            context.resources.getDrawable(
                R.drawable.dog,
                context.theme
            )
        )
        holder.nthCar?.text = car.nthCar
        holder.nthEngine?.text = car.nthEngine

        //해당 번째 View 리턴
//        val view = layoutInflater.inflate(R.layout.car_item, null)
//        val carImage = view.findViewById<ImageView>(R.id.carImage)
//        val nthCar = view.findViewById<TextView>(R.id.nthCar)
//        val nthEngine = view.findViewById<TextView>(R.id.nthEngine)
//        val car = carList.get(position)
//        carImage.setImageDrawable(context.resources.getDrawable(R.drawable.dog, context.theme))
//        nthCar.text = car.nthCar
//        nthEngine.text = car.nthEngine
        return view
    }
}


class ViewHolder {
    var carImage: ImageView? = null
    var nthCar: TextView? = null
    var nthEngine: TextView? = null
}
