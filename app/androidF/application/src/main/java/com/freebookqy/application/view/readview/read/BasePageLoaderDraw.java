//package com.freebookqy.application.view.readview.read;
//
//import android.graphics.Paint;
//import android.graphics.Typeface;
//import android.text.TextPaint;
//import android.view.ViewGroup;
//import com.freebookqy.application.R;
//import com.freebookqy.application.mvp.model.entity.book.bookread.BookDetailsBean;
//import com.freebookqy.application.view.readview.IPageView;
//import com.freebookqy.application.view.readview.ReadSettingManager;
//import com.freebookqy.application.view.readview.bean.TxtChapter;
//import com.freebookqy.application.view.readview.bean.TxtPage;
//import com.freebookqy.application.view.readview.utils.TypeFaceUtils;
//import com.freebookqy.utilslib.IOUtils;
//import com.freebookqy.utilslib.ResUtils;
//import com.freebookqy.utilslib.ScreenUtils;
//import com.freebookqy.viewlib.book.utils.StringUtils;
//
//import java.io.BufferedReader;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by leafye on 2019-05-14.
// */
//public class BasePageLoaderDraw {
//    //页面显示类
//    protected IPageView mPageView;
//
//    public static final int DEFAULT_MARGIN_HEIGHT = 28;
//    public static final int DEFAULT_MARGIN_WIDTH = 12;
//
//    //默认的显示参数配置
//    protected static final int DEFAULT_TIP_SIZE = 12;
//    protected static final int EXTRA_TITLE_SIZE = 4;
//    //绘制电池的画笔
//    //private Paint mBatteryPaint;
//    //绘制提示的画笔
//    protected Paint mTipPaint;
//    //绘制标题的画笔
//    protected Paint mTitlePaint;
//    //绘制背景颜色的画笔(用来擦除需要重绘的部分)
//    protected Paint mBgPaint;
//    //绘制小说内容的画笔
//    protected TextPaint mTextPaint;
//    //阅读器的配置选项
//    protected ReadSettingManager mSettingManager;
//    //书籍绘制区域的宽高
//    protected int mVisibleWidth;
//    protected int mVisibleHeight;
//    //应用的宽高
//    protected int mDisplayWidth;
//    protected int mDisplayHeight;
//    //间距
//    protected int mMarginWidth;
//    protected int mMarginHeight;
//    protected int mMarginTop;
//    //字体的颜色
//    protected int mTextColor;
//    //标题的大小
//    protected int mTitleSize;
//    //字体的大小
//    protected int mTextSize;
//    //行间距
//    protected int mTextInterval;
//    //标题的行间距
//    protected int mTitleInterval;
//    //段落距离(基于行间距的额外距离)
//    protected int mTextPara;
//    protected int mTitlePara;
//    //电池的百分比
//    //private intface mBatteryLevel;
//    //加载器的颜色主题
//    protected int mBgTheme;
//    //当前页面的背景
//    protected int mPageBg;
//
//
//    //页面的翻页效果模式
//    protected int mPageMode;
//
//    public BasePageLoaderDraw() {
//    }
//
//    private void initPaint() {
//        //绘制提示的画笔
//        mTipPaint = new Paint();
//        mTipPaint.setColor(mTextColor);
//        mTipPaint.setTextAlign(Paint.Align.LEFT);//绘制的起始点
//        mTipPaint.setTextSize(ScreenUtils.spToPx(DEFAULT_TIP_SIZE));//Tip默认的字体大小
//        mTipPaint.setAntiAlias(true);
//        mTipPaint.setSubpixelText(true);
//
//        TypeFaceUtils.bindTypeFace_SourceHanSerifCN_Regular(mTipPaint);
//
//        //绘制页面内容的画笔
//        mTextPaint = new TextPaint();
//        mTextPaint.setColor(mTextColor);
//        mTextPaint.setTextSize(mTextSize);
//        mTextPaint.setAntiAlias(true);
//        TypeFaceUtils.bindTypeFace_SourceHanSerifCN_Regular(mTextPaint);
//
//        //绘制标题的画笔
//        mTitlePaint = new TextPaint();
//        mTitlePaint.setColor(mTextColor);
//        mTitlePaint.setTextSize(mTitleSize);
//        mTitlePaint.setStyle(Paint.Style.FILL_AND_STROKE);
//        mTitlePaint.setTypeface(Typeface.DEFAULT_BOLD);
//        mTitlePaint.setAntiAlias(true);
//        TypeFaceUtils.bindTypeFace_SourceHanSerifCN_Regular(mTitlePaint);
//
//        //绘制背景的画笔
//        mBgPaint = new Paint();
//        mBgPaint.setColor(mPageBg);
//
////        mBatteryPaint = new Paint();
////        mBatteryPaint.setAntiAlias(true);
////        mBatteryPaint.setDither(true);
////        if (isNightMode) {
////            mBatteryPaint.setColor(Color.WHITE);
////        } else {
////            mBatteryPaint.setColor(Color.BLACK);
////        }
//    }
//
//    private void initData() {
//        mSettingManager = ReadSettingManager.getInstance();
//        mTextSize = mSettingManager.getTextSize();
//        mTitleSize = mTextSize + ScreenUtils.spToPx(EXTRA_TITLE_SIZE);
//        mPageMode = mSettingManager.getPageMode();
//        mBgTheme = mSettingManager.getReadBgTheme();
//        setBgColor(mBgTheme, false);
//        //初始化参数
//        mMarginWidth = ScreenUtils.dpToPx(DEFAULT_MARGIN_WIDTH);
//        mMarginHeight = ScreenUtils.dpToPx(DEFAULT_MARGIN_HEIGHT);
//        mMarginTop = ScreenUtils.dpToPx(20);
//        mTextInterval = mTextSize / 2;
//        mTitleInterval = mTitleSize / 2;
//        mTextPara = mTextSize; //段落间距由 text 的高度决定。
//        mTitlePara = mTitleSize + ScreenUtils.dpToPx(20);
//    }
//
//
//
//
//
//
//    public void init(IPageView pageView) {
//        mPageView = pageView;
//        //初始化数据
//        initData();
//        //初始化画笔
//        initPaint();
//        mPageView.setPageMode(mPageMode);
//        mPageView.setBgColor(mPageBg);
//    }
//
//    //设置文字大小
//    public void setTextSize(int textSize) {
//        //设置textSize
//        mTextSize = textSize;
//        mTextInterval = mTextSize / 2;
//        mTextPara = mTextSize;
//        mTitleSize = mTextSize + ScreenUtils.spToPx(EXTRA_TITLE_SIZE);
//        mTitleInterval = mTitleInterval / 2;
//        mTitlePara = mTitleSize;
//        //设置画笔的字体大小
//        mTextPaint.setTextSize(mTextSize);
//        //设置标题的字体大小
//        mTitlePaint.setTextSize(mTitleSize);
//        //存储状态
//        mSettingManager.setTextSize(mTextSize);
//    }
//
//
//    //绘制背景
//    public void setBgColor(int theme, boolean isBookOpen) {
//        mSettingManager.setReadBackground(theme);
//        switch (theme) {
//            case ReadSettingManager.READ_BG_DEFAULT:
//                mTextColor = ResUtils.getColor(R.color.color_eadec4);
//                mPageBg = ResUtils.getColor(R.color.color_42301a);
//                break;
//            case ReadSettingManager.READ_BG_1:
//                mTextColor = ResUtils.getColor(R.color.color_42301a);
//                mPageBg = ResUtils.getColor(R.color.color_eadec4);
//                break;
//            case ReadSettingManager.READ_BG_2:
//                mTextColor = ResUtils.getColor(R.color.color_1b271e);
//                mPageBg = ResUtils.getColor(R.color.color_cedcd3);
//                break;
//            case ReadSettingManager.READ_BG_3:
//                mTextColor = ResUtils.getColor(R.color.color_1f2934);
//                mPageBg = ResUtils.getColor(R.color.color_c7d8e1);
//                break;
//            case ReadSettingManager.READ_BG_4:
//                mTextColor = ResUtils.getColor(R.color.color_898989);
//                mPageBg = ResUtils.getColor(R.color.color_1f1f1f);
//                break;
//        }
//        if (isBookOpen) {
//            //设置参数
//            mPageView.setBgColor(mPageBg);
//            mTextPaint.setColor(mTextColor);
//            mTitlePaint.setColor(mTextColor);
//            mTipPaint.setColor(mTextColor);
//            //重绘
//            mPageView.refreshPage();
//        }
//    }
//
//    public void refreshPage() {
//        mPageView.refreshPage();
//    }
//
//    //翻页动画
////    public void setPageMode(intface pageMode) {
////        mPageMode = pageMode;
////        mPageView.setPageMode(mPageMode);
////        mSettingManager.setPageMode(mPageMode);
////        //重绘
////        mPageView.drawCurPage(false);
////    }
//
//    public void drawCurPage() {
//        if (mPageView != null) {
//            mPageView.drawCurPage();
//        }
//    }
//
//    public void release() {
//        mPageView = null;
//    }
//
//    public void drawNextPage() {
//        mPageView.drawNextPage();
//    }
//
//    public void setDisplaySize(int w, int h) {
//        //获取PageView的宽高
//        mDisplayWidth = w;
//        mDisplayHeight = h;
//
//        //获取内容显示位置的大小
//        mVisibleWidth = mDisplayWidth - mMarginWidth * 2;
//        mVisibleHeight = mDisplayHeight - mMarginHeight * 2 - mTitleSize - mMarginTop;
//    }
//
//
//    public List<TxtPage> getTxtPageList(TxtChapter chapter, BufferedReader br) {
//        //生成的页面
//        List<TxtPage> pages = new ArrayList<>();
//        List<String> lines = new ArrayList<>();
//        int rHeight = mVisibleHeight; //由于匹配到最后，会多删除行间距，所以在这里多加个行间距
//        int titleLinesCount = 0;
//        boolean isTitle = true; //不存在没有 Title 的情况，所以默认设置为 true。
//        String paragraph = chapter.title;//默认展示标题
//        try {
//            while (isTitle || (paragraph = br.readLine()) != null) {
//
//                //重置段落
//                if (!isTitle) {
//                    paragraph = paragraph.replaceAll("\\s", "");
//                    //如果只有换行符，那么就不执行
//                    if (paragraph.equals("")) continue;
//                    paragraph = StringUtils.halfToFull("  " + paragraph + "\n");
//                } else {
//                    //设置 title 的顶部间距
//                    rHeight -= mTitlePara + mMarginHeight;
//                }
//
//                int wordCount = 0;
//                String subStr = null;
//                while (paragraph.length() > 0) {
//                    //当前空间，是否容得下一行文字
//                    if (isTitle) {
//                        rHeight -= mTitlePaint.getTextSize();
//                    } else {
//                        rHeight -= mTextPaint.getTextSize();
//                    }
//
//                    //一页已经填充满了，创建 TextPage
//                    if (rHeight < 0) {
//                        //创建Page
//                        TxtPage page = new TxtPage();
//                        page.position = pages.size();
//                        page.title = chapter.title;
//                        page.lines = new ArrayList<>(lines);
//                        page.titleLines = titleLinesCount;
//                        pages.add(page);
//                        //重置Lines
//                        lines.clear();
//                        rHeight = mVisibleHeight;
//                        titleLinesCount = 0;
//                        continue;
//                    }
//
//                    //测量一行占用的字节数
//                    if (isTitle) {
//                        wordCount = mTitlePaint.breakText(paragraph, true, mVisibleWidth, null);
//                    } else {
//                        wordCount = mTextPaint.breakText(paragraph, true, mVisibleWidth, null);
//                    }
//
//                    subStr = paragraph.substring(0, wordCount);
//                    if (!subStr.equals("\n")) {
//                        //将一行字节，存储到lines中
//                        lines.add(subStr);
//
//                        //设置段落间距
//                        if (isTitle) {
//                            titleLinesCount += 1;
//                            rHeight -= mTitleInterval;
//                        } else {
//                            rHeight -= mTextInterval;
//                        }
//                    }
//                    //裁剪
//                    paragraph = paragraph.substring(wordCount);
//                }
//
//                //增加段落的间距
//                if (!isTitle && lines.size() != 0) {
//                    rHeight = rHeight - mTextPara + mTextInterval;
//                }
//
//                if (isTitle) {
//                    rHeight = rHeight - mTitlePara + mTitleInterval;
//                    isTitle = false;
//                }
//            }
//
//            if (lines.size() != 0) {
//                //创建Page
//                TxtPage page = new TxtPage();
//                page.position = pages.size();
//                page.title = chapter.title;
//                page.lines = new ArrayList<>(lines);
//                page.titleLines = titleLinesCount;
//                pages.add(page);
//                //重置Lines
//                lines.clear();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            IOUtils.close(br);
//        }
//        return pages;
//    }
//
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
//
//}
