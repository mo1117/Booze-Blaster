package com.boozeblaster.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.boozeblaster.composables.*
import com.boozeblaster.models.Game
import com.boozeblaster.navigation.NavigationController
import com.boozeblaster.ui.theme.getBackgroundColor

@Composable
fun GameOverScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SimpleTopAppBar(onBackButtonClick = {
                NavigationController.navigateToHomeScreen(
                    navController = navController
                )
            })
        },
        backgroundColor = getBackgroundColor()
    ) { paddingValues ->
        GameOverScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            playAgain = {
                navController.popBackStack()
                Game.playAgain()
                navController.navigate(route = Screen.DisplayDaresScreen.route)
            }
        )
    }
}

@Composable
fun GameOverScreenContent(
    modifier: Modifier,
    playAgain: () -> Unit
) {
    // Sort the list of players by their points
    val players = Game.getPlayersByPointsDescending()

    SurfaceWithColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        LazyColumn(
            modifier = Modifier.size(width = 300.dp, height = 400.dp),
            content = {
                items(players) { player ->
                    Row {
                        SimpleTextDisplay(
                            text = player.getName(),
                            fontSize = 20,
                            fontFamily = FontFamily.SansSerif
                        )
                        SimpleSpacer(size = 10)

                        SimpleTextDisplay(
                            text = "${player.getPoints()} Points",
                            fontSize = 20,
                            fontFamily = FontFamily.SansSerif
                        )
                        SimpleSpacer(size = 10)

                        SimpleTextDisplay(
                            text = "${player.getSips()} Sips",
                            fontSize = 20,
                            fontFamily = FontFamily.SansSerif
                        )
                    }
                }
            })

        SimpleSpacer(size = 50)

        SimpleButton(
            modifier = Modifier,
            onClick = {
                playAgain()
            },
            text = "Play Again",
            fontSize = 20,
            fontFamily = FontFamily.SansSerif
        )
    }
}