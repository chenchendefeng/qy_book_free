package com.freebookqy.viewlib

import android.content.Context
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import android.view.View
import kotlinx.android.synthetic.main.qy_title.view.*

/**
 * Created by leafye on 2019/4/29.
 *
 */
class QYToolbar : Toolbar {

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        View.inflate(context, R.layout.qy_title, this)
        var leftVisibility: Int
        var rightVisibility: Int
        var titleText = ""

        @DrawableRes
        var leftImgRes: Int
        var leftText = ""

        @DrawableRes
        var rightImgRes: Int
        var rightText = ""

        @ColorRes
        val titleColor: Int
        @ColorRes
        val leftColor: Int
        @ColorRes
        val rightColor: Int

        attrs.let {
            val o = context.obtainStyledAttributes(attrs, R.styleable.QYToolbar)
            leftVisibility = o.getInt(R.styleable.QYToolbar_left_visibility, 2)
            rightVisibility = o.getInt(R.styleable.QYToolbar_right_visibility, 0)
            val titleTextRes = o.getResourceId(R.styleable.QYToolbar_title_text, 0)
            if (titleTextRes > 0) {
                titleText = context.getString(titleTextRes)
            }
            leftImgRes = o.getResourceId(R.styleable.QYToolbar_left_img, 0)
            rightImgRes = o.getResourceId(R.styleable.QYToolbar_right_img, 0)
            val leftTextRes = o.getResourceId(R.styleable.QYToolbar_left_text, 0)
            if (leftTextRes > 0) {
                leftText = context.getString(leftTextRes)
            }
            val rightTextRes = o.getResourceId(R.styleable.QYToolbar_right_text, 0)
            if (rightTextRes > 0) {
                rightText = context.getString(rightTextRes)
            }

            titleColor = o.getResourceId(R.styleable.QYToolbar_qy_title_color, R.color.def_title_text_color)
            leftColor = o.getResourceId(R.styleable.QYToolbar_qy_left_color, R.color.def_title_text_color)
            rightColor = o.getResourceId(R.styleable.QYToolbar_qy_right_color, R.color.def_title_text_color)
            o.recycle()
        }
        setLeftVisibility(leftVisibility)
        setRightVisibility(rightVisibility)
        setLeftImg(leftImgRes)
        setRightImg(rightImgRes)
        setTitleText(titleText)

        setLeftText(leftText)
        setRightText(rightText)

        setQYTitleTextColor(titleColor)
        setQYLeftTextColor(leftColor)
        setQYRightTextColor(rightColor)
    }

    fun setLeftVisibility(visibility: Int) {
        setViewVisibility(visibility, toolbar_back)
    }

    fun setRightVisibility(visibility: Int) {
        setViewVisibility(visibility, toolbar_right)
    }

    private fun setViewVisibility(visibility: Int, view: View) {
        view.visibility = when (visibility) {
            0 -> View.GONE
            1 -> View.INVISIBLE
            2 -> View.VISIBLE
            else -> View.VISIBLE
        }
    }

    fun setLeftImg(@DrawableRes leftImgRes: Int) {
        toolbar_left_iv.setImageResource(leftImgRes)
    }

    fun setRightImg(@DrawableRes rightImgRes: Int) {
        toolbar_right_iv.setImageResource(rightImgRes)
    }

    fun setTitleText(text: CharSequence) {
        toolbar_title.text = text
    }

    fun setLeftText(text: CharSequence) {
        toolbar_left_tv.text = text
    }

    fun setRightText(text: CharSequence) {
        toolbar_right_tv.text = text
    }

    fun setQYTitleTextColor(@ColorInt colorInt: Int) {
        toolbar_title.setTextColor(colorInt)
    }

    fun setQYLeftTextColor(@ColorInt colorInt: Int) {
        toolbar_left_tv.setTextColor(colorInt)
    }

    fun setQYRightTextColor(@ColorInt colorInt: Int) {
        toolbar_right_tv.setTextColor(colorInt)
    }

}