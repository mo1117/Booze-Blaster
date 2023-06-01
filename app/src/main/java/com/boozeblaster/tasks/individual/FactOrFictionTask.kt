package com.boozeblaster.tasks.individual

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.boozeblaster.controllers.DarkmodeController
import com.boozeblaster.minigames.individual.FactOrFiction
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.IndividualTask
import com.boozeblaster.ui.theme.DarkBackGround
import com.boozeblaster.ui.theme.LightBackground

/**
 * A class that represents the Fact or Fiction mini-game
 *
 * Each assigned player will get three different statements displayed
 *
 * Every statement has to be labeled as fact or fiction
 *
 * 1 point per correct answer can be achieved
 */
class FactOrFictionTask(
    private val player: Player,
    private val subTasks: List<FactOrFiction>
) : IndividualTask(
    player = player,
    subTasks = subTasks
) {

    @Composable
    override fun DisplayCover(onSurfaceClicked: () -> Unit) {
        Surface(
            modifier = Modifier
                .fillMaxHeight(fraction = 1f)
                .fillMaxWidth(fraction = 1f)
                .clickable(onClick = { onSurfaceClicked() })
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.background(
                    color = if (DarkmodeController.isDarkmode())
                        DarkBackGround else LightBackground
                )
            ) {
                Text(text = player.getName())
                Spacer(Modifier.size(50.dp))
                Text("Fact or Fiction my guy")
            }
        }
    }

    @Composable
    override fun Display(callback: () -> Unit) {
        var subTaskCounter by remember {
            mutableStateOf(0)
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.background(
                color = if (DarkmodeController.isDarkmode())
                    DarkBackGround else LightBackground
            )
        ) {
            subTasks.get(index = subTaskCounter).DisplayContent(
                player = player,
                callback = {
                    if (subTaskCounter == 2) callback() else subTaskCounter++
                })
        }
    }
}