package com.boozeblaster.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavController
import com.boozeblaster.composables.ClickableSurfaceWithColumn
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.composables.SimpleTopAppBar
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.ui.theme.headerFont

@Composable
fun TutorialScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SimpleTopAppBar(
                onBackButtonClick = { navController.popBackStack() }
            )
        },
        backgroundColor = getBackgroundColor()
    ) { paddingValues ->
        TutorialScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            onTutorialFinished = { navController.popBackStack() }
        )
    }
}

@Composable
fun TutorialScreenContent(
    modifier: Modifier,
    onTutorialFinished: () -> Unit
) {
    var textCounter by remember {
        mutableStateOf(0)
    }
    ClickableSurfaceWithColumn(
        onSurfaceClicked = {
            if (textCounter + 1 == headerTexts.size)
                onTutorialFinished() else textCounter++
        },
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SimpleTextDisplay(
            text = headerTexts.get(index = textCounter),
            fontSize = 40,
            fontFamily = headerFont
        )
        SimpleSpacer(size = 30)
        SimpleTextDisplay(
            text = tutorialTexts.get(index = textCounter),
            fontSize = 24,
            fontFamily = FontFamily.SansSerif
        )
    }
}

// Add the text for each tutorial page here
private val headerTexts = listOf(
    "Welcome to BoozeBlaster!",

    "There will be several different tasks that are randomly chosen and assigned to players.",

    "Before a task actually starts, a short description of it is being displayed.",

    "Every player should try to gather points!",

    "If you lose...",

    "In the Top App Bar, you can see several icons...",

    "Any Questions?"
)

private val tutorialTexts = listOf(
    "In this game it's all about mastering mini-games and gathering points.\n\n\n" +
            "Click through the next few pages to quickly learn how to play!",

    "Some tasks will be done by an individual, some by all players together!",

    "What you need to do and how it might affect your points is described there!",

    "In the end, the player(s) with the most points will give out sips to other players!",

    "You will have to complete a dare or drink a fair amount of sips!",

    "Click the judge hammer if someone has broken a rule.\n\nClick the score icon to see the " +
            "current score.",

    "Try reading the tutorial again!",
)