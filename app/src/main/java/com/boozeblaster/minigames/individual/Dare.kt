package com.boozeblaster.minigames.individual

import androidx.compose.runtime.Composable
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Player

class Dare(
    private val dare: String
) : MiniGame() {

    override fun toString(): String = this.dare

    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit, versusPlayer: Player?) {
        // STUB
        callback()
    }
}