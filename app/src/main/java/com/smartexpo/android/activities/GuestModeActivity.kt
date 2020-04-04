package com.smartexpo.android.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.smartexpo.android.R
import com.smartexpo.android.adapters.FragmentAdapter
import com.smartexpo.android.fragments.ChatsFragment
import com.smartexpo.android.fragments.HomeFragment
import com.smartexpo.android.utils.CustomViewPager

class GuestModeActivity : AppCompatActivity(),ViewPager.OnPageChangeListener {

    lateinit var viewPager: CustomViewPager
    lateinit var navigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_mode)

        initViewPager()
        initButton()

    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

    }

    override fun onPageSelected(position: Int) {

    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    private fun initViewPager(){
        val mOnNavItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
            handleNavItemSelection(it.itemId)
        }

        navigation = findViewById(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavItemSelectedListener)


        val fragmentAdapter = FragmentAdapter(supportFragmentManager,4)
        fragmentAdapter.add(HomeFragment(),"Home")
        fragmentAdapter.add(ChatsFragment(),"Chats")
        fragmentAdapter.add(HomeFragment(),"Maps")
        fragmentAdapter.add(HomeFragment(),"User")

        viewPager = findViewById(R.id.viewpager)
        viewPager.setCurrentItem(0)
        viewPager.setAdapter(fragmentAdapter)
        viewPager.setPaggingEnabled(false)
    }

    private fun initButton(){
        val btnBack = findViewById<ImageButton>(R.id.btn_back)
        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun handleNavItemSelection(itemNum: Int) : Boolean{
        when(itemNum){
            R.id.g_home -> {
                viewPager.currentItem = 0
                return true
            }
            R.id.g_chats -> {
                viewPager.currentItem = 1
                return true
            }
            R.id.g_maps -> {
                viewPager.currentItem = 2
                return true
            }
            R.id.g_user -> {
                viewPager.currentItem = 3
                return true
            }
        }
        return false
    }


}
