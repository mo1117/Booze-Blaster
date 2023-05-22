package com.boozeblaster.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.boozeblaster.screens.*

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {

        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.AddPlayerScreen.route) {
            AddPlayerScreen(navController = navController)
        }

        composable(route = Screen.EditPlayerScreen.route) {
            EditPlayerScreen(navController = navController)
        }

        composable(route = Screen.StartGameScreen.route) {
            StartGameScreen(navController = navController)
        }

        composable(route = Screen.GameScreen.route) {
            GameScreen(navController = navController)
        }

        composable(route = Screen.GameOverScreen.route) {
            GameOverScreen(navController = navController)
        }
    }
}