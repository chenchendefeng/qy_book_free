package com.wy.adbook.mvp.model.api.cache;

import android.text.TextUtils;
import com.wy.adbook.app.QYApplication;
import com.wy.adbook.app.base.BaseEntity;
import com.freebookqy.utilslib.ACache;
import com.google.gson.Gson;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;

/**
 * Created by leafye on 2019-05-20.
 */
public abstract class ApiCacheSubscriber<T extends BaseEntity> extends ErrorHandleSubscriber<T> {
    private final String keyHead = "xjavacache_";
    private String key;
    private boolean isCache = true;
    private boolean hasCache = false;

    @Override
    public void onError(Throwable e) {
        if (e != null && hasCache) {
            return;
        }
        super.onError(e);
    }

    public ApiCacheSubscriber(RxErrorHandler handler, String key, Class zclass) {
        this(handler, key, zclass, true);
    }

    public ApiCacheSubscriber(RxErrorHandler handler, String key, Class zclass, boolean isCache) {
        super(handler);
        this.key = keyHead + key;
        this.isCache = isCache;
        if (isCache) {
            String value = ACache.get(QYApplication.cxt()).getAsString(this.key);
            if (!TextUtils.isEmpty(value)) {
                T t = new Gson().fromJson(value, (Type) zclass);
                if (t != null) {
                    hasCache = true;
                    onCache(t);
                }
            }
        }
    }


    public abstract void onCache(T t);

    public abstract void onSuccess(@NotNull T t);

    @Override
    public void onNext(T t) {
        if (BaseEntity.RESULT_OK.equals(t.getResult())) {
            if (isCache) {
                ACache.get(QYApplication.cxt()).put(key, new Gson().toJson(t));
            }
        }
        onSuccess(t);
//        else if (ConfigUtils.INVALID.equals(t.getResult())) {
//            NetError error = new NetError(t.getErrorMsg(), NetError.AuthError);
//            onFail(error);
//        } else {
//            NetError error = new NetError(t.getErrorMsg(), NetError.BusinessError);
//            onFail(error);
//        }
    }

}