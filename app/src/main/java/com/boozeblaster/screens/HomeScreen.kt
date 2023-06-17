package com.boozeblaster.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.boozeblaster.composables.HomeTopAppBar
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleSpacer
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

    Surface(
        modifier = modifier
            .fillMaxWidth(fraction = 1f)
            .fillMaxHeight(fraction = 1f)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = modifier.background(
                color = getBackgroundColor()
            )
        ) {
            // Change button specifications here as we want them to look consistent
            val buttonModifier = Modifier
                .size(width = 150.dp, height = 75.dp)
            val fontSize = 16
            val fontFamily = FontFamily.SansSerif

            SimpleSpacer(size = 100)
            SimpleButton(
                modifier = buttonModifier,
                onClick = {
                    onStartClicked()
                },
                text = "Start",
                fontSize = fontSize,
                fontFamily = fontFamily
            )
            Spacer(
                modifier = modifier.size(size = 100.dp)
            )
            SimpleButton(
                modifier = buttonModifier,
                onClick = { onAddPlayerClicked() },
                text = "Add Player",
                fontSize = fontSize,
                fontFamily = fontFamily
            )
            Spacer(
                modifier = modifier.size(size = 100.dp)
            )
            SimpleButton(
                modifier = buttonModifier,
                onClick = { onTutorialClicked() },
                text = "How To Play",
                fontSize = fontSize,
                fontFamily = fontFamily
            )
        }
    }
}

