package com.freebookqy.application.mvp.contranct

import com.freebookqy.application.app.base.QYModel
import com.freebookqy.application.app.base.QYView

/**
 * Created by leafye on 2019-05-08.
 */
interface SignCalenderContract {

    interface View: QYView {
        fun refreshView()
    }

    interface Model: QYModel

}