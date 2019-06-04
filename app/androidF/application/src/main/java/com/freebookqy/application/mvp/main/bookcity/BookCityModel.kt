package com.freebookqy.application.mvp.main.bookcity

import com.freebookqy.application.app.base.BaseEntity
import com.freebookqy.application.mvp.contranct.BookCityContract
import com.freebookqy.application.mvp.model.api.service.QYService
import com.freebookqy.application.mvp.model.entity.SubjectType
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/30.
 */

@ActivityScope
class BookCityModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    BookCityContract.Model {



}