package com.wy.adbook.mvp.view.adapter

import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.freebookqy.application.R
import com.wy.adbook.ext.loadImage
import com.wy.adbook.ext.onClick
import com.wy.adbook.mvp.model.entity.ReadFooterItem
import com.wy.adbook.mvp.view.activity.BookDetailActivity

/**
 * Created by leafye on 2019-05-28.
 */
class ReadFooterAdapter(list: MutableList<ReadFooterItem>) :
    BaseQuickAdapter<ReadFooterItem, BaseViewHolder>(R.layout.item_read_footer, list) {
    override fun convert(helper: BaseViewHolder, item: ReadFooterItem) {
        helper.getView<ImageView>(R.id.cover_iv).loadImage(item.coverImg, R.mipmap.default_book_img)
        helper.getView<TextView>(R.id.book_name_tv).text = item.name
        helper.getView<TextView>(R.id.book_add_time_tv).text = item.createDate
        helper.addOnClickListener(R.id.right)
        helper.addOnClickListener(R.id.content)
    }


}