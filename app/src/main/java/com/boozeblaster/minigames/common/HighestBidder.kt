package com.boozeblaster.minigames.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.boozeblaster.composables.AskPlayersToDrinkDialog
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleChangeableButton
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.composables.SinglePlayerPicker
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player

class HighestBidder(
    private val pointsToGet: Int
) : MiniGame() {

    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit, versusPlayer: Player?) {

        var bid by remember {
            mutableStateOf(value = 0)
        }

        var winner by remember {
            mutableStateOf(value = mutableListOf<Player?>(null))
        }

        var selectWinner by remember {
            mutableStateOf(value = false)
        }

        var showDialog by remember {
            mutableStateOf(value = false)
        }

        if (selectWinner) {
            SinglePlayerPicker(
                callback = { selectWinner = false },
                players = Game.getPlayers(),
                pickedPlayer = winner
            )
        }

        SimpleTextDisplay(
            text = "$pointsToGet points can be snatched!",
            fontSize = 30,
            fontFamily = super.fontFamily
        )

        SimpleSpacer(size = 30)

        SimpleTextDisplay(
            text = "Current Bid:",
            fontSize = super.fontSize,
            fontFamily = super.fontFamily
        )

        SimpleSpacer(size = 30)

        SimpleChangeableButton(
            onClick = { bid++ },
            text = {
                SimpleTextDisplay(
                    text = "$bid",
                    fontSize = super.fontSize,
                    fontFamily = super.fontFamily
                )
            },
            fontSize = super.fontSize,
            fontFamily = super.fontFamily,
            enabled = !showDialog
        )

        SimpleSpacer(size = 60)

        SimpleButton(
            onClick = { selectWinner = true },
            text = "Select Winner",
            fontSize = super.fontSize,
            fontFamily = super.fontFamily,
            enabled = bid > 0 && !showDialog
        )

        SimpleSpacer(size = 30)

        SimpleChangeableButton(
            onClick = {
                if (winner.get(index = 0) != null) {
                    addPointsAndSips(
                        player = winner.get(index = 0)!!,
                        points = this.pointsToGet,
                        sips = bid
                    )
                }
                showDialog = true
            },
            text = {
                SimpleTextDisplay(
                    text = if (winner.get(index = 0) == null) "No Winner" else "Check",
                    fontSize = super.fontSize,
                    fontFamily = super.fontFamily
                )
            },
            fontSize = super.fontSize,
            fontFamily = super.fontFamily,
            needsConfirmation = true,
            enabled = !showDialog
        )

        SimpleSpacer(size = 30)

        if (showDialog) {
            AskPlayersToDrinkDialog(
                players = if (winner.get(index = 0) == null) null else listOf(winner.get(index = 0)!!),
                sips = bid,
                callback = {
                    showDialog = false
                    winner = mutableListOf(null)
                    callback()
                })
        }
    }
}