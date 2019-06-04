package com.wy.adbook.mvp.model.entity.book

import com.wy.adbook.app.base.BaseEntity
import java.io.Serializable

/**
 * Created by leafye on 2019/5/5.
 */
class NetPutOn:BaseEntity<PutOn>()

class PutOn:Serializable {

    override fun toString(): String {
        return "PutOn()"
    }
}