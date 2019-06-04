package com.wy.adbook.mvp.view.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.freebookqy.application.R
import com.wy.adbook.ext.loadImageCircle
import com.wy.adbook.mvp.model.entity.FriendItem

/**
 * Created by leafye on 2019-05-29.
 */
class MyFriendAdapter(list: MutableList<FriendItem>) :
    BaseQuickAdapter<FriendItem, BaseViewHolder>(R.layout.item_friend, list) {
    override fun convert(helper: BaseViewHolder, item: FriendItem) {
        helper.getView<ImageView>(R.id.user_header_iv).loadImageCircle(item.avatar)
        helper.getView<TextView>(R.id.user_name_tv).text = item.nickName
        val pokeTaTv = helper.getView<TextView>(R.id.poke_ta_tv)
        val lastTimeTv = helper.getView<TextView>(R.id.last_time_tv)

        val notifyStatus = item.notifyStatus == 1
        if (notifyStatus) {
            pokeTaTv.visibility = View.VISIBLE
            lastTimeTv.visibility = View.GONE
        } else {
            pokeTaTv.visibility = View.GONE
            lastTimeTv.visibility = View.VISIBLE
        }
        lastTimeTv.text = item.upTime
        helper.addOnClickListener(R.id.poke_ta_tv)
    }
}