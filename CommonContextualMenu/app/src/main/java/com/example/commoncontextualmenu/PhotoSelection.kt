package com.example.commoncontextualmenu

import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.ItemKeyProvider
import androidx.recyclerview.widget.RecyclerView


class PhotoKeyProvider(private val adapter: PhotoAdapter) :
    ItemKeyProvider<String>(SCOPE_CACHED) {

    override fun getKey(position: Int): String {
        return adapter.currentList[position].id
    }

    override fun getPosition(key: String): Int {
        return adapter.currentList.indexOfFirst { photo -> photo.id == key }
    }
}

class PhotoDetailsLookup(private val recyclerView: RecyclerView) :
    ItemDetailsLookup<String>() {
    override fun getItemDetails(e: MotionEvent): ItemDetails<String>? {
        val view: View? = recyclerView.findChildViewUnder(e.x, e.y)
        if (view != null) {
            val holder = recyclerView.getChildViewHolder(view)
            if (holder is PhotoAdapter.PhotoViewHolder) {
                return holder.details
            }
        }
        return null
    }
}