package com.boozeblaster.tasks.individual

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.boozeblaster.R
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

            Image(
                modifier = Modifier.size(size = 100.dp),
                painter = painterResource(id = R.drawable.lyrics),
                contentDescription = "Guess The Lyrics Icon"
            )

            SimpleSpacer(size = 30)

            SimpleTextDisplay(
                text = "You will have to guess the following three lyrics completions.\n\n" +
                        "If you guess it correctly, you will be rewarded with points.\n\n" +
                        "When not knowing any of the upcoming lyrics, you drink!\n\n" +
                        "When having the lyrics partially correct, points and sips will be halved!",
                fontSize = super.fontSize,
                fontFamily = super.fontFamily,
                horizontalTextPadding = 15
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