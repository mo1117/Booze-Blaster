package com.boozeblaster.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.boozeblaster.composables.HomeTopAppBar
import com.boozeblaster.composables.SimpleCard
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.composables.SurfaceWithScrollableColumn
import com.boozeblaster.models.Game
import com.boozeblaster.ui.theme.backgroundColorForCard
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

        SimpleCard(modifier = Modifier,
                width = 220.dp,
                height = 120.dp,
                onClick = onStartClicked,
                shape = AbsoluteRoundedCornerShape(20.dp),
                backgroundColor = getBackgroundColor().backgroundColorForCard(),
                border = null,
                elevation = 4.dp,
                padding = 16.dp,
                enabled = true) {
            SimpleTextDisplay(text = "Classic Game", fontSize = fontSize, fontFamily = headerFont)
        }

        SimpleSpacer(size = 30)

        SimpleCard(modifier = Modifier,
                width = 220.dp,
                height = 120.dp,
                onClick = onCustomizeGameClicked,
                shape = AbsoluteRoundedCornerShape(20.dp),
                backgroundColor = getBackgroundColor().backgroundColorForCard(),
                border = null,
                elevation = 4.dp,
                padding = 16.dp,
                enabled = true) {
            SimpleTextDisplay(
                    text = "Create Custom Game",
                    fontSize = fontSize,
                    fontFamily = headerFont
            )
        }

        SimpleSpacer(size = 30)

        SimpleCard(modifier = Modifier,
                width = 220.dp,
                height = 120.dp,
                onClick = onAddPlayerClicked,
                shape = AbsoluteRoundedCornerShape(20.dp),
                backgroundColor = getBackgroundColor().backgroundColorForCard(),
                border = null,
                elevation = 4.dp,
                padding = 16.dp,
                enabled = true) {
            SimpleTextDisplay(text = "Add Players", fontSize = fontSize, fontFamily = headerFont)
        }

        SimpleSpacer(size = 30)

        SimpleCard(modifier = Modifier,
                width = 220.dp,
                height = 120.dp,
                onClick = onTutorialClicked,
                shape = AbsoluteRoundedCornerShape(20.dp),
                backgroundColor = getBackgroundColor().backgroundColorForCard(),
                border = null,
                elevation = 4.dp,
                padding = 16.dp,
                enabled = true) {
            SimpleTextDisplay(text = "How To Play", fontSize = fontSize, fontFamily = headerFont)
        }
    }
}

