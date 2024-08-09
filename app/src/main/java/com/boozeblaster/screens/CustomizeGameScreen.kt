package com.boozeblaster.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.composables.SimpleTopAppBar
import com.boozeblaster.composables.SurfaceWithScrollableColumn
import com.boozeblaster.composables.builder.PickableCardBuilder
import com.boozeblaster.composables.builder.SimpleCardBuilder
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.ui.theme.getButtonColor
import com.boozeblaster.ui.theme.headerFont
import com.boozeblaster.utils.GameSettings

private val onCardClicked: (MutableList<String>, String) -> Unit = { list, string ->
    if (list.contains(element = string)) {
        list.remove(element = string)
    } else {
        list.add(element = string)
    }
}

private val pickableCardBuilder = PickableCardBuilder()

@Composable
fun CustomizeGameScreen(
    navController: NavController
) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState, topBar = {
        SimpleTopAppBar(onBackButtonClick = {
            GameSettings.reset()
            navController.popBackStack()
        })
    }, backgroundColor = getBackgroundColor()) { paddingValues ->
        CustomizeGameScreenContent(
            modifier = Modifier.padding(paddingValues = paddingValues),
            onContinueClicked = { navController.navigate(route = Screen.StartGameScreen.route) })
    }
}

@Composable
fun CustomizeGameScreenContent(
    modifier: Modifier,
    onContinueClicked: () -> Unit
) {
    SurfaceWithScrollableColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        val pickedCommonTasks = remember {
            mutableStateListOf<String>()
        }
        val pickedVersusTasks = remember {
            mutableStateListOf<String>()
        }
        val pickedIndividualTasks = remember {
            mutableStateListOf<String>()
        }
        DisplayCommonTasks(pickedCommonTasks = pickedCommonTasks)
        DisplayVersusTasks(pickedVersusTasks = pickedVersusTasks)
        DisplayIndividualTasks(pickedIndividualTasks = pickedIndividualTasks)

        val simpleCardBuilder = SimpleCardBuilder()
        simpleCardBuilder.callback = {
            GameSettings.setCommonTasks(options = pickedCommonTasks.toTypedArray())
            GameSettings.setVersusTasks(options = pickedVersusTasks.toTypedArray())
            GameSettings.setIndividualTasks(options = pickedIndividualTasks.toTypedArray())
            onContinueClicked()
        }
        simpleCardBuilder.content = {
            SimpleTextDisplay(text = "Continue", fontSize = 30, fontFamily = headerFont)
        }
        simpleCardBuilder.enabled = pickedCommonTasks.isNotEmpty()
                || pickedVersusTasks.isNotEmpty() || pickedIndividualTasks.isNotEmpty()
        simpleCardBuilder.backgroundColor = if (pickedCommonTasks.isNotEmpty()
            || pickedVersusTasks.isNotEmpty() || pickedIndividualTasks.isNotEmpty()
        ) getButtonColor(ButtonType.CORRECT) else getButtonColor(ButtonType.INCORRECT)
        simpleCardBuilder.width = 260.dp
        simpleCardBuilder.height = 140.dp
        simpleCardBuilder.build()()
        SimpleSpacer(size = 20)
    }
}

@Composable
private fun DisplayCommonTasks(pickedCommonTasks: MutableList<String>) {
    val commonTasks = GameSettings.getCommonTasks()

    SimpleSpacer(size = 20)
    SimpleTextDisplay(text = "Common Tasks", fontSize = 30, fontFamily = headerFont)
    SimpleSpacer(size = 20)

    for (i in commonTasks.indices) {
        pickableCardBuilder.callback = {
            onCardClicked(
                pickedCommonTasks,
                commonTasks.get(index = i)
            )
        }
        pickableCardBuilder.content = {
            SimpleTextDisplay(
                text = commonTasks.get(index = i),
                fontSize = 20,
                fontFamily = FontFamily.SansSerif
            )
        }
        pickableCardBuilder.build()()
        SimpleSpacer(size = 20)
    }
}

@Composable
private fun DisplayVersusTasks(pickedVersusTasks: MutableList<String>) {
    val versusTasks = GameSettings.getVersusTasks()

    SimpleSpacer(size = 20)
    SimpleTextDisplay(text = "Versus Tasks", fontSize = 30, fontFamily = headerFont)
    SimpleSpacer(size = 20)

    for (i in versusTasks.indices) {
        pickableCardBuilder.callback = {
            onCardClicked(
                pickedVersusTasks,
                versusTasks.get(index = i)
            )
        }
        pickableCardBuilder.content = {
            SimpleTextDisplay(
                text = versusTasks.get(index = i),
                fontSize = 20,
                fontFamily = FontFamily.SansSerif
            )
        }
        pickableCardBuilder.build()()
        SimpleSpacer(size = 20)
    }
}

@Composable
private fun DisplayIndividualTasks(pickedIndividualTasks: MutableList<String>) {
    val individualTasks = GameSettings.getIndividualTasks()

    SimpleSpacer(size = 20)
    SimpleTextDisplay(text = "Individual Tasks", fontSize = 30, fontFamily = headerFont)
    SimpleSpacer(size = 20)

    for (i in individualTasks.indices) {
        pickableCardBuilder.callback = {
            onCardClicked(
                pickedIndividualTasks,
                individualTasks.get(index = i)
            )
        }
        pickableCardBuilder.content = {
            SimpleTextDisplay(
                text = individualTasks.get(index = i),
                fontSize = 20,
                fontFamily = FontFamily.SansSerif
            )
        }
        pickableCardBuilder.build()()
        SimpleSpacer(size = 20)
    }
}