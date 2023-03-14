package com.example.bookshelf.model

@kotlinx.serialization.Serializable
data class ImageLinks(
    val smallThumbnail: String,
    val thumbnail: String
)