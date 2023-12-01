package com.example.commoncontextualmenu

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class GutterDecoration(private val gutter: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView, state: RecyclerView.State
    ) {
        outRect.left = gutter / 2
        outRect.right = gutter / 2

        outRect.bottom = gutter
    }
}