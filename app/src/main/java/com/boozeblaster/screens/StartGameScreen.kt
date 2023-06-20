package com.boozeblaster.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.boozeblaster.R
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleIconButton
import com.boozeblaster.composables.SimpleImageButton
import com.boozeblaster.composables.SimpleTopAppBar
import com.boozeblaster.enums.Difficulty
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.utils.InjectorUtils
import com.boozeblaster.viewmodels.GameSettingsViewModel
import com.boozeblaster.viewmodels.PlayerViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.*

@Composable
fun StartGameScreen(navController: NavController, gameSettingsViewModel: GameSettingsViewModel) {
    val playerViewModel: PlayerViewModel =
        viewModel(factory = InjectorUtils.providePlayerViewModelFactory(context = LocalContext.current))
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SimpleTopAppBar(
                onBackButtonClick = {
                    //Set the values of the view model to null
                    gameSettingsViewModel.setAdultMode(adultMode = null)
                    gameSettingsViewModel.setDifficulty(difficulty = null)
                    navController.popBackStack()
                }
            )
        },
        backgroundColor = getBackgroundColor()
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
            onContinueClicked = {
                navController.navigate(route = Screen.AdultModePickerScreen.route)
            }
        )
    }
}

@Composable
fun StartGameScreenContent(
    modifier: Modifier,
    getSavedPlayers: () -> Job,
    onAddPlayerClicked: () -> Unit,
    onRemovePlayerClicked: (Player) -> Unit,
    onContinueClicked: () -> Unit
) {
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
                onClick = { onAddPlayerClicked() },
                imageId = R.drawable.add_player,
                contentDescription = "Add Player",
                text = "Add Player",
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
                    val calendar = GregorianCalendar()
                    calendar.set(2000, 11, 17)
                    val date = calendar.gregorianChange

                    val p1 = Player(name = "Mo", birthDate = date)
                    val p2 = Player(2, "Mo2", date)
                    val p3 = Player(3, "Mo3", date)

                    Game.init(
                        listOf(p1, p2),
                        2,
                        Difficulty.MEDIUM,
                        false
                    )
                    onContinueClicked()
                },
                text = "Continue",
                fontSize = 20,
                fontFamily = FontFamily.SansSerif
            )
        }
    }
}