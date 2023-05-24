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
import com.boozeblaster.models.Player

@Composable
fun GameOverScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()
    val game = Game.getInstance()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SimpleTopAppBar(onBackButtonClick = { navController.navigate(route = Screen.HomeScreen.route) })
        }
    ) { paddingValues ->
        GameOverScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            players = game.getPlayers()
        )
    }
}

@Composable
fun GameOverScreenContent(
    modifier: Modifier,
    players: List<Player>
) {
    //TODO GameOverScreen content displaying sips etc
    Text(text = "GameOver")
}