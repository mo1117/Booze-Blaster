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
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.composables.SurfaceWithScrollableColumn
import com.boozeblaster.composables.builder.SimpleCardBuilder
import com.boozeblaster.models.Game
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.ui.theme.headerFont

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

        val simpleCardBuilder = SimpleCardBuilder()
        simpleCardBuilder.callback = onStartClicked
        simpleCardBuilder.content = {
            SimpleTextDisplay(text = "Classic Game", fontSize = fontSize, fontFamily = headerFont)
        }
        simpleCardBuilder.build()()

        SimpleSpacer(size = 30)

        simpleCardBuilder.callback = onCustomizeGameClicked
        simpleCardBuilder.content = {
            SimpleTextDisplay(text = "Create Custom Game", fontSize = fontSize, fontFamily = headerFont
            )
        }
        simpleCardBuilder.build()()

        SimpleSpacer(size = 30)

        simpleCardBuilder.callback = onAddPlayerClicked
        simpleCardBuilder.content = {
            SimpleTextDisplay(text = "Add Players", fontSize = fontSize, fontFamily = headerFont)
        }
        simpleCardBuilder.build()()

        SimpleSpacer(size = 30)

        simpleCardBuilder.callback = onTutorialClicked
        simpleCardBuilder.content = {
            SimpleTextDisplay(text = "How To Play", fontSize = fontSize, fontFamily = headerFont)
        }
    }
}

