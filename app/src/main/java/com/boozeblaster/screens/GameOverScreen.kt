package com.boozeblaster.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleTopAppBar
import com.boozeblaster.models.Game

@Composable
fun GameOverScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SimpleTopAppBar(onBackButtonClick = { navController.popBackStack() })
        }
    ) { paddingValues ->
        GameOverScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            playAgain = {
                navController.popBackStack()
                Game.getInstance().reset()
                navController.navigate(route = Screen.GameScreen.route)
            }
        )
    }
}

@Composable
fun GameOverScreenContent(
    modifier: Modifier,
    playAgain: () -> Unit
) {
    // Filter the list of players by their points
    val players = Game.getInstance().getPlayers()
        .sortedWith(comparator = compareBy(selector = { player -> player.getPoints() }))
    Surface(
        modifier = modifier
            .fillMaxWidth(fraction = 1f)
            .fillMaxHeight(fraction = 1f)
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val r = Row {
                Text(text = "Name")
                Spacer(modifier = modifier.size(50.dp))
                Text(text = "Points")
                Spacer(modifier = modifier.size(50.dp))
                Text(text = "Sips")
            }
            for (player in players) {
                Row {
                    Text(text = "${player.getName()}")
                    Spacer(modifier = modifier.size(50.dp))
                    Text(text = "${player.getPoints()}")
                    Spacer(modifier = modifier.size(50.dp))
                    Text(text = "${player.getSips()}")
                }
            }
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
}