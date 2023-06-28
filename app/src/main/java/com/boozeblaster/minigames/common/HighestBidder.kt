package com.boozeblaster.minigames.common

import androidx.compose.runtime.Composable
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Player

class HighestBidder(
    private val pointsToGet: Int
) : MiniGame() {

    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit, versusPlayer: Player?) {
        SimpleTextDisplay(
            text = "$pointsToGet points can be snatched!",
            fontSize = 30,
            fontFamily = super.fontFamily
        )

        SimpleSpacer(size = 30)

        SimpleTextDisplay(
            text = "Start bidding!",
            fontSize = super.fontSize,
            fontFamily = super.fontFamily
        )
    }
}