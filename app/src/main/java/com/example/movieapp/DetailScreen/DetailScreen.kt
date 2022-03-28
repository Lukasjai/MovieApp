package com.example.movieapp.DetailScreen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.movieapp.home.MainContent
import com.example.movieapp.ui.theme.getMovies


@Composable
fun DetailScreen(movieId: String? = getMovies()[0].id){
    Text(text = "My detail screen")
}