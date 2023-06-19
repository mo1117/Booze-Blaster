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
import com.boozeblaster.models.Game
import com.boozeblaster.tasks.CommonTask
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.widgets.MyMediaPlayer

@Composable
fun GameScreen(navController: NavController = rememberNavController()) {
    var roundCounter by remember {
        mutableStateOf(value = 0)
    }

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            //TODO When the back button gets clicked in-game we ask for confirmation to leave
            GameScreenAppBar(
                onBackButtonClick = {
                    MyMediaPlayer.stop()
                    navController.navigate(route = Screen.HomeScreen.route) {
                        popUpTo(id = navController.graph.startDestinationId) {
                            inclusive = false
                        }
                    }
                },
                currentRound = roundCounter
            )
        },
        backgroundColor = getBackgroundColor()
    ) { paddingValues ->
        GameScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            game = Game.getInstance(),
            gameFinished = {
                navController.popBackStack() // Remove the current GameScreen
                navController.navigate(route = Screen.GameOverScreen.route)
            },
            incrementRoundCounter = { roundCounter++ }
        )
    }
}

@Composable
fun GameScreenContent(
    modifier: Modifier,
    game: Game,
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
    val currentTask = game.getTask(index = taskCounter)

    //Whether we have already added the dares, this should happen only in the very end
    var daresAdded by remember {
        mutableStateOf(value = false)
    }

    Surface(
        modifier = modifier
            .fillMaxHeight(fraction = 1f)
            .fillMaxWidth(fraction = 1f)
    ) {

        //TODO: maybe use a viewmodel instead
        if (currentTask is CommonTask && !roundCounterIncremented) {
            incrementRoundCounter()
            roundCounterIncremented = true
        }

        currentTask.DisplayTask(
            callback = {
                if (taskCounter + 1 == game.getTasks().size) {
                    if (!daresAdded) {
                        game.appendDareTasks()
                        daresAdded = true
                        taskCounter++
                    } else {
                        gameFinished()
                    }
                } else {
                    taskCounter++
                    roundCounterIncremented = false
                }
            }
        )
    }
}