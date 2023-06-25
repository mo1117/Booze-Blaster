package com.boozeblaster.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.boozeblaster.R
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextField
import com.boozeblaster.composables.SimpleTopAppBar
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player
import com.boozeblaster.models.getPlayers
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.utils.InjectorUtils
import com.boozeblaster.viewmodels.PlayerViewModel
import kotlinx.coroutines.launch

@Composable
fun AddPlayerScreen(navController: NavController = rememberNavController()) {
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
        },
        backgroundColor = getBackgroundColor()
    ) { paddingValues ->
        AddPlayerScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            playerUIState = playerViewModel.playerUIState,
            onAddPlayerClicked = {
                coroutineScope.launch {
                    playerViewModel.addPlayer()
                    navController.navigate(route = Screen.AddPlayerScreen.route)
                }
            },
            onContinueClicked = {
                navController.navigate(route = Screen.StartGameScreen.route)
            },
            onPlayerValueChange = { newUiState, event ->
                playerViewModel.updateUIState(newUiState, event)

            },
            viewModel = playerViewModel
        )
    }
}

@Composable
fun AddPlayerScreenContent(
    modifier: Modifier,
    playerUIState: AddPlayerUIState,
    onAddPlayerClicked: () -> Unit,
    onContinueClicked: () -> Unit,
    onPlayerValueChange: (AddPlayerUIState, AddPlayerUIEvent) -> Unit,
    viewModel: PlayerViewModel
) {

    val coroutineScope = rememberCoroutineScope()

    Surface(

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = modifier.background(color = getBackgroundColor())
        ) {

            SimpleSpacer(size = 20)

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

            SimpleSpacer(size = 50)

            SimpleButton(
                enabled = playerUIState.actionEnabled,
                onClick = onAddPlayerClicked,
                text = "Add",
                fontSize = 16,
                fontFamily = FontFamily.SansSerif)

            SimpleSpacer(size = 20)

            SimpleButton(
                onClick = onContinueClicked,
                text = "continue",
                fontSize = 16,
                fontFamily = FontFamily.SansSerif)


//            PlayerList(
//                players = playerUIState,
//                onTaskDelete = {player ->
//                    coroutineScope.launch {
//                        viewModel.deletePlayer(player)
//                    }
//                })

        }
    }
}

@Composable
fun PlayerList(
    players: List<Player> = remember { getPlayers() },
    onTaskDelete: (Player) -> Unit = {}
){

    LazyColumn{
        items(items = players){ player ->
            PlayerItem(
                playerName = player.getName(),
                onClose = { onTaskDelete(player) })
        }
    }
}

@Composable
fun PlayerItem(
    playerName: String,
    onClose: () -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            text = playerName
        )
        IconButton(onClick = onClose) {
            Icon(Icons.Filled.Close, contentDescription = "Close")
        }
    }
}
