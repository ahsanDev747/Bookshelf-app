package com.example.bookshelf.data

import com.example.bookshelf.network.BooksApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface AppContainer{
    val booksRepository: BooksRepository
}

class DefaultAppContainer : AppContainer{
    private val BASE_URL = "https://www.googleapis.com/books/v1/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(
            Json{
                isLenient = true
                ignoreUnknownKeys = true
            }.asConverterFactory("application/json".toMediaType())
        )
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: BooksApiService by lazy {
            retrofit.create(BooksApiService :: class.java)
    }


    override val booksRepository: BooksRepository by lazy {
        NetworkBooksRepository(retrofitService)
    }



}