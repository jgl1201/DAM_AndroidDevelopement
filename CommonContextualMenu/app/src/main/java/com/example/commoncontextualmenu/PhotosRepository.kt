package com.example.commoncontextualmenu

object PhotosRepository {
    private val inMemoryPhotos = mutableListOf(
        Photo(R.drawable.photo1),
        Photo(R.drawable.photo2),
        Photo(R.drawable.photo3),
        Photo(R.drawable.photo4),
        Photo(R.drawable.photo5),
        Photo(R.drawable.photo6),
        Photo(R.drawable.photo7),
        Photo(R.drawable.photo8),
        Photo(R.drawable.photo9),
        Photo(R.drawable.photo10)
    )

    fun getAll(): List<Photo> = inMemoryPhotos.toList()

    fun delete(photoIdsToRemove: List<String>) {
        inMemoryPhotos.removeAll { photo -> photo.id in photoIdsToRemove }
    }
}