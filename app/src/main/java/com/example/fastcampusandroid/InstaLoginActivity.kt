package com.example.fastcampusandroid

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class InstaLoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var userName: String = ""
        var password: String = ""
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insta_login)

        val retrofit = Retrofit.Builder().baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val retroService = retrofit.create(RetrofitService::class.java)

        findViewById<EditText>(R.id.id_input).doAfterTextChanged {
            userName = it.toString()
        }
        findViewById<EditText>(R.id.pw_input).doAfterTextChanged {
            password = it.toString()
        }
        findViewById<TextView>(R.id.join_btn).setOnClickListener {
            startActivity(Intent(this, InstaJoinActivity::class.java))
        }
        findViewById<TextView>(R.id.login_btn).setOnClickListener {
            val user = HashMap<String, Any>()
            user.put("username", userName)
            user.put("password", password)
            retroService.instaLogin(user).enqueue(object : Callback<InstaUser> {
                override fun onResponse(call: Call<InstaUser>, response: Response<InstaUser>) {
                    if (response.isSuccessful) {
                        val instaUser: InstaUser = response.body()!!
                        val sharedPreference =
                            getSharedPreferences("user_info", Context.MODE_PRIVATE)
                        val editor: SharedPreferences.Editor = sharedPreference.edit()
                        editor.putString("token", instaUser.token)
                        editor.putString("user_id", instaUser.id.toString())
                        editor.commit()
                        Log.d("testt", "로그인 성공:" + instaUser.token)
                        startActivity(Intent(this@InstaLoginActivity,InstaMainActivity::class.java))
                    } else {
                        when (response.code()) {
                            500 -> {
                                Toast.makeText(
                                    this@InstaLoginActivity,
                                    "아이디 혹은 비밀번호를 다시 적어주세요",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                            404 -> {
                                Toast.makeText(
                                    this@InstaLoginActivity, "서버 주소를 다시 확인하세요", Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                }

                override fun onFailure(call: Call<InstaUser>, t: Throwable) {

                }
            })
        }
    }
}