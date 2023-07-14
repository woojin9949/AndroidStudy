package com.example.fastcampusandroid

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

//fragment파일 생성 Fragment interface 상속
class FragmentFirst : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //argument를 통해 Activity에서 전달한 데이터 받기
        val data: String? = arguments?.getString("key")
        Log.d("testt", "data is " + data)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // inflater : XML을 화면에 사용할 준비를 한다 (XML -> View로 만들어 준다)
        // container : fragment에서 사용될 XML의 부모뷰
        val view = inflater.inflate(R.layout.first_fragment, container, false)
        // attachRoot : root 뷰에 언제 붙는지

        // fragment에서 activity측 함수 콜 (접근)
        (view.findViewById<TextView>(R.id.call_activity)).setOnClickListener {
            (activity as FragmentActivity).printTestLog()
        }
        return view
    }

    fun printTestLog() {
        Log.d("testt", "print test log from fragment")
    }
}