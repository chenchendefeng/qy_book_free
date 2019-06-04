package com.freebookqy.application.mvp.classification.detail.book

import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.base.QYBasePresenter
import com.freebookqy.application.app.constant.Constant
import com.freebookqy.application.mvp.book.detail.BookDetailActivity
import com.freebookqy.application.mvp.contranct.BookContract
import com.freebookqy.application.mvp.model.entity.book.Book
import com.freebookqy.application.mvp.model.entity.PageListByBookClass
import com.jess.arms.di.scope.ActivityScope
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import javax.inject.Inject

/**
 * Created by leafye on 2019/5/5.
 */
@ActivityScope
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
            .doOnSubscribe {
                mRootView.startRefreshLayout(true)
            }
            .doFinally {
                mRootView.startRefreshLayout(false)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ErrorHandleSubscriber<BaseEntity<PageListByBookClass>>(mErrorHandler) {
                override fun onNext(t: BaseEntity<PageListByBookClass>) {
                    if (t.result == BaseEntity.RESULT_OK) {
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
            .subscribe(object : ErrorHandleSubscriber<BaseEntity<PageListByBookClass>>(mErrorHandler) {
                override fun onNext(t: BaseEntity<PageListByBookClass>) {
                    if (t.result == BaseEntity.RESULT_OK) {
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