package com.example.bookshelf.data

import android.util.Log
import com.example.bookshelf.model.ImageLinks
import com.example.bookshelf.network.BooksApiService

interface BooksRepository{
    suspend fun getBooks(query: String): MutableList<ImageLinks>
}

class NetworkBooksRepository(private val booksApiService: BooksApiService) :
    BooksRepository {
    private val bookPhotos = mutableListOf<ImageLinks>()
    override suspend fun getBooks(query: String): MutableList<ImageLinks> {
        val response = booksApiService.searchBooks(query)
        val books = response.items
        for (i in books.indices) {
            val book = books[i]
            val bookID = book.id
            val bookResponse = booksApiService.searchBooksPhotos(bookID)
            val thumb = bookResponse.volumeInfo.imageLinks
            Log.d("debugging", thumb.thumbnail)
            bookPhotos.add(thumb)
        }
        return bookPhotos
    }
    }

