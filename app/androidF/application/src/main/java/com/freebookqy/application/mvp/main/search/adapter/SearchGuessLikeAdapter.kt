package com.freebookqy.application.mvp.main.search.adapter

import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.freebookqy.application.R
import com.freebookqy.application.ext.dip2Px
import com.freebookqy.application.ext.loadImage
import com.freebookqy.application.mvp.model.entity.book.Book

/**
 * Created by leafye on 2019/5/7.
 */
class SearchGuessLikeAdapter(list: MutableList<Book>?) :
    BaseQuickAdapter<Book, BaseViewHolder>(R.layout.item_project_main, list) {
    override fun convert(helper: BaseViewHolder, item: Book) {
        helper.getView<ImageView>(R.id.cover_iv).loadImage(item.bookCovers)
        helper.getView<TextView>(R.id.book_name_tv).text = item.bookName
        helper.getView<TextView>(R.id.book_des_tv).text = item.author
        helper.itemView.setPadding(0, 5.dip2Px, 0, 5.dip2Px)
    }
}