package com.freebookqy.application.mvp.main.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

/**
 * Created by leafye on 2019/4/30.
 */
class MainAdapter(
    private val mainFragList: MutableList<Fragment>,
    fm: FragmentManager
) : FragmentStatePagerAdapter(fm) {

    override fun getItem(p0: Int): Fragment {
        return mainFragList[p0]
    }

    override fun getCount(): Int {
        return mainFragList.size
    }

}