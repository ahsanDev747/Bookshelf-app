package com.example.bookshelf.data

import android.util.Log
import com.example.bookshelf.model.BookPhoto
import com.example.bookshelf.model.ImageLinks
import com.example.bookshelf.model.Item
import com.example.bookshelf.network.BooksApiService

interface BooksRepository{
    suspend fun getBooks(query: String): MutableList<BookPhoto>
}

class NetworkBooksRepository(private val booksApiService: BooksApiService) :
    BooksRepository {
    private val bookPhotos = mutableListOf<BookPhoto>()
    override suspend fun getBooks(query: String): MutableList<BookPhoto> {
        val response = booksApiService.searchBooks(query)
        val books = response.items

        for (i in books.indices) {
            val book = BookPhoto(books[i].id, books[i].volumeInfo.imageLinks.thumbnail)
            bookPhotos.add(book)
            Log.d("Book debug ID", bookPhotos[i].id)
            Log.d("Book debug image", bookPhotos[i].image)
        }
        return bookPhotos
    }

    }

