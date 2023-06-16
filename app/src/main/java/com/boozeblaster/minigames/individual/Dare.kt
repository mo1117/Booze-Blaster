package com.boozeblaster.minigames.individual

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
import com.boozeblaster.widgets.Timer

class Dare(
    private val dare: String
) : MiniGame() {

    override fun toString(): String = this.dare

    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit, timer: Timer) {
        // STUB
    }
}