package com.example.fastcampusandroid

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ReportChattingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_chatting)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val chatList = mutableListOf<Chat>()
        for (i in 0..100) {
            when (i % 6) {
                0 -> chatList.add(Chat("안녕하세요"))
                1 -> chatList.add(Chat("네 안녕하세요"))
                2 -> chatList.add(Chat("반갑습니다"))
                3 -> chatList.add(Chat("네 반가워요"))
                4 -> chatList.add(Chat("안녕히 주무세요"))
                5 -> chatList.add(Chat("네 안녕히주무세요"))
            }
        }
        val adapter = ChatRecyclerViewAdapter(chatList, LayoutInflater.from(this), this)
        with(recyclerView) {
            this.layoutManager = LinearLayoutManager(this@ReportChattingActivity)
            this.adapter = adapter
            //adapter 선언 안에다가 넣어버려도 됨. 클릭리스너를 통해 notifyItemInserted테스트해봄
        }
//        findViewById<Button>(R.id.button).setOnClickListener {
//            adapter.chatList.add(2,Chat("두번째 입니다"))
//            adapter.notifyItemInserted(2)
//        }


//        recyclerView.adapter = ChatRecyclerViewAdapter(chatList, LayoutInflater.from(this), this)
//        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}

class ChatRecyclerViewAdapter(
    var chatList: MutableList<Chat>,
    val inflater: LayoutInflater,
    val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class LeftViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var chatImage: ImageView
        var chatText: TextView

        init {
            chatText = itemView.findViewById(R.id.chatText)
            chatImage = itemView.findViewById(R.id.chatImage)
        }
    }

    inner class RightViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var chatImage2: ImageView
        var chatText2: TextView

        init {
            chatText2 = itemView.findViewById(R.id.chatText2)
            chatImage2 = itemView.findViewById(R.id.chatImage2)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) 0 else 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            0 -> {
//                val view = inflater.inflate(R.layout.chatitem_left, parent, false)
//                LeftViewHolder(view)
                LeftViewHolder(inflater.inflate(R.layout.chatitem_left, parent, false))
            }
            else -> {
//                val view = inflater.inflate(R.layout.chatitem_right, parent, false)
//                RightViewHolder(view)
                RightViewHolder(inflater.inflate(R.layout.chatitem_right, parent, false))
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (position % 2) {
            0 -> {
                val holder = (holder as LeftViewHolder)
                holder.chatText.text = chatList.get(position).message
                holder.chatImage.setImageDrawable(
                    context.resources.getDrawable(
                        R.drawable.facebook_background,
                        context.theme
                    )
                )
            }
            else -> {
                val holder = (holder as RightViewHolder)
                holder.chatText2.text = chatList.get(position).message
                holder.chatImage2.setImageDrawable(
                    context.resources.getDrawable(
                        R.drawable.kakao_background,
                        context.theme
                    )
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return chatList.size
    }
}

class Chat(val message: String)