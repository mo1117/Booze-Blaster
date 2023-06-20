package com.boozeblaster.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.boozeblaster.R
import com.boozeblaster.composables.*
import com.boozeblaster.models.Game
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.viewmodels.GameSettingsViewModel

@Composable
fun AdultModePickerScreen(
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
        AdultModePickerScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            gameSettingsViewModel = gameSettingsViewModel,
            onContinueClicked = { navController.navigate(route = Screen.DifficultyPickerScreen.route) }
        )
    }
}

@Composable
fun AdultModePickerScreenContent(
    modifier: Modifier,
    gameSettingsViewModel: GameSettingsViewModel,
    onContinueClicked: () -> Unit
) {

    var adultModeEnabled = gameSettingsViewModel.getAdultMode()

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
            modifier = modifier.background(getBackgroundColor())
        ) {
            SimpleTextDisplay(
                text = "Choose Mode",
                fontSize = textFontSize,
                fontFamily = fontFamily
            )

            SimpleSpacer(size = 50)

            //PG mode button
            SimpleImageButton(
                onClick = { gameSettingsViewModel.setAdultMode(adultMode = false) },
                modifier = buttonModifier,
                imageId = if (adultModeEnabled != null && !adultModeEnabled)
                    R.drawable.angel_selected else R.drawable.angel_unselected
            )

            SimpleSpacer(size = 50)

            //Adult mode button
            SimpleImageButton(
                onClick = { gameSettingsViewModel.setAdultMode(adultMode = true) },
                imageId = if (adultModeEnabled != null && adultModeEnabled)
                    R.drawable.adult_mode_selected else R.drawable.adult_mode_unselected,
                modifier = buttonModifier,
            )

            SimpleSpacer(size = 50)

            //Continue Button
            SimpleButton(
                onClick = {
                    Game.getInstance().setAdultMode(adultMode = adultModeEnabled!!)
                    onContinueClicked()
                },
                modifier = buttonModifier,
                text = "Continue",
                fontSize = buttonFontSize,
                fontFamily = fontFamily,
                enabled = adultModeEnabled != null
            )
        }
    }
}