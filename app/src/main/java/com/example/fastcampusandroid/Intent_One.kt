package com.example.fastcampusandroid

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class Intent_One : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_one)

        // 암시적 인텐트
        // - 전화, SMS, Google Play Store, Website, GoogleMap, 사진첩, 등등
        //  - 상수
        //      - 변하지 않는 수(문자)
        //      - 상수의 변수명은 전부 대문자로 만듦 (암묵적)
        //  - URI (Uniform Resource Identifier)
        //      - id라고 생각하면 됨 -> 고유하다
        //      - 자원을 나타내는 고유한 주소
        //      - URL
        //          - 인터넷 페이지의 고유한 주소
        val implicit_intent: TextView = findViewById(R.id.implicit_intent)
        implicit_intent.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "010-6287-4693"))
            startActivity(intent)
        }
        // 명시적 인텐트 + ComponentName -> 액티비티 전환
        val intent_one: TextView = findViewById(R.id.intent_one)
        intent_one.setOnClickListener {
            val intent: Intent = Intent()
            val componentName: ComponentName = ComponentName(
                "com.example.fastcampusandroid",
                "com.example.fastcampusandroid.Intent_Two"
            )
            intent.component = componentName
            startActivity(intent)
        }
        // 2번째 방법을 사용해야함
        // 명시적 인텐트 -> 액티비티 전환
        // Context
        //  - 문맥
        // A액티비티 -> B액티비티
        // componentName의 pkg, cls 오류 범하는걸 방지 하기 위함 또다른 좋은 방법
        (findViewById<TextView>(R.id.intent_two)).apply {
            this.setOnClickListener {
                startActivity(
                    Intent(this@Intent_One, Intent_Two::class.java)
                    //context는 activity가 구현해 놓고 추가한 기능이므로 context자리에 activity가 들어갈 수 있다. 부모(context), 자식(Activity)
                )
            }
        }
        // 명시적 인텐트 + data 전달
        (findViewById<TextView>(R.id.intent_three)).apply {
            this.setOnClickListener {
                val intent = Intent(this@Intent_One, Intent_Two::class.java)
                intent.putExtra("extra", "data-one")
                startActivity(intent)
            }
        }

        //명시적 인텐트 + 결과 받기
        // requestCode
        // - 구분을 하기 위해서
        (findViewById<TextView>(R.id.intent_four)).apply {
            setOnClickListener {
                val intent = Intent(this@Intent_One, Intent_Two::class.java)
                startActivityForResult(intent, 1)  //deprecated 되었다
            }
        }

        // 최신 방식
        // 명시적 인텐트 + 결과받기 (ActivityResult API)
        // -> requestCode 존재X
        // -> requestCode 없어도 요청자를 구분할 수 있다
        val startActivityLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            // onActivityResult에 해당하는 부분
            when (it.resultCode) {
                RESULT_OK -> {
                    Log.d("dataa", it.data?.extras?.getString("result")!!)
                }
            }
            //onActivityResult
            // - 모든 intent가 한곳에서 처리된다 -> 구분이 필요하다(request Code)
            //ActivityResult API
            // - 각각의 intent가 처리되는 곳이 별도로 있다 -> 구분이 필요없다
        }
        (findViewById<TextView>(R.id.intent_five)).apply {
            setOnClickListener {
                val intent = Intent(this@Intent_One, Intent_Two::class.java)
                intent.putExtra("dd", 1234)
                startActivityLauncher.launch(intent)
            }
        }

        // 명시적 인텐트 + 이미지 URI 전달
        (findViewById<TextView>(R.id.intent_six)).apply {
            this.setOnClickListener {
                val intent: Intent = Intent(this@Intent_One, Intent_Two::class.java).apply {
                    val imageUri =
                        Uri.parse("android.resource://" + packageName + "/drawable/" + "dog")
                    this.action = Intent.ACTION_SEND
                    this.putExtra(Intent.EXTRA_STREAM, imageUri)
                    this.setType("image/*")
                }
                startActivity(intent)
            }
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        //resultCode (status code)
        // - 최종결과
        // - 성공, 실패
        when (requestCode) {
            1 -> {
                when (resultCode) {
                    RESULT_OK -> {
                        val data: String? = data?.extras?.getString("result")
                        Log.d("dataa", data!!)
                    }
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}