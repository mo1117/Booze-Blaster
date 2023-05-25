package com.boozeblaster.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.boozeblaster.composables.SimpleTopAppBar
import com.boozeblaster.models.Game

@Composable
fun GameOverScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SimpleTopAppBar(onBackButtonClick = { navController.navigate(route = Screen.HomeScreen.route) })
        }
    ) { paddingValues ->
        GameOverScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues)
        )
    }
}

@Composable
fun GameOverScreenContent(
    modifier: Modifier
) {
    val players = Game.getInstance().getPlayers()
    //TODO GameOverScreen content displaying sips etc
    Text(text = "GameOver")
}