package com.wy.adbook.mvp.presenter

import com.jess.arms.di.scope.FragmentScope
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.app.constant.Constant
import com.wy.adbook.mvp.contranct.BookContract
import com.wy.adbook.mvp.model.entity.NetPageListByBookClass
import com.wy.adbook.mvp.model.entity.book.Book
import com.wy.adbook.mvp.view.activity.BookDetailActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import javax.inject.Inject

/**
 * Created by leafye on 2019/5/5.
 */
@FragmentScope
class BookPresenter
@Inject
constructor(model: BookContract.Model, view: BookContract.View) :
    QYBasePresenter<BookContract.Model, BookContract.View>(model, view) {

    var bookList: MutableList<Book>? = null

    var className: String = "玄幻"

    val finishFlag = 0

    private var pageNo: Int = 1


    fun fetchData() {
        mModel.pageListByBookClass(
            1,
            Constant.PAGE_SIZE,
            finishFlag,
            className
        )
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                mRootView.startRefreshLayout(true)
            }
            .doFinally {
                mRootView.startRefreshLayout(false)
            }
            .subscribe(object : ErrorHandleSubscriber<NetPageListByBookClass>(mErrorHandler) {
                override fun onNext(t: NetPageListByBookClass) {
                    if (t.isOk()) {
                        pageNo = t.data?.pageNo ?: pageNo
                        if (bookList == null) {
                            bookList = t.data?.bookList
                        } else {
                            bookList!!.clear()
                            t.data?.bookList?.let { bookList!!.addAll(it) }
                        }
                        mRootView.refreshView()
                    } else {
                        mRootView.showError(t.msg)
                        mRootView.getAdapter().loadMoreFail()
                    }
                }

            })

        mRootView.refreshView()
    }

    fun loadMore() {
        mModel.pageListByBookClass(
            pageNo + 1,
            Constant.PAGE_SIZE,
            finishFlag,
            className
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ErrorHandleSubscriber<NetPageListByBookClass>(mErrorHandler) {
                override fun onNext(t: NetPageListByBookClass) {
                    if (t.isOk()) {
                        pageNo = t.data?.pageNo ?: pageNo
                        t.data?.bookList?.let {
                            mRootView.getAdapter().addData(it)
                        }
                        if (t.data?.pageNo ?: 0 >= t.data?.pages ?: 0) {
                            mRootView.getAdapter().loadMoreEnd()
                        } else {
                            mRootView.getAdapter().loadMoreComplete()
                        }
                    } else {
                        mRootView.showError(t.msg)
                        mRootView.getAdapter().loadMoreFail()
                    }
                }

            })

        mRootView.refreshView()
    }


    fun enterBookDetail(book: Book) {
        BookDetailActivity.startActivity(mRootView.getContext(), book)
    }


}