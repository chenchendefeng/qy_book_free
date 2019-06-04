package com.freebookqy.application.mvp.main.search

import android.text.TextUtils
import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.base.QYBasePresenter
import com.freebookqy.application.app.rx.netReq
import com.freebookqy.application.mvp.book.detail.BookDetailActivity
import com.freebookqy.application.mvp.contranct.SearchContract
import com.freebookqy.application.mvp.model.entity.GuessYouLike
import com.freebookqy.application.mvp.model.entity.SearchResult
import com.freebookqy.application.mvp.model.entity.book.Book
import com.jess.arms.di.scope.ActivityScope
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * Created by leafye on 2019/5/3.
 */
@ActivityScope
class SearchPresenter
@Inject
constructor(model: SearchContract.Model, view: SearchContract.View) :
    QYBasePresenter<SearchContract.Model, SearchContract.View>(model, view) {

    var guessYouLike: GuessYouLike? = null

    var searchResult: SearchResult? = null

    var searchKeyStr: String = ""

    private var pageSize: Int = 10

    private var guessLikePageSize = 3

    companion object {
        const val VIEW_TYPE_GUESS = 0
        const val VIEW_TYPE_START_SEARCH = 1
        const val VIEW_TYPE_SEARCH_RESULT = 2
    }


    var searchViewType: Int = VIEW_TYPE_GUESS

    fun fetchData() {
        fetchGuessYouLike(true, 0, guessLikePageSize)
    }

    fun loadMore() {
//        if (TextUtils.isEmpty(searchKeyStr)) {
//            mRootView.getContext().toast("请输入关键词")
//            return
//        }
        mModel.search(
            searchKeyStr,
            searchResult?.pageNo ?: 0 + 1,
            pageSize
        ).netReq(mRootView)
            .subscribe(object : ErrorHandleSubscriber<BaseEntity<SearchResult>>(mErrorHandler) {
                override fun onNext(t: BaseEntity<SearchResult>) {
                    t.data?.searchResult?.let {
                        mRootView.searchAdapter().addData(it)
                    }
                    searchViewType = VIEW_TYPE_SEARCH_RESULT
                    if (t.data?.pageNo ?: 0 >= t.data?.pages ?: 0) {
                        mRootView.searchAdapter().loadMoreEnd()
                    } else {
                        mRootView.searchAdapter().loadMoreComplete()
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    mRootView.searchAdapter().loadMoreFail()
                }
            })
    }

    fun search(key: String) {
        if (TextUtils.isEmpty(key)) {
            mRootView.getContext().toast("请输入关键词")
            return
        }
        var pageNo = 0
        if (TextUtils.equals(searchKeyStr, key)) {
            pageNo = 0
        }
        mModel.search(key, pageNo + 1, pageSize)
            .netReq(mRootView)
            .subscribe(object : ErrorHandleSubscriber<BaseEntity<SearchResult>>(mErrorHandler) {
                override fun onNext(t: BaseEntity<SearchResult>) {
                    searchResult = t.data
                    searchKeyStr = key
                    searchViewType = VIEW_TYPE_SEARCH_RESULT
                    mRootView.refreshView()
                    if (t.data?.pageNo ?: 0 >= t.data?.pages ?: 0) {
                        mRootView.searchAdapter().loadMoreEnd()
                    } else {
                        mRootView.searchAdapter().loadMoreComplete()
                    }
                }
            })
    }


    private fun fetchGuessYouLike(
        isRefresh: Boolean,
        pageNo: Int,
        pageSize: Int
    ) {
        mModel.guessYouLike(pageNo, pageSize)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : ErrorHandleSubscriber<BaseEntity<GuessYouLike>>(mErrorHandler) {
                override fun onNext(t: BaseEntity<GuessYouLike>) {
                    if (t.result == BaseEntity.RESULT_OK) {
                        guessYouLike = t.data
                        mRootView.refreshView()
                        searchViewType = VIEW_TYPE_GUESS
                    } else {
                        mRootView.showError(t.msg)
                    }
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    if (!isRefresh)
                        mRootView.searchAdapter().loadMoreFail()
                }
            })
    }


    fun enterBookDetail(book: Book) {
        BookDetailActivity.startActivity(mRootView.getContext(), book)
    }

    fun change() {
        var no = guessYouLike?.pageNo ?: 0
        if (no > guessYouLike?.pages ?: 0) {
            no = 0
        }
        fetchGuessYouLike(false, no + 1, guessLikePageSize)
    }

}