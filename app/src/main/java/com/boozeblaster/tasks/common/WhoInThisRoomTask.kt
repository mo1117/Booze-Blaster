package com.boozeblaster.tasks.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import com.boozeblaster.composables.ClickableSurfaceWithColumn
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.composables.SurfaceWithColumn
import com.boozeblaster.minigames.common.WhoInThisRoom
import com.boozeblaster.tasks.CommonTask
import com.boozeblaster.ui.theme.headerFont

class WhoInThisRoomTask(
    private val subTasks: List<WhoInThisRoom>
) : CommonTask(
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
                text = "Who In This Room",
                fontSize = 30,
                fontFamily = headerFont
            )
            SimpleSpacer(size = 50)
            SimpleTextDisplay(
                text = "Do your own countdown and point to the player that you thought of first " +
                        "when you heard the statement!",
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
        SurfaceWithColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            subTasks.get(subTaskCounter).DisplayContent(
                player = null,
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