package com.freebookqy.application.mvp.main.bookcase.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.chad.library.adapter.base.entity.MultiItemEntity
import com.freebookqy.application.R
import com.freebookqy.application.ext.loadImage
import com.freebookqy.application.mvp.main.bookcase.adapter.MultiBookcaseItem.Companion.TYPE_AD
import com.freebookqy.application.mvp.main.bookcase.adapter.MultiBookcaseItem.Companion.TYPE_NORMAL
import com.freebookqy.application.mvp.model.entity.book.Book
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
        helper.getView<TextView>(R.id.book_name_tv).text = book.bookName
        helper.getView<TextView>(R.id.author_tv).text = book.author
        helper.getView<TextView>(R.id.ad_tv).visibility = View.GONE
        helper.getView<View>(R.id.right).setOnClickListener {
            mL?.delete(book)
            swipeMenuLayout.resetStatus()
        }

    }

    private fun refreshAd(helper: BaseViewHolder, any: Any?) {
        val bookcaseLeftIv = helper.getView<ImageView>(R.id.bookcase_left_iv)
//        bookcaseLeftIv.loadImage(book.bookCovers)
//        helper.getView<TextView>(R.id.book_name_tv).text = book.bookName
//        helper.getView<TextView>(R.id.author_tv).text = book.author
        helper.getView<TextView>(R.id.ad_tv).visibility = View.VISIBLE
    }


}

interface BookcaseClickListener {

    fun delete(book: Book)

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
