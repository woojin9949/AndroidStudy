package com.example.fastcampusandroid

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Calculator : AppCompatActivity() {

    lateinit var one: TextView
    lateinit var two: TextView
    lateinit var three: TextView
    lateinit var four: TextView
    lateinit var five: TextView
    lateinit var six: TextView
    lateinit var seven: TextView
    lateinit var eight: TextView
    lateinit var nine: TextView
    lateinit var zero: TextView
    lateinit var ca: TextView
    lateinit var plus: TextView
    lateinit var equal: TextView
    lateinit var result: TextView
    var input: String = ""
    var temp: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator)
        findViews()  // 초기화 완료
        setNumberTextViewListener()

        ca.setOnClickListener {
            input = ""
            temp = ""
            result.text = "0"
        }
        plus.setOnClickListener {
            temp = result.text.toString() //+누를시 temp에 저장
            result.text = ""
            input = ""
        }
        equal.setOnClickListener {
            val finalResult: String = (input.toInt() + temp.toInt()).toString()
            result.text = finalResult
            temp = finalResult
        }
    }

    fun findViews() {
        one = findViewById(R.id.num1)
        two = findViewById(R.id.num2)
        three = findViewById(R.id.num3)
        four = findViewById(R.id.num4)
        five = findViewById(R.id.num5)
        six = findViewById(R.id.num6)
        seven = findViewById(R.id.num7)
        eight = findViewById(R.id.num8)
        nine = findViewById(R.id.num9)
        zero = findViewById(R.id.num0)
        plus = findViewById(R.id.plus)
        ca = findViewById(R.id.reset)
        equal = findViewById(R.id.enter)
        result = findViewById(R.id.result)
    }

    fun setNumberTextViewListener() {
        //첫번째 단계
        // 우선 변수부터 리스트를 통해 설정

        val numberTextViewList: List<TextView> = listOf(
            one, two, three, four, five, six, seven, eight, eight, nine, zero
        )
        //리스트를 통해 for문으로 클릭 리스너 설정
        //익명함수 사용
        val listener = object : View.OnClickListener {
            override fun onClick(p0: View?) {
                input += (p0 as TextView).text  //다운캐스팅까지 why? View타입이니깐 TextView를 사용하기 위해 스마트 캐스팅으로 사용
                result.text = input
            }
        }
        numberTextViewList.forEach {
            it.setOnClickListener(listener)
        }
    }
}