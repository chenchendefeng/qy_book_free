package com.freebookqy.viewlib.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.*;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.freebookqy.viewlib.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


/**
 * Created by zoumeng on 2018-01-15.
 * 通用dialog<br>
 * 可以方便的设置dialog的视图、主题、动画、窗体的大小、位置以及窗体是否变暗和变暗的范围
 */

public class CommonDialog extends AlertDialog {
    private Builder mBuilder;

    private CommonDialog(@NonNull Context context, Builder builder) {
        super(context, builder.mTheme == 0 ? R.style.BaseAlertDialogTheme_NoPadding : builder.mTheme);
        this.mBuilder = builder;
    }

    @CallSuper
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
//        ColorDrawable drawable = new ColorDrawable(Color.parseColor("#B3000000"));
//        getWindow().setBackgroundDrawable(drawable);
        WindowManager.LayoutParams params = getWindow().getAttributes();
        if (mBuilder.mGravity != 0) {
            params.gravity = mBuilder.mGravity;
        }
        if (mBuilder.mWindowParams != null) {
            params.width = mBuilder.mWindowParams.width;
            params.height = mBuilder.mWindowParams.height;
        }
        if (mBuilder.mDimEnable) {
            params.flags |= WindowManager.LayoutParams.FLAG_DIM_BEHIND;
            params.dimAmount = mBuilder.mDimAmount == -1 ? params.dimAmount : mBuilder.mDimAmount;
        } else {
            params.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        }
        getWindow().setAttributes(params);
        if (mBuilder.mAnimation != 0) {
            getWindow().setWindowAnimations(mBuilder.mAnimation);
        }
        if (mBuilder.mView != null && mBuilder.mLayoutParams != null) {
            setContentView(mBuilder.mView, mBuilder.mLayoutParams);
        } else if (mBuilder.mView != null) {
            setContentView(mBuilder.mView);
        }
        if (mBuilder.mView != null && mBuilder.mBindViewHashMap != null) {
            Iterator<Integer> iterator = mBuilder.mBindViewHashMap.keySet().iterator();
            while (iterator.hasNext()) {
                int viewId = iterator.next();
                OnBindView onBindView = mBuilder.mBindViewHashMap.get(viewId);
                if (onBindView != null) {
                    onBindView.bindView(mBuilder.mView.findViewById(viewId));
                }
            }
        }
        setCancelable(mBuilder.mCancelAble);
        if (mBuilder.mView != null && mBuilder.mIDs != null) {
            for (int id : mBuilder.mIDs) {
                View view = mBuilder.mView.findViewById(id);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mBuilder.mOnClickListener != null) {
                            mBuilder.mOnClickListener.onClick(CommonDialog.this, v);
                        }
                    }
                });
            }
        }
        if (mBuilder.mOnCancelListener != null) {
            setOnCancelListener(mBuilder.mOnCancelListener);
        }
        params.dimAmount = 0.7f;
    }

    public static class Builder {
        private int mGravity;
        private View mView;
        private ViewGroup.LayoutParams mLayoutParams;
        private int mTheme;
        private int mAnimation;
        private ViewGroup.LayoutParams mWindowParams;
        private boolean mDimEnable = true;
        private float mDimAmount = -1;
        private boolean mCancelAble = true;
        private HashMap<Integer, OnBindView> mBindViewHashMap;
        private List<Integer> mIDs;
        private OnClickListener mOnClickListener;
        private OnCancelListener mOnCancelListener;

        /**
         * 设置dialog显示的视图和布局属性
         *
         * @param view 视图
         * @return
         */
        public Builder contentView(View view) {
            this.mView = view;
            this.mLayoutParams = null;
            return this;
        }

        /**
         * 设置dialog显示的视图和布局属性
         *
         * @param view   视图
         * @param params 视图的布局属性
         * @return
         */
        public Builder contentView(View view, ViewGroup.LayoutParams params) {
            this.mView = view;
            this.mLayoutParams = params;
            return this;
        }

        /**
         * dialog所在window的布局属性
         *
         * @param params
         * @return
         */
        public Builder windowParams(ViewGroup.LayoutParams params) {
            this.mWindowParams = params;
            return this;
        }

        /**
         * dialog在window中的位置
         *
         * @param gravity @GravityFlag
         * @return
         */
        public Builder layoutGravity(int gravity) {
            this.mGravity = gravity;
            return this;
        }

        /**
         * dialog的主题
         *
         * @param theme
         * @return
         */
        public Builder theme(@StyleRes int theme) {
            this.mTheme = theme;
            return this;
        }

        /**
         * dialog出现和消失的动画
         *
         * @param animation
         * @return
         */
        public Builder animation(@StyleRes int animation) {
            this.mAnimation = animation;
            return this;
        }

        /**
         * dialog显示时window后面是否变暗
         *
         * @param dimEnable
         * @return
         */
        public Builder dimEnable(boolean dimEnable) {
            this.mDimEnable = dimEnable;
            return this;
        }

        /**
         * 设置dialog显示时window后面变暗的范围，只有在{@link #dimEnable(boolean)}为true时才有效<br>
         * 取值范围为0.0f-1.0f， 如果不设置则为默认值
         *
         * @param dimAmount
         * @return
         */
        public Builder dimAmount(@FloatRange(from = 0.0f, to = 1.0f) float dimAmount) {
            this.mDimAmount = dimAmount;
            return this;
        }

        /**
         * 能否取消
         *
         * @param cancelAble
         * @return
         */
        public Builder cancelAble(boolean cancelAble) {
            this.mCancelAble = cancelAble;
            return this;
        }

        /**
         * 绑定View
         *
         * @param id         View的id
         * @param onBindView 绑定回调
         * @return
         */
        public <T extends View> Builder bindView(@IdRes int id, OnBindView<T> onBindView) {
            if (mBindViewHashMap == null) {
                mBindViewHashMap = new HashMap<>();
            }
            mBindViewHashMap.put(id, onBindView);
            return this;
        }

        /**
         * 设置点击事件，然后通过{@link #onClick(OnClickListener)}监听点击事件
         *
         * @param ids 控件id
         * @return
         */
        public Builder setOnClick(@IdRes int... ids) {
            if (mIDs == null) {
                mIDs = new ArrayList<>();
            }
            for (int id : ids) {
                if (!mIDs.contains(id)) {
                    mIDs.add(id);
                }
            }
            return this;
        }

        /**
         * 响应点击事件，请先通过{@link #setOnClick(int...)}这只需要监听的控件的点击事件
         *
         * @param listener 点击事件响应回调接口
         * @return
         */
        public Builder onClick(OnClickListener listener) {
            this.mOnClickListener = listener;
            return this;
        }

        /**
         * 当设置{@link #setCancelable(boolean)}为true时，点击外部dialog消失的回调
         *
         * @param listener
         * @return
         */
        public Builder onCancel(OnCancelListener listener) {
            this.mOnCancelListener = listener;
            return this;
        }


        public CommonDialog build(Context context) {
            return new CommonDialog(context, this);
        }
    }

    public interface OnClickListener {
        /**
         * 点击事件响应
         *
         * @param dialog
         * @param view   被点击的view，通过{@link View#getId()}获取当前的id与设置的id进行比对确认是哪个控件的点击事件
         */
        void onClick(CommonDialog dialog, View view);
    }

    public interface OnBindView<T extends View> {
        void bindView(T view);
    }
}