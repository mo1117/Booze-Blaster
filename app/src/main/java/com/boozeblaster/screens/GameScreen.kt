package com.boozeblaster.screens

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.boozeblaster.composables.GameScreenAppBar
import com.boozeblaster.composables.MyAlertDialog
import com.boozeblaster.models.Game
import com.boozeblaster.navigation.NavigationController
import com.boozeblaster.tasks.CommonTask
import com.boozeblaster.tasks.IndividualTask
import com.boozeblaster.tasks.Task
import com.boozeblaster.tasks.VersusTask
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.utils.GameSettings

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
                currentRound = roundCounter,
                onRestartClicked = {
                    navController.popBackStack()
                    Game.reset()
                    navController.navigate(route = Screen.StartGameScreen.route)
                }
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

    var roundCounterIncremented by remember {
        mutableStateOf(value = false)
    }

    var taskCounter by remember {
        mutableStateOf(value = 0)
    }

    val currentTask = Game.getTask(index = taskCounter)

    Surface(
        modifier = modifier
            .fillMaxHeight(fraction = 1f)
            .fillMaxWidth(fraction = 1f)
    ) {

        if (shouldIncrementRoundCounter(currentTask = currentTask) && !roundCounterIncremented) {
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

private fun shouldIncrementRoundCounter(currentTask: Task): Boolean {
    if (currentTask is CommonTask) {
        return true
    } else if (currentTask is VersusTask && !GameSettings.playCommonTasks()) {
        return true
    } else if (currentTask is IndividualTask && !GameSettings.playCommonTasks() && !GameSettings.playVersusTasks()) {
        return Game.getTasks().indexOf(element = currentTask) % Game.getPlayers().size == 0
    }
    return false
}