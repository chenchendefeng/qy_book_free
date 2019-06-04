package com.freebookqy.viewlib.rv.decoration

import android.content.Context
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import com.freebookqy.utilslib.ScreenUtils


/**
 * Created by leafye on 2019/5/4.
 */
class EvenItemDecoration(
    private val context: Context,
    private val column: Int
) :
    RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        val measuredWidth = ScreenUtils.dpToPx(90)
        val screenWidth = ScreenUtils.getScreenWidth()
        val diff = (screenWidth - measuredWidth * column) * 1F / (column - 1) / 2
        when {
            position % column == 0 -> {
                outRect.left = 0
            }
            position % column == column - 1 -> {
                outRect.left = diff.toInt()
                outRect.right = 0
            }
            else -> {
                outRect.left = diff.toInt() / 2
            }
        }
    }


}