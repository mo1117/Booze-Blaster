package com.boozeblaster.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.boozeblaster.R
import com.boozeblaster.composables.*
import com.boozeblaster.enums.AnimationConstants
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player
import com.boozeblaster.navigation.NavigationController
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.utils.InjectorUtils
import com.boozeblaster.viewmodels.GameSettingsViewModel
import com.boozeblaster.viewmodels.PlayerViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import java.util.*

@Composable
fun StartGameScreen(navController: NavController, gameSettingsViewModel: GameSettingsViewModel) {
    val playerViewModel: PlayerViewModel =
        viewModel(factory = InjectorUtils.providePlayerViewModelFactory(context = LocalContext.current))
    val scaffoldState = rememberScaffoldState()


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SimpleTopAppBar(
                onBackButtonClick = {
                    NavigationController.popBackStackIntoHomeScreen(
                        navController = navController,
                        setAdultMode = gameSettingsViewModel::setAdultMode,
                        setDifficulty = gameSettingsViewModel::setDifficulty
                    )
                }
            )
        },
        backgroundColor = getBackgroundColor()
    ) { paddingValues ->
        StartGameScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            onAddPlayerClicked = { navController.navigate(route = Screen.AddPlayerScreen.route) },
            onContinueClicked = {
                navController.navigate(route = Screen.AdultModePickerScreen.route)
            },
            getAllPlayers = playerViewModel::getAllPlayers
        )
    }
}

@Composable
fun StartGameScreenContent(
    modifier: Modifier,
    onAddPlayerClicked: () -> Unit,
    onContinueClicked: () -> Unit,
    getAllPlayers: () -> Flow<List<Player>>
) {

    val savedPlayersValues by getAllPlayers().collectAsState(initial = emptyList())

    var addExistingPlayers by remember {
        mutableStateOf(value = false)
    }

    if (!addExistingPlayers) {
        Surface(
            modifier = modifier
                .fillMaxWidth(fraction = 1f)
                .fillMaxHeight(fraction = 1f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = modifier.background(
                    color = getBackgroundColor()
                )
            ) {
                SimpleImageButton(
                    modifier = Modifier.size(width = 100.dp, height = 100.dp),
                    onClick = {

                        addExistingPlayers = true
                    },
                    imageId = R.drawable.add_player,
                    contentDescription = "Add existing Player",
                    text = "Add players to the Game ",
                    fontSize = 20,
                    fontFamily = FontFamily.SansSerif
                )

                //TODO Here we need to instantiate our singleton Game object
                //TODO The adult / pg mode is set in the next screen
                //TODO The difficulty is picked in the 2nd next screen
                //TODO Init the

                SimpleSpacer(size = 20)

                SimpleButton(
                    modifier = Modifier,
                    onClick = {
                        onContinueClicked()
                    },
                    text = "Continue",
                    fontSize = 20,
                    fontFamily = FontFamily.SansSerif
                )
            }
        }
    }

    MyAnimatedVisibility(
        visible = addExistingPlayers,
        animationDuration = AnimationConstants.ADD_EXISTING_PLAYERS_FADE_IN_OUT.durationMillis,
        content = {
            Box{
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    SimpleSpacer(size = 20)

                    LazyColumn {
                            items(items = savedPlayersValues) { player ->
                                SimpleButtonAdd(
                                    onClick = {
                                        Game.addPlayer(player)
                                    },
                                    text = player.getName(),
                                    fontSize = 20,
                                    fontFamily = FontFamily.SansSerif
                                )
                                SimpleSpacer(size = 10)
                            }

                        }

                    SimpleSpacer(size = 50)

                        SimpleButton(
                            onClick = { addExistingPlayers = false },
                            text = "Done",
                            fontSize = 20,
                            fontFamily = FontFamily.SansSerif
                        )
                    }
            }
        }
    )

}