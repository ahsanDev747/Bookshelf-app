package com.example.bookshelf.model



@kotlinx.serialization.Serializable
data class Item(
    val id: String,
    val volumeInfo: VolumeInfo
)