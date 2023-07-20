package com.example.fastcampusandroid

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import java.util.concurrent.RecursiveAction

class InstaFeedFragment : Fragment() {
    lateinit var retrofitService: RetrofitService
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.insta_feed_fragment, container, false)
    }

    //onViewCreated를 통해 설정하기, 인스타 피드에 들어올 정보를 가져오기위함 Retrofit사용,
    //RetrofitService측 함수 설정 GET사용 class InstaPost 정보(content, image, ownerProfile(username,userProfile)가져오기)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val postRecyclerView = view.findViewById<RecyclerView>(R.id.feed_list)
        val retrofit = Retrofit.Builder().baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        retrofitService = retrofit.create(RetrofitService::class.java)

        retrofitService.getInstagramPosts().enqueue(object : Callback<ArrayList<InstaPost>> {
            override fun onResponse(
                call: Call<ArrayList<InstaPost>>,
                response: Response<ArrayList<InstaPost>>
            ) {
                val postList = response.body()
                postRecyclerView.adapter = PostRecyclerViewAdapter(
                    postList!!,
                    //문제 발생: LayoutInflater.from()은 Context를 인자로 받는데 현재 Fragment클래스이므로 
                    //this를 취해도 안된다 그래서 이 fragment를 tab으로 올려두는 Activity를 가져와야한다
                    LayoutInflater.from(activity),
                    Glide.with(this@InstaFeedFragment),
                    this@InstaFeedFragment,
                    activity as InstaMainActivity
                )
            }

            override fun onFailure(call: Call<ArrayList<InstaPost>>, t: Throwable) {
            }
        })
    }

    //post클릭시 좋아요를 위한 함수 설정
    fun postLike(postId: Int) {
        retrofitService.postLike(postId).enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                Toast.makeText(activity, "좋아요", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                Toast.makeText(activity, "좋아요 실패", Toast.LENGTH_SHORT).show()
            }
        })
    }

    class PostRecyclerViewAdapter(
        val postList: ArrayList<InstaPost>,
        val inflater: LayoutInflater,
        val glide: RequestManager,
        val instaFeedFragment: InstaFeedFragment,//InstaFeedFragment에 있는 postLike함수를 사용하기 위함
        val activity: InstaMainActivity //Thread작업을 위해선 activity가 필요 => 73번줄 참고
    ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        //inner클래스 작업
        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val ownerImg: ImageView
            val ownerUsername: TextView
            val postImg: ImageView
            val postContent: TextView
            val postLayer: ImageView
            val postHeart: ImageView

            init {
                ownerImg = itemView.findViewById(R.id.owner_img)
                ownerUsername = itemView.findViewById(R.id.owner_username)
                postImg = itemView.findViewById(R.id.post_img)
                postContent = itemView.findViewById(R.id.post_content)


                postLayer = itemView.findViewById(R.id.post_layer)
                postHeart = itemView.findViewById(R.id.post_heart)
                postImg.setOnClickListener {
                    instaFeedFragment.postLike(postList.get(adapterPosition).id)
                    Thread {
                        activity.runOnUiThread {
                            postLayer.visibility = VISIBLE
                            postHeart.visibility = VISIBLE
                        }
                        Thread.sleep(2000)
                        activity.runOnUiThread {
                            postLayer.visibility = INVISIBLE
                            postHeart.visibility = INVISIBLE
                        }
                    }.start()
                }
            }
        }

        //뷰 create
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
            return ViewHolder(inflater.inflate(R.layout.post_item, parent, false))
        }

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            val holder = holder as ViewHolder
            val post = postList.get(position)
            //non-null만 들어올 수 있음
            //null이 아닌 경우에만 작업 수행
            post.owner_profile.image?.let {
                glide.load(it).centerCrop().circleCrop().into(holder.ownerImg)
            }
            post.image.let {
                glide.load(it).centerCrop().into(holder.postImg)
            }
            holder.ownerUsername.text = post.owner_profile.username
            holder.postContent.text = post.content
        }

        override fun getItemCount(): Int {
            return postList.size
        }
    }
}
