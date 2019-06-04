package com.freebookqy.application.mvp.main.bookcity

import com.freebookqy.application.app.base.QYBasePresenter
import com.freebookqy.application.mvp.classification.ClassificationActivity
import com.freebookqy.application.mvp.contranct.BookCityContract
import com.freebookqy.application.mvp.main.search.SearchActivity
import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/30.
 */
@ActivityScope
class BookCityPresenter
@Inject constructor(model: BookCityContract.Model, view: BookCityContract.View) :
    QYBasePresenter<BookCityContract.Model, BookCityContract.View>(model, view) {

    fun enterSearch() {
        SearchActivity.startActivity(mRootView.getContext())
    }

    fun enterClassification() {
        ClassificationActivity.startActivity(mRootView.getContext())
    }


}