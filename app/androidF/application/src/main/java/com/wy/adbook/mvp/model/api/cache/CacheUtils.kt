package com.wy.adbook.mvp.model.api.cache

import android.text.TextUtils
import com.wy.adbook.app.QYApplication
import com.freebookqy.utilslib.ACache
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.schedulers.Schedulers
import java.lang.reflect.Type

/**
 * Created by leafye on 2019-05-21.
 */
object CacheUtils {

    fun <T> getCacheObservable(zclazz: Class<T>, key: String) =
        Observable.create(ObservableOnSubscribe<T> { emitter ->
            val value = ACache.get(QYApplication.cxt()).getAsString(key)
            if (!TextUtils.isEmpty(value)) {
                try {
                    val t = Gson().fromJson<T>(value, zclazz as Type)
                    emitter.onNext(t)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            emitter.onComplete()
        }).subscribeOn(Schedulers.io())


//        Observable<DataClass> localDataObservable = Observable . create ((ObservableOnSubscribe<DataClass>)
//                emitter -> {
//            DataClass cacheData = null;
//            try {
//                cacheData = ... // 缓存数据来源根据具体的业务决定
//            } catch (Exception e) {
//                // 当场抓获，防止异常导致整个事件流中断，致使网络请求无法进行
//            }
//            if (cacheData != null) {
//                // 没毛病就传递给UI层，onNext可以多次调用，比如在循环体中使用很方便
//                emitter.onNext(cacheData);
//            }
//            emitter.onComplete(); // 本次事件结束了，把执行权交给下一个可能存在的事件
//        })
//        .subscribeOn(Schedulers.io()); // 读缓存当然要在子线程


}