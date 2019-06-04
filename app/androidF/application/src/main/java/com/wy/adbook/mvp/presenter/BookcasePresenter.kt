package com.wy.adbook.mvp.presenter

import com.chad.library.adapter.base.loadmore.LoadMoreView
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.integration.EventBusManager
import com.jess.arms.utils.RxLifecycleUtils
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.app.base.QYView
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.mvp.contranct.BookcaseContract
import com.wy.adbook.mvp.model.api.cache.ApiCacheSubscriber
import com.wy.adbook.mvp.model.api.service.QYService
import com.wy.adbook.mvp.model.entity.Bookcase
import com.wy.adbook.mvp.model.entity.NetBookcase
import com.wy.adbook.mvp.model.entity.book.Book
import com.wy.adbook.mvp.model.entity.book.NetRemove
import com.wy.adbook.mvp.model.event.MainEvent
import com.wy.adbook.mvp.view.activity.BookDetailActivity
import com.wy.adbook.mvp.view.activity.ReadActivity
import com.wy.adbook.mvp.view.activity.SearchActivity
import com.wy.adbook.mvp.view.adapter.MultiBookcaseItem
import greendao.BookRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/30.
 */
@FragmentScope
class BookcasePresenter
@Inject
constructor(model: BookcaseContract.Model, view: BookcaseContract.View) :
    QYBasePresenter<BookcaseContract.Model, BookcaseContract.View>(model, view) {

    private var pageNo: Int = 0

    private var pageSize: Int = 0

    var bookcase: Bookcase? = null

    var newBookNum: Int = 0

    fun fetchBookcaseList(isRefresh: Boolean) {
        mModel
            .newBookNumPerWeek()
            .concatMap {
                newBookNum = it.data ?: 0
                mModel.fetchBookcase(pageNo, pageSize, QYAccount.uid())
            }
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                if (isRefresh) {
                    mRootView.refreshStatus(true)
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView as QYView))
            .doFinally {
                mRootView?.refreshStatus(false)
            }
            .subscribe(object :
                ApiCacheSubscriber<NetBookcase>(
                    mErrorHandler,
                    QYService.BOOK_SHELF_PAGE_LIST,
                    NetBookcase::class.java,
                    isRefresh
                ) {
                override fun onCache(t: NetBookcase?) {
                    if (isRefresh)
                        t?.data?.let {
                            bookcase = it
                        }
                }

                override fun onSuccess(t: NetBookcase) {
                    if (t.isOk()) {
                        if (bookcase == null) {
                            bookcase = t.data
                        } else {
                            t.data?.data?.let {
                                if (isRefresh) {
                                    bookcase?.data?.clear()
                                }
                                bookcase?.data?.addAll(it)
                            }
                        }
                        mRootView.refreshVIew()
                        if ((bookcase?.data?.size ?: 0) >= (t.data?.count ?: 0)) {
                            mRootView.loadMoreStatus(LoadMoreView.STATUS_END)
                        } else {
                            mRootView.loadMoreStatus(LoadMoreView.STATUS_DEFAULT)
                        }
                    } else {
                        mRootView.loadMoreStatus(LoadMoreView.STATUS_FAIL)
                        //请求失败
                    }
                    mRootView.refreshStatus(false)
                }

                override fun onError(e: Throwable) {
                    super.onError(e)
                    if (isRefresh && bookcase != null) {
                        mRootView.refreshVIew()
                        mRootView.loadMoreStatus(LoadMoreView.STATUS_DEFAULT)
                    } else {
                        mRootView.loadMoreStatus(LoadMoreView.STATUS_FAIL)
                    }
                }
            })
    }

    fun getBookItem(): MutableList<MultiBookcaseItem> {
        return mutableListOf<MultiBookcaseItem>().apply {
            bookcase?.data?.forEach {
                val multiBookcaseItem = MultiBookcaseItem()
                multiBookcaseItem.any = it
                add(multiBookcaseItem)
            }
        }
    }

    fun cashCheckClick() {

    }

    fun getCashEveryDay() {

    }

    fun makeLotMoney() {

    }

    fun enterSearch() {
        SearchActivity.startActivity(mRootView.getContext())
    }

    fun enterBookCity() {
        EventBusManager.getInstance().post(MainEvent(MainEvent.EVENT_ENTER_BOOK_CITY))
    }

    fun removeBook(book: Book) {
        mModel.removeBook(QYAccount.uid(), book.bid)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                mRootView.showLoading()
            }
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .subscribe(object : ErrorHandleSubscriber<NetRemove>(mErrorHandler) {
                override fun onNext(t: NetRemove) {
                    if (t.isOk()) {
                        mRootView?.getAdapter()?.data?.forEachIndexed { index, multiBookcaseItem ->
                            if (multiBookcaseItem.any is Book) {
                                if ((multiBookcaseItem.any as Book).bid == book.bid) {
                                    mRootView?.getAdapter()?.remove(index)
                                }
                            }
                        }
                        BookRepository.getInstance().getCollBook("" + book.bid).let {
                            it.shelfStatus = Book.ShelfStatus.SHELF_STATUS_OFF
                            BookRepository.getInstance().saveCollBook(it)
                        }
                        mRootView.showSuccess(t.msg)
                    } else {
                        mRootView.showError(t.msg)
                    }
                }

                override fun onError(e: Throwable) {
                    super.onError(e)
                    mRootView.hideLoading()
                }
            })
    }

    fun addBook(book: Book) {
        bookcase?.data?.let {
            val bookcaseItem = MultiBookcaseItem().apply {
                any = book
            }
            mRootView?.getAdapter()?.addData(0, bookcaseItem)
        }
    }

    fun bookContentClick(book: Book) {
        val collBook = BookRepository.getInstance().getCollBook(book.bid.toString())
        if (collBook != null) {
            ReadActivity.startActivity(mRootView.getContext(), collBook)
        } else {
            BookDetailActivity.startActivity(mRootView.getContext(), book)
        }
    }
}

