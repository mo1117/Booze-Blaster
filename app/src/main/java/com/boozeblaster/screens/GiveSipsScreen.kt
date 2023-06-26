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
import com.boozeblaster.composables.*
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.models.Game
import com.boozeblaster.navigation.NavigationController
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.ui.theme.headerFont

@Composable
fun GiveSipsScreen(navController: NavController) {
    val scaffoldState = rememberScaffoldState()

    var askForConfirmation by remember {
        mutableStateOf(value = false)
    }

    if (askForConfirmation) {
        MyAlertDialog(
            title = "Confirm Leave",
            message = "Do you really wish to leave?",
            onConfirm = { NavigationController.navigateToHomeScreen(navController = navController) },
            onDismiss = { askForConfirmation = false })
    }

    Scaffold(scaffoldState = scaffoldState,
        backgroundColor = getBackgroundColor(),
        topBar = {
            SimpleTopAppBar(onBackButtonClick = { askForConfirmation = true })
        }) { paddingValues ->
        GiveSipsScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            onContinueClicked = { navController.navigate(route = Screen.GameOverScreen.route) }
        )
    }

}

@Composable
fun GiveSipsScreenContent(
    modifier: Modifier,
    onContinueClicked: () -> Unit
) {
    var winnerIndex by remember {
        mutableStateOf(value = 0)
    }

    SurfaceWithColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SimpleTextDisplay(
            text = "${
                Game.getWinners().get(index = winnerIndex).getName()
            }\n\nCongratulations - you are a winner!",
            fontSize = 30,
            fontFamily = headerFont
        )
        SimpleSpacer(size = 30)
        SimpleTextDisplay(
            text = "Give ${Game.getSipMultiplier() * 3} sips to any players during the next 5 minutes!",
            fontSize = 26,
            fontFamily = FontFamily.SansSerif
        )
        SimpleSpacer(size = 30)
        SimpleButton(
            onClick = {
                if (winnerIndex == Game.getWinners().size - 1) {
                    onContinueClicked()
                } else {
                    winnerIndex++
                }
            },
            text = "Continue",
            fontSize = 20,
            fontFamily = FontFamily.SansSerif,
            buttonType = ButtonType.CORRECT
        )
    }
}