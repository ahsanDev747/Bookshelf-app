package com.example.bookshelf.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelf.R
import com.example.bookshelf.ui.screens.BooksViewModel
import com.example.bookshelf.ui.screens.HomeScreen

@Composable
fun BooksApp(modifier: Modifier = Modifier){
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { TopAppBar(title = {Text(stringResource(R.string.app_name)) })}

    ) {
         Surface(
             modifier = Modifier
                 .fillMaxSize()
                 .padding(it),
             color = MaterialTheme.colors.background
         ) {
             val booksViewModel: BooksViewModel =
                 viewModel(factory = BooksViewModel.Factory)
             HomeScreen(
                 booksUiState = booksViewModel.booksUiState,
                 retryAction = booksViewModel::getBooksPhotos
             )

         }
    }
}
