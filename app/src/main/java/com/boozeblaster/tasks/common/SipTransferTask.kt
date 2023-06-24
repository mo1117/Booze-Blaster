package com.boozeblaster.tasks.common

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import com.boozeblaster.composables.ClickableSurfaceWithColumn
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.minigames.common.SipTransfer
import com.boozeblaster.tasks.CommonTask
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.ui.theme.headerFont

class SipTransferTask(private val subTasks: List<SipTransfer>) :
    CommonTask(subTasks = subTasks) {

    @Composable
    override fun DisplayCover(onSurfaceClicked: () -> Unit) {
        ClickableSurfaceWithColumn(
            onSurfaceClicked = { onSurfaceClicked() },
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            SimpleTextDisplay(
                text = "SipTransfer",
                fontSize = 30,
                fontFamily = headerFont
            )
            SimpleSpacer(size = 50)
            SimpleTextDisplay(
                text = "The last round has started!\n\nYou will now have limited time to " +
                        "trade points for sips!\nStart making offers to your teammates!",
                fontSize = 20,
                fontFamily = FontFamily.SansSerif
            )
        }
    }

    @Composable
    override fun Display(callback: () -> Unit) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.background(
                color = getBackgroundColor()
            )
        ) {
            subTasks.get(index = 0).DisplayContent(
                player = null,
                callback = { callback() }
            )
        }
    }
}