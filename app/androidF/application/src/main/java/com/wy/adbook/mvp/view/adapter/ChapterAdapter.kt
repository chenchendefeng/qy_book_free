package com.wy.adbook.mvp.view.adapter

import android.view.View
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.freebookqy.application.R
import com.wy.adbook.mvp.model.dao.BookChapterBean
import com.wy.adbook.view.page.PageStyle
import com.wy.adbook.view.readview.ReadSettingManager
import com.freebookqy.utilslib.ResUtils

/**
 * Created by leafye on 2019-05-14.
 */
class ChapterAdapter(list: MutableList<BookChapterBean>? = null) :
    BaseQuickAdapter<BookChapterBean, BaseViewHolder>(R.layout.item_chapter, list) {

    override fun convert(helper: BaseViewHolder, item: BookChapterBean) {
        val nightMode = ReadSettingManager.getInstance().isNightMode
        val readBgTheme = ReadSettingManager.getInstance().readBgTheme
        helper.getView<View>(R.id.divide_line).apply {
            if (nightMode
                || readBgTheme == PageStyle.BG_4
            ) {
                setBackgroundColor(ResUtils.getColor(R.color.black_text_color))
            } else {
                setBackgroundColor(ResUtils.getColor(R.color.color_e8e8e8))
            }
        }
        helper.getView<TextView>(R.id.chapter_tv).apply {
            text = item.title
            if (item.isSelected) {
                setTextColor(ResUtils.getColor(R.color.color_e60001))
            } else {
                if (nightMode
                    || readBgTheme == PageStyle.BG_4
                ) {
                    setTextColor(ResUtils.getColor(PageStyle.BG_4.fontColor))
                } else {
                    setTextColor(ResUtils.getColor(R.color.black_text_color))
                }
            }
        }
    }

    fun setChapter(i: Int) {
        data.forEach { it.isSelected = false }
        if (data.size > i)
            data[i].isSelected = true
        val nextPos = if (i + 6 > data.size) i else i + 6
        recyclerView?.smoothScrollToPosition(nextPos)
        notifyDataSetChanged()
    }

    fun setTextColor() {
        notifyDataSetChanged()
    }
}