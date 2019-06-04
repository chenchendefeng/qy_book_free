package com.wy.adbook.mvp.presenter

import android.text.TextUtils
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.utils.RxLifecycleUtils
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.mvp.contranct.SearchContract
import com.wy.adbook.mvp.model.entity.GuessYouLike
import com.wy.adbook.mvp.model.entity.NetGuessYouLike
import com.wy.adbook.mvp.model.entity.NetSearchResult
import com.wy.adbook.mvp.model.entity.SearchResult
import com.wy.adbook.mvp.model.entity.book.Book
import com.wy.adbook.mvp.view.activity.BookDetailActivity
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
            (searchResult?.pageNo ?: 1) + 1,
            pageSize
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .subscribe(object : ErrorHandleSubscriber<NetSearchResult>(mErrorHandler) {
                override fun onNext(t: NetSearchResult) {
                    if (t.isOk()) {
                        t.data?.searchResult?.let {
                            mRootView.searchAdapter().addData(it)
                        }
                        searchViewType =
                            VIEW_TYPE_SEARCH_RESULT
                        if (t.data?.pageNo ?: 0 >= t.data?.pages ?: 0) {
                            mRootView.searchAdapter().loadMoreEnd()
                        } else {
                            mRootView.searchAdapter().loadMoreComplete()
                        }
                    } else {
                        mRootView.showError(t.msg)
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
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .subscribe(object : ErrorHandleSubscriber<NetSearchResult>(mErrorHandler) {
                override fun onNext(t: NetSearchResult) {
                    if (t.isOk()) {
                        searchResult = t.data
                        searchKeyStr = key
                        searchViewType =
                            VIEW_TYPE_SEARCH_RESULT
                        mRootView.refreshView()
                        if (t.data?.pageNo ?: 0 >= t.data?.pages ?: 0) {
                            mRootView.searchAdapter().loadMoreEnd()
                        } else {
                            mRootView.searchAdapter().loadMoreComplete()
                        }
                    } else {
                        mRootView.showError(t.msg)
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
            .subscribe(object : ErrorHandleSubscriber<NetGuessYouLike>(mErrorHandler) {
                override fun onNext(t: NetGuessYouLike) {
                    if (t.isOk()) {
                        guessYouLike = t.data
                        mRootView.refreshView()
                        searchViewType =
                            VIEW_TYPE_GUESS
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