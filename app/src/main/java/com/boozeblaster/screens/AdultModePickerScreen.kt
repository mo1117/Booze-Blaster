package com.boozeblaster.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavController
import com.boozeblaster.R
import com.boozeblaster.composables.*
import com.boozeblaster.generators.DareTaskGenerator
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
            onContinueClicked = { navController.navigate(route = Screen.DifficultyPickerScreen.route) },
            getAdultMode = gameSettingsViewModel::getAdultMode,
            setAdultMode = gameSettingsViewModel::setAdultMode
        )
    }
}

@Composable
fun AdultModePickerScreenContent(
    modifier: Modifier,
    onContinueClicked: () -> Unit,
    getAdultMode: () -> Boolean?,
    setAdultMode: (Boolean) -> Unit
) {

    var adultModeEnabled = getAdultMode()

    val buttonFontSize = 20
    val textFontSize = 26
    val fontFamily = FontFamily.SansSerif

    SurfaceWithColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SimpleTextDisplay(
            text = "Choose Mode",
            fontSize = textFontSize,
            fontFamily = fontFamily
        )

        SimpleSpacer(size = 50)

        //PG mode button
        SimpleImageButton(
            onClick = {
                if (getAdultMode() == true) {
                    Game.resetAllDares()
                }
                setAdultMode(false)
            },
            imageId = if (adultModeEnabled != null && !adultModeEnabled)
                R.drawable.angel_selected else R.drawable.angel_unselected
        )

        SimpleSpacer(size = 50)

        //Adult mode button
        SimpleImageButton(
            onClick = {
                if (getAdultMode() == false) {
                    Game.resetAllDares()
                }
                setAdultMode(true)
            },
            imageId = if (adultModeEnabled != null && adultModeEnabled)
                R.drawable.adult_mode_selected else R.drawable.adult_mode_unselected,
        )

        SimpleSpacer(size = 50)

        //Continue Button
        SimpleButton(
            onClick = {
                Game.setAdultMode(adultMode = adultModeEnabled!!)
                DareTaskGenerator.assignDares(players = Game.getPlayers())
                onContinueClicked()
            },
            text = "Continue",
            fontSize = buttonFontSize,
            fontFamily = fontFamily,
            enabled = adultModeEnabled != null
        )
    }
}