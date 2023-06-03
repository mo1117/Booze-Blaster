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
import com.boozeblaster.composables.SimpleTopAppBar
import com.boozeblaster.controllers.DarkmodeController
import com.boozeblaster.models.Game
import com.boozeblaster.ui.theme.DarkBackGround
import com.boozeblaster.ui.theme.LightBackground

@Composable
fun GameScreen(navController: NavController = rememberNavController()) {
    val game = Game.getInstance()
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            //TODO When the back button gets clicked in-game we ask for confirmation to leave
            SimpleTopAppBar(onBackButtonClick = {
                navController.popBackStack()
                navController.popBackStack()
            })
        },
        backgroundColor = if (DarkmodeController.isDarkmode()) DarkBackGround else LightBackground
    ) { paddingValues ->
        GameScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            game = game,
            gameFinished = {
                navController.popBackStack()
                navController.navigate(route = Screen.GameOverScreen.route)
            }
        )
    }
}

@Composable
fun GameScreenContent(
    modifier: Modifier,
    game: Game,
    gameFinished: () -> Unit
) {

    var taskCounter by remember {
        mutableStateOf(value = 0)
    }
    val currentTask = game.getTask(index = taskCounter)

    var daresAdded by remember {
        mutableStateOf(value = false)
    }

    Surface(
        modifier = modifier
            .fillMaxHeight(fraction = 1f)
            .fillMaxWidth(fraction = 1f)
    ) {

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
                }
            }
        )
    }
}