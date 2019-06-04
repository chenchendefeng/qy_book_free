package com.freebookqy.application.mvp.book.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.freebookqy.application.R
import com.freebookqy.application.app.base.QYBaseActivity
import com.freebookqy.application.di.component.DaggerBookDetailComponent
import com.freebookqy.application.di.module.BookDetailModule
import com.freebookqy.application.dialog.ShareBookDialog
import com.freebookqy.application.ext.dip2Px
import com.freebookqy.application.ext.loadImage
import com.freebookqy.application.mvp.book.detail.adapter.EveryoneWatchingAdapter
import com.freebookqy.application.mvp.contranct.BookDetailContract
import com.freebookqy.application.mvp.model.entity.book.Book
import com.freebookqy.utilslib.BookNumChangeFormat
import com.freebookqy.utilslib.ResUtils
import com.freebookqy.utilslib.SpanUtils
import com.freebookqy.viewlib.rv.layoutmanager.FullyLinearLayoutManager
import com.jess.arms.di.component.AppComponent
import kotlinx.android.synthetic.main.activity_book_detail.*

/**
 * Created by leafye on 2019/5/7.
 */
class BookDetailActivity :
    QYBaseActivity<BookDetailPresenter>(),
    BookDetailContract.View {

    companion object {

        private const val EXTRA_BOOK = "extraBook"

        @JvmStatic
        fun startActivity(
            context: Context,
            book: Book
        ) {
            context.startActivity(
                Intent(context, BookDetailActivity::class.java).apply {
                    putExtra(EXTRA_BOOK, book)
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
        EveryoneWatchingAdapter(null)
    }

    override fun initView(savedInstanceState: Bundle?): Int = R.layout.activity_book_detail

    override fun getToolbar(): View? = title_bar_view

    override fun initData(savedInstanceState: Bundle?) {
        intent.apply {
            getSerializableExtra(EXTRA_BOOK).let {
                if (it is Book) mPresenter?.extraBook = it
            }
        }
        initListener()
        refreshBookInfo()
        mPresenter?.fetchData()
    }

    private fun initListener() {
        title_bar_view.setOnLeftButtonClickListener { finish() }
        title_bar_view.setOnRightButtonClickListener { showShareDialog() }
        refresh_layout.setOnRefreshListener { mPresenter?.fetchData() }
        bookcase_tv.setOnClickListener { mPresenter?.putOn() }
        free_read_book_tv.setOnClickListener { mPresenter?.enterRead() }
    }

    private fun showShareDialog() {
        ShareBookDialog(this@BookDetailActivity).apply {
            setShareListener(object : ShareBookDialog.ShareListener {
                override fun share(shareType: Int) {
                    mPresenter?.startShare(shareType)
                }
            })
        }.show()
    }

    override fun refreshBookInfo() {
        collection_tv.text = SpanUtils()
            .append("${mPresenter?.extraBook?.collectionCount ?: 0}")
            .append("万+")
            .setFontSize(11.dip2Px)
            .create()
        had_read_tv.text = SpanUtils()
            .append("${mPresenter?.extraBook?.readedCount ?: 0}")
            .append("万+")
            .setFontSize(11.dip2Px)
            .create()
        reading_tv.text = SpanUtils()
            .append("${mPresenter?.extraBook?.readingCount ?: 0}")
            .append("万+")
            .setFontSize(11.dip2Px)
            .create()
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
            book_status_tv.text = it.getFinishFlagStatus()
            btm_btn_container.visibility = View.VISIBLE
            bookcase_tv.text =
                ResUtils.getString(
                    if (it.shelfStatus == Book.ShelfStatus.SHELF_STATUS_ON)
                        R.string.has_been_in_bookcase
                    else
                        R.string.add_bookcase
                )
        }
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
        if (mPresenter?.hasAd() == true) {
            ad_all_container.visibility = View.VISIBLE
        } else {
            ad_all_container.visibility = View.GONE
        }
    }

    override fun isRefresh(isRefresh: Boolean) {
        refresh_layout.isRefreshing = isRefresh
    }


}