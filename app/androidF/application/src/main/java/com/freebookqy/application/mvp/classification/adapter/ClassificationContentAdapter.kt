package com.freebookqy.application.mvp.classification.adapter

import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.freebookqy.application.R
import com.freebookqy.application.app.QYApplication
import com.freebookqy.application.mvp.model.entity.ClassificationItem
import com.freebookqy.utilslib.ResUtils

/**
 * Created by leafye on 2019/5/5.
 */
class ClassificationContentAdapter(list: MutableList<ClassificationItem>?) :
    BaseQuickAdapter<ClassificationItem, BaseViewHolder>(R.layout.item_classification_content, list) {
    override fun convert(helper: BaseViewHolder, item: ClassificationItem) {
        val coverIv = helper.getView<ImageView>(R.id.cover_iv)
        Glide.with(QYApplication.cxt()).load(item.classificationCoverUrl).into(coverIv)
        helper.getView<TextView>(R.id.classification_name_tv).text = item.classificationName
        helper.getView<TextView>(R.id.classification_type_tv).text = item.getCategoryListName()
        helper.getView<TextView>(R.id.book_num_tv).text =
            ResUtils.getString(R.string.book_num_ben, item.bookNum)
    }
}