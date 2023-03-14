package com.example.bookshelf.network

import com.example.bookshelf.model.BookResponse
import com.example.bookshelf.model.Item
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BooksApiService {

    @GET("volumes")
    suspend fun searchBooks(@Query("q") query: String): BookResponse

//    @GET("volumes/{id}")
//    suspend fun searchBooksPhotos(@Path("id") bookId: String): Item

}