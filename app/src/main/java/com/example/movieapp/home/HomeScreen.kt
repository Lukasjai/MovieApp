package com.example.movieapp.home

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

import com.example.movieapp.ui.theme.Movie
import com.example.movieapp.ui.theme.MovieRow
import com.example.movieapp.ui.theme.getMovies


@Composable
fun HomeScreen(navController: NavHostController, content: (String) -> Unit ={}){
    var showMenu by remember {
        mutableStateOf(false)
    }
    Scaffold (
        topBar = {
            TopAppBar(title = {Text(text = "Movie")},
                actions = {
                    IconButton(onClick = {showMenu =! showMenu}) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "moreVert")
                    }
                    DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
                        DropdownMenuItem(onClick = { /*TODO*/ }) {
                            Row {
                                Icon(imageVector = Icons.Default.Favorite,
                                    contentDescription = "Favorites" )
                                Text(text = "Favorites", modifier = Modifier
                                    .padding(4.dp)
                                    .width(100.dp))

                            }
                        }

                    }
                } )
        }){
        MainContent(navController = navController)
    }
    }
    


@Composable
fun MainContent (movies: List<Movie> = getMovies(), navController: NavHostController) {
    LazyColumn {
        items(movies) { movie ->
            MovieRow(movie )
            {movieId ->
                navController.navigate("homeScreen")
                navController.navigate("detailScreen")
            }


          //  ActualMovies(movie = movie)

        }
    }
}
