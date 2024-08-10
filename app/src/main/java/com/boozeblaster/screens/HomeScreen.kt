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
import com.boozeblaster.composables.topAppBars.HomeTopAppBarCreator
import com.boozeblaster.composables.*
import com.boozeblaster.models.Game
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.ui.theme.headerFont

@Composable
fun HomeScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            HomeTopAppBarCreator().CreateAppBar()
        },
        backgroundColor = getBackgroundColor()
    ) { paddingValues ->
        HomeScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            onStartClicked = { navController.navigate(route = Screen.StartGameScreen.route) },
            onCustomizeGameClicked = { navController.navigate(route = Screen.CustomizeGameScreen.route) },
            onAddPlayerClicked = { navController.navigate(route = Screen.AddPlayerScreen.route) },
            onTutorialClicked = { navController.navigate(route = Screen.TutorialScreen.route) }
        )
    }
}

@Composable
fun HomeScreenContent(
    modifier: Modifier,
    onStartClicked: () -> Unit,
    onCustomizeGameClicked: () -> Unit,
    onAddPlayerClicked: () -> Unit,
    onTutorialClicked: () -> Unit
) {

    Game.reset()

    SurfaceWithScrollableColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Change button specifications here as we want them to look consistent
        val minHeight = 75
        val fontSize = 16
        val fontFamily = FontFamily.SansSerif

        SimpleCard(onClick = onStartClicked) {
            SimpleTextDisplay(text = "Classic Game", fontSize = fontSize, fontFamily = headerFont)
        }

        SimpleSpacer(size = 30)

        SimpleCard(onClick = onCustomizeGameClicked) {
            SimpleTextDisplay(
                text = "Create Custom Game",
                fontSize = fontSize,
                fontFamily = headerFont
            )
        }

        SimpleSpacer(size = 30)

        SimpleCard(onClick = onAddPlayerClicked) {
            SimpleTextDisplay(text = "Add Players", fontSize = fontSize, fontFamily = headerFont)
        }

        SimpleSpacer(size = 30)

        SimpleCard(onClick = onTutorialClicked) {
            SimpleTextDisplay(text = "How To Play", fontSize = fontSize, fontFamily = headerFont)
        }
    }
}

