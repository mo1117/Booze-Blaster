package com.boozeblaster.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
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
    val players = game.getPlayers()
    val scaffoldState = rememberScaffoldState()

    if (tasks.isEmpty()) {
        //TODO If the tasks are empty, something went wrong - we might want to alert the user here
        navController.popBackStack()
    }

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SimpleTopAppBar(onBackButtonClick = { navController.popBackStack() })
        }
    ) { paddingValues ->
        GameScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            tasks = tasks,
            gameFinished = { navController.navigate(route = Screen.GameOverScreen.route) }
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

    currentTask.DisplayTask(callback = {
        if (taskCounter + 1 == tasks.size) {
            gameFinished()
        } else {
            taskCounter++
        }
    })
}