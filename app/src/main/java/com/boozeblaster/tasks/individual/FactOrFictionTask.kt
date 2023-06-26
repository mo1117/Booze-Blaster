package com.boozeblaster.tasks.individual

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.boozeblaster.composables.ClickableSurfaceWithColumn
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.minigames.individual.FactOrFiction
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.IndividualTask
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.ui.theme.headerFont

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
        ClickableSurfaceWithColumn(
            onSurfaceClicked = onSurfaceClicked,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SimpleTextDisplay(
                text = "Fact or Fiction",
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
                text = "Guess if the following statements are true or false!\n\nIf you are " +
                        "correct, you are rewarded a point.\n\nOtherwise you drink!",
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
            verticalArrangement = Arrangement.Top,
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