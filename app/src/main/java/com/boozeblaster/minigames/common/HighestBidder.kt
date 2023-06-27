package com.boozeblaster.minigames.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.composables.SurfaceWithColumn
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Player

class HighestBidder(
    private val pointsToGet: Int
) : MiniGame() {

    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit) {
        SurfaceWithColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
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
}