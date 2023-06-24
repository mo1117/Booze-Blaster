package com.boozeblaster.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavController
import com.boozeblaster.composables.*
import com.boozeblaster.enums.Difficulty
import com.boozeblaster.generators.DareTaskGenerator
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player
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
            onContinueClicked = {
                navController.navigate(route = Screen.DisplayDaresScreen.route)
            },
            getDifficulty = gameSettingsViewModel::getDifficulty,
            setDifficulty = gameSettingsViewModel::setDifficulty,
            setDaresAssigned = gameSettingsViewModel::setDaresAssigned,
            areDaresAssigned = gameSettingsViewModel::areDaresAssigned
        )
    }
}

@Composable
fun DifficultyPickerScreenContent(
    modifier: Modifier = Modifier,
    onContinueClicked: () -> Unit = {},
    getDifficulty: () -> Difficulty?,
    setDifficulty: (Difficulty) -> Unit,
    setDaresAssigned: (Boolean) -> Unit,
    areDaresAssigned: () -> Boolean
) {

    val buttonFontSize = 20
    val textFontSize = 26
    val fontFamily = FontFamily.SansSerif

    SurfaceWithColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SimpleTextDisplay(
            text = "Pick a Difficulty!",
            fontSize = 30,
            fontFamily = fontFamily
        )
        SimpleSpacer(size = 30)

        //Easy Button
        SimpleButton(
            onClick = { setDifficulty(Difficulty.EASY) },
            text = "Easy",
            fontSize = buttonFontSize,
            fontFamily = fontFamily,
            color = if (getDifficulty() == Difficulty.EASY) null else Color.Gray
        )
        SimpleTextDisplay(
            text = "Drinking for the first time?",
            fontSize = textFontSize,
            fontFamily = fontFamily
        )
        SimpleSpacer(size = 40)

        //Medium Button
        SimpleButton(
            onClick = { setDifficulty(Difficulty.MEDIUM) },
            text = "Medium",
            fontSize = buttonFontSize,
            fontFamily = fontFamily,
            color = if (getDifficulty() == Difficulty.MEDIUM) null else Color.Gray
        )
        SimpleTextDisplay(
            text = "Way to go!",
            fontSize = textFontSize,
            fontFamily = fontFamily
        )
        SimpleSpacer(size = 40)

        //Hard Button
        SimpleButton(
            onClick = { setDifficulty(Difficulty.HARD) },
            text = "Hard",
            fontSize = buttonFontSize,
            fontFamily = fontFamily,
            color = if (getDifficulty() == Difficulty.HARD) null else Color.Gray
        )
        SimpleTextDisplay(
            text = "Daring today, aren't we?",
            fontSize = textFontSize,
            fontFamily = fontFamily
        )
        SimpleSpacer(size = 40)

        //Alcoholic Button
        SimpleButton(
            onClick = { setDifficulty(Difficulty.ALCOHOLIC) },
            text = "Alcoholic",
            fontSize = buttonFontSize,
            fontFamily = fontFamily,
            color = if (getDifficulty() == Difficulty.ALCOHOLIC) null else Color.Gray
        )
        SimpleTextDisplay(
            text = "Better call an ambulance!",
            fontSize = textFontSize,
            fontFamily = fontFamily
        )
        SimpleSpacer(size = 100)

        SimpleButton(
            onClick = {
                Game.setDifficulty(difficulty = getDifficulty()!!)
                if (!areDaresAssigned()) {
                    DareTaskGenerator.assignDares(players = Game.getPlayers())
                    setDaresAssigned(true)
                }
                onContinueClicked()
            },
            text = "Continue",
            fontSize = buttonFontSize,
            fontFamily = fontFamily,
            enabled = getDifficulty() != null
        )
    }
}