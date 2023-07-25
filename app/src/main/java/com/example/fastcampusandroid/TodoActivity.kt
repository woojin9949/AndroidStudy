package com.example.fastcampusandroid

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class TodoActivity : AppCompatActivity() {
    lateinit var todoRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)

        findViewById<ImageView>(R.id.write).setOnClickListener {
            startActivity(Intent(this@TodoActivity, TodoWriteActivity::class.java))
        }
        todoRecyclerView = findViewById(R.id.todo_list)
        getToDoList()

        findViewById<EditText>(R.id.search_edittext).doAfterTextChanged {
            searchToDoList(it.toString())
        }
    }

    fun searchToDoList(keyword: String) {
        val retrofit = Retrofit.Builder().baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val retrofitService = retrofit.create(RetrofitService::class.java)

        val header = HashMap<String, String>()
        val sp = getSharedPreferences("user_info", Context.MODE_PRIVATE)
        val token = sp.getString("token", "")
        header.put("Authorization", "token $token")

        retrofitService.searchToDoList(header, keyword).enqueue(object : Callback<ArrayList<ToDo>> {
            override fun onResponse(
                call: Call<ArrayList<ToDo>>,
                response: Response<ArrayList<ToDo>>
            ) {
                if (response.isSuccessful) {
                    val todoList = response.body()
                    makeToDoList(todoList!!)
                }
            }

            override fun onFailure(call: Call<ArrayList<ToDo>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    fun makeToDoList(todoList: ArrayList<ToDo>) {
        todoRecyclerView.adapter =
            ToDoListRecyclerViwAdapter(
                todoList!!,
                LayoutInflater.from(this@TodoActivity),
                this@TodoActivity
            )
    }

    fun changeToDoComplete(todoId: Int, activity: TodoActivity) {
        val retrofit = Retrofit.Builder().baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val retrofitService = retrofit.create(RetrofitService::class.java)

        val header = HashMap<String, String>()
        val sp = getSharedPreferences("user_info", Context.MODE_PRIVATE)
        val token = sp.getString("token", "")
        header.put("Authorization", "token $token")

        retrofitService.changeToDoComplete(header, todoId).enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                activity.getToDoList()
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                activity.getToDoList()
            }
        })
    }

    fun getToDoList() {
        val retrofit = Retrofit.Builder().baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val retrofitService = retrofit.create(RetrofitService::class.java)

        val header = HashMap<String, String>()
        val sp = getSharedPreferences("user_info", Context.MODE_PRIVATE)
        val token = sp.getString("token", "")
        header.put("Authorization", "token $token")
        retrofitService.getTodoList(header).enqueue(object : Callback<ArrayList<ToDo>> {
            override fun onResponse(
                call: Call<ArrayList<ToDo>>,
                response: Response<ArrayList<ToDo>>
            ) {
                if (response.isSuccessful) {
                    val todoList = response.body()
                    todoList!!.forEach {
                        Log.d("testt", it.content)
                        Log.d("testt", it.created)
                    }
                    makeToDoList(todoList)
                }
            }

            override fun onFailure(call: Call<ArrayList<ToDo>>, t: Throwable) {
            }
        })
    }
}

class ToDoListRecyclerViwAdapter(
    val todoList: ArrayList<ToDo>,
    val inflater: LayoutInflater,
    val activity: TodoActivity
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var previusDate: String = ""

    inner class DateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val dateTextView: TextView

        init {
            dateTextView = itemView.findViewById(R.id.date)
        }
    }

    inner class ContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val contentView: TextView
        val isComplete: ImageView

        init {
            contentView = itemView.findViewById(R.id.todo_content)
            isComplete = itemView.findViewById(R.id.is_complete)
            isComplete.setOnClickListener {
                activity.changeToDoComplete(todoList.get(adapterPosition).id, activity)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val todo = todoList.get(position)
        val tempDate = todo.created.split("T")[0]
        if (previusDate == tempDate) {
            return 0

        } else {
            previusDate = tempDate
            return 1
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return when (viewType) {
            //1일 경우 일이 같으므로 동일 뷰가 나옴
            1 -> DateViewHolder(inflater.inflate(R.layout.todo_date, parent, false))
            else -> ContentViewHolder(inflater.inflate(R.layout.todo_content, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val todo = todoList.get(position)
        if (holder is DateViewHolder) {
            holder.dateTextView.text = todo.created.split("T")[0]
        } else {
            val holder = (holder as ContentViewHolder)
            holder.contentView.text = todo.content
            if (todo.is_complete) {
                holder.isComplete.setImageDrawable(
                    activity.resources.getDrawable(
                        R.drawable.btn_radio_check,
                        activity.theme
                    )
                )
            } else {
                holder.isComplete.setImageDrawable(
                    activity.resources.getDrawable(
                        R.drawable.btn_radio,
                        activity.theme
                    )
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return todoList.size
    }
}