package com.wy.adbook.mvp.view.adapter

import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.freebookqy.application.R
import com.wy.adbook.ext.loadImage
import com.wy.adbook.mvp.model.entity.ClassificationItem

/**
 * Created by leafye on 2019/5/5.
 */
class ClassificationContentAdapter :
    BaseQuickAdapter<ClassificationItem, BaseViewHolder> {

    constructor() : this(null)

    constructor(list: MutableList<ClassificationItem>?) : super(R.layout.item_classification_content, list)

    override fun convert(helper: BaseViewHolder, item: ClassificationItem) {
        val coverIv = helper.getView<ImageView>(R.id.cover_iv)
        coverIv.loadImage(item.topBook?.bookCovers ?: "", R.mipmap.default_book_img)
        helper.getView<TextView>(R.id.classification_name_tv).text = item.classificationName
        helper.getView<TextView>(R.id.classification_type_tv).text = item.getCategoryListName()
        //helper.getView<TextView>(R.id.book_num_tv).text =
        //ResUtils.getString(R.string.book_num_ben, item.bookNum)
    }
}