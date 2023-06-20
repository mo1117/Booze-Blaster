package com.boozeblaster.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.composables.SimpleTopAppBar
import com.boozeblaster.enums.Difficulty
import com.boozeblaster.models.Game
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.viewmodels.GameSettingsViewModel

@Composable
fun DifficultyPickerScreen(
    navController: NavController,
    gameSettingsViewModel: GameSettingsViewModel
) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SimpleTopAppBar(onBackButtonClick = { navController.popBackStack() })
        },
        backgroundColor = getBackgroundColor()
    ) { paddingValues ->
        DifficultyPickerScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            gameSettingsViewModel = gameSettingsViewModel,
            onStartClicked = {
                //Make sure to clear the values of the game settings view model
                gameSettingsViewModel.setDifficulty(difficulty = null)
                gameSettingsViewModel.setAdultMode(adultMode = null)
                navController.navigate(route = Screen.GameScreen.route)
            })
    }
}

@Composable
fun DifficultyPickerScreenContent(
    modifier: Modifier = Modifier,
    gameSettingsViewModel: GameSettingsViewModel,
    onStartClicked: () -> Unit = {}
) {

    var difficulty = gameSettingsViewModel.getDifficulty()

    val buttonFontSize = 20
    val textFontSize = 26
    val fontFamily = FontFamily.SansSerif
    val buttonModifier = Modifier.sizeIn(minWidth = 150.dp, minHeight = 50.dp)

    Surface(
        modifier = modifier
            .fillMaxWidth(fraction = 1f)
            .fillMaxHeight(fraction = 1f)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier.background(color = getBackgroundColor())
        ) {
            SimpleTextDisplay(
                text = "Pick a Difficulty!",
                fontSize = 30,
                fontFamily = fontFamily
            )
            SimpleSpacer(size = 30)

            //Easy Button
            SimpleButton(
                modifier = buttonModifier,
                onClick = { gameSettingsViewModel.setDifficulty(difficulty = Difficulty.EASY) },
                text = "Easy",
                fontSize = buttonFontSize,
                fontFamily = fontFamily,
                color = if (difficulty == Difficulty.EASY) null else Color.Gray
            )
            SimpleTextDisplay(
                text = "Drinking for the first time?",
                fontSize = textFontSize,
                fontFamily = fontFamily
            )
            SimpleSpacer(size = 40)

            //Medium Button
            SimpleButton(
                modifier = buttonModifier,
                onClick = { gameSettingsViewModel.setDifficulty(difficulty = Difficulty.MEDIUM) },
                text = "Medium",
                fontSize = buttonFontSize,
                fontFamily = fontFamily,
                color = if (difficulty == Difficulty.MEDIUM) null else Color.Gray
            )
            SimpleTextDisplay(
                text = "Way to go!",
                fontSize = textFontSize,
                fontFamily = fontFamily
            )
            SimpleSpacer(size = 40)

            //Hard Button
            SimpleButton(
                modifier = buttonModifier,
                onClick = { gameSettingsViewModel.setDifficulty(difficulty = Difficulty.HARD) },
                text = "Hard",
                fontSize = buttonFontSize,
                fontFamily = fontFamily,
                color = if (difficulty == Difficulty.HARD) null else Color.Gray
            )
            SimpleTextDisplay(
                text = "Daring today, aren't we?",
                fontSize = textFontSize,
                fontFamily = fontFamily
            )
            SimpleSpacer(size = 40)

            //Alcoholic Button
            SimpleButton(
                modifier = buttonModifier,
                onClick = { gameSettingsViewModel.setDifficulty(difficulty = Difficulty.ALCOHOLIC) },
                text = "Alcoholic",
                fontSize = buttonFontSize,
                fontFamily = fontFamily,
                color = if (difficulty == Difficulty.ALCOHOLIC) null else Color.Gray
            )
            SimpleTextDisplay(
                text = "Better call an ambulance!",
                fontSize = textFontSize,
                fontFamily = fontFamily
            )
            SimpleSpacer(size = 100)

            SimpleButton(
                modifier = buttonModifier,
                onClick = {
                    Game.getInstance().setDifficulty(difficulty = difficulty!!)
                    onStartClicked()
                },
                text = "Start",
                fontSize = buttonFontSize,
                fontFamily = fontFamily,
                enabled = difficulty != null
            )
        }
    }
}