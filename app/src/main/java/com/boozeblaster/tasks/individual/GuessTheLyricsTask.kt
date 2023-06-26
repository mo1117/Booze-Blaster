package com.boozeblaster.tasks.individual

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.boozeblaster.composables.ClickableSurfaceWithColumn
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.minigames.individual.GuessTheLyrics
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.IndividualTask
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.ui.theme.headerFont

class GuessTheLyricsTask(
    private val player: Player,
    private val subTasks: List<GuessTheLyrics>
) : IndividualTask(
    player = player,
    subTasks = subTasks
) {

    @Composable
    override fun DisplayCover(onSurfaceClicked: () -> Unit) {
        ClickableSurfaceWithColumn(
            onSurfaceClicked = onSurfaceClicked,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SimpleTextDisplay(
                text = "Guess the Lyrics",
                fontSize = 30,
                fontFamily = headerFont
            )
            SimpleSpacer(size = 30)

            SimpleTextDisplay(
                text = player.getName(),
                fontSize = 26,
                fontFamily = super.fontFamily
            )
            SimpleSpacer(size = 30)

            SimpleTextDisplay(
                text = "You will have to guess the following three lyrics completions.\n\n" +
                        "If you guess it correctly, you will be rewarded with points.\n\n" +
                        "When not knowing any of the upcoming lyrics, you drink!\n\n" +
                        "When having the lyrics partially correct, points and sips will be halved!",
                fontSize = super.fontSize,
                fontFamily = super.fontFamily
            )
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