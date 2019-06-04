package com.wy.adbook.mvp.presenter


import android.text.TextUtils
import com.freebookqy.utilslib.ResUtils
import com.freebookqy.utilslib.ThreadManager
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.EventBusManager
import com.jess.arms.utils.DataHelper
import com.jess.arms.utils.RxLifecycleUtils
import com.wy.adbook.app.base.BaseEntity
import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.app.manager.QYAccount
import com.wy.adbook.app.rx.RxUtils
import com.wy.adbook.app.rx.SimpleErrorSubscribe
import com.wy.adbook.app.rx.SimpleObserver
import com.wy.adbook.app.rx.net
import com.wy.adbook.app.utils.NetworkUtils
import com.wy.adbook.ext.toIntS
import com.wy.adbook.mvp.contranct.ReadContract
import com.wy.adbook.mvp.model.dao.BookChapterBean
import com.wy.adbook.mvp.model.dao.CollBookBean
import com.wy.adbook.mvp.model.entity.Chapter
import com.wy.adbook.mvp.model.entity.NetBookProgress
import com.wy.adbook.mvp.model.entity.NetChapterList
import com.wy.adbook.mvp.model.entity.NetReadFooterRecord
import com.wy.adbook.mvp.model.entity.book.Book
import com.wy.adbook.mvp.model.entity.book.NetBook
import com.wy.adbook.mvp.model.entity.book.NetPutOn
import com.wy.adbook.mvp.model.event.BookEvent
import greendao.BookRepository
import io.reactivex.Observable
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber
import okhttp3.*
import org.jetbrains.anko.collections.forEachWithIndex
import org.jetbrains.anko.toast
import java.io.IOException
import java.io.InputStream
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import kotlin.concurrent.thread


/**
 * Created by leafye on 2019/5/7.
 */
@ActivityScope
class ReadPresenter
@Inject
constructor(model: ReadContract.Model, view: ReadContract.View) :
    QYBasePresenter<ReadContract.Model, ReadContract.View>(model, view) {

    companion object {
        const val NET_GET_30S_WELFARE_READ_TIME = 31L
        private const val CACHE_COUNT = 20//缓存的章节数
    }

    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    var mCollBook: CollBookBean? = null

    private var readTime: Long = 0L

    private var onceTiming = 0L

    var timeCoutDownDisposable: Disposable? = null

    fun setFirstEnter() {
        DataHelper.setIntergerSF(
            mRootView.getContext(),
            ResUtils.getString(com.freebookqy.application.R.string.sp_qy_is_first_enter_book_read),
            1
        )
    }

    fun isFirstEnter(): Boolean {
        return DataHelper.getIntergerSF(
            mRootView.getContext(),
            ResUtils.getString(com.freebookqy.application.R.string.sp_qy_is_first_enter_book_read)
        ) == 0
    }

    private fun fetchBookDetail() {
        mModel.bookDetail(mCollBook?._id?.toInt() ?: 0)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .subscribe(object : SimpleErrorSubscribe<NetBook>(mRootView) {
                override fun success(t: NetBook) {
                    t.data?.let {
                        mCollBook = t.data?.createCollBookBean()
                        BookRepository.getInstance().saveCollBook(it.getCollBookBean())
                    }
                    mCollBook = BookRepository.getInstance().getCollBook(mCollBook?._id)
                    fetchChapterList()
                }

                override fun onError(e: Throwable) {
                    mRootView.showError("无法获取书籍信息")
                    RxUtils.delay(mRootView, 2, TimeUnit.SECONDS, mRootView.finish())
                }
            })
    }

    fun fetchChapterList() {
        mCollBook = BookRepository.getInstance().getCollBook(mCollBook?._id)
        if (mCollBook != null) {
            mModel.listChapter(mCollBook?._id?.toInt() ?: 0)
                .net(mRootView)
                .doOnNext { t ->
                    if (t.isOk()) {
                        val list = mutableListOf<BookChapterBean>().apply {
                            t.data?.forEach {
                                add(BookChapterBean().apply {
                                    id = it.cid.toString()
                                    title = it.chapterTitle
                                    bid = it.bid
                                })
                            }
                        }
                        //异步下载更新的内容存到数据库
                        mCollBook?.let {
                            mCollBook?.bookChapters = list
                            BookRepository.getInstance().saveCollBook(mCollBook)
                            BookRepository.getInstance().saveBookChapters(list)
                        }
                        mRootView.getReadPageLoader()?.collBook?.bookChapters = list
                    }
                }
                .subscribe(object : ErrorHandleSubscriber<NetChapterList>(mErrorHandler) {
                    override fun onNext(t: NetChapterList) {
                        if (t.isOk()) {
                            mRootView.refreshChapter()
                            checkNeedDownloadBookContent()
                        } else {
                            mRootView.showError(t.msg)
                            loadBookChapterList()
                        }
                    }

                    override fun onError(e: Throwable) {
                        super.onError(e)
                        loadBookChapterList()
                    }
                })
        } else {
            fetchBookDetail()
        }
    }

    fun loadBookChapterList() {
        //先获取本地
        BookRepository.getInstance()
            .getBookChaptersInRx(mCollBook?._id)
            .compose { RxUtils.toSimpleSingle(it) }
            .subscribe(object : SingleObserver<List<BookChapterBean>> {
                override fun onSuccess(t: List<BookChapterBean>) {
                    if (t.isEmpty()) {
                        //也没有缓存 提示用户检查网络
                        mRootView.showError("请检查网络设置")
                        mRootView.errorChapters()
                    } else {
                        if (mCollBook?.bookChapterList == null) {
                            mCollBook?.bookChapterList = t as MutableList<BookChapterBean>
                        } else {
                            mCollBook?.bookChapterList!!.clear()
                            mCollBook?.bookChapterList!!.addAll(t)
                        }
                        mRootView.getReadPageLoader()?.collBook?.bookChapters = mCollBook?.bookChapterList
                        checkNeedDownloadBookContent()
                    }
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    mRootView.showError("请检查网络设置")
                    mRootView.errorChapters()
                }
            })
    }

    private fun checkNeedDownloadBookContent() {
        val bookRecord = BookRepository.getInstance().getBookRecord(mCollBook?._id)
        val chapterCached = bookRecord != null && BookRepository
            .isChapterCached("" + (mCollBook?._id ?: 0), "" + mCollBook?.bookChapterList?.get(bookRecord.chapter)?.id)
        if (chapterCached) {
            ThreadManager.getMainHandler().post { mRootView.finishChapters() }
        } else {
            val bookRecordChapter = bookRecord?.chapter ?: 0
            var startChapter: BookChapterBean? = null
            mCollBook?.bookChapterList?.apply {
                startChapter = this[bookRecordChapter]
            }?.forEachIndexed { i, chapter ->
                if (i >= bookRecordChapter && i < bookRecordChapter + 10) {
                    val isCache: Boolean = BookRepository.isChapterCached("" + chapter.bid, "" + chapter.id)
                    if (!isCache) {
                        mModel.chapterContent(chapter.bid, chapter.id.toIntS())
                            .net(mRootView)
                            .subscribeWith(object : SimpleObserver<BaseEntity<Chapter>>() {
                                override fun onNext(t: BaseEntity<Chapter>) {
                                    if (t.isOk()) {
                                        getOssStr(
                                            "" + chapter.bid,
                                            "" + chapter.id,
                                            t.data?.ossUrl ?: "",
                                            startChapter?.id?.toIntS() == t.data?.cid
                                        )
                                    } else {
                                        //请求失败
                                        mRootView.errorChapters()
                                    }
                                }

                                override fun onError(e: Throwable) {
                                    super.onError(e)
                                    e.printStackTrace()
                                    mRootView.errorChapters()
                                }
                            })
                    } else {
                        ThreadManager.getMainHandler().post { mRootView.finishChapters() }
                    }
                }
            }
        }
    }

    //1.创建OkHttpClient对象
    private val okHttpClient by lazy {
        OkHttpClient()
    }

    fun getOssStr(bookId: String, ccid: String, url: String, isCurrent: Boolean) {
        //2.创建Request对象，设置一个url地址（百度地址）,设置请求方式。
        val request = Request.Builder().url(url).method("GET", null).build()
        //3.创建一个call对象,参数就是Request请求对象
        val call = okHttpClient.newCall(request)
        //4.请求加入调度，重写回调方法
        call.enqueue(object : Callback {
            //请求失败执行的方法
            override fun onFailure(call: Call, e: IOException) {
                mRootView.errorChapters()
            }

            //请求成功执行的方法
            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                val `is` = response.body()!!.byteStream()
                BookRepository.getInstance()
                    .saveChapterInfo(bookId, ccid, inputStream2String(`is`))
                if (isCurrent) {
                    ThreadManager.getMainHandler().postDelayed({ mRootView.finishChapters() }, 100)
                }
            }
        })
    }

    @Throws(IOException::class)
    fun inputStream2String(ins: InputStream): String {
        val out = StringBuffer()
        val b = ByteArray(4096)
        var n: Int
        n = ins.read(b)
        while (n != -1) {
            out.append(String(b, 0, n))
            n = ins.read(b)
        }
        return out.toString()
    }

    fun resetReadTime() {
        readTime = 0L
    }

    fun startCalculateReadTime() {
        readTime = Date().time
    }

    fun calculateReadTime() {
        if (readTime > 0) {
            val diffTime = (Date().time - readTime) / 1000 / 60
            QYAccount.updateTodayReadMinute(QYAccount.getTodayReadMinute() + diffTime)
        }
        readTime = 0L
        updateReadProgress()
    }

    /**
     * 尝试下载下一章节
     */
    fun tryDownloadNextChapter(curChapter: Int) {
        thread {
            var curChapterId: String = ""
            mCollBook?.bookChapterList?.apply {
                curChapterId = this[curChapter].id
            }?.forEachWithIndex { i, chapter ->
                if (i > curChapter + CACHE_COUNT) return@thread
                if (!BookRepository.isChapterCached("" + chapter.bid, "" + chapter.id)) {
                    mModel.chapterContent(chapter.bid, chapter.id.toIntS())
                        .net(mRootView)
                        .subscribeWith(object : SimpleObserver<BaseEntity<Chapter>>() {
                            override fun onNext(t: BaseEntity<Chapter>) {
                                if (t.isOk()) {
                                    getOssStr(
                                        "" + chapter.bid,
                                        "" + chapter.id,
                                        t.data?.ossUrl ?: "",
                                        TextUtils.equals(curChapterId, chapter.id)
                                    )
                                }
                            }

                            override fun onError(e: Throwable) {
                                super.onError(e)
                                e.printStackTrace()
                            }
                        })
                } else {
                    if (TextUtils.equals(curChapterId, chapter.id)) {
                        ThreadManager.getMainHandler().postDelayed({ mRootView.finishChapters() }, 100)
                    }
                }
            }
        }
    }

    /**
     * 添加到书架
     */
    fun addBookcase() {
        mRootView.showLoading()
        mModel.addToBookcase(QYAccount.uid(), mCollBook?._id?.toIntS() ?: 0)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .subscribe(object : ErrorHandleSubscriber<NetPutOn>(mErrorHandler) {
                override fun onNext(t: NetPutOn) {
                    if (t.isOk()) {
                        //书籍存入成功
                        postBookPutOnSuccessEvent()
                        mRootView.showSuccess(t.msg)
                        mCollBook?.shelfStatus = Book.ShelfStatus.SHELF_STATUS_ON
                        BookRepository.getInstance().saveCollBook(mCollBook)
                        mRootView.showSuccess(t.msg)
                    } else {
                        mRootView.showError(t.msg)
                    }
                    RxUtils.delay(mRootView, 1, TimeUnit.SECONDS, mRootView.finish())
                }

                override fun onError(t: Throwable) {
                    super.onError(t)
                    mRootView.hideLoading()
                }
            })
    }

    private fun postBookPutOnSuccessEvent() {
        val bookEvent = BookEvent(
            key = BookEvent.PUT_ON_BOOK_SUCCESS,
            obj = mCollBook
        )
        EventBusManager.getInstance().post(bookEvent)
    }

    /**
     * 更新读书进度到后台
     */
    private fun updateReadProgress() {
        val book = mCollBook ?: return
        val loader = mRootView.getReadPageLoader() ?: return
        val list = mCollBook?.bookChapterList ?: return
        val curPage = loader.mCurPage ?: return
        var position = loader.mCurPage?.position ?: 0
        if (curPage.isCustomView) {
            if (position > 0) {
                position -= 1
            }
        }
        var readWords = 0
        loader.mCurPageList?.forEachWithIndex { i, txtPage ->
            if (i > position) {
                return@forEachWithIndex
            }
            txtPage.lines?.forEach {
                readWords += it.length
            }

        }
        val chapterPos = loader.chapterPos
        val cid = list[chapterPos].id
        mModel.updateBookProgress(QYAccount.uid(), book._id.toIntS(), cid.toIntS(), readWords)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
            .subscribe(object : ErrorHandleSubscriber<NetBookProgress>(mErrorHandler) {
                override fun onNext(t: NetBookProgress) {

                }
            })

    }

    private val timeCoutDownObservable by lazy {
        Observable.interval(onceTiming, 1, TimeUnit.SECONDS)
    }

    /**
     * 开启计时
     */
    fun startTiming() {
        if (timeCoutDownDisposable == null
            || timeCoutDownDisposable?.isDisposed == true
        ) {
            timeCoutDownDisposable = timeCoutDownObservable
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext {
                    //检查网络是否ok
                    if (NetworkUtils.isAvailable()) {
                        onceTiming++
                        mRootView.refreshProgressBar(onceTiming.toFloat())
                    }
                }
                .subscribe {
                    if (onceTiming > 0 && onceTiming % NET_GET_30S_WELFARE_READ_TIME == 0L) {
                        //更新读书页面ui
                        _30sWelfareRead()
                        timeCoutDownDisposable?.dispose()
                    }
                }
            compositeDisposable.add(timeCoutDownDisposable!!)
        }
    }

    /**
     * 停止计时
     */
    fun stopTiming() {
        compositeDisposable.dispose()
    }

    private fun _30sWelfareRead() {
        if (QYAccount.isLogin()) {
            val disposable = mModel.get30sWelfareRead(QYAccount.uid())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                .doFinally { startTiming() }
                .subscribe {
                    if (it.isOk()) {
                        tip(it.msg)
                    } else {
                        mRootView.getContext().toast(it.msg)
                    }
                }
            compositeDisposable.add(disposable)
        }
    }

    private fun tip(tip: String) {
        mRootView.getGoldTipTv().text = tip
        val disposable = Observable.create<Int> { it.onNext(1) }
            .delay(1, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                onceTiming = 0
                mRootView.getGoldTipTv().text = ""
            }
        compositeDisposable.add(disposable)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }

    fun startDownload() {
        //需要显示进度条
        mCollBook?.bookChapterList?.forEachWithIndex { i, chapter ->
            if (!BookRepository.isChapterCached("" + chapter.bid, "" + chapter.id)) {
                mModel.chapterContent(chapter.bid, chapter.id.toIntS())
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .compose(RxLifecycleUtils.bindToLifecycle(mRootView))
                    .subscribeWith(object : SimpleObserver<BaseEntity<Chapter>>() {
                        override fun onNext(t: BaseEntity<Chapter>) {
                            if (t.isOk()) {
                                getOssStr("" + chapter.bid, "" + chapter.id, t.data?.ossUrl ?: "", false)
                            }
                        }

                        override fun onError(e: Throwable) {
                            super.onError(e)
                            e.printStackTrace()
                        }
                    })
            }
        }
    }

    fun recordBook() {
        mModel.recordBook(QYAccount.uid(), mCollBook?._id?.toIntS() ?: 0)
            .net(mRootView)
            .subscribe(object : ErrorHandleSubscriber<NetReadFooterRecord>(mErrorHandler) {
                override fun onNext(t: NetReadFooterRecord) {

                }
            })
    }


}