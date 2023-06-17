package com.boozeblaster.tasks.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.minigames.common.SipTransfer
import com.boozeblaster.tasks.CommonTask
import com.boozeblaster.ui.theme.getBackgroundColor

class SipTransferTask(subTasks: List<SipTransfer> = emptyList()) :
    CommonTask(subTasks = emptyList()) {

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
                Spacer(Modifier.size(50.dp))
                SimpleTextDisplay(
                    text = "SipTransfer",
                    fontSize = 20,
                    fontFamily = FontFamily.SansSerif
                )
            }
        }
    }

    /**
     * We do not display any content here - just invoke the callback() method instantly
     */
    @Composable
    override fun Display(callback: () -> Unit) {
        callback()
    }
}