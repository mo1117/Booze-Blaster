package com.boozeblaster.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.boozeblaster.screens.*
import com.boozeblaster.viewmodels.GameSettingsViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val gameSettingsViewModel = GameSettingsViewModel()

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {

        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.AddPlayerScreen.route) {
            AddPlayerScreen(navController = navController)
        }

        composable(route = Screen.StartGameScreen.route) {
            StartGameScreen(
                navController = navController,
                gameSettingsViewModel = gameSettingsViewModel
            )
        }

        composable(route = Screen.GameScreen.route) {
            GameScreen(navController = navController)
        }

        composable(route = Screen.GameOverScreen.route) {
            GameOverScreen(navController = navController)
        }

        composable(route = Screen.TutorialScreen.route) {
            TutorialScreen(navController = navController)
        }

        composable(route = Screen.DifficultyPickerScreen.route) {
            DifficultyPickerScreen(
                navController = navController,
                gameSettingsViewModel = gameSettingsViewModel
            )
        }

        composable(route = Screen.AdultModePickerScreen.route) {
            AdultModePickerScreen(
                navController = navController,
                gameSettingsViewModel = gameSettingsViewModel
            )
        }

        composable(route = Screen.DisplayDaresScreen.route) {
            DisplayDaresScreen(
                navController = navController,
                gameSettingsViewModel = gameSettingsViewModel
            )
        }

        composable(route = Screen.RoundPickerScreen.route) {
            RoundPickerScreen(
                navController = navController,
                gameSettingsViewModel = gameSettingsViewModel
            )
        }

        composable(route = Screen.FullfillDaresScreen.route) {
            FulfillDaresScreen(navController = navController)
        }

        composable(route = Screen.GiveSipsScreen.route) {
            GiveSipsScreen(navController = navController)
        }

        composable(route = Screen.CustomizeGameScreen.route) {
            CustomizeGameScreen(navController = navController)
        }
    }
}