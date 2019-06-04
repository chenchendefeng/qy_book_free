package com.wy.adbook.mvp.view.adapter

import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.freebookqy.application.R
import com.wy.adbook.ext.dip2Px
import com.wy.adbook.ext.loadImage
import com.wy.adbook.mvp.model.entity.book.Book

/**
 * Created by leafye on 2019/5/7.
 */
class EveryoneWatchingAdapter(list: MutableList<Book>?) :
    BaseQuickAdapter<Book, BaseViewHolder>(R.layout.item_project_main, list) {
    override fun convert(helper: BaseViewHolder, item: Book) {
        helper.getView<ImageView>(R.id.cover_iv).loadImage(item.bookCovers)
        helper.getView<TextView>(R.id.book_name_tv).text = item.bookName
        helper.getView<TextView>(R.id.book_des_tv).text = item.author
        helper.itemView.setPadding(0, 10.dip2Px, 0, 10.dip2Px)
    }
}