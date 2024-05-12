package com.boozeblaster.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.boozeblaster.R
import com.boozeblaster.composables.AskPlayersToDrinkDialog
import com.boozeblaster.composables.MyAlertDialog
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.composables.topAppBars.SimpleTopAppBarCreator
import com.boozeblaster.composables.SurfaceWithColumn
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
            SimpleTopAppBarCreator().CreateAppBar(onBackButtonClick = {
                askForConfirmation = true
            })
        }) { paddingValues ->
        FulfillDaresScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            onContinueClicked = { navController.navigate(route = Screen.GiveSipsScreen.route) }
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
        SimpleTextDisplay(
            text = "${
                Game.getLosers().get(index = loserIndex).getName()
            }\n\nYou are a loser - complete the Dare!", fontSize = 30, fontFamily = headerFont
        )
        SimpleSpacer(size = 30)

        Image(
            modifier = Modifier.size(size = 100.dp),
            painter = painterResource(id = R.drawable.judge_hammer_black),
            contentDescription = "Judge Hammer Icon"
        )

        SimpleSpacer(size = 30)

        SimpleTextDisplay(
            text = Game.getLosers().get(index = loserIndex).getDare().toString(),
            fontSize = 20,
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
                sips = Game.getSipMultiplier() * 4,
                callback = {
                    if (loserIndex == Game.getLosers().size - 1) {
                        Game.getLosers().get(index = loserIndex)
                            .addSips(sips = Game.getSipMultiplier() * 4)
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