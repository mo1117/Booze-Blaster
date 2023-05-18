package com.boozeblaster.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.boozeblaster.R
import com.boozeblaster.composables.SimpleTopAppBar
import com.boozeblaster.models.Player
import com.boozeblaster.ui.theme.LightBackground
import com.boozeblaster.utils.InjectorUtils
import com.boozeblaster.viewmodels.PlayerViewModel

@Composable
fun StartGameScreen(navController: NavController) {
    val playerViewModel: PlayerViewModel =
        viewModel(factory = InjectorUtils.providePlayerViewModelFactory(context = LocalContext.current))
    val scaffoldState = rememberScaffoldState()


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SimpleTopAppBar(
                onBackButtonClick = { navController.popBackStack() })
        }
    ) { paddingValues ->
        StartGameScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            onAddClicked = { navController.navigate(route = Screen.AddPlayerScreen.route) },
            onRemovePlayerClicked = playerViewModel::deletePlayer
        )
    }
}

@Composable
fun StartGameScreenContent(
    modifier: Modifier,
    onAddClicked: () -> Unit,
    onRemovePlayerClicked: (Player) -> Unit
    //TODO Add function that actually STARTS the game
) {
    Surface(
        modifier = modifier
            .fillMaxWidth(fraction = 1f)
            .fillMaxHeight(fraction = 1f)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = modifier.background(color = LightBackground) // TODO darkmode
        ) {
            Button(
                onClick = { onAddClicked() }, colors = ButtonDefaults.buttonColors(
                    contentColor = LightBackground, backgroundColor = LightBackground
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.add_player),
                    contentDescription = "Add Player",
                    modifier = modifier.background(color = LightBackground)
                )
            }
        }
    }
}