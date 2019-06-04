//package com.freebookqy.imp
//
//import android.support.v4.app.Fragment
//import android.support.v4.app.FragmentManager
//import android.support.v4.view.PagerAdapter.POSITION_NONE
//import android.text.method.TextKeyListener.clear
//import android.support.v4.app.FragmentStatePagerAdapter
//import android.util.Log
//import java.util.*
//
//
///**
// * Created by leafye on 2019/5/5.
// */
//class FSPagerAdapter(fm: FragmentManager, types: List<Int>) : FragmentStatePagerAdapter(fm) {
//
//    private var mFragmentList: ArrayList<Fragment>? = null
//
//    init {
//        updateData(types)
//    }
//
//    fun updateData(dataList: List<Int>) {
//        val fragments = ArrayList()
//        var i = 0
//        val size = dataList.size
//        while (i < size) {
//            Log.e("FPagerAdapter1", dataList[i].toString())
//            fragments.add(FragmentTest.instance(dataList[i]))
//            i++
//        }
//        setFragmentList(fragments)
//    }
//
//    private fun setFragmentList(fragmentList: ArrayList<Fragment>) {
//        if (this.mFragmentList != null) {
//            mFragmentList!!.clear()
//        }
//        this.mFragmentList = fragmentList
//        notifyDataSetChanged()
//    }
//
//    override fun getCount(): Int {
//        return this.mFragmentList!!.size()
//    }
//
//    override fun getItemPosition(`object`: Any): Int {
//        return POSITION_NONE
//    }
//
//    override fun getItem(position: Int): Fragment {
//        return mFragmentList!!.get(position)
//    }
//}