package com.boozeblaster.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
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
import com.boozeblaster.composables.SimpleTextField
import com.boozeblaster.composables.SimpleTopAppBar
import com.boozeblaster.models.Player
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
                    playerViewModel.addPlayer()}
            },
            onPlayerValueChange = { newUiState, event ->
                playerViewModel.updateUIState(newUiState, event)
            }
        )

    }
}

@Composable
fun AddPlayerScreenContent(
    modifier: Modifier,
    playerUIState: AddPlayerUIState,
    onAddPlayerClicked: () -> Unit,
    onPlayerValueChange: (AddPlayerUIState, AddPlayerUIEvent) -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth(fraction = 1f)
            .fillMaxHeight(fraction = 1f)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = modifier.background(color = getBackgroundColor())
        ) {
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

            Button(
                enabled = playerUIState.actionEnabled,
                onClick = onAddPlayerClicked
            ) {
                Text(text = stringResource(R.string.add))
            }

            SimpleButton(
                onClick = { /*TODO*/ },
                text = "Add",
                fontSize = 16,
                fontFamily = FontFamily.SansSerif)
        }
    }
}
//
//@Composable
//fun PlayerList(
//    modifier: Modifier,
//    players: List<Player> = remember { }
//) {
//    val playerListState by viewModel.playerListState.collectAsState()
//    val coroutineScope = rememberCoroutineScope()
//
//    LazyColumn{
//        items(items = playerListState){Player ->
//            PlayerItem(
//                playerName = playerListState.name)
//        }
//    }
//}
//
//@Composable
//fun PlayerItem(
//    playerName: String,
//){
//    Row(
//        modifier = Modifier,
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Text(
//            modifier = Modifier
//                .weight(1f)
//                .padding(start = 16.dp),
//            text = playerName
//        )
//    }
//}


