package com.wy.adbook.mvp.view.activity

import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.freebookqy.application.R
import com.freebookqy.utilslib.BookNumChangeFormat
import com.freebookqy.utilslib.ResUtils
import com.freebookqy.utilslib.SpanUtils
import com.freebookqy.utilslib.UtilsView
import com.freebookqy.viewlib.rv.layoutmanager.FullyLinearLayoutManager
import com.jess.arms.di.component.AppComponent
import com.wy.adbook.app.base.QYBaseActivity
import com.wy.adbook.app.manager.ShareManager
import com.wy.adbook.app.utils.StringUtils
import com.wy.adbook.di.component.DaggerBookDetailComponent
import com.wy.adbook.di.module.BookDetailModule
import com.wy.adbook.dialog.share.ShareDialog
import com.wy.adbook.dialog.share.ShareListener
import com.wy.adbook.ext.dip2Px
import com.wy.adbook.ext.loadImage
import com.wy.adbook.ext.onClick
import com.wy.adbook.ext.sp
import com.wy.adbook.mvp.contranct.BookDetailContract
import com.wy.adbook.mvp.model.entity.book.Book
import com.wy.adbook.mvp.presenter.BookDetailPresenter
import com.wy.adbook.mvp.view.adapter.EveryoneWatchingAdapter
import kotlinx.android.synthetic.main.activity_book_detail.*

/**
 * Created by leafye on 2019/5/7.
 */
class BookDetailActivity :
    QYBaseActivity<BookDetailPresenter>(),
    BookDetailContract.View {

    companion object {

        private const val EXTRA_BOOK = "extraBook"
        private const val EXTRA_BOOK_ID = "extraBookId"

        @JvmStatic
        fun startActivity(context: Context, book: Book) {
            context.startActivity(
                Intent(context, BookDetailActivity::class.java).apply {
                    putExtra(EXTRA_BOOK, book)
                })
        }

        @JvmStatic
        fun startActivity(context: Context, bookId: Int) {
            context.startActivity(Intent(context, BookDetailActivity::class.java).apply {
                putExtra(EXTRA_BOOK_ID, bookId)
            })
        }
    }

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerBookDetailComponent.builder()
            .appComponent(appComponent)
            .bookDetailModule(BookDetailModule((this@BookDetailActivity)))
            .build()
            .inject(this@BookDetailActivity)
    }

    private val everyoneWatchingAdapter: EveryoneWatchingAdapter by lazy {
        EveryoneWatchingAdapter(null).apply {
            onItemClickListener =
                BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
                    val item = adapter.data[position]
                    if (item is Book) {
                        BookDetailActivity.startActivity(this@BookDetailActivity, item)
                    }
                }
        }
    }

    override fun initView(savedInstanceState: Bundle?): Int = R.layout.activity_book_detail

    override fun getToolbar(): View? = title_bar_view

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        initData(null)
    }

    override fun initData(savedInstanceState: Bundle?) {
        intent.apply {
            getSerializableExtra(EXTRA_BOOK).let {
                if (it is Book) mPresenter?.extraBook = it
            }
            getSerializableExtra(EXTRA_BOOK_ID)?.let {
                mPresenter?.extraBookId = it as Int
            }
        }
        initListener()
        refreshBookInfo(false)
        mPresenter?.fetchData()
    }

    private fun initListener() {
        title_bar_view.setOnLeftButtonClickListener { finish() }
        title_bar_view.setOnRightButtonClickListener { showShareDialog() }
        refresh_layout.setOnRefreshListener { mPresenter?.fetchData() }
        bookcase_tv.onClick { mPresenter?.putOn() }
        free_read_book_tv.onClick { mPresenter?.enterRead() }
        close_ad_container.onClick { mPresenter?.closeAd() }
        more_btn.onClick {
            val maxLines = book_des_tv.maxLines
            if (maxLines == 4) {
                more_btn.text = "收起"
                more_btn.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.mipmap.arrow_up, 0)
                book_des_tv.maxLines = 100
            } else {
                book_des_tv.maxLines = 4
                more_btn.text = "更多"
                more_btn.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.mipmap.arrow_down, 0)
            }
        }
    }

    private fun showShareDialog() {
        ShareManager.showShareBookDialog(
            this@BookDetailActivity,
            object : ShareListener {
                override fun share(shareDialog: ShareDialog, shareType: Int) {
                    mPresenter?.startShare(shareDialog, shareType)
                }
            })
    }

    override fun refreshBookInfo(isShowBtm: Boolean) {
        collection_tv.text = getNumFormatSpan(mPresenter?.extraBook?.collectionCount ?: 0)
        had_read_tv.text = getNumFormatSpan(mPresenter?.extraBook?.readedCount ?: 0)
        reading_tv.text = getNumFormatSpan(mPresenter?.extraBook?.readingCount ?: 0)
        book_status_tv.text = "连载"
        chapter_number_tv.text =
            ResUtils.getString(R.string.n_chapter_ends, 0)
        mPresenter?.extraBook?.let {
            chapter_number_tv.text =
                ResUtils.getString(R.string.n_chapter_ends, it.chapterCount)
            book_cover_iv.loadImage(it.bookCovers)
            book_name_tv.text = it.bookName
            author_tv.text = it.author
            book_num_tv.text = ResUtils.getString(
                R.string.number_words,
                BookNumChangeFormat.formatBookNum(it.totalWordCount)
            )
            book_category_tv.text = it.category
            book_des_tv.text = it.description
            val paint = Paint().apply {
                textSize = 14.sp.toFloat()
            }
            val measureText = paint.measureText(it.description)
            val measuredWidth = book_des_tv.measuredWidth
            val cLines = measureText / measuredWidth
            if (cLines > 4) {
                more_btn.visibility = View.VISIBLE
            }

            book_status_tv.text = it.getFinishFlagStatus()
            btm_btn_container.visibility = if (isShowBtm) View.VISIBLE else View.GONE
            bookcase_tv.text =
                ResUtils.getString(
                    if (it.shelfStatus == Book.ShelfStatus.SHELF_STATUS_ON)
                        R.string.has_been_in_bookcase
                    else
                        R.string.add_bookcase
                )
        }
    }

    private fun getNumFormatSpan(collectionCount: Int): SpannableStringBuilder? {
        return SpanUtils().apply {
            append(StringUtils.getStringByDividend(collectionCount, 10000))
            if (collectionCount >= 10000) {
                append("万")
                setFontSize(11.dip2Px)
            }
            append("+")
            setFontSize(11.dip2Px)
        }.create()
    }

    override fun refreshGuessYouLike() {
        if (mPresenter?.togetherRead?.bookList?.isNotEmpty() == true) {
            everyone_watching_container.visibility = View.VISIBLE
            if (everyone_watching_rv.layoutManager == null) {
                everyone_watching_rv.layoutManager = FullyLinearLayoutManager(this@BookDetailActivity)
                everyone_watching_rv.adapter = everyoneWatchingAdapter
            }
            everyoneWatchingAdapter.setNewData(mPresenter?.togetherRead?.bookList)
        } else {
            everyone_watching_container.visibility = View.GONE
        }
    }

    override fun refreshAd() {
        if (mPresenter?.adViewList?.isNotEmpty() == true) {
            mPresenter?.adViewList?.let {
                val nextAdIndex = mPresenter!!.getNextAdIndex()
                val nativeExpressADView = it[nextAdIndex]
                UtilsView.removeParent(nativeExpressADView)
                ad_container.addView(nativeExpressADView)
                nativeExpressADView.render()
                close_ad_container.visibility = View.VISIBLE
                ad_all_container.visibility = View.VISIBLE
            }
        } else {
            ad_all_container.visibility = View.GONE
        }
    }

    override fun isRefresh(isRefresh: Boolean) {
        refresh_layout.isRefreshing = isRefresh
    }


}