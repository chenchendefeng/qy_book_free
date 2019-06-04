package com.freebookqy.application.mvp.book.detail

import com.freebookqy.application.app.QYAccount
import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.base.QYBasePresenter
import com.freebookqy.application.app.constant.Constant
import com.freebookqy.application.app.rx.SimpleErrorSubscribe
import com.freebookqy.application.app.rx.netReq
import com.freebookqy.application.mvp.account.Login.LoginActivity
import com.freebookqy.application.mvp.book.read.ReadActivity
import com.freebookqy.application.mvp.contranct.BookDetailContract
import com.freebookqy.application.mvp.model.entity.TogetherRead
import com.freebookqy.application.mvp.model.entity.book.Book
import com.freebookqy.application.mvp.model.entity.book.PutOn
import com.freebookqy.application.mvp.model.event.BookEvent
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.EventBusManager
import com.jess.arms.utils.RxLifecycleUtils
import greendao.BookRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import javax.inject.Inject

/**
 * Created by leafye on 2019/5/7.
 */
@ActivityScope
class BookDetailPresenter
@Inject
constructor(model: BookDetailContract.Model, view: BookDetailContract.View) :
    QYBasePresenter<BookDetailContract.Model, BookDetailContract.View>(model, view) {

    var extraBook: Book? = null

    private var pageSize: Int = 3

    var togetherRead: TogetherRead? = null

    fun fetchData() {
        //先获取书籍数据
        //再获取大家都在看
        mModel.bookDetail(extraBook?.bid ?: 0)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                mRootView.isRefresh(true)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .doOnNext {
                it.data?.category = extraBook?.category ?: it.data?.category ?: ""
                extraBook = it.data
                BookRepository.getInstance().saveCollBook(it.data?.getCollBookBean())
                //BookManager.getInstance().saveBookDetail(it.data)
                mRootView.refreshBookInfo()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .concatMap { t ->
                mModel.pageListTogetherRead(
                    pageNo = getPageNo(),
                    pageSize = pageSize,
                    category = extraBook?.category ?: ""
                )
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .subscribe(object : ErrorHandleSubscriber<BaseEntity<TogetherRead>>(mErrorHandler) {
                override fun onNext(t: BaseEntity<TogetherRead>) {
                    togetherRead = t.data
                    mRootView.refreshGuessYouLike()
                    mRootView.isRefresh(false)
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    mRootView.isRefresh(false)
                }
            })
    }

    private fun getPageNo(): Int {
        var pageNo = 0
        togetherRead?.let {
            pageNo = if (it.pageNo >= it.pages)
                0
            else
                it.pageNo

        }
        return pageNo + 1
    }

    fun startShare(@Constant.ShareType shareType: Int) {
        //开始分享

    }

    fun hasAd(): Boolean {
        return false
    }

    /**
     * 存入书架
     */
    fun putOn() {
        if (!QYAccount.isLogin()) {
            LoginActivity.startActivity(mRootView.getContext())
            return
        }
        val bid = extraBook?.bid ?: return
        val cuId = QYAccount.getUserInfo().cuId
        mModel.putOn(cuId.toInt(), bid)
            .netReq(mRootView)
            .subscribe(object : SimpleErrorSubscribe<BaseEntity<PutOn>>(mRootView) {
                override fun success(t: BaseEntity<PutOn>) {
                    //书籍存入成功
                    postBookPutOnSuccessEvent()
                    mRootView.showSuccess(t.msg)
                    extraBook?.shelfStatus = Book.ShelfStatus.SHELF_STATUS_ON
                    mRootView.refreshBookInfo()
                }
            })
    }

    private fun postBookPutOnSuccessEvent() {
        val bookEvent = BookEvent(
            key = BookEvent.PUT_ON_BOOK_SUCCESS,
            obj = extraBook
        )
        EventBusManager.getInstance().post(bookEvent)
    }

    fun enterRead() {
        //书籍详情 然后获取书籍列表

        mModel.getChapterList(extraBook?.bid?:0)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                mRootView.showLoading()
            }
            .observeOn(AndroidSchedulers.mainThread())
            .doFinally {
                mRootView.hideLoading()
            }
            .doOnNext {

            }

        extraBook?.let {
            ReadActivity.startActivity(mRootView.getContext(), it.createCollBookBean())
        }
    }

}