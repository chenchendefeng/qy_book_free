package com.wy.adbook.mvp.view.adapter

import android.support.annotation.DrawableRes
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.freebookqy.application.R
import com.wy.adbook.app.constant.Constant
import java.io.Serializable

/**
 * Created by leafye on 2019-05-29.
 */
class ShareItemAdapter(list: MutableList<ShareItem>?) :
    BaseQuickAdapter<ShareItem, BaseViewHolder>(R.layout.item_share, list) {
    override fun convert(helper: BaseViewHolder, item: ShareItem) {
        helper.getView<TextView>(R.id.share_tv).apply {
            text = item.name
            setCompoundDrawablesRelativeWithIntrinsicBounds(0, item.topId, 0, 0)
        }
    }
}

class ShareItem(
    var name: String,
    @DrawableRes var topId: Int,
    @Constant.ShareType var type: Int
) : Serializable