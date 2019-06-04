package com.freebookqy.application.mvp.book.read.adapter

import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.freebookqy.application.R
import com.freebookqy.application.mvp.model.entity.Chapter

/**
 * Created by leafye on 2019-05-14.
 */
class ChapterAdapter(list: MutableList<Chapter>? = null) :
    BaseQuickAdapter<Chapter, BaseViewHolder>(R.layout.item_chapter, list) {
    override fun convert(helper: BaseViewHolder, item: Chapter) {
        helper.getView<TextView>(R.id.chapter_tv).apply {
            text = item.chapterTitle
            isSelected = item.isSelected
        }
    }

    fun setChapter(i: Int) {
        data.forEach { it.isSelected = false }
        data[i].isSelected = true
        val nextPos = if (i + 6 > data.size) i else i + 6
        recyclerView?.smoothScrollToPosition(nextPos)
        notifyDataSetChanged()
    }
}