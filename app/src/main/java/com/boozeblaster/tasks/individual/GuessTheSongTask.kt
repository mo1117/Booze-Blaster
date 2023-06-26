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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.boozeblaster.R
import com.boozeblaster.composables.ClickableSurfaceWithColumn
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.minigames.individual.GuessTheSong
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.IndividualTask
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.ui.theme.headerFont

class GuessTheSongTask(
    private val player: Player,
    private val subTasks: List<GuessTheSong>
) : IndividualTask(
    player = player,
    subTasks = subTasks
) {

    @Composable
    override fun DisplayCover(onSurfaceClicked: () -> Unit) {
        ClickableSurfaceWithColumn(
            onSurfaceClicked = { onSurfaceClicked() },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SimpleTextDisplay(
                text = "Guess the Song",
                fontSize = 30,
                fontFamily = headerFont
            )
            SimpleSpacer(size = 30)

            SimpleTextDisplay(
                text = player.getName(),
                fontSize = 26,
                fontFamily = FontFamily.SansSerif
            )
            SimpleSpacer(size = 30)

            Image(
                modifier = Modifier.size(size = 100.dp),
                painter = painterResource(id = R.drawable.guessing),
                contentDescription = "Guess The Song Icon"
            )

            SimpleSpacer(size = 30)

            SimpleTextDisplay(
                text = "You will have to guess the following three songs.\n\nIf you cannot name " +
                        "both artist and the song's name, you will drink the full amount!\n\n" +
                        "If you are able to guess both correct, you will be rewarded full points " +
                        "instead!\n\nIf only one guess is correct, points and sips will both be " +
                        "halved.",
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
                }
            )
        }
    }
}