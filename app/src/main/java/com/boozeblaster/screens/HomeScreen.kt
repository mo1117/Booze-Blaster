package com.boozeblaster.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavController
import com.boozeblaster.composables.HomeTopAppBar
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SurfaceWithColumn
import com.boozeblaster.models.Game
import com.boozeblaster.ui.theme.getBackgroundColor

@Composable
fun HomeScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            HomeTopAppBar()
        },
        backgroundColor = getBackgroundColor()
    ) { paddingValues ->
        HomeScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            onStartClicked = { navController.navigate(route = Screen.StartGameScreen.route) },
            onAddPlayerClicked = { navController.navigate(route = Screen.AddPlayerScreen.route) },
            onTutorialClicked = { navController.navigate(route = Screen.TutorialScreen.route) }
        )
    }
}

@Composable
fun HomeScreenContent(
    modifier: Modifier,
    onStartClicked: () -> Unit,
    onAddPlayerClicked: () -> Unit,
    onTutorialClicked: () -> Unit
) {

    Game.reset()

    SurfaceWithColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Change button specifications here as we want them to look consistent
        val minHeight = 75
        val fontSize = 16
        val fontFamily = FontFamily.SansSerif

        //Start button
        SimpleButton(
            onClick = {
                onStartClicked()
            },
            text = "Start",
            fontSize = fontSize,
            fontFamily = fontFamily,
            minHeight = minHeight
        )
        SimpleSpacer(size = 100)

        //Add a player button
        SimpleButton(
            onClick = { onAddPlayerClicked() },
            text = "Add Player",
            fontSize = fontSize,
            fontFamily = fontFamily,
            minHeight = minHeight
        )
        SimpleSpacer(size = 100)

        //Tutorial button
        SimpleButton(
            onClick = { onTutorialClicked() },
            text = "How To Play",
            fontSize = fontSize,
            fontFamily = fontFamily,
            minHeight = minHeight
        )
    }
}

