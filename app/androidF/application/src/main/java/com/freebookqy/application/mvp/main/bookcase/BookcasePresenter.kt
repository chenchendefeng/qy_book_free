package com.freebookqy.application.mvp.main.bookcase

import com.chad.library.adapter.base.loadmore.LoadMoreView
import com.freebookqy.application.app.QYAccount
import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.base.QYBasePresenter
import com.freebookqy.application.app.base.QYView
import com.freebookqy.application.app.rx.netReqConcat
import com.freebookqy.application.mvp.contranct.BookcaseContract
import com.freebookqy.application.mvp.main.MainEvent
import com.freebookqy.application.mvp.main.bookcase.adapter.MultiBookcaseItem
import com.freebookqy.application.mvp.main.search.SearchActivity
import com.freebookqy.application.mvp.model.entity.Bookcase
import com.freebookqy.application.mvp.model.entity.book.Book
import com.freebookqy.application.mvp.model.entity.book.Remove
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.EventBusManager
import com.jess.arms.utils.RxLifecycleUtils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/30.
 */
@ActivityScope
class BookcasePresenter
@Inject
constructor(model: BookcaseContract.Model, view: BookcaseContract.View) :
    QYBasePresenter<BookcaseContract.Model, BookcaseContract.View>(model, view) {

    private var pageNo: Int = 0

    private var pageSize: Int = 0

    var bookcase: Bookcase? = null

    var newBookNum: Int = 0

    fun fetchBookcaseList(isRefresh: Boolean) {
        val cuId = QYAccount.getUserInfo().cuId
        mModel
            .newBookNumPerWeek()
            .netReqConcat()
            .concatMap {
                newBookNum = it.data ?: 0
                mModel.fetchBookcase(pageNo, pageSize, cuId.toInt())
            }
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                if (isRefresh) {
                    mRootView.refreshStatus(true)
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally {
                mRootView.refreshStatus(false)
            }
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView as QYView))
            .subscribe(object : ErrorHandleSubscriber<BaseEntity<Bookcase>>(mErrorHandler) {
                override fun onNext(t: BaseEntity<Bookcase>) {
                    if (t.result == BaseEntity.RESULT_OK) {
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

                override fun onError(t: Throwable) {
                    t.printStackTrace()
                    mRootView.refreshStatus(false)
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
        val cuId = QYAccount.getUserInfo().cuId
        mModel.removeBook(cuId.toInt(), book.bid)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                mRootView.showLoading()
            }
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .subscribe(object : ErrorHandleSubscriber<BaseEntity<Remove>>(mErrorHandler) {
                override fun onNext(t: BaseEntity<Remove>) {
                    if (BaseEntity.RESULT_OK == t.result) {
                        mRootView?.getAdapter()?.data?.forEachIndexed { index, multiBookcaseItem ->
                            if (multiBookcaseItem.any is Book) {
                                if ((multiBookcaseItem.any as Book).bid == book.bid) {
                                    mRootView?.getAdapter()?.remove(index)
                                }
                            }
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
}

