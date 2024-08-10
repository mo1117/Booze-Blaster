package com.boozeblaster.screens

import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.boozeblaster.R
import com.boozeblaster.composables.*
import com.boozeblaster.composables.topAppBars.SimpleTopAppBarCreator
import com.boozeblaster.models.Player
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.utils.InjectorUtils
import com.boozeblaster.viewmodels.PlayerViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlin.reflect.KSuspendFunction1

@Composable
fun AddPlayerScreen(navController: NavController = rememberNavController()) {
    val playerViewModel: PlayerViewModel =
        viewModel(factory = InjectorUtils.providePlayerViewModelFactory(context = LocalContext.current))
    val scaffoldState = rememberScaffoldState()

    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SimpleTopAppBarCreator().CreateAppBar(onBackButtonClick = {
                navController.popBackStack()
            })
        },
        backgroundColor = getBackgroundColor()
    ) { paddingValues ->
        AddPlayerScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            playerUIState = playerViewModel.playerUIState,
            onAddPlayerClicked = {
                coroutineScope.launch {
                    playerViewModel.addPlayer()
                    navController.popBackStack()
                    navController.navigate(route = Screen.AddPlayerScreen.route)
                }
            },
            removePlayer = playerViewModel::deletePlayer,
            onDoneClicked = {
                navController.popBackStack()
            },
            onPlayerValueChange = { newUiState, event ->
                playerViewModel.updateUIState(newUiState, event)
            },
            getAllPlayers = playerViewModel::getAllPlayers
        )
    }
}

@Composable
fun AddPlayerScreenContent(
    modifier: Modifier,
    playerUIState: AddPlayerUIState,
    onAddPlayerClicked: () -> Unit,
    removePlayer: KSuspendFunction1<Player, Unit>,
    onDoneClicked: () -> Unit,
    onPlayerValueChange: (AddPlayerUIState, AddPlayerUIEvent) -> Unit,
    getAllPlayers: () -> Flow<List<Player>>
) {

    val coroutineScope = rememberCoroutineScope()

    val savedPlayersValues by getAllPlayers().collectAsState(initial = emptyList())

    var deletedPlayers by remember {
        mutableStateOf(value = emptyList<Player>())
    }

    var displayAgeConfirmation by remember {
        mutableStateOf(value = false)
    }

    var ageConfirmed by remember {
        mutableStateOf(value = false)
    }

    if (displayAgeConfirmation) {
        MyAlertDialog(
            title = "Confirm Age",
            message = "Are you at least 16 years old?",
            onConfirm = {
                ageConfirmed = true
                displayAgeConfirmation = false
            },
            onDismiss = {
                ageConfirmed = false
                displayAgeConfirmation = false
            })
    }

    SurfaceWithColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn(
            modifier = Modifier
                .height(height = 300.dp)
                .fillMaxWidth(fraction = 0.9f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            content = {
                items(savedPlayersValues) { player ->
                    if (!deletedPlayers.contains(element = player)) {
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
                                    coroutineScope.launch {
                                        removePlayer(player)
                                    }
                                    deletedPlayers = deletedPlayers.plus(element = player)
                                }, imageId = R.drawable.delete,
                                modifier = Modifier.size(size = 40.dp),
                                contentDescription = "Delete"
                            )
                        }
                        SimpleSpacer(size = 10)
                    }
                }
            })

        SimpleTextField(
            modifier = Modifier,
            value = playerUIState.name,
            label = "Name:",
            isError = playerUIState.nameError,
            errorMsg = "Invalid Name",
            onChange = { input ->
                onPlayerValueChange(
                    playerUIState.copy(name = input),
                    AddPlayerUIEvent.UsernameChanged
                )
            }
        )

        SimpleSpacer(size = 30)

        SimpleButton(
            onClick = { displayAgeConfirmation = true },
            text = "Confirm Age",
            fontSize = 20,
            fontFamily = FontFamily.SansSerif
        )

        SimpleSpacer(size = 30)

        SimpleButton(
            enabled = playerUIState.actionEnabled && ageConfirmed,
            onClick = {
                ageConfirmed = false
                onAddPlayerClicked()
            },
            text = "Add",
            fontSize = 16,
            fontFamily = FontFamily.SansSerif,
        )

        SimpleSpacer(size = 30)

        SimpleButton(
            onClick = {
                onDoneClicked()
            },
            text = "Back",
            fontSize = 16,
            fontFamily = FontFamily.SansSerif
        )
    }
}
