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
fun FulfillDaresScreen(navController: NavController) {
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
        FulfillDaresScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            onContinueClicked = { navController.navigate(route = Screen.GameOverScreen.route) }
        )
    }
}

@Composable
fun FulfillDaresScreenContent(
    modifier: Modifier,
    onContinueClicked: () -> Unit
) {

    var loserIndex by remember {
        mutableStateOf(value = 0)
    }

    var showDialog by remember {
        mutableStateOf(value = false)
    }

    var buttonClicked by remember {
        mutableStateOf(value = false)
    }

    SurfaceWithColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        SimpleTextDisplay(text = "Complete the Dare!", fontSize = 30, fontFamily = headerFont)
        SimpleSpacer(size = 30)
        SimpleTextDisplay(
            text = Game.getLosers().get(index = loserIndex).getDare().toString(),
            fontSize = 24,
            fontFamily = FontFamily.SansSerif
        )
        SimpleSpacer(size = 30)
        SimpleButton(
            onClick = {
                if (loserIndex == Game.getLosers().size - 1) {
                    onContinueClicked()
                } else {
                    loserIndex++
                }
            },
            text = "Completed",
            fontSize = 20,
            fontFamily = FontFamily.SansSerif,
            buttonType = ButtonType.CORRECT,
            enabled = !buttonClicked
        )
        SimpleSpacer(size = 30)
        SimpleButton(
            onClick = {
                showDialog = true
                buttonClicked = true
            },
            text = "Not Completed",
            fontSize = 20,
            fontFamily = FontFamily.SansSerif,
            buttonType = ButtonType.INCORRECT,
            enabled = !buttonClicked
        )

        if (showDialog) {
            SimpleSpacer(size = 20)
            AskPlayersToDrinkDialog(
                players = listOf(Game.getLosers().get(index = loserIndex)),
                sips = Game.getSipMultiplier() * 2,
                callback = {
                    if (loserIndex == Game.getLosers().size - 1) {
                        Game.getLosers().get(index = loserIndex)
                            .addSips(sips = Game.getSipMultiplier() * 2)
                        onContinueClicked()
                    } else {
                        loserIndex++
                    }
                    buttonClicked = false
                    showDialog = false
                }
            )
        }
    }
}