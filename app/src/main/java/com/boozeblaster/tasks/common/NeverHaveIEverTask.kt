package com.boozeblaster.tasks.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.boozeblaster.composables.ClickableSurfaceWithColumn
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.minigames.common.NeverHaveIEver
import com.boozeblaster.tasks.CommonTask
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.ui.theme.headerFont

class NeverHaveIEverTask(
    private val subTasks: List<NeverHaveIEver>
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
                text = "Never Have I Ever",
                fontSize = 30,
                fontFamily = headerFont
            )
            SimpleSpacer(size = 50)
            SimpleTextDisplay(
                text = "There will be three tasks of Never Have I Ever coming up.\n\nPlayers that " +
                        "have done said statement have to drink, others will be rewarded points.",
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
        Surface(
            modifier = Modifier
                .fillMaxWidth(fraction = 1f)
                .fillMaxHeight(fraction = 1f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.background(
                    color = getBackgroundColor()
                )
            ) {
                subTasks.get(index = subTaskCounter).DisplayContent(
                    player = null,
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
}