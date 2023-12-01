package com.example.commoncontextualmenu

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ActionMode
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.selection.StorageStrategy
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    private var actionMode: ActionMode? = null

    private lateinit var photoGrid: RecyclerView
    private lateinit var tracker: SelectionTracker<String>

    private val repository = PhotosRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.photo_grid)

        setUpPhotoGrid()
    }

    private fun setUpPhotoGrid() {
        photoGrid = findViewById(R.id.grid)
        val photoAdapter = PhotoAdapter()
        photoGrid.adapter = photoAdapter


        tracker = SelectionTracker.Builder(
            "photo-tracker",
            photoGrid,
            PhotoKeyProvider(photoAdapter),
            PhotoDetailsLookup(photoGrid),
            StorageStrategy.createStringStorage()
        ).build()

        photoAdapter.selectionTracker = tracker

        tracker.addObserver(object : SelectionTracker.SelectionObserver<String>() {
            override fun onSelectionChanged() {

                if (tracker.hasSelection()) {
                    if (actionMode == null) {
                        actionMode = startSupportActionMode(actionModeCallback)
                    }
                    updateContextualActionBarTitle()
                } else {
                    actionMode?.finish()
                }
            }
        })

        photoAdapter.submitList(repository.getAll())
    }

    private fun updateContextualActionBarTitle() {
        actionMode?.title = "${tracker.selection.size()} seleccionados"
        // todo[opcional]: Cambiar el subtítulo
        // ej: actionMode?.subtitle ="4MB"
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        tracker.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        tracker.onRestoreInstanceState(savedInstanceState)

        if (tracker.hasSelection()) {
            actionMode = startSupportActionMode(actionModeCallback)
            updateContextualActionBarTitle()
        }
    }

    private val actionModeCallback = object : ActionMode.Callback {
        override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
            menuInflater.inflate(R.menu.cab_photos_menu, menu)
            return true
        }

        override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
            return false
        }

        override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.delete -> {
                    deletePhotos()
                    true
                }
                R.id.tag, R.id.move, R.id.size -> {
                    showMessage(item)
                    true
                }
                else -> false
            }
        }

        override fun onDestroyActionMode(mode: ActionMode) {
            tracker.clearSelection()
            actionMode = null
        }
    }

    private fun deletePhotos() {
        val ids = tracker.selection.map { it }
        repository.delete(ids)
        (photoGrid.adapter as PhotoAdapter).submitList(repository.getAll())
        actionMode?.finish()
    }

    private fun showMessage(item: MenuItem) {
        val msg = "Aplicar \"${item.title}\" a ${tracker.selection.size()} elementos"
        Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
        actionMode?.finish()
    }
}