package com.example.fastcampusandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class InstaMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val instaPostFragment = InstaPostFragment()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insta_main)

        //로그인 시 Main화면으로 정함
        //탭 레이아웃 과 뷰페이저를 통해 구분하기

        val tabs = findViewById<TabLayout>(R.id.main_tab)
        tabs.addTab(tabs.newTab().setIcon(R.drawable.btn_outsta_home))
        tabs.addTab(tabs.newTab().setIcon(R.drawable.btn_outsta_post))
        tabs.addTab(tabs.newTab().setIcon(R.drawable.btn_outsta_my))

        val pager = findViewById<ViewPager2>(R.id.main_pager)
        pager.adapter = InstaMainPagerAdapter(this, 3, instaPostFragment)
        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                pager.setCurrentItem(tab!!.position)
                if (tab!!.position == 1) {
                    instaPostFragment.makePost()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }
}

class InstaMainPagerAdapter(
    fragmentActivity: androidx.fragment.app.FragmentActivity,
    val tabCount: Int,
    val instaPostFragment: InstaPostFragment
) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return tabCount
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return InstaFeedFragment()
            //2번째 프라그먼트만 미리 만들어서 설정해둔 이유
            //앱 실행후 세번째 프라그먼트를 실행시에 두번째 프라그먼트도 누르지는 않았지만 실행된다
            //고로, 이전에 설정해둔 2번째 프라그먼트 onViewCreated시에 사진첩으로 넘어가 사진을 고를 수 있게
            //설정을 해뒀기에 발생한다. 해결방안으로 함수로 makePost를 만들어 그곳에 작업들을 넘겨두고, 그 함수를
            //여기서 onTabSelected를 통해 두번째 탭 눌렀을 시에 실행하게 설정해두었다.
            1 -> return instaPostFragment
            else -> return InstaProfileFragment()
        }
    }
}