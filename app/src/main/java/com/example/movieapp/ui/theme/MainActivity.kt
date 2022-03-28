    package com.example.movieapp.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieapp.home.HomeScreen
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert

    import androidx.compose.material.icons.filled.*
import com.example.movieapp.navigation.MovieNavigation


    class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
               Myapp()

            }
        }
    }
}

@Composable
fun Myapp(movieList: List<Movie> = getMovies()){
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
        LazyColumn {
            items(items = movieList) { movie ->
                MovieRow(movie = movie)

            }
        }
    }
}






@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MovieRow (movie: Movie,
                onItemClick: (String) -> Unit ={}){
    var changeState by remember {
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .height(130.dp)
        .clickable { onItemClick(movie.id) },
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = 6.dp
    ) {
        Row (verticalAlignment = Alignment.CenterVertically){
            Surface(modifier = Modifier
                .size(100.dp)
                .padding(12.dp)) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "movie pic")
            }

            LazyColumn{
               item{
                   Text(text= movie.title)
                   Text(text = "Director: ${movie.director}")
                   Text(text = "Year: ${movie.year}")
                   AnimatedVisibility(visible = changeState ) {
                       Column(modifier = Modifier.padding(8.dp)) {
                           Text(text = "Plot: ${movie.plot}")
                           Text(text = "Actors: ${movie.actors}")
                           Text(text = "Genre: ${movie.genre}")
                           Text(text = "Rating: ${movie.rating}")
                       }
                   }
                   IconButton(onClick = {changeState =! changeState}) {
                       if (changeState){
                           Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = "Arrowup")
                       }else{
                           Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Arrowdown")
                       }
                   }
               }
            }
               }

    }
}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MovieAppTheme {
        Myapp()

    }
}