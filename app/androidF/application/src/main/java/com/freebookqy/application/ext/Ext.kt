package com.freebookqy.application.ext

import android.app.Activity
import android.content.ContentResolver
import android.content.Context
import android.content.res.Resources
import android.net.Uri
import android.provider.MediaStore
import android.support.annotation.DrawableRes
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.freebookqy.application.app.QY
import com.freebookqy.application.app.QYApplication
import com.freebookqy.application.di.component.QYComponent
import com.jess.arms.http.imageloader.ImageConfig
import com.jess.arms.http.imageloader.glide.ImageConfigImpl
import com.jess.arms.utils.ArmsUtils


/**
 * Author : zhongwenpeng
 * Email : 1340751953@qq.com
 * Time :  2018/5/23
 * Description :
 */


val Float.px: Float get() = (this * Resources.getSystem().displayMetrics.density)

val Int.px: Int get() = ((this * Resources.getSystem().displayMetrics.density).toInt())

val Int.dip2Px: Int get() = ArmsUtils.dip2px(QYApplication.cxt(), this.toFloat())

/**
 * 点击事件扩展方法
 */
fun View.onClick(method: (() -> Unit)?): View {
    setOnClickListener { method?.invoke() }
    return this
}

/**
 * 点击事件扩展方法
 */
fun View.onClick(listener: View.OnClickListener): View {
    setOnClickListener(listener)
    return this
}

/**
 * 设置View的可见
 */
fun View.visible(isVisible: Boolean): View {
    visibility = if (isVisible) VISIBLE else GONE
    return this
}

fun AppCompatActivity.showDialog(dialog: DialogFragment) {
    dialog.show(supportFragmentManager, "TAG")
}

fun Fragment.showDialog(dialog: DialogFragment) {
    dialog.show(fragmentManager, "TAG")
}

fun dismissDialog(dialog: DialogFragment) {
    dialog.dismiss()
}

/**
 *
 */
fun <T : ImageConfig> ImageView.loadImage(config: T) {
    ArmsUtils.obtainAppComponentFromContext(this.getContext())
        .imageLoader()
        .loadImage(this.context, config)
}

fun ImageView.loadImage(url: String) {
    loadImage(url, 0)
}

fun ImageView.loadImage(url: String, placeholder: Int) {
    ArmsUtils
        .obtainAppComponentFromContext(this.context)
        .imageLoader()
        .loadImage(
            this.context,
//            QYImageConfig.Builder()
            ImageConfigImpl.builder()
                .url(url)
                .placeholder(placeholder)
                .imageView(this)
                .build()
        )
}

fun ImageView.gif(@DrawableRes id: Int) {
    Glide.with(QYApplication.cxt()).asGif().load(id).into(this)
}


fun Context.getTopActivity(): Activity {
    return ArmsUtils.obtainAppComponentFromContext(this).appManager().topActivity!!
}

/**
 * 通过uri  获取文件的路径
 */
fun Uri.getRealFilePath(context: Context): String? {
    val scheme = this.getScheme()
    var data: String? = null
    if (scheme == null)
        data = this.getPath()
    else if (ContentResolver.SCHEME_FILE == scheme) {
        data = this.getPath()
    } else if (ContentResolver.SCHEME_CONTENT == scheme) {
        val cursor = context.contentResolver.query(this, arrayOf(MediaStore.Images.ImageColumns.DATA), null, null, null)
        if (null != cursor) {
            if (cursor.moveToFirst()) {
                val index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
                if (index > -1) {
                    data = cursor.getString(index)
                }
            }
            cursor.close()
        }
    }
    return data
}

fun Context.getYangYanComponent(): QYComponent {
    return (this as QY).yangYangComponent()
}

fun Fragment.hideKeyboard() {
    activity?.hideKeyboard()
}

fun Activity.hideKeyboard() {
    val imm =
        getSystemService(android.content.Context.INPUT_METHOD_SERVICE) as InputMethodManager
    val currentFocus = window.currentFocus
    val windowToken = if (currentFocus != null) {
        currentFocus.windowToken
    } else {
        window.decorView.windowToken
    }
    if (windowToken != null) {
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}

fun Activity.showKeyboard(editText: EditText) {
    val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
    inputMethodManager!!.showSoftInput(editText, 0)
}



