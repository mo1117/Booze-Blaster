package com.boozeblaster.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.boozeblaster.composables.*
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
                    navController.popBackStack()
                    navController.navigate(route = Screen.AddPlayerScreen.route)
                }
            },
            onContinueClicked = {
                navController.navigate(route = Screen.StartGameScreen.route)
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
    onContinueClicked: () -> Unit,
    onPlayerValueChange: (AddPlayerUIState, AddPlayerUIEvent) -> Unit
) {

    SurfaceWithColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
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
            fontFamily = FontFamily.SansSerif
        )

        SimpleSpacer(size = 20)

        SimpleButton(
            onClick = onContinueClicked,
            text = "Continue",
            fontSize = 16,
            fontFamily = FontFamily.SansSerif
        )
    }
}
