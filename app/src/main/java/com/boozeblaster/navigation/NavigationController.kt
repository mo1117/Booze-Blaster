package com.boozeblaster.navigation

import androidx.navigation.NavController
import com.boozeblaster.enums.Difficulty
import com.boozeblaster.models.Game
import com.boozeblaster.screens.Screen
import com.boozeblaster.widgets.MyMediaPlayer

object NavigationController {

    fun navigateToHomeScreen(navController: NavController) {
        MyMediaPlayer.stop()
        Game.reset()
        navController.navigate(route = Screen.HomeScreen.route) {
            popUpTo(id = navController.graph.startDestinationId) {
                inclusive = false
            }
        }
    }

    fun popBackStackIntoHomeScreen(
        navController: NavController,
        setAdultMode: (Boolean?) -> Unit,
        setDifficulty: (Difficulty?) -> Unit
    ) {
        setAdultMode(null)
        setDifficulty(null)
        navController.popBackStack()
    }

}

