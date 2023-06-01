package com.boozeblaster.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.boozeblaster.R
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleTopAppBar
import com.boozeblaster.controllers.DarkmodeController
import com.boozeblaster.models.Player
import com.boozeblaster.ui.theme.DarkBackGround
import com.boozeblaster.ui.theme.LightBackground
import com.boozeblaster.utils.InjectorUtils
import com.boozeblaster.viewmodels.PlayerViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

@Composable
fun StartGameScreen(navController: NavController) {
    val playerViewModel: PlayerViewModel =
        viewModel(factory = InjectorUtils.providePlayerViewModelFactory(context = LocalContext.current))
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SimpleTopAppBar(
                onBackButtonClick = { navController.popBackStack() }
            )
        }
    ) { paddingValues ->
        StartGameScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            getSavedPlayers = {
                coroutineScope.launch {
                    playerViewModel.getAllPlayers()
                }
            },
            onAddPlayerClicked = { navController.navigate(route = Screen.AddPlayerScreen.route) },
            onRemovePlayerClicked = playerViewModel::deletePlayer,
            onStartClicked = { navController.navigate(route = Screen.GameScreen.route) }
        )
    }
}

@Composable
fun StartGameScreenContent(
    modifier: Modifier,
    getSavedPlayers: () -> Job,
    onAddPlayerClicked: () -> Unit,
    onRemovePlayerClicked: (Player) -> Unit,
    onStartClicked: () -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth(fraction = 1f)
            .fillMaxHeight(fraction = 1f)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = modifier.background(
                color = if (DarkmodeController.isDarkmode()) DarkBackGround else LightBackground
            )
        ) {
            Button(
                onClick = { onAddPlayerClicked() }, colors = ButtonDefaults.buttonColors(
                    contentColor = LightBackground, backgroundColor = LightBackground
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.add_player),
                    contentDescription = "Add Player",
                    modifier = modifier.background(
                        color = if (DarkmodeController.isDarkmode())
                            DarkBackGround else LightBackground
                    )
                )
            }

            //TODO Here we need to instantiate our singleton Game object
            //TODO Create a list of tasks and use the generators to generate the subtasks
            //TODO To create our list of tasks just call TaskGenerator.generateTasks(players, rounds)
            //TODO players = List<Player> and rounds = Int can be chosen before starting the game
            //TODO Call Game.init with a list of players, tasks, and whether or not adult mode is enabled

            SimpleButton(
                modifier = Modifier,
                onClick = { onStartClicked() },
                text = "Start",
                fontSize = 20,
                fontFamily = FontFamily.SansSerif,
                color = Color.Magenta
            )
        }
    }
}