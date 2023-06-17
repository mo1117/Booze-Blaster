package com.boozeblaster.minigames.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Player
import com.boozeblaster.ui.theme.getBackgroundColor
import com.boozeblaster.widgets.Timer

class NeverHaveIEver(
    private val statement: String
) : MiniGame() {

    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit, timer: Timer) {
        Surface(
            modifier = Modifier
                .fillMaxHeight(fraction = 1f)
                .fillMaxWidth(fraction = 1f)
                .clickable(onClick = { callback() })
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier.background(
                    color = getBackgroundColor()
                )
            ) {
                SimpleSpacer(size = 50)
                SimpleTextDisplay(
                    text = "Never Have I Ever...\n\n",
                    fontSize = super.fontSize,
                    fontFamily = super.fontFamily
                )
            }
        }
    }
}