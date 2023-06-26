package com.boozeblaster.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.boozeblaster.composables.*
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.models.Game
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.ui.theme.headerFont
import com.boozeblaster.viewmodels.GameSettingsViewModel

@Composable
fun RoundPickerScreen(navController: NavController, gameSettingsViewModel: GameSettingsViewModel) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        backgroundColor = getBackgroundColor(),
        topBar = {
            SimpleTopAppBar(onBackButtonClick = { navController.popBackStack() })
        }
    ) { paddingValues ->
        RoundPickerScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            onContinueClicked = { navController.navigate(route = Screen.AdultModePickerScreen.route) },
            getSelectedRounds = gameSettingsViewModel::getSelectedRounds,
            setSelectedRounds = gameSettingsViewModel::setSelectedRounds
        )
    }
}

@Composable
fun RoundPickerScreenContent(
    modifier: Modifier,
    onContinueClicked: () -> Unit,
    getSelectedRounds: () -> Int,
    setSelectedRounds: (Int) -> Unit
) {
    SurfaceWithColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        SimpleTextDisplay(text = "Select number of Rounds", fontSize = 30, fontFamily = headerFont)
        SimpleSpacer(size = 30)

        LazyColumn(
            modifier = Modifier
                .height(height = 400.dp)
                .fillMaxWidth(0.9f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            content = {
                items(count = 11) { rounds ->
                    if (rounds != 0) {
                        SimpleButton(
                            onClick = { setSelectedRounds(rounds) },
                            text = "$rounds",
                            fontSize = 20,
                            fontFamily = FontFamily.SansSerif,
                            buttonType = if (getSelectedRounds() == rounds) ButtonType.CORRECT
                            else ButtonType.INCORRECT
                        )
                        SimpleSpacer(size = 10)
                    }
                }
            })
        SimpleSpacer(size = 20)

        SimpleButton(
            onClick = {
                Game.setRounds(rounds = getSelectedRounds())
                onContinueClicked()

            },
            text = "Continue",
            fontSize = 20,
            fontFamily = FontFamily.SansSerif,
            enabled = getSelectedRounds() != 0
        )
    }
}