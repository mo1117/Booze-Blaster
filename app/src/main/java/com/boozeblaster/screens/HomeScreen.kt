package com.boozeblaster.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.boozeblaster.composables.HomeTopAppBar
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.ui.theme.LightBackground
import com.boozeblaster.utils.InjectorUtils
import com.boozeblaster.viewmodels.PlayerViewModel

@Composable
fun HomeScreen(navController: NavController) {
    val playerViewModel: PlayerViewModel =
        viewModel(factory = InjectorUtils.providePlayerViewModelFactory(context = LocalContext.current))
    //TODO: is playerViewModel needed here?
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            HomeTopAppBar()
        }
    ) { paddingValues ->
        HomeScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            onStartClicked = { navController.navigate(route = Screen.StartGameScreen.route) },
            onAddPlayerClicked = { navController.navigate(route = Screen.AddPlayerScreen.route) }
        )
    }
}

@Composable
fun HomeScreenContent(
    modifier: Modifier,
    onStartClicked: () -> Unit,
    onAddPlayerClicked: () -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth(fraction = 1f)
            .fillMaxHeight(fraction = 1f)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = modifier.background(color = LightBackground) // TODO darkmode
        ) {
            // Change button specifications here as we want them to look consistent
            val buttonModifier = Modifier
                .size(width = 150.dp, height = 75.dp)
            val fontSize = 16
            val fontFamily = FontFamily.SansSerif

            Spacer(
                modifier = modifier.size(size = 100.dp) //TODO Maybe use percentual layouts?
            )
            SimpleButton(
                modifier = buttonModifier,
                onClick = { onStartClicked() },
                text = "Start",
                fontSize = fontSize,
                fontFamily = fontFamily
            )
            Spacer(
                modifier = modifier.size(size = 100.dp)
            )
            SimpleButton(
                modifier = buttonModifier,
                onClick = { onAddPlayerClicked() },
                text = "Add Player",
                fontSize = fontSize,
                fontFamily = fontFamily
            )
            Spacer(
                modifier = modifier.size(size = 100.dp)
            )
            var text by remember {
                mutableStateOf("hi")
            }
            SimpleButton(
                modifier = buttonModifier,
                onClick = { text = "moin" },
                text = text,
                fontSize = fontSize,
                fontFamily = fontFamily
            )
// TEST DONT DELETE
//            val p = Player(1, "h", "h", "h", 5)
//            val s = "GuessTheLyrics"
//            val clazz = Class.forName("com.boozeblaster.tasks.individual.${s}Task")
//            val generator = Class.forName("com.boozeblaster.generators.individual.${s}Generator")
//                .getMethod("getList")
//
//            val instance = Class.forName("com.boozeblaster.generators.individual.GuessTheLyricsGenerator").newInstance()
//
//            val o = clazz.getConstructor(Player::class.java, List::class.java).newInstance(
//                p,
//                generator.invoke(instance)
//            ) as GuessTheLyricsTask
//
//            Text(o.print())
        }
    }
}

