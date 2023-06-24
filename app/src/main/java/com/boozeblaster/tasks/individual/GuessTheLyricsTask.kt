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
import com.boozeblaster.minigames.individual.GuessTheLyrics
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.IndividualTask
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.widgets.Timer

class GuessTheLyricsTask(
    private val player: Player,
    private val subTasks: List<GuessTheLyrics>
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
                    color = getBackgroundColor()
                )
            ) {
                Text(text = player.getName())
                Spacer(Modifier.size(50.dp))
                Text("GuessTheLyrics - Be aware of the timer")
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
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.background(
                color = getBackgroundColor()
            )
        ) {
            subTasks.get(index = subTaskCounter).DisplayContent(
                player = player,
                callback = {
                    if (subTaskCounter == subTasks.size - 1) {
                        subTaskCounter = 0
                        callback()
                    } else {
                        subTaskCounter++
                    }
                })
        }
    }
}