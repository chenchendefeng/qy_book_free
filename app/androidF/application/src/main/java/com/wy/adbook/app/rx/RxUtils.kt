package com.wy.adbook.app.rx

import com.jess.arms.mvp.IView
import com.jess.arms.utils.RxLifecycleUtils
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

/**
 * ================================================
 * 放置便于使用 RxJava 的一些工具方法
 *
 *
 * Created by MVPArmsTemplate on 04/29/2019 11:35
 * [Contact me](mailto:jess.yan.effort@gmail.com)
 * [Follow me](https://github.com/JessYanCoding)
 * ================================================
 */
object RxUtils {

    fun <T> applySchedulers(view: IView): ObservableTransformer<T, T> {
        return ObservableTransformer { observable ->
            observable.subscribeOn(Schedulers.io())
                .doOnSubscribe {
                    view.showLoading()//显示进度条
                }
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally {
                    view.hideLoading()//隐藏进度条
                }.compose(RxLifecycleUtils.bindToLifecycle(view))
        }
    }

    fun delay(view: IView, delay: Long, timeUnit: TimeUnit, fun1: () -> Unit) {
        Observable
            .create(ObservableOnSubscribe<Int> { emitter ->
                emitter.onNext(1)
            })
            .delay(delay, timeUnit)
            .compose(RxLifecycleUtils.bindToLifecycle(view))
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SimpleObserver<Int>() {
                override fun onNext(t: Int) {
                    fun1()
                }
            })
    }

    fun delay(view: IView, delay: Long, timeUnit: TimeUnit, fun1: Unit) {
        Observable
            .create(ObservableOnSubscribe<Int> { emitter ->
                emitter.onNext(1)
            })
            .delay(delay, timeUnit)
            .observeOn(AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(view))
            .subscribe(object : SimpleObserver<Int>() {
                override fun onNext(t: Int) {
                    fun1
                }
            })
    }


    @JvmStatic
    fun <T> toSimpleSingle(upstream: Single<T>): SingleSource<T> {
        return upstream.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}
