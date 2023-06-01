package com.boozeblaster.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.boozeblaster.composables.SimpleTextField
import com.boozeblaster.composables.SimpleTopAppBar
import com.boozeblaster.models.Player
import com.boozeblaster.utils.InjectorUtils
import com.boozeblaster.viewmodels.PlayerViewModel

@Composable
fun AddPlayerScreen(navController: NavController = rememberNavController()) {
    val playerViewModel: PlayerViewModel =
        viewModel(factory = InjectorUtils.providePlayerViewModelFactory(context = LocalContext.current))
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SimpleTopAppBar(
                onBackButtonClick = { navController.popBackStack() }
            )
        }
    ) { paddingValues ->
        AddPlayerScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            onAddPlayerClicked = { playerViewModel::addPlayer },
            onStartClicked = { }
        )
    }
}

@Composable
fun AddPlayerScreenContent(
    modifier: Modifier,
    onAddPlayerClicked: (Player) -> Unit,
    onStartClicked: () -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth(fraction = 1f)
            .fillMaxHeight(fraction = 1f)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            SimpleTextField(
                modifier = Modifier,
                value = "",
                label = "Name:",
                isError = true,
                onDone = { /*TODO*/ },
                onChange = {}
            )
            SimpleTextField(
                modifier = Modifier,
                value = "",
                label = "Name:",
                isError = true,
                onDone = { /*TODO*/ },
                onChange = {}
            )
            SimpleTextField(
                modifier = Modifier,
                value = "",
                label = "Name:",
                isError = true,
                onDone = { /*TODO*/ },
                onChange = {}
            )
        }
    }
}