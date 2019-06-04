package com.wy.adbook.app.utils

import android.content.pm.PackageManager
import android.support.v4.content.ContextCompat
import com.wy.adbook.app.QYApplication

/**
 * Created by leafye on 2019-05-10.
 */
class PermissionHelper {

    companion object {
        fun checkPermission(permission: String): Boolean {
            return ContextCompat.checkSelfPermission(
                QYApplication.cxt(),
                permission
            ) == PackageManager.PERMISSION_GRANTED
        }
    }


}