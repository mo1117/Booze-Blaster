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
import com.boozeblaster.ui.theme.headerFont
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

    val buttonFontSize = 20
    val fontFamily = FontFamily.SansSerif

    SurfaceWithColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SimpleTextDisplay(
            text = "Choose Mode",
            fontSize = 30,
            fontFamily = headerFont
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
            imageId = if (getAdultMode() != null && !getAdultMode()!!)
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
            imageId = if (getAdultMode() != null && getAdultMode()!!)
                R.drawable.adult_mode_selected else R.drawable.adult_mode_unselected,
        )

        SimpleSpacer(size = 50)

        //Continue Button
        SimpleButton(
            onClick = {
                Game.setAdultMode(adultMode = getAdultMode()!!)
                DareTaskGenerator.assignDares(players = Game.getPlayers())
                onContinueClicked()
            },
            text = "Continue",
            fontSize = buttonFontSize,
            fontFamily = fontFamily,
            enabled = getAdultMode() != null
        )
    }
}