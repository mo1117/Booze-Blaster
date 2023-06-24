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
                        setDifficulty = gameSettingsViewModel::setDifficulty,
                        setDaresAssigned = gameSettingsViewModel::setDaresAssigned
                    )
                }
            )
        },
        backgroundColor = getBackgroundColor()
    ) { paddingValues ->
        StartGameScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            playerViewModel = playerViewModel,
            onAddPlayerClicked = { navController.navigate(route = Screen.AddPlayerScreen.route) },
            onContinueClicked = {
                navController.navigate(route = Screen.AdultModePickerScreen.route)
            }
        )
    }
}

@Composable
fun StartGameScreenContent(
    modifier: Modifier,
    playerViewModel: PlayerViewModel,
    onAddPlayerClicked: () -> Unit,
    onContinueClicked: () -> Unit
) {

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
                    onClick = { addExistingPlayers = true },
                    imageId = R.drawable.add_player,
                    contentDescription = "Add existing Player",
                    text = "Add already existing player",
                    fontSize = 20,
                    fontFamily = FontFamily.SansSerif
                )

                //TODO Here we need to instantiate our singleton Game object
                //TODO The adult / pg mode is set in the next screen
                //TODO The difficulty is picked in the 2nd next screen
                //TODO Init the

                SimpleButton(
                    modifier = Modifier,
                    onClick = {
                        Game.addPlayer(Player(name = "Mo"))
                        Game.addPlayer(Player(name = "Mo1337"))
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

            //The actual list, not used now since we might change UI before
            var savedPlayers = mutableListOf<Player>()
            LaunchedEffect(Unit) {
                playerViewModel.getAllPlayers().collect() {
                    savedPlayers.addAll(it)
                }
            }

            val test: List<String> = listOf(
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
                "hi",
            )
            LazyColumn(
                modifier = Modifier.size(height = 200.dp, width = 100.dp),
                content = {
                    items(items = test) {
                        SimpleTextDisplay(
                            text = it,
                            fontSize = 16,
                            fontFamily = FontFamily.SansSerif
                        )
                    }
                }
            )

            SimpleSpacer(size = 50)

            SimpleButton(
                onClick = { addExistingPlayers = false },
                text = "Done",
                fontSize = 20,
                fontFamily = FontFamily.SansSerif
            )
        }
    )

}