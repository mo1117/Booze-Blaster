package com.boozeblaster.screens

import androidx.compose.foundation.layout.*
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
import com.boozeblaster.navigation.NavigationController
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
                NavigationController.navigateToGameScreen(
                    navController = navController,
                    setAdultMode = gameSettingsViewModel::setAdultMode,
                    setDifficulty = gameSettingsViewModel::setDifficulty,
                    resetAddedPlayers = gameSettingsViewModel::resetAddedPlayers,
                    setSelectedRounds = gameSettingsViewModel::setSelectedRounds
                )
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
        SimpleSpacer(size = 20)
        SimpleTextDisplay(
            text = "The following dares have to be completed by the losers!\n\n If some of them " +
                    "are too boring or hardcore, you might now want to change them.",
            fontSize = 20,
            fontFamily = FontFamily.SansSerif
        )
        SimpleSpacer(size = 20)

        LazyColumn(
            modifier = Modifier
                .height(height = 300.dp)
                .fillMaxWidth(0.9f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            content = {
                items(Game.getPlayers()) { player ->

                    var dareText by remember {
                        mutableStateOf(value = player.getDare().toString())
                    }

                    SimpleSpacer(size = 10)

                    Row {
                        SimpleTextDisplay(
                            modifier = Modifier.padding(top = 10.dp),
                            text = player.getName(),
                            fontSize = 20,
                            fontFamily = FontFamily.SansSerif
                        )

                        SimpleSpacer(size = 30)

                        SimpleImageButton(
                            onClick = {
                                loadedNewDare = DareTaskGenerator.reloadDare(player = player)
                                dareText = player.getDare().toString()
                            },
                            imageId = R.drawable.refresh,
                            modifier = Modifier.size(size = 40.dp)
                        )
                    }

                    SimpleSpacer(size = 20)

                    SimpleTextDisplay(
                        text = dareText,
                        fontSize = 24,
                        fontFamily = FontFamily.SansSerif
                    )

                    SimpleSpacer(size = 10)
                }
            })
        SimpleSpacer(size = 50)
        SimpleButton(
            onClick = {
                Game.loadTasks()
                onStartClicked()
            },
            text = "Start",
            fontSize = 16,
            fontFamily = FontFamily.SansSerif
        )
    }
}