package com.wy.adbook.dialog.share

import com.wy.adbook.app.constant.Constant

/**
 * Created by leafye on 2019-05-20.
 */
interface ShareListener {
    fun share(shareDialog: ShareDialog, @Constant.ShareType shareType: Int)
}