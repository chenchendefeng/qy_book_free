package com.wy.adbook.app.manager

import com.bumptech.glide.Glide
import com.freebookqy.utilslib.ACache
import com.freebookqy.utilslib.FileUtils
import com.jess.arms.utils.LogUtils
import com.wy.adbook.app.QYApplication
import com.wy.adbook.app.constant.Constant
import java.io.File

/**
 * Created by leafye on 2019-05-30.
 */
object CacheManager {

    /**
     * 获取缓存大小
     *
     * @return
     */
    @Synchronized
    fun getCacheSize(): String {
        var cacheSize: Long = 0
        try {
            val cacheDir = QYApplication.cxt().cacheDir.path
            cacheSize += FileUtils.getFolderSize(cacheDir)
            if (FileUtils.isSdCardAvailable()) {
                val extCacheDir = QYApplication.cxt().externalCacheDir.path
                cacheSize += FileUtils.getFolderSize(extCacheDir)
            }
        } catch (e: Exception) {
            LogUtils.debugInfo(e.toString())
        }
        return FileUtils.formatFileSizeToString(cacheSize)
    }

    /**
     * 清除缓存
     *
     * @param clearReadPos 是否删除阅读记录
     */
    @Synchronized
    fun clearCache(clearReadPos: Boolean, clearCollect: Boolean) {
        try {
            // 删除内存缓存
            val cacheDir = QYApplication.cxt().cacheDir.path
            FileUtils.deleteFileOrDirectory(File(cacheDir))
            FileUtils.deleteFileOrDirectory(File(FileUtils.getCachePath()))
            if (FileUtils.isSdCardAvailable()) {
                // 删除SD书籍缓存
                FileUtils.deleteFileOrDirectory(File(Constant.BOOK_CACHE_PATH))
            }
            // 删除阅读记录（SharePreference）
//            if (clearReadPos) {
//                //防止再次弹出性别选择框，sp要重写入保存的性别
//                val chooseSex = AppPreference.getInstance().getString("userChooseSex", Constant.Gender.MALE)
//                AppPreference.getInstance().removeAll()
//                AppPreference.getInstance().setValue("userChooseSex", chooseSex)
//            }
            Glide.get(QYApplication.cxt()).clearDiskCache()
            // 清除其他缓存
            ACache.get(QYApplication.cxt()).clear()
        } catch (e: Exception) {
            LogUtils.debugInfo(e.toString())
        }

    }


}