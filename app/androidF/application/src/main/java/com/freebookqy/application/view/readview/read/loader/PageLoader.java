//package com.freebookqy.application.view.readview.read.loader;
//
//import android.graphics.Bitmap;
//import android.support.annotation.Nullable;
//import com.freebookqy.application.mvp.model.entity.book.bookread.BookDetailsBean;
//import com.freebookqy.application.mvp.model.entity.book.bookread.ChapterListBean;
//import com.freebookqy.application.view.readview.IPageView;
//import com.freebookqy.application.view.readview.bean.BookRecordBean;
//import com.freebookqy.application.view.readview.bean.TxtChapter;
//import com.freebookqy.application.view.readview.bean.TxtPage;
//import com.freebookqy.application.view.readview.read.PageLoaderDraw;
//import com.freebookqy.application.view.readview.read.PageLoaderState;
//import com.freebookqy.viewlib.book.utils.ToastUtils;
//import greendao.helper.BookRecordHelper;
//import io.reactivex.Observable;
//import io.reactivex.ObservableOnSubscribe;
//import io.reactivex.Observer;
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.disposables.Disposable;
//import io.reactivex.schedulers.Schedulers;
//
//import java.io.BufferedReader;
//import java.lang.ref.WeakReference;
//import java.util.ArrayList;
//import java.util.List;
//
//
//public abstract class PageLoader implements IPageLoader {
//    //当前章节列表
//    List<TxtChapter> mChapterList;
//    //监听器
//    OnPageChangeListener mPageChangeListener;
//
//    private PageLoaderDraw mPageLoaderDraw;
//
//    //当前显示的页
//    private TxtPage mCurPage;
//    //上一章的页面列表缓存
//    private WeakReference<List<TxtPage>> mWeakPrePageList;
//    //当前章节的页面列表
//    private List<TxtPage> mCurPageList;
//
//    //下一章的页面列表缓存
//    private List<TxtPage> mNextPageList;
//
//    //被遮盖的页，或者认为被取消显示的页
//    private TxtPage mCancelPage;
//    //存储阅读记录类
//    BookRecordBean mBookRecord;
//    /*****************params**************************/
//    //当前的状态
//    int mStatus = PageLoaderState.STATUS_LOADING;
//    //当前章
//    int mCurChapterPos = 0;
//    //书本是否打开
//    boolean isBookOpen = false;
//
//    private Disposable mPreLoadDisp;
//    //上一章的记录
//    private int mLastChapter = 0;
//
//    private boolean showAD;
//
//    private BookDetailsBean mCollBook;
//
//    public PageLoader(IPageView pageView) {
//        mPageLoaderDraw = new PageLoaderDraw();
//        mPageLoaderDraw.init(pageView);
//    }
//
//
//    //跳转到上一章
////    public intface skipPreChapter() {
////        if (!isBookOpen) {
////            return mCurChapterPos;
////        }
////
////        //载入上一章。
////        if (prevChapter()) {
////            mCurPage = getCurPage(0);
////            mPageLoaderDraw.refreshPage();
////        }
////        return mCurChapterPos;
////    }
//
//    //跳转到下一章
////    public intface skipNextChapter() {
////        if (!isBookOpen) {
////            return mCurChapterPos;
////        }
////
////        //判断是否达到章节的终止点
////        if (nextChapter()) {
////            mCurPage = getCurPage(0);
////            mPageLoaderDraw.refreshPage();
////        }
////        return mCurChapterPos;
////    }
//
//    //跳转到指定章节
//    public void skipToChapter(int pos) {
//        //正在加载
//        mStatus = PageLoaderState.STATUS_LOADING;
//        //绘制当前的状态
//        mCurChapterPos = pos;
//        //将上一章的缓存设置为null
//        mWeakPrePageList = null;
//        //如果当前下一章缓存正在执行，则取消
//        if (mPreLoadDisp != null) {
//            mPreLoadDisp.dispose();
//        }
//        //将下一章缓存设置为null
//        mNextPageList = null;
//        if (mCurPage != null) {
//            //重置position的位置，防止正在加载的时候退出时候存储的位置为上一章的页码
//            mCurPage.position = 0;
//        }
//        if (mPageChangeListener != null) {
//            mPageChangeListener.onChapterChange(mCurChapterPos);
//        }
//
//        //需要对ScrollAnimation进行重新布局
//        mPageLoaderDraw.refreshPage();
//    }
//
////    //跳转到具体的页
////    public void skipToPage(intface pos) {
////        mCurPage = getCurPage(pos);
////        mPageView.refreshPage();
////    }
////
////    //自动翻到上一章
////    public boolean autoPrevPage() {
////        if (!isBookOpen) return false;
////        return mPageView.autoPrevPage();
////    }
////
////    //自动翻到下一章
////    public boolean autoNextPage() {
////        if (!isBookOpen) return false;
////        return mPageView.autoNextPage();
////    }
//
//
//    //设置页面切换监听
//    public void setOnPageChangeListener(OnPageChangeListener listener) {
//        mPageChangeListener = listener;
//    }
//
//    //获取当前页的状态
//    public int getPageStatus() {
//        return mStatus;
//    }
//
//    //获取当前章节的章节位置
//    public int getChapterPos() {
//        return mCurChapterPos;
//    }
//
//    //获取当前页的页码
//    public int getPagePos() {
//        return mCurPage == null ? 0 : mCurPage.position;
//    }
//
//    //保存阅读记录
//    public void saveRecord() {
//        //书没打开，就没有记录
//        if (!isBookOpen || mBookRecord == null) return;
//        // mBookRecord.setBookId(mBookRecord.getBookId());
//        mBookRecord.setChapter(mCurChapterPos);
//        mBookRecord.setPagePos(getPagePos());
//        //存储到数据库
//        BookRecordHelper.getsInstance().saveRecordBook(mBookRecord);
//    }
//
//    //打开书本，初始化书籍
//    public void openBook(BookDetailsBean collBook) {
//        mCollBook = collBook;
//        //从数据库取阅读数据
//        mBookRecord = BookRecordHelper.getsInstance()
//                .findBookRecordById(collBook.getCBID());
//        if (mBookRecord == null) {
//            mBookRecord = new BookRecordBean();
//            mBookRecord.setBookId(collBook.getCBID());
//        }
//        showAD = "-1".equals(mCollBook.getFreeStatus());
//        mCurChapterPos = mBookRecord.getChapter();
//
//        mLastChapter = mCurChapterPos;
//    }
//
//    //打开具体章节
//    public void openChapter() {
//        mCurPageList = loadPageList(mCurChapterPos);
//        //进行预加载
//        preLoadNextChapter();
//        //加载完成
//        mStatus = PageLoaderState.STATUS_FINISH;
//        //获取制定页面
//        if (!isBookOpen) {
//            isBookOpen = true;
//            //可能会出现当前页的大小大于记录页的情况。
//
//            int position = 0;
//            if (mBookRecord != null) {
//                position = mBookRecord.getPagePos();
//            }
//            if (mCurPageList != null) {
//                if (position >= mCurPageList.size()) {
//                    position = mCurPageList.size() - 1;
//                }
//            }
//            if (position < 0) {
//                position = 0;
//            }
//            mCurPage = getCurPage(position);
//            mCancelPage = mCurPage;
//            if (mPageChangeListener != null) {
//                mPageChangeListener.onChapterChange(mCurChapterPos);
//            }
//        } else {
//            mCurPage = getCurPage(0);
//        }
//        saveRecord();
//        drawCurPage();
//    }
//
//    public void chapterError() {
//        //加载错误
//        mStatus = PageLoaderState.STATUS_ERROR;
//        //显示加载错误
//        drawCurPage();
//    }
//
//    //清除记录，并设定是否缓存数据
//    public void closeBook() {
//        isBookOpen = false;
//
//        if (mPreLoadDisp != null) {
//            mPreLoadDisp.dispose();
//        }
//        mPageLoaderDraw.release();
//    }
//
//    /*******************************abstract method***************************************/
//    //设置章节
//    public abstract void setChapterList(List<ChapterListBean> bookChapters);
//
//
//    @Nullable
//    protected abstract List<TxtPage> loadPageList(int chapter);
//
//    /***********************************default method***********************************************/
//    //通过流获取Page的方法
//    List<TxtPage> loadPages(TxtChapter txtChapter, BufferedReader br) {
//        //使用流的方式加载
//        List<TxtPage> pages = mPageLoaderDraw.getTxtPageList(txtChapter, br);
//        // TxtPageLoad.bandingTxtPage(pages, chapter == 0, mustAD);
//        //可能出现内容为空的情况
//        if (pages.size() == 0) {
//            TxtPage page = new TxtPage();
//            page.lines = new ArrayList<>(1);
//            pages.add(page);
//            mStatus = PageLoaderState.STATUS_EMPTY;
//        }
//        return pages;
//    }
//
//    public void setDisplaySize(int w, int h) {
//        mPageLoaderDraw.setDisplaySize(w, h);
//        //如果章节已显示，那么就重新计算页面
//        if (mStatus == PageLoaderState.STATUS_FINISH) {
//            mCurPageList = loadPageList(mCurChapterPos);
//            //重新设置文章指针的位置
//            if (mCurPage != null) {
//                mCurPage = getCurPage(mCurPage.position);
//            }
//        }
//        drawCurPage();
//    }
//
//    public int getState() {
//        return mStatus;
//    }
//
//    //翻阅上一页
//    public boolean prev() {
//        if (!checkStatus()) return false;
//        slidePages--;
//        if (slidePages < 0) {
//            slidePages = 0;
//        }
//        //判断是否达到章节的起始点
//        TxtPage prevPage = getPrevPage();
//        if (prevPage == null) {
//            //载入上一章。
//            if (!prevChapter()) {
//                return false;
//            } else {
//                mCancelPage = mCurPage;
//                mCurPage = getPrevLastPage();
//                mPageLoaderDraw.drawNextPage();
//                return true;
//            }
//        }
//        mCancelPage = mCurPage;
//        mCurPage = prevPage;
//
//        mPageLoaderDraw.drawNextPage();
//        return true;
//    }
//
//    //加载上一章
//    boolean prevChapter() {
//        //判断是否上一章节为空
//        if (mCurChapterPos - 1 < 0) {
//            // ToastUtils.showSingleToast("已经没有上一章了");
//            mPageLoaderDraw.addWappage(mCollBook);
//            return false;
//        }
//        //当前章变成下一章
//        mNextPageList = mCurPageList;
//        //加载上一章数据
//        int prevChapter = mCurChapterPos - 1;
//        //判断上一章缓存是否存在，如果存在则从缓存中获取数据。
//        if (mWeakPrePageList != null && mWeakPrePageList.get() != null) {
//            mCurPageList = mWeakPrePageList.get();
//            mWeakPrePageList = null;
//        }
//        //如果不存在则加载数据
//        else {
//            mCurPageList = loadPageList(prevChapter);
//        }
//        mLastChapter = mCurChapterPos;
//        mCurChapterPos = prevChapter;
//
//        if (mCurPageList != null) {
//            mStatus = PageLoaderState.STATUS_FINISH;
//        }
//        //如果当前章不存在，则表示在加载中
//        else {
//            mStatus = PageLoaderState.STATUS_LOADING;
//            //重置position的位置，防止正在加载的时候退出时候存储的位置为上一章的页码
//            if (mCurPage != null) {
//                mCurPage.position = 0;
//            }
//            mPageLoaderDraw.drawNextPage();
//        }
//        if (mPageChangeListener != null) {
//            mPageChangeListener.onChapterChange(mCurChapterPos);
//        }
//        return true;
//    }
//
//    private final int ADSPACE = 10;
//    int slidePages = 0;
//
//    //翻阅下一页
//    public boolean next() {
//        if (!checkStatus()) return false;
//        if (showAD && slidePages++ >= ADSPACE) {
//            mPageLoaderDraw.addAdd();
//            slidePages = 0;
//            return false;
//        }
//        //判断是否到最后一页了
//        TxtPage nextPage = getNextPage();
//        if (nextPage == null) {
//            if (!nextChapter()) {
//                return false;
//            } else {
//                mCancelPage = mCurPage;
//                mCurPage = getCurPage(0);
//                mPageLoaderDraw.drawNextPage();
//                return true;
//            }
//        }
//        mCancelPage = mCurPage;
//        mCurPage = nextPage;
//        mPageLoaderDraw.drawNextPage();
//        //为下一页做缓冲
//        //加载下一页的文章
//        return true;
//    }
//
//    boolean nextChapter() {
//        //加载一章
//        if (mChapterList == null || mCurChapterPos + 1 >= mChapterList.size()) {
//            ToastUtils.showSingleToast("已经没有下一章了");
//            return false;
//        }
//        //如果存在下一章，则存储当前Page列表为上一章
//        if (mCurPageList != null) {
//            mWeakPrePageList =
//                    new WeakReference<>(new ArrayList<>(mCurPageList));
//        }
//        int nextChapter = mCurChapterPos + 1;
//        //如果存在下一章预加载章节。
//        if (mNextPageList != null) {
//            mCurPageList = mNextPageList;
//            mNextPageList = null;
//        } else {
//            mCurPageList = loadPageList(nextChapter);
//        }
//        mLastChapter = mCurChapterPos;
//        mCurChapterPos = nextChapter;
//        //如果存在当前章，预加载下一章
//        if (mCurPageList != null) {
//            mStatus = PageLoaderState.STATUS_FINISH;
//            preLoadNextChapter();
//        }
//        //如果当前章不存在，则表示在加载中
//        else {
//            mStatus = PageLoaderState.STATUS_LOADING;
//            //重置position的位置，防止正在加载的时候退出时候存储的位置为上一章的页码
//            mCurPage.position = 0;
//            mPageLoaderDraw.drawNextPage();
//        }
//        if (mPageChangeListener != null) {
//            mPageChangeListener.onChapterChange(mCurChapterPos);
//        }
//        return true;
//    }
//
//    //预加载下一章
//    private void preLoadNextChapter() {
//        if (mChapterList == null) {
//            return;
//        }
//        //判断是否存在下一章
//        if (mCurChapterPos + 1 >= mChapterList.size()) {
//            return;
//        }
//        //判断下一章的文件是否存在
//        final int nextChapter = mCurChapterPos + 1;
//
//        //如果之前正在加载则取消
//        if (mPreLoadDisp != null) {
//            mPreLoadDisp.dispose();
//        }
//        //调用异步进行预加载加载
//        Observable.create(
//                (ObservableOnSubscribe<List<TxtPage>>) e ->
//                        e.onNext(loadPageList(nextChapter)))
//                .subscribeOn(Schedulers.io()) // 指定 subscribe() 发生在 运算 线程
//                .observeOn(AndroidSchedulers.mainThread())
//                // 指定 Subscriber 的回调发生在主线程
//                .subscribe(new Observer<List<TxtPage>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        mPreLoadDisp = d;
//                    }
//
//                    @Override
//                    public void onNext(List<TxtPage> pages) {
//                        mNextPageList = pages;
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        //无视错误
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//
//    }
//
//    //取消翻页 (这个cancel有点歧义，指的是不需要看的页面)
//    public void pageCancel() {
//        if (mCurPage == null) {
//            return;
//        }
//        slidePages--;
//        if (slidePages < 0) {
//            slidePages = 0;
//        }
//        //加载到下一章取消了
//        if (mCurPage.position == 0 && mCurChapterPos > mLastChapter) {
//            prevChapter();
//        }
//        //加载上一章取消了 (可能有点小问题)
//        else if (mCurPageList == null ||
//                (mCurPage.position == mCurPageList.size() - 1 && mCurChapterPos < mLastChapter)) {
//            nextChapter();
//        }
//        //假设加载到下一页了，又取消了。那么需要重新装载的问题
//        mCurPage = mCancelPage;
//    }
//
//    /**
//     * @return:获取初始显示的页面
//     */
//    TxtPage getCurPage(int pos) {
//
//        if (mCurPageList == null) {
//            return null;
//        }
//
//        if (pos < 0 || pos >= mCurPageList.size()) {
//            return null;
//        }
//        if (mPageChangeListener != null) {
//            mPageChangeListener.onPageChange(pos);
//        }
//        return mCurPageList.get(pos);
//    }
//
//
//    /**************************************private method********************************************/
//
//    /**
//     * @return:获取上一个页面
//     */
//    private TxtPage getPrevPage() {
//        if (mCurPage == null) {
//            return null;
//        }
//        int pos = mCurPage.position - 1;
//        if (pos < 0) {
//            //需要换一章节
//            return null;
//        }
//        if (mPageChangeListener != null) {
//            mPageChangeListener.onPageChange(pos);
//        }
//        return mCurPageList.get(pos);
//    }
//
//    /**
//     * @return:获取下一的页面
//     */
//    private TxtPage getNextPage() {
//        if (null != mCurPage && mCurPageList != null) {
//            int pos = mCurPage.position + 1;
//            if (pos >= mCurPageList.size()) {
//                return null;
//            }
//            if (mPageChangeListener != null) {
//                mPageChangeListener.onPageChange(pos);
//            }
//            return mCurPageList.get(pos);
//        }
//        return new TxtPage();
//    }
//
//    /**
//     * @return:获取上一个章节的最后一页
//     */
//    private TxtPage getPrevLastPage() {
//        if (mCurPageList == null) {
//            return null;
//        }
//        int pos = mCurPageList.size() - 1;
//        if (pos < 0) {
//            return null;
//        }
//        TxtPage page = mCurPageList.get(pos);
//        page.position = pos;
//        return page;
//    }
//
//    /**
//     * 检测当前状态是否能够进行加载章节数据
//     *
//     * @return
//     */
//    private boolean checkStatus() {
//        if (mStatus == PageLoaderState.STATUS_LOADING) {
//            return false;
//        } else if (mStatus == PageLoaderState.STATUS_ERROR) {
//            //点击重试
//            mStatus = PageLoaderState.STATUS_LOADING;
//            drawCurPage();
//            return false;
//        }
//        //由于解析失败，让其退出
//        return true;
//    }
//
//    void drawCurPage() {
//        mPageLoaderDraw.drawCurPage();
//        if (mBookRecord != null && mBookRecord.getChapter() == 0 && mBookRecord.getPagePos() == 0) {
//            mPageLoaderDraw.addWappage(mCollBook);
//        }
//    }
//
//    public void setBgColor(int bgColor) {
//        mPageLoaderDraw.setBgColor(bgColor, isBookOpen);
//    }
//
//    public void setTextSize(int textSize) {
//        if (!isBookOpen || mPageLoaderDraw == null) return;
//        mPageLoaderDraw.setTextSize(textSize);
//        //取消缓存
//        mWeakPrePageList = null;
//        mNextPageList = null;
//        //如果当前为完成状态。
//        if (mStatus == PageLoaderState.STATUS_FINISH) {
//            //重新计算页面
//            mCurPageList = loadPageList(mCurChapterPos);
//            //防止在最后一页，通过修改字体，以至于页面数减少导致崩溃的问题
//            if (mCurPageList != null && mCurPage.position >= mCurPageList.size()) {
//                mCurPage.position = mCurPageList.size() - 1;
//            }
//        }
//        //重新设置文章指针的位置
//        mCurPage = getCurPage(mCurPage.position);
//        //绘制
//        mPageLoaderDraw.refreshPage();
//    }
//
//    public void onDraw(Bitmap nextPage) {
//        //绘制背景
//        String title = null;
//        if (mStatus != PageLoaderState.STATUS_FINISH) {
//            if (mChapterList != null && mChapterList.size() != 0) {
//                title = mChapterList.get(mCurChapterPos).title;
//            }
//        } else {
//            if (mCurPage != null && mCurPage.title != null) {
//                title = mCurPage.title;
//            }
//        }
//        String percent = null;
//        if (mCurPage != null && mCurPageList != null) {
//            percent = (mCurPage.position + 1) + "/" + mCurPageList.size();
//        }
//        if (nextPage != null) {
//            if (mCurPage != null && mCurPage.titleLines > 0) {
//                title = null;
//            }
//            mPageLoaderDraw.drawBackground(title, percent, nextPage);
//            //绘制内容
//            mPageLoaderDraw.onDraw(mCurPage, nextPage, mStatus);
//        }
//    }
//
//    /*****************************************interface*****************************************/
//
//    public interface OnPageChangeListener {
//        void onChapterChange(int pos);
//
//        //请求加载回调
//        void onLoadChapter(List<TxtChapter> chapters, int pos, String ccid);
//
//        //当目录加载完成的回调(必须要在创建的时候，就要存在了)
//        void onCategoryFinish(List<TxtChapter> chapters);
//
//
//        //页面改变
//        void onPageChange(int pos);
//    }
//}
