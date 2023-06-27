package com.boozeblaster.minigames.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.boozeblaster.composables.AskPlayersToDrinkDialog
import com.boozeblaster.composables.PlayerPicker
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player
import com.boozeblaster.ui.theme.headerFont

class NeverHaveIEver(
    private val statement: String
) : MiniGame() {

    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit) {

        var selectPlayers by remember {
            mutableStateOf(value = false)
        }

        var playersDoneIt by remember {
            mutableStateOf(value = mutableListOf<Player>())
        }

        var showDialog by remember {
            mutableStateOf(value = false)
        }

        if (selectPlayers) {
            PlayerPicker(
                callback = { selectPlayers = false },
                players = Game.getPlayers(),
                pickedPlayers = playersDoneIt
            )
        }
        SimpleTextDisplay(
            text = "Never Have I Ever",
            fontSize = 30,
            fontFamily = headerFont
        )

        SimpleSpacer(size = 50)

        SimpleTextDisplay(
            text = statement,
            fontSize = super.fontSize,
            fontFamily = super.fontFamily
        )

        SimpleSpacer(size = 30)

        SimpleButton(
            onClick = { selectPlayers = true },
            text = "Select Player(s)",
            fontSize = super.fontSize,
            fontFamily = super.fontFamily,
            enabled = !showDialog
        )

        SimpleSpacer(size = 30)
        SimpleButton(
            onClick = {
                addPointsOrSips(playersDoneIt = playersDoneIt)
                showDialog = true
            },
            text = "Check",
            fontSize = super.fontSize,
            fontFamily = super.fontFamily,
            needsConfirmation = true,
            enabled = !showDialog
        )
        SimpleSpacer(size = 50)

        if (showDialog) {
            AskPlayersToDrinkDialog(
                players = playersDoneIt,
                sips = Game.getSipMultiplier()
            ) {
                showDialog = false
                playersDoneIt = mutableListOf()
                callback()
            }
        }

    }
}

/**
 * Gives points to all players that have not done the said thing
 *
 * Gives sips to all players that have done it
 * @param playersDoneIt List of players that have done the said statement
 */
private fun addPointsOrSips(playersDoneIt: List<Player>) {
    for (player in Game.getPlayers()) {
        if (playersDoneIt.contains(element = player)) {
            player.addSips(sips = Game.getSipMultiplier())
        } else {
            player.addPoints(points = 1)
        }
    }
}