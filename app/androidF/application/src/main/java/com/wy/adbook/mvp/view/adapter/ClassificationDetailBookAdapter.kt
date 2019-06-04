package com.wy.adbook.mvp.view.adapter

import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.freebookqy.application.R
import com.wy.adbook.ext.loadImage
import com.wy.adbook.mvp.model.entity.book.Book
import com.freebookqy.utilslib.ResUtils

/**
 * Created by leafye on 2019/5/5.
 */
class ClassificationDetailBookAdapter(list: MutableList<Book>?) :
    BaseQuickAdapter<Book, BaseViewHolder>(R.layout.item_project_main, list) {
    override fun convert(helper: BaseViewHolder, item: Book) {
        val coverIv = helper.getView<ImageView>(R.id.cover_iv)
        val bookNameTv = helper.getView<TextView>(R.id.book_name_tv)
        val bookDesTv = helper.getView<TextView>(R.id.book_des_tv)
        val bookAuthorClassifyTv = helper.getView<TextView>(R.id.author_classify_tv)
        coverIv.loadImage(item.bookCovers,R.mipmap.default_book_img)
        bookNameTv.text = item.bookName
        bookDesTv.text = item.description
        bookAuthorClassifyTv.text = ResUtils.getString(
            R.string.author_classification,
            item.author,
            item.category
        )
    }
}