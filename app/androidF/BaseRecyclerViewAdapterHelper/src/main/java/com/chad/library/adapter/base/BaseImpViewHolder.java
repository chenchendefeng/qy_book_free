package com.chad.library.adapter.base;

import android.view.View;

/**
 * Created by leafye on 2018/5/28.
 * DES:
 */

public abstract class BaseImpViewHolder<T> extends BaseViewHolder {

    public BaseImpViewHolder(View view) {
        super(view);
    }

    protected T mData;

    public void setDataAndRefreshHolderView(T t) {
        mData = t;
        refreshHolderView(t);
    }

    public abstract void refreshHolderView(T t);

}
