package com.boozeblaster.minigames

import androidx.compose.runtime.Composable
import com.boozeblaster.models.Player

interface MiniGame {
    /**
     * Every type of MiniGame needs to implement the DisplayContent method
     *
     * The callback function is used to show the content of the following subTask, which is a
     * MiniGame
     */
    @Composable
    fun DisplayContent(player: Player?, callback: () -> Unit)
}