package com.freebookqy.application.app.rx

import android.text.TextUtils
import com.freebookqy.application.app.ResponseErrorListenerImpl
import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.app.base.QYView
import com.jess.arms.utils.RxLifecycleUtils
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers

/**
 * Created by leafye on 2019-05-08.
 */
abstract class SimpleObserver<T> : Observer<T> {
    override fun onComplete() {

    }

    override fun onSubscribe(d: Disposable) {

    }

    override fun onError(e: Throwable) {

    }
}

fun <T> Observable<BaseEntity<T>>.netReq(rootView: QYView): Observable<BaseEntity<T>> {
    return this.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .compose(RxLifecycleUtils.bindToLifecycle(rootView))
        .concatMap(object : Function<BaseEntity<T>, ObservableSource<BaseEntity<T>>> {

            @Throws(Exception::class)
            override fun apply(t: BaseEntity<T>): ObservableSource<BaseEntity<T>> {
                if (t.result == BaseEntity.RESULT_OK) {
                    return Observable
                        .create { emitter ->
                            emitter.onNext(t)
                        }
                } else {
                    throw ServerRetException(t.result, t.msg, t.otherData)
                }
            }
        })
}


fun <T> Observable<BaseEntity<T>>.netReqConcat(): Observable<BaseEntity<T>> {
    return this.concatMap(object : Function<BaseEntity<T>, ObservableSource<BaseEntity<T>>> {

        @Throws(Exception::class)
        override fun apply(t: BaseEntity<T>): ObservableSource<BaseEntity<T>> {
            if (t.result == BaseEntity.RESULT_OK) {
                return Observable.create { emitter -> emitter.onNext(t) }
            } else {
                throw ServerRetException(t.result, t.msg, t.otherData)
            }
        }
    })
}

abstract class SimpleErrorSubscribe<T> : Observer<T> {

    private val rootView: QYView
    private var loadingStr: String = ""

    constructor(rootView: QYView) {
        this.rootView = rootView
    }

    constructor(rootView: QYView, loadingStr: String) {
        this.rootView = rootView
        this.loadingStr = loadingStr
    }

    private val handlerError: ResponseErrorListenerImpl by lazy {
        ResponseErrorListenerImpl()
    }

    override fun onComplete() {

    }

    override fun onNext(t: T) {
        success(t)
        rootView.hideLoading()
    }

    override fun onSubscribe(d: Disposable) {
        if (TextUtils.isEmpty(loadingStr)) {
            rootView.showLoading()
        } else {
            rootView.showLoading(loadingStr)
        }
    }

    override fun onError(e: Throwable) {
        if (e is ServerRetException) {
            onServerError(e)
        } else {
            handlerError.handleResponseError(rootView.getContext(), e)
        }
    }

    abstract fun success(t: T)

    fun onServerError(e: ServerRetException) {
        handlerError.handleResponseError(rootView.getContext(), e)
    }
}

class ServerRetException(
    val result: String,
    val msg: String,
    val otherData: Any?
) : RuntimeException(msg)