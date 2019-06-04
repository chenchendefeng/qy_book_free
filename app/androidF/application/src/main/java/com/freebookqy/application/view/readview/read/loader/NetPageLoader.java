//package com.freebookqy.application.view.readview.read.loader;
//
//import com.freebookqy.application.mvp.model.entity.book.bookread.BookDetailsBean;
//import com.freebookqy.application.mvp.model.entity.book.bookread.ChapterListBean;
//import com.freebookqy.application.view.page.PageLoader;
//import com.freebookqy.application.view.page.PageView;
//import com.freebookqy.application.view.page.TxtChapter;
//import com.freebookqy.application.view.page.TxtPage;
//import com.freebookqy.application.view.readview.manager.BookManager;
//import greendao.helper.EntityManager;
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by newbiechen on 17-5-29.
// * 网络页面加载器
// */
//
//public class NetPageLoader extends PageLoader {
//
//    public NetPageLoader(PageView pageView) {
//        super(pageView);
//    }
//
//    //初始化书籍
//    @Override
//    public void openBook(BookDetailsBean collBook) {
//        super.openBook(collBook);
//        isBookOpen = false;
//
//        List<ChapterListBean> chapterListBeans = EntityManager.queryChapterListBean(collBook.getCBID());
//        if (chapterListBeans == null) return;
//        mChapterList = convertTxtChapter(chapterListBeans);
//        //设置目录回调
//        if (mPageChangeListener != null) {
//            mPageChangeListener.onCategoryFinish(mChapterList);
//        }
//        //提示加载下面的章节
//        loadCurrentChapter();
//    }
//
//    private List<TxtChapter> convertTxtChapter(List<ChapterListBean> bookChapters) {
//        List<TxtChapter> txtChapters = new ArrayList<>(bookChapters.size());
//        for (ChapterListBean bean : bookChapters) {
//            TxtChapter chapter = new TxtChapter();
//            chapter.bookId = bean.getCBID();
//            chapter.title = bean.getDurChapterName();
//            chapter.CCID = bean.getCCID();
//            chapter.authority = bean.getAuthority();
//            txtChapters.add(chapter);
//        }
//        return txtChapters;
//    }
//
//
//    @Override
//    protected List<TxtPage> loadPageList(int chapter) {
//        if (mChapterList == null) {
//            return null;
//        }
//        //获取要加载的文件
//        TxtChapter txtChapter = mChapterList.get(chapter);
//        String path = BookManager.getInstance().getBookFilePath(mBookRecord.getBookId(), mChapterList.get(chapter).CCID);
//
//        File file = new File(path);
//
//        if (!file.exists()) return null;
//
//        Reader reader = null;
//        try {
//            reader = new FileReader(file);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        BufferedReader br = new BufferedReader(reader);
//        List<TxtPage> pages = loadPages(txtChapter, br);
//
//        return pages;
//    }
//
//    //装载上一章节的内容
//    @Override
//    boolean prevChapter() {
//        boolean hasPrev = super.prevChapter();
//        if (!hasPrev) return false;
//
//        if (mStatus == PageLoaderState.STATUS_FINISH) {
//            loadCurrentChapter();
//            return true;
//        } else if (mStatus == PageLoaderState.STATUS_LOADING) {
//            loadCurrentChapter();
//            return false;
//        }
//        return false;
//    }
//
//    //装载下一章节的内容
//    @Override
//    boolean nextChapter() {
//        boolean hasNext = super.nextChapter();
//        if (!hasNext) return false;
//
//        if (mStatus == PageLoaderState.STATUS_FINISH) {
//            loadNextChapter();
//            return true;
//        } else if (mStatus == PageLoaderState.STATUS_LOADING) {
//            loadCurrentChapter();
//            return false;
//        }
//        return false;
//    }
//
//    //跳转到指定章节
//    public void skipToChapter(int pos) {
//        super.skipToChapter(pos);
//        //提示章节改变，需要下载
//        loadCurrentChapter();
//    }
//
//
//    private void loadCurrentChapter() {
//        if (mPageChangeListener != null && mChapterList.size() > 0) {
//            List<TxtChapter> bookChapters = new ArrayList<>(5);
//            //提示加载当前章节和前面两章和后面两章
//            int current = mCurChapterPos;
//            if (mChapterList.size() > 0 && mChapterList.size() > current) {
//                bookChapters.add(mChapterList.get(current));
//            }
//            //如果当前已经是最后一章，那么就没有必要加载后面章节
//            if (current != mChapterList.size()) {
//                int begin = current + 1;
//                int next = begin + 2;
//                if (next > mChapterList.size()) {
//                    next = mChapterList.size();
//                }
//                bookChapters.addAll(mChapterList.subList(begin, next));
//            }
//
//            //如果当前已经是第一章，那么就没有必要加载前面章节
//            if (current != 0) {
//                int prev = current - 2;
//                if (prev < 0) {
//                    prev = 0;
//                }
//                bookChapters.addAll(mChapterList.subList(prev, current));
//            }
//            mPageChangeListener.onLoadChapter(
//                    bookChapters,
//                    mCurChapterPos,
//                    mChapterList.get(mCurChapterPos).CCID);
//        }
//    }
//
//    private void loadNextChapter() {
//        //提示加载下一章
//        if (mPageChangeListener != null) {
//            //提示加载当前章节和后面3个章节
//            int current = mCurChapterPos + 1;
//            int next = mCurChapterPos + 3;
//            if (next > mChapterList.size()) {
//                next = mChapterList.size();
//            }
//            mPageChangeListener.onLoadChapter(
//                    mChapterList.subList(current, next),
//                    mCurChapterPos,
//                    mChapterList.get(mCurChapterPos).CCID);
//        }
//    }
//
//    @Override
//    public void setChapterList(List<ChapterListBean> bookChapters) {
//        if (bookChapters == null) return;
//
//        mChapterList = convertTxtChapter(bookChapters);
//
//        if (mPageChangeListener != null) {
//            mPageChangeListener.onCategoryFinish(mChapterList);
//        }
//    }
//
//}
//
