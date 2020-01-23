package com.smartexpo.android.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentAdapter(fm: FragmentManager, behavior: Int) : FragmentPagerAdapter(fm, behavior){

    private var fragmentList = ArrayList<Fragment>()
    private var pageList = ArrayList<String>()

    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return pageList.get(position)
    }

    fun add(frag: Fragment, title: String) {
        fragmentList.add(frag)
        pageList.add(title)
    }
}

