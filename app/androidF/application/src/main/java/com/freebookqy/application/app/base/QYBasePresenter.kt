package com.freebookqy.application.app.base

import com.jess.arms.mvp.BasePresenter
import com.jess.arms.mvp.IModel
import com.jess.arms.mvp.IView
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/29.
 */
abstract class QYBasePresenter<M:IModel,V:IView>: BasePresenter<M, V> {
    constructor(model: M, rootView: V) : super(model, rootView)
    constructor(rootView: V) : super(rootView)
    constructor() : super()

    @Inject
    lateinit var mErrorHandler: RxErrorHandler
}