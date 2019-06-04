//package com.freebookqy.application.view.readview.read.loader;
//
//import android.graphics.Bitmap;
//import com.freebookqy.application.view.readview.IPageView;
//import com.freebookqy.application.view.readview.read.PageGroupLoaderDraw;
//import com.freebookqy.application.view.readview.read.PageLoaderState;
//
///**
// * Created by leafye on 2019-05-14.
// */
//public class PageGroupLoader implements IPageLoader {
//    public void pageCancel() {
////        if (mCurPage == null) {
////            return;
////        }
////        slidePages--;
////        if (slidePages < 0) {
////            slidePages = 0;
////        }
////        //加载到下一章取消了
////        if (mCurPage.position == 0 && mCurChapterPos > mLastChapter) {
////            prevChapter();
////        }
////        //加载上一章取消了 (可能有点小问题)
////        else if (mCurPageList == null ||
////                (mCurPage.position == mCurPageList.size() - 1 && mCurChapterPos < mLastChapter)) {
////            nextChapter();
////        }
////        //假设加载到下一页了，又取消了。那么需要重新装载的问题
////        mCurPage = mCancelPage;
//    }
//
//    public void setDisplaySize(int w, int h) {
//        mPageLoaderDraw.setDisplaySize(w, h);
//        //如果章节已显示，那么就重新计算页面
//        drawCurPage();
//    }
//
//    private void drawCurPage() {
//        mPageLoaderDraw.drawCurPage();
//    }
//
//    public PageGroupLoader(IPageView pageView) {
//        super();
//        this.mPageLoaderDraw = new PageGroupLoaderDraw();
//        this.pageView = pageView;
//    }
//
//    private IPageView pageView;
//
//    int mStatus = PageLoaderState.STATUS_LOADING;
//
//    private PageGroupLoaderDraw mPageLoaderDraw;
//
//    public void onDraw(Bitmap nextPage) {
//        //绘制背景
//        String title = "";
//        mPageLoaderDraw.drawBackground(nextPage);
//        //绘制内容
//        mPageLoaderDraw.onDraw(nextPage);
//    }
//
//}
