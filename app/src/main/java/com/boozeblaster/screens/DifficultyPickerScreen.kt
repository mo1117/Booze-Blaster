package com.boozeblaster.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.composables.SimpleTopAppBar
import com.boozeblaster.controllers.DarkmodeController
import com.boozeblaster.enums.Difficulty
import com.boozeblaster.models.Game
import com.boozeblaster.ui.theme.DarkBackGround
import com.boozeblaster.ui.theme.LightBackground

@Composable
fun DifficultyPickerScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SimpleTopAppBar(onBackButtonClick = { navController.popBackStack() })
        },
        backgroundColor = if (DarkmodeController.isDarkmode()) DarkBackGround else LightBackground
    ) { paddingValues ->
        DifficultyPickerScreenContent(modifier = Modifier.padding(paddingValues = paddingValues),
            onStartClicked = { navController.navigate(route = Screen.GameScreen.route) })
    }
}

@Preview
@Composable
fun DifficultyPickerScreenContent(
    modifier: Modifier = Modifier,
    onStartClicked: () -> Unit = {}
) {
    var difficulty: Difficulty? by remember {
        mutableStateOf(value = null)
    }

    val buttonFontSize = 20
    val textFontSize = 26
    val fontFamily = FontFamily.SansSerif
    val minWidth = 150.dp
    val minHeight = 50.dp

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
            SimpleTextDisplay(
                text = "Pick a Difficulty!",
                fontSize = 30,
                fontFamily = fontFamily
            )
            SimpleSpacer(size = 30)

            SimpleButton(
                modifier = Modifier.sizeIn(minWidth = minWidth, minHeight = minHeight),
                onClick = { difficulty = Difficulty.EASY },
                text = "Easy",
                fontSize = buttonFontSize,
                fontFamily = fontFamily,
                color = if (difficulty == Difficulty.EASY) Color.Blue else Color.Gray
            )
            SimpleTextDisplay(
                text = "Drinking for the first time?",
                fontSize = textFontSize,
                fontFamily = fontFamily
            )
            SimpleSpacer(size = 40)

            SimpleButton(
                modifier = Modifier.sizeIn(minWidth = minWidth, minHeight = minHeight),
                onClick = { difficulty = Difficulty.MEDIUM },
                text = "Medium",
                fontSize = buttonFontSize,
                fontFamily = fontFamily,
                color = if (difficulty == Difficulty.MEDIUM) Color.Blue else Color.Gray
            )
            SimpleTextDisplay(
                text = "Way to go!",
                fontSize = textFontSize,
                fontFamily = fontFamily
            )
            SimpleSpacer(size = 40)

            SimpleButton(
                modifier = Modifier.sizeIn(minWidth = minWidth, minHeight = minHeight),
                onClick = { difficulty = Difficulty.HARD },
                text = "Hard",
                fontSize = buttonFontSize,
                fontFamily = fontFamily,
                color = if (difficulty == Difficulty.HARD) Color.Blue else Color.Gray
            )
            SimpleTextDisplay(
                text = "Daring today, aren't we?",
                fontSize = textFontSize,
                fontFamily = fontFamily
            )
            SimpleSpacer(size = 40)

            SimpleButton(
                modifier = Modifier.sizeIn(minWidth = minWidth, minHeight = minHeight),
                onClick = { difficulty = Difficulty.ALCOHOLIC },
                text = "Alcoholic",
                fontSize = buttonFontSize,
                fontFamily = fontFamily,
                color = if (difficulty == Difficulty.ALCOHOLIC) Color.Blue else Color.Gray
            )
            SimpleTextDisplay(
                text = "Better call an ambulance!",
                fontSize = textFontSize,
                fontFamily = fontFamily
            )
            SimpleSpacer(size = 100)

            SimpleButton(
                modifier = Modifier.sizeIn(minWidth = minWidth, minHeight = minHeight),
                onClick = {
                    Game.getInstance().setDifficulty(difficulty = difficulty!!)
                    onStartClicked()
                },
                text = "Start",
                fontSize = buttonFontSize,
                fontFamily = fontFamily,
                color = Color.Magenta,
                enabled = difficulty != null
            )
        }
    }
}