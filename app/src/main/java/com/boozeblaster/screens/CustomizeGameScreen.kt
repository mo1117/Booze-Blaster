package com.boozeblaster.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.navigation.NavController
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimplePickableCard
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.composables.SimpleTopAppBar
import com.boozeblaster.composables.SurfaceWithColumn
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.utils.GameSettings

private val onCardClicked: (MutableList<String>, String) -> Unit = { list, string ->
    if (list.contains(element = string)) {
        list.remove(element = string)
    } else {
        list.add(element = string)
    }
}

@Composable
fun CustomizeGameScreen(
    navController: NavController
) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState, topBar = {
        SimpleTopAppBar(onBackButtonClick = { navController.popBackStack() })
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
    SurfaceWithColumn(
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
        displayCommonTasks(pickedCommonTasks = pickedCommonTasks)
        displayVersusTasks(pickedVersusTasks = pickedVersusTasks)
        displayIndividualTasks(pickedIndividualTasks = pickedIndividualTasks)
        SimpleButton(
            onClick = {
                GameSettings.setCommonTasks(options = pickedCommonTasks.toTypedArray())
                GameSettings.setVersusTasks(options = pickedVersusTasks.toTypedArray())
                GameSettings.setIndividualTasks(options = pickedIndividualTasks.toTypedArray())
                onContinueClicked()
            },
            text = "Continue",
            fontSize = 20,
            fontFamily = FontFamily.SansSerif,
            enabled = pickedCommonTasks.isNotEmpty()
                    || pickedVersusTasks.isNotEmpty() || pickedIndividualTasks.isNotEmpty()
        )
    }

}

@Composable
private fun displayCommonTasks(pickedCommonTasks: MutableList<String>) {
    val commonTasks = GameSettings.getCommonTasks()

    SimpleTextDisplay(text = "Common Tasks", fontSize = 20, fontFamily = FontFamily.SansSerif)
    SimpleSpacer(size = 20)

    for (i in commonTasks.indices step 2) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SimplePickableCard(callback = {
                onCardClicked(
                    pickedCommonTasks,
                    commonTasks.get(index = i)
                )
            }) {
                SimpleTextDisplay(
                    text = commonTasks.get(index = i),
                    fontSize = 20,
                    fontFamily = FontFamily.SansSerif
                )
            }

            if (i + 1 < commonTasks.size) {
                SimplePickableCard(callback = {
                    onCardClicked(
                        pickedCommonTasks,
                        commonTasks.get(index = i + i)
                    )
                }) {
                    SimpleTextDisplay(
                        text = commonTasks.get(index = i + 1),
                        fontSize = 20,
                        fontFamily = FontFamily.SansSerif
                    )
                }
            }
            SimpleSpacer(size = 20)
        }
    }
}

@Composable
private fun displayVersusTasks(pickedVersusTasks: MutableList<String>) {
    val versusTasks = GameSettings.getVersusTasks()

    SimpleTextDisplay(text = "Versus Tasks", fontSize = 20, fontFamily = FontFamily.SansSerif)
    SimpleSpacer(size = 20)

    for (i in versusTasks.indices step 2) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SimplePickableCard(callback = {
                onCardClicked(
                    pickedVersusTasks,
                    versusTasks.get(index = i)
                )
            }) {
                SimpleTextDisplay(
                    text = versusTasks.get(index = i),
                    fontSize = 20,
                    fontFamily = FontFamily.SansSerif
                )
            }

            if (i + 1 < versusTasks.size) {
                SimplePickableCard(callback = {
                    onCardClicked(
                        pickedVersusTasks,
                        versusTasks.get(index = i + 1)
                    )
                }) {
                    SimpleTextDisplay(
                        text = versusTasks.get(index = i + 1),
                        fontSize = 20,
                        fontFamily = FontFamily.SansSerif
                    )
                }
            }
            SimpleSpacer(size = 20)
        }
    }
}

@Composable
private fun displayIndividualTasks(pickedIndividualTasks: MutableList<String>) {
    val individualTasks = GameSettings.getIndividualTasks()

    SimpleTextDisplay(text = "Individual Tasks", fontSize = 20, fontFamily = FontFamily.SansSerif)
    SimpleSpacer(size = 20)

    for (i in individualTasks.indices step 2) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SimplePickableCard(callback = {
                onCardClicked(
                    pickedIndividualTasks,
                    individualTasks.get(index = i)
                )
            }) {
                SimpleTextDisplay(
                    text = individualTasks.get(index = i),
                    fontSize = 20,
                    fontFamily = FontFamily.SansSerif
                )
            }

            if (i + 1 < individualTasks.size) {
                SimplePickableCard(callback = {
                    onCardClicked(
                        pickedIndividualTasks,
                        individualTasks.get(index = i + 1)
                    )
                }) {
                    SimpleTextDisplay(
                        text = individualTasks.get(index = i + 1),
                        fontSize = 20,
                        fontFamily = FontFamily.SansSerif
                    )
                }
            }
            SimpleSpacer(size = 20)
        }
    }
}