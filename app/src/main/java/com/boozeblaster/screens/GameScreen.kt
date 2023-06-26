package com.boozeblaster.screens

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.boozeblaster.composables.GameScreenAppBar
import com.boozeblaster.composables.MyAlertDialog
import com.boozeblaster.models.Game
import com.boozeblaster.navigation.NavigationController
import com.boozeblaster.tasks.CommonTask
import com.boozeblaster.ui.theme.getBackgroundColor

@Composable
fun GameScreen(navController: NavController = rememberNavController()) {
    var roundCounter by remember {
        mutableStateOf(value = 0)
    }

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

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            GameScreenAppBar(
                onBackButtonClick = {
                    askForConfirmation = true
                },
                currentRound = roundCounter
            )
        },
        backgroundColor = getBackgroundColor()
    ) { paddingValues ->
        GameScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            gameFinished = {
                navController.popBackStack() // Remove the current GameScreen
                navController.navigate(route = Screen.FullfillDaresScreen.route)
            },
            incrementRoundCounter = { roundCounter++ }
        )
    }
}

@Composable
fun GameScreenContent(
    modifier: Modifier,
    gameFinished: () -> Unit,
    incrementRoundCounter: () -> Unit
) {

    //Whether we have already incremented the round counter
    var roundCounterIncremented by remember {
        mutableStateOf(value = false)
    }

    //The task counter is responsible for iterating through our list of tasks
    var taskCounter by remember {
        mutableStateOf(value = 0)
    }

    //The current task to be played
    val currentTask = Game.getTask(index = taskCounter)

    Surface(
        modifier = modifier
            .fillMaxHeight(fraction = 1f)
            .fillMaxWidth(fraction = 1f)
    ) {

        if (currentTask is CommonTask && !roundCounterIncremented) {
            incrementRoundCounter()
            roundCounterIncremented = true
        }

        currentTask.DisplayTask(
            callback = {
                if (taskCounter + 1 == Game.getTasks().size) {
                    gameFinished()
                } else {
                    taskCounter++
                    roundCounterIncremented = false
                }
            }
        )
    }
}

