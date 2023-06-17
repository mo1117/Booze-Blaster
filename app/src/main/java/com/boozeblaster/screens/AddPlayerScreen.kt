package com.boozeblaster.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.boozeblaster.composables.SimpleTextField
import com.boozeblaster.composables.SimpleTopAppBar
import com.boozeblaster.models.Player
import com.boozeblaster.ui.theme.getBackgroundColor
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
        },
        backgroundColor = getBackgroundColor()
    ) { paddingValues ->
        AddPlayerScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            playerUIState = playerViewModel.playerUIState,
            onAddPlayerClicked = { playerViewModel::addPlayer },
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
    onAddPlayerClicked: (Player) -> Unit,
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
                value = playerUIState.userName,
                label = "Name:",
                isError = playerUIState.nameError,
                errorMsg = "Invalid Name",
                onChange = { input ->
                    onPlayerValueChange(
                        playerUIState.copy(userName = input),
                        AddPlayerUIEvent.UsernameChanged
                    )
                }
            )

//            val calendar = Calendar.getInstance()
//            val year = calendar.get(Calendar.YEAR)
//            val month = calendar.get(Calendar.MONTH)
//            val day = calendar.get(Calendar.DAY_OF_MONTH)
//            calendar.time = Date()
//            val date = remember { mutableStateOf("") }

//            DatePickerDialog(
//                LocalContext.current,
//                { _: DatePicker, year: Int, month: Int, day: Int ->
//                    date.value = "$year/${month + 1}/$day"
//                }, year, month, day
//            ).show()
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