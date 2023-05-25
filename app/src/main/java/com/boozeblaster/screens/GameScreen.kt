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
import com.boozeblaster.models.Game
import com.boozeblaster.tasks.Task

@Composable
fun GameScreen(navController: NavController = rememberNavController()) {
    val game = Game.getInstance() // Singleton instance
    val tasks = game.getTasks()
    val scaffoldState = rememberScaffoldState()

    if (tasks.isEmpty()) {
        //TODO If the tasks are empty, something went wrong - we might want to alert the user here
        navController.popBackStack()
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            //TODO When the back button gets clicked in-game we ask for confirmation to leave
            SimpleTopAppBar(onBackButtonClick = {
                navController.popBackStack()
            })
        }
    ) { paddingValues ->
        GameScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            tasks = tasks,
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
    tasks: List<Task>,
    gameFinished: () -> Unit
) {
    var taskCounter by remember {
        mutableStateOf(value = 0)
    }
    val currentTask = tasks.get(index = taskCounter)

    Surface(
        modifier = modifier
            .fillMaxHeight(fraction = 1f)
            .fillMaxWidth(fraction = 1f)
    ) {
        currentTask.DisplayTask(callback = {
            if (taskCounter + 1 == tasks.size) {
                gameFinished()
            } else {
                taskCounter++
            }
        })
    }
}