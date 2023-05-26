package com.boozeblaster.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavController
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.composables.SimpleTopAppBar

private var screens = listOf<Composable>()

@Composable
fun TutorialScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SimpleTopAppBar(
                onBackButtonClick = { navController.popBackStack() }
            )
        }
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
    Surface(
        modifier = modifier
            .fillMaxWidth(fraction = 1f)
            .fillMaxHeight(fraction = 1f)
            .clickable(onClick = {
                if (textCounter + 1 == tutorialTexts.size) {
                    onTutorialFinished()
                } else {
                    textCounter++
                }
            })
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            SimpleTextDisplay(
                text = tutorialTexts.get(index = textCounter),
                fontSize = 20,
                fontFamily = FontFamily.SansSerif
            )
        }
    }
}

// Add the text for each tutorial page here
// Maybe we want to display some kind of icon on each page and can just create a list of icons as well
private val tutorialTexts = listOf(
    "Welcome to BoozeBlaster!\n\n\nIn this game it's all about mastering mini-games and gathering points.\n" +
            "Click through the next few pages to discover how to play!",
    "Test page 2",
    "Test page 3"
)