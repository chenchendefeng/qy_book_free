//package com.freebookqy.application.view.readview.read;
//
//import android.graphics.Bitmap;
//import android.graphics.Canvas;
//import android.view.ViewGroup;
//import com.freebookqy.application.mvp.model.entity.book.bookread.BookDetailsBean;
//
//public class PageGroupLoaderDraw extends BasePageLoaderDraw {
//
//    public void drawBackground( Bitmap bitmap) {
//        Canvas canvas = new Canvas(bitmap);
//        canvas.drawColor(mPageBg);
//    }
//
//    void drawContent(Bitmap bitmap) {
//        Canvas canvas = new Canvas(bitmap);
////        canvas.drawBitmap();
////        if (mPageMode == PageView.PAGE_MODE_SCROLL) {
////            canvas.drawColor(mPageBg);
////        }
////        /******绘制内容****/
////        if (status != PageLoaderState.STATUS_FINISH) {
////            //绘制字体
////            String tip = "";
////            switch (status) {
////                case PageLoaderState.STATUS_LOADING:
////                    tip = "正在拼命加载中...";
////                    break;
////                case PageLoaderState.STATUS_ERROR:
////                    tip = "加载失败(点击边缘重试)";
////                    break;
////                case PageLoaderState.STATUS_EMPTY:
////                    tip = "文章内容为空";
////                    break;
////                case PageLoaderState.STATUS_PARSE:
////                    tip = "正在排版请等待...";
////                    break;
////                case PageLoaderState.STATUS_PARSE_ERROR:
////                    tip = "文件解析错误";
////                    break;
////            }
////            //将提示语句放到正中间
////            Paint.FontMetrics fontMetrics = mTextPaint.getFontMetrics();
////            float textHeight = fontMetrics.top - fontMetrics.bottom;
////            float textWidth = mTextPaint.measureText(tip);
////            float pivotX = (mDisplayWidth - textWidth) / 2;
////            float pivotY = (mDisplayHeight - textHeight) / 2;
////            canvas.drawText(tip, pivotX, pivotY, mTextPaint);
////            return;
////        }
////        float top;
////        if (mPageMode == PageView.PAGE_MODE_SCROLL) {
////            top = -mTextPaint.getFontMetrics().top;
////        } else {
////            top = mMarginHeight - mTextPaint.getFontMetrics().top;//+ 60;
////        }
////        top += mMarginTop;
////
////        if (curPage == null || curPage.lines == null) {
////            return;
////        }
////        //设置总距离
////        int interval = mTextInterval + (int) mTextPaint.getTextSize();
////        int para = mTextPara + (int) mTextPaint.getTextSize();
////        int titleInterval = mTitleInterval + (int) mTitlePaint.getTextSize();
////        int titlePara = mTitlePara + (int) mTextPaint.getTextSize();
////        String str = null;
////        //对标题进行绘制
////        for (int i = 0; i < curPage.titleLines; ++i) {
////            str = curPage.lines.get(i);
////            //设置顶部间距
////            if (i == 0) {
////                top += mTitlePara;
////            }
////            //计算文字显示的起始点
////            //int start = (int) (mDisplayWidth - mTitlePaint.measureText(str)) / 2;
////            int start = mMarginWidth;
////            //进行绘制
////            canvas.drawText(str, start, top, mTitlePaint);
////            //设置尾部间距
////            if (i == curPage.titleLines - 1) {
////                top += titlePara;
////            } else {
////                //行间距
////                top += titleInterval;
////            }
////        }
////        if (curPage.titleLines > 0) {
////            top += mMarginHeight;
////        }
////        //对内容进行绘制
////        for (int i = curPage.titleLines; i < curPage.lines.size(); ++i) {
////            str = curPage.lines.get(i);
////            canvas.drawText(str, mMarginWidth, top, mTextPaint);
////            if (str.endsWith("\n")) {
////                top += para;
////            } else {
////                top += interval;
////            }
////        }
//    }
//
//    public void onDraw(Bitmap bitmap) {
//        drawContent(bitmap);
//        //更新绘制
//        mPageView.invalidate();
//    }
//
//    // 阅读封皮
//    public void addWappage(BookDetailsBean bean) {
//        mPageView.canReadable(false);
//        ReadWappageView view = new ReadWappageView(bean);
//        view.create((ViewGroup) mPageView.getParent());
//        view.setOnStateListener(() -> mPageView.canReadable(true));
//    }
//
//    public void addAdd() {
//        mPageView.canReadable(false);
//        ReadAdView view = new ReadAdView();
//        view.create((ViewGroup) mPageView.getParent());
//        view.setOnStateListener(() -> mPageView.canReadable(true));
//    }
//
//}
