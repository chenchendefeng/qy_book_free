package com.wy.adbook.mvp.presenter

import android.app.Activity
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.EventBusManager
import com.jess.arms.utils.LogUtils
import com.jess.arms.utils.RxLifecycleUtils
import com.qq.e.ads.nativ.NativeExpressAD
import com.qq.e.ads.nativ.NativeExpressADView
import com.qq.e.comm.util.AdError
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.app.constant.Constant
import com.wy.adbook.app.manager.ADManager
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.app.manager.ShareManager
import com.wy.adbook.app.rx.net
import com.wy.adbook.app.utils.ShareUtils
import com.wy.adbook.dialog.share.ShareBookDialog
import com.wy.adbook.dialog.share.ShareDialog
import com.wy.adbook.mvp.contranct.BookDetailContract
import com.wy.adbook.mvp.model.entity.NetTogetherRead
import com.wy.adbook.mvp.model.entity.TogetherRead
import com.wy.adbook.mvp.model.entity.book.Book
import com.wy.adbook.mvp.model.entity.book.NetPutOn
import com.wy.adbook.mvp.model.event.BookEvent
import com.wy.adbook.mvp.view.activity.LoginActivity
import com.wy.adbook.mvp.view.activity.ReadActivity
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

    var extraBookId: Int = 0

    private var pageSize: Int = 3

    var adViewList: MutableList<NativeExpressADView>? = null

    private var currentAdIndex: Int = -1

    var togetherRead: TogetherRead? = null

    private var isCloseAd: Boolean = false

    fun fetchData() {
        //先获取书籍数据
        //再获取大家都在看
        var bid1 = this.extraBook?.bid ?: 0
        if (bid1 == 0) {
            bid1 = extraBookId
        }
        mModel.bookDetail(bid1)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                mRootView.isRefresh(true)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .doOnNext {
                it.data?.category = extraBook?.category ?: it.data?.category ?: ""
                extraBook = it.data
                BookRepository.getInstance().saveCollBookWithAsync(it.data?.getCollBookBean())
                mRootView.refreshBookInfo(true)
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
            .subscribe(object : ErrorHandleSubscriber<NetTogetherRead>(mErrorHandler) {
                override fun onNext(t: NetTogetherRead) {
                    togetherRead = t.data
                    mRootView.refreshGuessYouLike()
                    mRootView.isRefresh(false)
                    requestAd()
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

    fun startShare(shareDialog: ShareDialog, @Constant.ShareType shareType: Int) {
        //开始分享
        shareDialog.dismiss()
        if (shareDialog !is ShareBookDialog) {
            return
        }
        val shareBitmap = shareDialog.getShareBitmap()
        when (shareType) {
            Constant.ShareType.SHARE_TYPE_WX_PYQ -> ShareUtils.ShareWXSceneTimeline(shareBitmap)
            Constant.ShareType.SHARE_TYPE_WX_HY -> ShareUtils.ShareWXSceneSession(shareBitmap)
            Constant.ShareType.SHARE_TYPE_QQ -> ShareUtils.ShareQQ(
                mRootView.getContext() as Activity,
                shareBitmap,
                object : ShareUtils.BaseUiListener() {
                    override fun onComplete(response: Any?) {
                        super.onComplete(response)
                        shareSuccess()
                    }
                }
            )
        }
    }

    fun shareSuccess() {
        ShareManager.shareSuccess(mRootView, mModel.getRm(), QYAccount.uid(), mErrorHandler)
    }

    private fun requestAd() {
        ADManager.displayNativeExpressAD(
            mRootView.getContext(),
            ADManager.POSID_FREEPAGE,
            object : NativeExpressAD.NativeExpressADListener {
                override fun onADCloseOverlay(p0: NativeExpressADView?) {
                    LogUtils.debugInfo("onADCloseOverlay")
                }

                override fun onADLoaded(p0: MutableList<NativeExpressADView>?) {
                    LogUtils.debugInfo("onADLoaded")
                    if (isCloseAd) {
                        adViewList = null
                    } else {
                        adViewList = p0
                    }
                    mRootView.refreshAd()
                }

                override fun onADOpenOverlay(p0: NativeExpressADView?) {
                    LogUtils.debugInfo("onADOpenOverlay")
                }

                override fun onRenderFail(p0: NativeExpressADView?) {
                    LogUtils.debugInfo("onRenderFail")
                }

                override fun onADExposure(p0: NativeExpressADView?) {
                    LogUtils.debugInfo("onADExposure")
                }

                override fun onADClosed(p0: NativeExpressADView?) {
                    LogUtils.debugInfo("onADClosed")
                    closeAd()
                }

                override fun onADLeftApplication(p0: NativeExpressADView?) {
                    LogUtils.debugInfo("onADLeftApplication")
                }

                override fun onNoAD(p0: AdError?) {
                    LogUtils.debugInfo("onNoAD")
                }

                override fun onADClicked(p0: NativeExpressADView?) {
                    LogUtils.debugInfo("onADClicked")
                }

                override fun onRenderSuccess(p0: NativeExpressADView?) {
                    LogUtils.debugInfo("onRenderSuccess")
                }
            }
        )
    }

    fun closeAd() {
        isCloseAd = true
        adViewList = null
        currentAdIndex = -1
        mRootView.refreshAd()
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
        mRootView.showLoading()
        mModel.putOn(QYAccount.uid(), bid)
            .net(mRootView)
            .subscribe(object : ErrorHandleSubscriber<NetPutOn>(mErrorHandler) {
                override fun onNext(t: NetPutOn) {
                    if (t.isOk()) {
                        //书籍存入成功
                        postBookPutOnSuccessEvent()
                        mRootView.showSuccess(t.msg)
                        extraBook?.shelfStatus = Book.ShelfStatus.SHELF_STATUS_ON
                        var collBook = BookRepository.getInstance().getCollBook("" + (extraBook?.bid ?: 0))
                        if (collBook != null) {
                            collBook.shelfStatus = Book.ShelfStatus.SHELF_STATUS_ON
                        } else {
                            collBook = extraBook?.getCollBookBean()
                        }
                        BookRepository.getInstance().saveCollBook(collBook)
                        mRootView.refreshBookInfo(true)
                    } else {
                        mRootView.showError(t.msg)
                    }
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
        extraBook?.let {
            if (it.shelfStatus == Book.ShelfStatus.SHELF_STATUS_OFF)
                ReadActivity.startActivity(mRootView.getContext(), it.createCollBookBean())
        }
    }

    fun getNextAdIndex(): Int {
        val size = adViewList?.size ?: -1
        if (size == -1) return -1
        if (currentAdIndex + 1 >= size) {
            currentAdIndex = 0
        } else {
            currentAdIndex++
        }
        return currentAdIndex
    }


}