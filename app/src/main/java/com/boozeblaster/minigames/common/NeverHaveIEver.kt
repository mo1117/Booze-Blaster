package com.boozeblaster.minigames.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Player

class NeverHaveIEver(
    private val statement: String
) : MiniGame() {

    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit) {
        Surface(
            modifier = Modifier
                .fillMaxHeight(fraction = 1f)
                .fillMaxWidth(fraction = 1f)
                .clickable(onClick = { callback() })
        ) {
            SimpleTextDisplay(
                text = "Never Have I Ever...\n\n",
                fontSize = super.fontSize,
                fontFamily = super.fontFamily
            )
        }
    }
}