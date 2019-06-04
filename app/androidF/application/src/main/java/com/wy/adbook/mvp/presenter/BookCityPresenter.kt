package com.wy.adbook.mvp.presenter

import com.wy.adbook.app.base.QYBasePresenter
import com.wy.adbook.mvp.view.activity.ClassificationActivity
import com.wy.adbook.mvp.contranct.BookCityContract
import com.wy.adbook.mvp.view.activity.SearchActivity
import com.jess.arms.di.scope.FragmentScope
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/30.
 */
@FragmentScope
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