package com.boozeblaster.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.boozeblaster.composables.HomeTopAppBar
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.controllers.DarkmodeController
import com.boozeblaster.enums.Difficulty
import com.boozeblaster.generators.TaskGenerator
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player
import com.boozeblaster.ui.theme.DarkBackGround
import com.boozeblaster.ui.theme.LightBackground

@Composable
fun HomeScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            HomeTopAppBar()
        },
        backgroundColor = if (DarkmodeController.isDarkmode()) DarkBackGround else LightBackground
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

    val p1 = Player(name = "Mo", birthDate = "egal")
    val p2 = Player(2, "Mo2", "egal")
    val p3 = Player(3, "Mo3", "egal")
    Game.init(
        listOf(p1, p2, p3),
        TaskGenerator.generateTasks(listOf(p1, p2, p3), 1),
        Difficulty.MEDIUM,
        false
    )

    Surface(
        modifier = modifier
            .fillMaxWidth(fraction = 1f)
            .fillMaxHeight(fraction = 1f)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = modifier.background(
                color = if (DarkmodeController.isDarkmode()) DarkBackGround else LightBackground
            )
        ) {
            // Change button specifications here as we want them to look consistent
            val buttonModifier = Modifier
                .size(width = 150.dp, height = 75.dp)
            val fontSize = 16
            val fontFamily = FontFamily.SansSerif
            val buttonColor = Color.Cyan

            SimpleSpacer(size = 100)
            SimpleButton(
                modifier = buttonModifier,
                onClick = {
                    onStartClicked()
                },
                text = "Start",
                fontSize = fontSize,
                fontFamily = fontFamily,
                color = buttonColor
            )
            Spacer(
                modifier = modifier.size(size = 100.dp)
            )
            SimpleButton(
                modifier = buttonModifier,
                onClick = { onAddPlayerClicked() },
                text = "Add Player",
                fontSize = fontSize,
                fontFamily = fontFamily,
                color = buttonColor
            )
            Spacer(
                modifier = modifier.size(size = 100.dp)
            )
            SimpleButton(
                modifier = buttonModifier,
                onClick = { onTutorialClicked() },
                text = "How To Play",
                fontSize = fontSize,
                fontFamily = fontFamily,
                color = buttonColor
            )
        }
    }
}

