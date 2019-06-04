package com.wy.adbook.mvp.model

import com.wy.adbook.mvp.contranct.BookCityContract
import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/30.
 */

@FragmentScope
class BookCityModel
@Inject
constructor(
    repositoryManager:
    IRepositoryManager
) : BaseModel(repositoryManager),
    BookCityContract.Model {


}