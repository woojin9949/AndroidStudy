package com.example.fastcampusandroid

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InstaJoinActivity : AppCompatActivity() {

    var username: String = ""
    var password1: String = ""
    var password2: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insta_join)

        findViewById<TextView>(R.id.insta_login).setOnClickListener {
            startActivity(Intent(this@InstaJoinActivity, InstaLoginActivity::class.java))
        }
        findViewById<EditText>(R.id.id_input).doAfterTextChanged {
            username = it.toString()
        }
        findViewById<EditText>(R.id.pw_input1).doAfterTextChanged {
            password1 = it.toString()
        }
        findViewById<EditText>(R.id.pw_input2).doAfterTextChanged {
            password2 = it.toString()
        }

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitService = retrofit.create(RetrofitService::class.java)

        findViewById<TextView>(R.id.insta_join).setOnClickListener {
            if (password1 != password2) {
                Toast.makeText(
                    this@InstaJoinActivity,
                    "비밀번호가 서로 동일하지 않습니다 다시 입력해주세요",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val user = HashMap<String, Any>()
                user.put("username", username)
                user.put("password1", password1)
                user.put("password2", password2)
                retrofitService.instaJoin(user).enqueue(object : Callback<InstaUser> {
                    override fun onResponse(call: Call<InstaUser>, response: Response<InstaUser>) {
                        if (response.isSuccessful) {
                            val instaUser: InstaUser = response.body()!!
                            val sharedPreference =
                                getSharedPreferences("user_info", Context.MODE_PRIVATE)
                            val editor: SharedPreferences.Editor = sharedPreference.edit()
                            editor.putString("token", instaUser.token)
                            editor.putString("user_id", instaUser.id.toString())
                            editor.commit()
                            Log.d("testt", "회원가입 성공:" + instaUser.token)
                            startActivity(Intent(this@InstaJoinActivity,InstaMainActivity::class.java))
                        }
                    }

                    override fun onFailure(call: Call<InstaUser>, t: Throwable) {
                        TODO("Not yet implemented")
                    }
                })
            }

        }
    }
}