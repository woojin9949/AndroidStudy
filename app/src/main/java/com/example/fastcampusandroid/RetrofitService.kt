package com.example.fastcampusandroid

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

class StudentFromServer(
    val id: Int,
    val name: String,
    val age: Int,
    val intro: String
) {
    constructor(name: String, age: Int, intro: String) : this(0, name, age, intro)
}

interface RetrofitService {
    @GET("json/students") //이 요청에 대해선 형태 변환하겠다란뜻
    fun getStudentList(): Call<ArrayList<StudentFromServer>>

    @POST("json/students/")
    fun createStudent(
        @Body params: HashMap<String, Any>
    ): Call<StudentFromServer>

    @POST("json/students/")
    fun easyCreateStudent(
        @Body student: StudentFromServer
    ): Call<StudentFromServer>
}