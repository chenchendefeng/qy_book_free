package com.wy.adbook.mvp.view.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.freebookqy.application.R
import com.wy.adbook.ext.loadImage
import com.wy.adbook.ext.onClick
import com.wy.adbook.mvp.model.entity.book.Book
import com.wy.adbook.mvp.view.adapter.MultiBookcaseItem.Companion.TYPE_AD
import com.wy.adbook.mvp.view.adapter.MultiBookcaseItem.Companion.TYPE_NORMAL
import com.guanaj.easyswipemenulibrary.EasySwipeMenuLayout

/**
 * Created by leafye on 2019/4/
 */
class BookcaseAdapter(multiBookcaseItemList: MutableList<MultiBookcaseItem>?) :
    BaseMultiItemQuickAdapter<MultiBookcaseItem, BaseViewHolder>(multiBookcaseItemList) {

    private var mL: BookcaseClickListener? = null

    init {
        addItemType(TYPE_NORMAL, R.layout.item_bookcase)
        addItemType(TYPE_AD, R.layout.item_bookcase)
    }

    fun setBookcaseClickListener(l: BookcaseClickListener) {
        this.mL = l
    }

    override fun convert(helper: BaseViewHolder, item: MultiBookcaseItem) {
        when (item.itemType) {
            TYPE_NORMAL -> refreshNormal(helper, item.any as Book)
            TYPE_AD -> refreshAd(helper, item.any)
        }
    }

    private fun refreshNormal(helper: BaseViewHolder, book: Book) {
        val bookcaseLeftIv = helper.getView<ImageView>(R.id.bookcase_left_iv)
        bookcaseLeftIv.loadImage(book.bookCovers)
        val swipeMenuLayout = helper.getView<EasySwipeMenuLayout>(R.id.swipe_menu_layout)
        helper.getView<TextView>(R.id.read_progress).apply {
            text = when {
                book.readProgress == 0F -> "未读"
                book.readProgress == 100F -> "已读完"
                else -> "${book.readProgress}%"
            }
        }
        helper.getView<TextView>(R.id.book_name_tv).text = book.bookName
        helper.getView<TextView>(R.id.author_tv).text = book.author
        helper.getView<TextView>(R.id.ad_tv).visibility = View.GONE
        helper.getView<View>(R.id.right).onClick {
            mL?.delete(book)
            swipeMenuLayout.resetStatus()
        }
        helper.getView<View>(R.id.content).apply {
            setOnLongClickListener {
                mL?.longClick(book)
                true
            }
            onClick {
                mL?.contentCick(book)
            }
        }
    }

    private fun refreshAd(helper: BaseViewHolder, any: Any?) {
        val bookcaseLeftIv = helper.getView<ImageView>(R.id.bookcase_left_iv)
//        bookcaseLeftIv.loadImage(book.bookCovers)
//        helper.getView<TextView>(R.id.book_name_tv).text = book.bookName
//        helper.getView<TextView>(R.id.author_tv).text = book.author
        helper.getView<TextView>(R.id.ad_tv).visibility = View.VISIBLE
        helper.getView<View>(R.id.content).onClick {
            //mL?.adClick(book)
        }
    }


}

interface BookcaseClickListener {

    fun delete(book: Book)

    fun contentCick(book: Book)

    fun adClick(book: Book)

    fun longClick(book: Book)
}


class MultiBookcaseItem : MultiItemEntity {

    companion object {
        const val TYPE_NORMAL = 0
        const val TYPE_AD = 1
    }

    override fun getItemType(): Int {
        return if (any is Book) {
            TYPE_NORMAL
        } else {
            TYPE_AD
        }
    }

    var any: Any? = null
}
