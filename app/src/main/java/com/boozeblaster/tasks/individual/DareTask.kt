package com.boozeblaster.tasks.individual

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.boozeblaster.composables.ClickableSurfaceWithColumn
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.models.Player
import com.boozeblaster.tasks.IndividualTask

class DareTask(
    private val player: Player
) : IndividualTask(
    player = player,
    subTasks = emptyList()
) {

    @Composable
    override fun DisplayCover(onSurfaceClicked: () -> Unit) {
        ClickableSurfaceWithColumn(
            onSurfaceClicked = { onSurfaceClicked() },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SimpleTextDisplay(
                text = "$player\n\nYou lost!\nTime to complete your dare!",
                fontSize = super.fontSize,
                fontFamily = super.fontFamily
            )
        }
    }

    @Composable
    override fun Display(callback: () -> Unit) {
        ClickableSurfaceWithColumn(
            onSurfaceClicked = { callback() },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            SimpleTextDisplay(
                text = "${player.getName()}\n\n${player.getDare()}",
                fontSize = super.fontSize,
                fontFamily = super.fontFamily
            )
        }
    }
}