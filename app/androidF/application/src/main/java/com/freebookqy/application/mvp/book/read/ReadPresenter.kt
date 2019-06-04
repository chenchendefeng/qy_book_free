package com.freebookqy.application.mvp.book.read


import com.freebookqy.application.app.QYAccount
import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.base.QYBasePresenter
import com.freebookqy.application.app.rx.SimpleErrorSubscribe
import com.freebookqy.application.app.rx.SimpleObserver
import com.freebookqy.application.app.rx.netReq
import com.freebookqy.application.mvp.contranct.ReadContract
import com.freebookqy.application.mvp.model.dao.BookChapterBean
import com.freebookqy.application.mvp.model.dao.CollBookBean
import com.freebookqy.application.mvp.model.entity.Chapter
import com.freebookqy.application.mvp.model.entity.book.Book
import com.freebookqy.utilslib.ResUtils
import com.freebookqy.utilslib.ThreadManager
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.utils.DataHelper
import greendao.BookRepository
import io.reactivex.disposables.Disposable
import okhttp3.*
import org.jetbrains.anko.collections.forEachWithIndex
import java.io.IOException
import java.io.InputStream
import java.util.*
import javax.inject.Inject


/**
 * Created by leafye on 2019/5/7.
 */
@ActivityScope
class ReadPresenter
@Inject
constructor(model: ReadContract.Model, view: ReadContract.View) :
    QYBasePresenter<ReadContract.Model, ReadContract.View>(model, view) {

    var chapterList: MutableList<Chapter>? = null

    var mCollBook: CollBookBean? = null

    fun getChapterBeanList(): MutableList<BookChapterBean> {
        val list = mutableListOf<BookChapterBean>()
        chapterList?.forEach {
            val chapterBean = BookChapterBean().apply {
                id = "" + it.cid
                title = it.chapterTitle
                bookId = "" + it.bid
            }
            list.add(chapterBean)
        }
        return list
    }


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

    fun loadBookChapterList() {
        //先获取本地
        mCollBook = BookRepository.getInstance().getCollBook(mCollBook?._id)
        fetchBookDetail()
        fetchChapterList()
    }

    fun fetchBookDetail() {
        if (mCollBook != null) {
            return
        }
        mModel.bookDetail(mCollBook?._id?.toInt() ?: 0)
            .netReq(mRootView)
//            .retryUntil {
//                netCount++
//                mCollBook != null ||netCount>=5
//            }
            .subscribe(object : SimpleErrorSubscribe<BaseEntity<Book>>(mRootView) {
                override fun success(t: BaseEntity<Book>) {
                    t.data?.let {
                        mCollBook = t.data?.createCollBookBean()
                        BookRepository.getInstance().saveCollBook(it.getCollBookBean())
                    }
                    mCollBook = BookRepository.getInstance().getCollBook(mCollBook?._id)
                    mRootView.initReadView()
                }

                override fun onError(e: Throwable) {
                    mRootView.hideLoading()
                }
            })
    }

    private fun fetchChapterList() {
        mModel.listChapter(mCollBook?._id?.toInt() ?: 0)
            .netReq(mRootView)
            .subscribe(object : SimpleErrorSubscribe<BaseEntity<MutableList<Chapter>>>(mRootView) {
                override fun success(t: BaseEntity<MutableList<Chapter>>) {
                    chapterList = t.data
                    //异步下载更新的内容存到数据库
                    mCollBook?.let {
                        mCollBook?.bookChapters = getChapterBeanList()
                        BookRepository.getInstance().saveCollBook(mCollBook)
                    }
                    mRootView.getReadPageLoader()?.collBook?.bookChapters = getChapterBeanList()
                    checkNeedDownloadBookContent()
                    mRootView.refreshChapter()
                }
            })
    }

    private fun checkNeedDownloadBookContent() {
        val chapterCached = BookRepository
            .isChapterCached("" + (mCollBook?._id ?: 0), "" + (chapterList?.get(0)?.cid ?: 0))
        if (chapterCached) {
            mRootView.finishChapters()
        } else {
            chapterList?.forEachWithIndex { i, chapter ->
                if (i > 100) return
                if (!BookRepository.isChapterCached("" + chapter.bid, "" + chapter.cid)) {
                    mModel.chapterContent(chapter.bid, chapter.cid)
                        .netReq(mRootView)
                        .subscribeWith(object : SimpleObserver<BaseEntity<Chapter>>() {
                            override fun onNext(t: BaseEntity<Chapter>) {
                                getOssStr("" + chapter.bid, "" + chapter.cid, t.data?.ossUrl ?: "", true)
                            }

                            override fun onError(e: Throwable) {
                                super.onError(e)
                                e.printStackTrace()
                            }
                        })
                }
            }
        }
    }


    private val mChapterSub: Disposable? = null

//    fun loadChapter(bookId: String, bookChapters: List<TxtChapter>) {
//        val size = bookChapters.size
//        //取消上次的任务，防止多次加载
//        mChapterSub?.dispose()
//        val chapterInfos = ArrayList<Single<ChapterInfoBean>>(bookChapters.size)
//        val titles = ArrayDeque<String>(bookChapters.size)
//
//        // 将要下载章节，转换成网络请求。
//        for (i in 0 until size) {
//            val bookChapter = bookChapters[i]
//            // 网络中获取数据
//            val chapterInfoSingle = RemoteRepository.getInstance()
//                .getChapterInfo(bookChapter.getLink())
//            chapterInfos.add(chapterInfoSingle)
//            titles.add(bookChapter.getTitle())
//        }
//        val title = arrayOf(titles.poll())
//        Single.concat(chapterInfos)
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({ chapterInfoBean ->
//                //存储数据
//                BookRepository.getInstance().saveChapterInfo(
//                    bookId, title[0], chapterInfoBean.getBody()
//                )
//                mRootView.finishChapter()
//                //将获取到的数据进行存储
//                title[0] = titles.poll()
//            }, { throwable ->
//                //只有第一个加载失败才会调用errorChapter
//                if (bookChapters[0].getTitle().equals(title[0])) {
//                    //mRootView.errorChapter()
//                }
//            }
//            )
//    }


    fun getOssStr(bookId: String, ccid: String, url: String, isCurrent: Boolean) {
        //1.创建OkHttpClient对象
        val okHttpClient = OkHttpClient()
        //2.创建Request对象，设置一个url地址（百度地址）,设置请求方式。
        val request = Request.Builder().url(url).method("GET", null).build()
        //3.创建一个call对象,参数就是Request请求对象
        val call = okHttpClient.newCall(request)
        //4.请求加入调度，重写回调方法
        call.enqueue(object : Callback {
            //请求失败执行的方法
            override fun onFailure(call: Call, e: IOException) {}

            //请求成功执行的方法
            @Throws(IOException::class)
            override fun onResponse(call: Call, response: Response) {
                val `is` = response.body()!!.byteStream()
                //BookManager.getInstance().saveChapterInfo(bookId, ccid, inputStream2String(`is`))
                BookRepository.getInstance()
                    .saveChapterInfo(bookId, ccid, inputStream2String(`is`))
                if (isCurrent) {
                    ThreadManager.getMainHandler().post { mRootView.finishChapters() }
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

    private var readTime: Long = 0L

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
    }
}