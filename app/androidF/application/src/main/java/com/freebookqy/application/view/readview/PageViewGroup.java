//package com.freebookqy.application.view.readview;
//
//import android.app.Activity;
//import android.content.Context;
//import android.graphics.*;
//import android.util.AttributeSet;
//import android.widget.RelativeLayout;
//import com.freebookqy.application.R;
//import com.freebookqy.application.view.animation.*;
//import com.freebookqy.application.view.readview.read.PageLoaderDraw;
//import com.freebookqy.application.view.readview.read.loader.PageGroupLoader;
//import com.freebookqy.utilslib.ResUtils;
//import com.freebookqy.utilslib.ScreenUtils;
//import com.jess.arms.integration.AppManager;
//import me.jessyan.autosize.utils.LogUtils;
//
///**
// * Created by leafye on 2019-05-13.
// */
//public class PageViewGroup extends RelativeLayout implements IPageView {
//
//    public final static int PAGE_MODE_SIMULATION = 0;
//    public final static int PAGE_MODE_COVER = 1;
//    public final static int PAGE_MODE_SLIDE = 2;
//    public final static int PAGE_MODE_NONE = 3;
//    //滚动效果
//    public final static int PAGE_MODE_SCROLL = 4;
//
//
//    public int mViewWidth = 0; // 当前View的宽
//    public int mViewHeight = 0; // 当前View的高
//
//    private int mStartX = 0;
//    private int mStartY = 0;
//    private boolean isMove = false;
//    //初始化参数
//    private int mBgColor = 0xFFff5501;
//    public int mPageMode = PAGE_MODE_COVER;
//
//    //是否允许点击
//    private boolean canTouch = true;
//    //是否允许阅读
//    private boolean canRead = true;
//    //判断是否初始化完成
//    private boolean isPrepare = false;
//    //唤醒菜单的区域
//    private RectF mCenterRect = null;
//
//    //动画类
//    private PageAnimation mPageAnim;
//
//    private int View_TYPE_AD = 1;//广告界面
//
//    //动画监听类
//    private PageAnimation.OnPageChangeListener mPageAnimListener = new PageAnimation.OnPageChangeListener() {
//        @Override
//        public boolean hasPrev() {
//            return true;
//        }
//
//        @Override
//        public boolean hasNext() {
//            return true;
//        }
//
//        @Override
//        public void pageCancel() {
//            mPageLoader.pageCancel();
//        }
//    };
//
//    //点击监听
//    private PageView.PageViewTouchListener mTouchListener;
//    //内容加载器
//    private PageGroupLoader mPageLoader = new PageGroupLoader(this);
//
//    public PageViewGroup(Context context) {
//        this(context, null);
//    }
//
//    public PageViewGroup(Context context, AttributeSet attrs) {
//        this(context, attrs, 0);
//    }
//
//    public PageViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        init();
//    }
//
//    Bitmap bitmapFromView;
//
//    private void init() {
//        mViewWidth = ScreenUtils.getScreenWidth();
//        try {
//            initScreenHeight();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        setPageMode(mPageMode);
//
//        if (View_TYPE_AD == 1) {
//            removeAllViews();
//            setBackgroundColor(ResUtils.getColor(R.color.white));
//            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.image_share);
//            bitmapFromView = bitmap.copy(bitmap.getConfig(), true);
////            View inflate = View.inflate(getContext(), R.layout.read_page_ad, null);
////            addView(inflate);
////            inflate.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
////                @Override
////                public void onGlobalLayout() {
////                    bitmapFromView = BitmapUtil.getViewBitmap(inflate);
//////                    ImageView imageView = new ImageView(getContext());
//////                    imageView.setPadding(20, 20, 20, 20);
//////                    imageView.setImageBitmap(bitmapFromView);
//////                    addView(imageView);
////                    inflate.setVisibility(View.INVISIBLE);
////                    inflate.getViewTreeObserver().removeOnGlobalLayoutListener(this);
////                }
////            });
//        }
//    }
//
//    private void initScreenHeight() {
//        Activity topActivity = AppManager.getAppManager().getTopActivity();
//        if (topActivity != null) {
//            mViewHeight = ScreenUtils.getRealScreenHeight(topActivity);
//        } else {
//            mViewHeight = ScreenUtils.getScreenHeight();
//        }
//    }
//
//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        super.onSizeChanged(w, h, oldw, oldh);
//        //重置图片的大小,由于w,h可能比原始的Bitmap更大，所以如果使用Bitmap.setWidth/Height()是会报错的。
//        //所以最终还是创建Bitmap的方式。这种方式比较消耗性能，暂时没有找到更好的方法。
//        //        setPageMode(mPageMode);
//        //        //重置页面加载器的页面
//        if (!isPrepare) {
//            mPageLoader.setDisplaySize(w, h);
//            //初始化完成
//            isPrepare = true;
//        }
//    }
//
//    //设置翻页的模式
//    public void setPageMode(int pageMode) {
//        mPageMode = pageMode;
//        //视图未初始化的时候，禁止调用
//        if (mViewWidth == 0) return;
//        if (mViewHeight == 0) {
//            try {
//                initScreenHeight();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        if (mViewHeight == 0) return;
//
//        switch (pageMode) {
//            case PAGE_MODE_SIMULATION:
//                mPageAnim = new SimulationPageAnim(mViewWidth, mViewHeight, this, mPageAnimListener);
//                break;
//            case PAGE_MODE_COVER:
//                mPageAnim = new CoverPageAnim(mViewWidth, mViewHeight, this, mPageAnimListener);
//                break;
//            case PAGE_MODE_SLIDE:
//                mPageAnim = new SlidePageAnim(mViewWidth, mViewHeight, this, mPageAnimListener);
//                break;
//            case PAGE_MODE_NONE:
//                mPageAnim = new NonePageAnim(mViewWidth, mViewHeight, this, mPageAnimListener);
//                break;
//            case PAGE_MODE_SCROLL:
//                mPageAnim = new ScrollPageAnim(mViewWidth, mViewHeight, 0,
//                        ScreenUtils.dpToPx(PageLoaderDraw.DEFAULT_MARGIN_HEIGHT), this, mPageAnimListener);
//                break;
//            default:
//                mPageAnim = new SimulationPageAnim(mViewWidth, mViewHeight, this, mPageAnimListener);
//        }
//    }
//
//    public Bitmap getNextPage() {
////        if (mPageAnim == null) return null;
////        return mPageAnim.getNextBitmap();
//        return bitmapFromView;
//    }
//
//
//    public void setBgColor(int color) {
//        mBgColor = color;
//    }
//
//    public void canTouchable(boolean touchable) {
//        canTouch = touchable;
//    }
//
//    public void canReadable(boolean enable) {
//        canRead = enable;
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//        LogUtils.w("开始绘制界面.....");
//        //绘制背景
//        canvas.drawColor(ResUtils.getColor(R.color.red_text_color));
//        //绘制动画
//
//        Paint paint = new Paint();
//        canvas.drawBitmap(bitmapFromView, 0, 0, paint);
////        mPageAnim.draw(canvas);
//    }
//
////    @Override
////    public boolean onTouchEvent(MotionEvent event) {
////        super.onTouchEvent(event);
////        if (!canTouch && event.getAction() != MotionEvent.ACTION_DOWN) return true;
////        int x = (int) event.getX();
////        int y = (int) event.getY();
////        switch (event.getAction()) {
////            case MotionEvent.ACTION_DOWN:
////                mStartX = x;
////                mStartY = y;
////                isMove = false;
////                if (canRead) {
////                    mPageAnim.onTouchEvent(event);
////                }
////                break;
////            case MotionEvent.ACTION_MOVE:
////                //判断是否大于最小滑动值。
////                int slop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
////                if (!isMove) {
////                    isMove = Math.abs(mStartX - event.getX()) > slop || Math.abs(mStartY - event.getY()) > slop;
////                }
////                //如果滑动了，则进行翻页。
////                if (isMove) {
////                    if (canRead) {
////                        mPageAnim.onTouchEvent(event);
////                    }
////                }
////                break;
////            case MotionEvent.ACTION_UP:
////                if (!isMove) {
////                    //设置中间区域范围
////                    if (mCenterRect == null) {
////                        mCenterRect = new RectF(mViewWidth / 4, 0,
////                                mViewWidth * 3 / 4, mViewHeight);
////                    }
////                    //是否点击了中间
////                    if (mCenterRect.contains(x, y)) {
////                        if (mTouchListener != null) {
////                            mTouchListener.center();
////                        }
////                        return true;
////                    }
////
////                }
////                if (canRead) {
////                    mPageAnim.onTouchEvent(event);
////                }
////                break;
////        }
////        return true;
////    }
//
////    //判断是否下一页存在
////    private boolean hasNext() {
////        boolean hasNext = false;
////        if (mTouchListener != null) {
////            hasNext = mTouchListener.nextPage();
////            //加载下一页
////            if (hasNext) {
////                hasNext = mPageLoader.next();
////            }
////        }
////        return hasNext;
////    }
////
////    //判断是否存在上一页
////    private boolean hasPrev() {
////        boolean hasPrev = false;
////        if (mTouchListener != null) {
////            hasPrev = mTouchListener.prePage();
////            //加载下一页
////            if (hasPrev) {
////                hasPrev = mPageLoader.prev();
////            }
////        }
////        return hasPrev;
////    }
//
////    @Override
////    public void computeScroll() {
////        //进行滑动
////        mPageAnim.scrollAnim();
////        super.computeScroll();
////    }
//
//    //如果滑动状态没有停止就取消状态，重新设置Anim的触碰点
//    public void abortAnimation() {
//        mPageAnim.abortAnim();
//    }
//
//    public boolean isPrepare() {
//        return isPrepare;
//    }
//
//    public boolean isRunning() {
//        return mPageAnim.isRunning();
//    }
//
//    public void setTouchListener(PageView.PageViewTouchListener mTouchListener) {
//        this.mTouchListener = mTouchListener;
//    }
//
//    public void drawNextPage() {
//        if (mPageAnim instanceof HorizonPageAnim) {
//            ((HorizonPageAnim) mPageAnim).changePage();
//        }
//        mPageLoader.onDraw(getNextPage());
//    }
//
//
//    /**
//     * 刷新当前页(主要是为了ScrollAnimation)
//     */
//    public void refreshPage() {
//        if (mPageAnim instanceof ScrollPageAnim) {
//            ((ScrollPageAnim) mPageAnim).refreshBitmap();
//        }
//        drawCurPage();
//    }
//
//    //refreshPage和drawCurPage容易造成歧义,后面需要修改
//
//    /**
//     * 绘制当前页。
//     */
//    public void drawCurPage() {
//        mPageLoader.onDraw(getNextPage());
//        //在这里设置广告或者章节
//    }
//
////    //获取PageLoader
////    public PageLoader getPageLoader() {
////        if (mPageLoader == null) {
////            //            if (boolean isLocal =false) {
////            //暂时用同一个loader
////            //                mPageLoader = new LocalPageLoader(this);
////            //            } else {
////            mPageLoader = new NetPageLoader(this);
////            //     }
////        }
////        return mPageLoader;
////    }
//
//    public interface PageViewTouchListener {
//        void center();
//
//        boolean prePage();
//
//        boolean nextPage();
//
//    }
//
//}
