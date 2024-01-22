package com.boozeblaster.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.boozeblaster.R
import com.boozeblaster.composables.MyAnimatedVisibilityTopToTop
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleCard
import com.boozeblaster.composables.SimpleChangeableButton
import com.boozeblaster.composables.SimpleImageButton
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.composables.SimpleTopAppBar
import com.boozeblaster.composables.SurfaceWithColumn
import com.boozeblaster.composables.SurfaceWithScrollableColumn
import com.boozeblaster.enums.AnimationConstants
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player
import com.boozeblaster.navigation.NavigationController
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.ui.theme.getButtonColor
import com.boozeblaster.ui.theme.headerFont
import com.boozeblaster.utils.InjectorUtils
import com.boozeblaster.viewmodels.GameSettingsViewModel
import com.boozeblaster.viewmodels.PlayerViewModel
import kotlinx.coroutines.flow.Flow

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
                        resetAddedPlayers = gameSettingsViewModel::resetAddedPlayers,
                        setSelectedRounds = gameSettingsViewModel::setSelectedRounds
                    )
                }
            )
        },
        backgroundColor = getBackgroundColor()
    ) { paddingValues ->
        StartGameScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            onContinueClicked = {
                navController.navigate(route = Screen.RoundPickerScreen.route)
            },
            getAllPlayers = playerViewModel::getAllPlayers,
            getAddedPlayers = gameSettingsViewModel::getAddedPlayers,
            setAddedPlayers = gameSettingsViewModel::setPlayers
        )
    }
}

@Composable
fun StartGameScreenContent(
    modifier: Modifier,
    onContinueClicked: () -> Unit,
    getAllPlayers: () -> Flow<List<Player>>,
    getAddedPlayers: () -> List<Player>,
    setAddedPlayers: (List<Player>) -> Unit
) {

    val savedPlayersValues by getAllPlayers().collectAsState(initial = emptyList())

    var addExistingPlayers by remember {
        mutableStateOf(value = false)
    }

    var addedPlayers by remember {
        mutableStateOf(value = getAddedPlayers())
    }

    if (!addExistingPlayers) {
        SurfaceWithColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            SimpleTextDisplay(text = "Players in Session", fontSize = 30, fontFamily = headerFont)
            SimpleSpacer(size = 30)

            LazyColumn(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth(fraction = 0.9f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(items = addedPlayers) { player ->
                    Row {
                        SimpleTextDisplay(
                            modifier = Modifier.padding(top = 12.dp),
                            text = player.getName(),
                            fontSize = 20,
                            fontFamily = FontFamily.SansSerif
                        )
                        SimpleSpacer(size = 30)
                        SimpleImageButton(
                            onClick = {
                                addedPlayers = addedPlayers.minus(element = player)
                            }, imageId = R.drawable.delete,
                            modifier = Modifier.size(size = 40.dp)
                        )
                    }
                    SimpleSpacer(size = 10)
                }
            }

            SimpleImageButton(
                modifier = Modifier.size(width = 100.dp, height = 100.dp),
                onClick = {
                    addExistingPlayers = true
                },
                imageId = R.drawable.add_player,
                contentDescription = "Add existing Player",
                fontSize = 20,
                fontFamily = FontFamily.SansSerif
            )
            SimpleSpacer(size = 10)
            SimpleTextDisplay(text = "Add Players", fontSize = 30, fontFamily = headerFont)

            SimpleSpacer(size = 30)

            SimpleCard(
                onClick = {
                    Game.setPlayers(players = addedPlayers)
                    setAddedPlayers(addedPlayers)
                    onContinueClicked()
                },
                content = {
                    SimpleTextDisplay(
                        text = if (addedPlayers.size < 2) {
                            "Add more Players"
                        } else if (addedPlayers.size > 10) {
                            "Too many Players"
                        } else {
                            "Continue"
                        },
                        fontSize = 20,
                        fontFamily = FontFamily.SansSerif
                    )
                },
                backgroundColor = if (addedPlayers.size in 2..10) getButtonColor(ButtonType.CORRECT) else getButtonColor(
                    ButtonType.INCORRECT
                ))
        }
    }

    MyAnimatedVisibilityTopToTop(
        visible = addExistingPlayers,
        animationDuration = AnimationConstants.ADD_EXISTING_PLAYERS_FADE_IN_OUT.durationMillis,
        content = {
            Box {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    SimpleSpacer(size = 20)

                    LazyColumn {
                        items(items = savedPlayersValues) { player ->
                            if (!addedPlayers.contains(element = player)) {
                                SimpleButton(
                                    onClick = {
                                        addedPlayers = addedPlayers.plus(element = player)
                                    },
                                    text = player.getName(),
                                    fontSize = 20,
                                    fontFamily = FontFamily.SansSerif
                                )
                                SimpleSpacer(size = 10)
                            }
                        }
                    }

                    SimpleSpacer(size = 50)

                    SimpleButton(
                        onClick = {
                            addExistingPlayers = false
                        },
                        text = "Done",
                        fontSize = 20,
                        fontFamily = FontFamily.SansSerif
                    )
                }
            }
        }
    )
}