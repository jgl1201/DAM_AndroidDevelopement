package com.example.commoncontextualmenu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class PhotoAdapter : ListAdapter<Photo, PhotoAdapter.PhotoViewHolder>(PhotoDiffCallback()) {

    var selectionTracker: SelectionTracker<String>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.photo_item, parent, false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = getItem(position)
        selectionTracker?.let {
            holder.bind(photo, it.isSelected(photo.id))
        }
    }

    inner class PhotoViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        private val featuredImage: ImageView = view.findViewById(R.id.photo)
        private val overlay: View = view.findViewById(R.id.selection_overlay)


        fun bind(article: Photo, isSelected: Boolean) {
            overlay.visibility = if (isSelected) View.VISIBLE else View.INVISIBLE
            featuredImage.setImageResource(article.featuredImage)
        }

        val details
            get() = object : ItemDetailsLookup.ItemDetails<String>() {
                override fun getPosition(): Int = adapterPosition

                override fun getSelectionKey(): String? = getItem(adapterPosition).id
            }
    }
}

class PhotoDiffCallback : DiffUtil.ItemCallback<Photo>() {
    override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
        return oldItem == newItem
    }
}