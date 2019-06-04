package com.wy.adbook.mvp.presenter

import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.mvp.contranct.ClassificationDetailContract
import com.wy.adbook.mvp.model.entity.book.Book
import com.wy.adbook.mvp.model.entity.ClassificationItem
import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

/**
 * Created by leafye on 2019/5/5.
 */
@ActivityScope
class ClassificationDetailPresenter
@Inject
constructor(model: ClassificationDetailContract.Model, view: ClassificationDetailContract.View) :
    QYBasePresenter<ClassificationDetailContract.Model, ClassificationDetailContract.View>(model, view) {

    var bookList: MutableList<Book>? = null

    var classificationItem:ClassificationItem?=null

    fun fetchData() {
        mRootView.refreshView()
    }

    fun enterBookDetail(book: Book) {

    }


}