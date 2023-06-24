package com.boozeblaster.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.boozeblaster.R
import com.boozeblaster.composables.*
import com.boozeblaster.generators.DareTaskGenerator
import com.boozeblaster.models.Game
import com.boozeblaster.ui.theme.getAppBarColor
import com.boozeblaster.ui.theme.headerFont
import com.boozeblaster.viewmodels.GameSettingsViewModel

@Composable
fun DisplayDaresScreen(navController: NavController, gameSettingsViewModel: GameSettingsViewModel) {
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { SimpleTopAppBar(onBackButtonClick = { navController.popBackStack() }) },
        backgroundColor = getAppBarColor()
    ) { paddingValues ->
        DisplayDaresScreenContent(modifier = Modifier.padding(paddingValues = paddingValues),
            onStartClicked = {
                //Clear the settings
                gameSettingsViewModel.setDifficulty(difficulty = null)
                gameSettingsViewModel.setAdultMode(adultMode = null)
                gameSettingsViewModel.setDaresAssigned(assigned = false)
                navController.navigate(route = Screen.GameScreen.route)
            })
    }
}

@Composable
fun DisplayDaresScreenContent(
    modifier: Modifier,
    onStartClicked: () -> Unit
) {
    SurfaceWithColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        var loadedNewDare by remember {
            mutableStateOf(value = false)
        }

        SimpleTextDisplay(text = "The Dares", fontSize = 30, fontFamily = headerFont)

        LazyColumn(
            modifier = Modifier.size(width = 300.dp, height = 400.dp),
            content = {
                items(Game.getPlayers()) { player ->

                    var dareText by remember {
                        mutableStateOf(value = player.getDare().toString())
                    }

                    SimpleSpacer(size = 10)

                    Row {
                        SimpleTextDisplay(
                            text = player.getName(),
                            fontSize = 16,
                            fontFamily = FontFamily.SansSerif
                        )

                        SimpleSpacer(size = 30)

                        SimpleImageButton(
                            onClick = {
                                loadedNewDare = DareTaskGenerator.reloadDare(player = player)
                                dareText = player.getDare().toString()
                            },
                            imageId = R.drawable.add_player,
                            modifier = Modifier.size(width = 30.dp, height = 30.dp)
                        )
                    }

                    SimpleSpacer(size = 20)

                    SimpleTextDisplay(
                        text = dareText,
                        fontSize = 16,
                        fontFamily = FontFamily.SansSerif
                    )

                    SimpleSpacer(size = 10)
                }
            })
        SimpleSpacer(size = 50)
        SimpleButton(
            onClick = {
                Game.load()
                onStartClicked()
            },
            text = "Start",
            fontSize = 16,
            fontFamily = FontFamily.SansSerif
        )
    }
}