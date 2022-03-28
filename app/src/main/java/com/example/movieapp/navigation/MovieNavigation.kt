package com.example.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieapp.DetailScreen.DetailScreen
import com.example.movieapp.home.HomeScreen

@Composable
fun MovieNavigation ( ){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "homeScreen" ){
        composable("homeScreen"){ HomeScreen(navController = navController)}
        composable(route ="detailScreen/{movieId}",
            arguments = listOf(navArgument("movieId"){
                type = NavType.StringType
            })
        ){
            DetailScreen()
        }

            /*
            route = "detailScreen/{movieId}",
            arguments = listOf(navArgument("movieId"){
                type = NavType.StringType
            })
            ){ backStackEntry ->
            DetailScreen(movieId = BackStackEntry.arguments?.getString("movieId"))
        }

             */

        //add more routes and screens here
    }
}