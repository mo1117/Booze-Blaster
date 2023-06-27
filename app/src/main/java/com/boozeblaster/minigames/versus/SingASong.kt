package com.boozeblaster.minigames.versus

import androidx.compose.runtime.Composable
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Player

class SingASong(
    private val crowdDecides: Boolean = false,
    private val statement: String
) :
    MiniGame() {

    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit) {
        TODO("Not yet implemented")
    }
}