package com.wy.adbook.mvp.view.web.frag

import com.jess.arms.di.scope.FragmentScope
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel
import javax.inject.Inject

/**
 * Created by leafye on 2019-05-23.
 */
@FragmentScope
class QYWebModel
@Inject
constructor(
repositoryManager:
IRepositoryManager
) : BaseModel(repositoryManager),
QYWebContract.Model {


}
