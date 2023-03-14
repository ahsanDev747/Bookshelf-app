package com.example.bookshelf.model

@kotlinx.serialization.Serializable
data class BookResponse(
    val items: List<Item>,
    val kind: String,
    val totalItems: Int
)
