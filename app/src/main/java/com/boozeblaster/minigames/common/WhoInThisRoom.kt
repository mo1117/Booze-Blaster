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

class WhoInThisRoom(
    private val statement: String
) : MiniGame() {

    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit, versusPlayer: Player?) {

        var showDialog by remember {
            mutableStateOf(value = false)
        }

        var pickedPlayers by remember {
            mutableStateOf(value = mutableListOf<Player>())
        }

        var selectPlayers by remember {
            mutableStateOf(value = false)
        }

        if (selectPlayers) {
            PlayerPicker(
                callback = { selectPlayers = false },
                players = Game.getPlayers(),
                pickedPlayers = pickedPlayers
            )
        }

        SimpleTextDisplay(
            text = "Who In This Room?",
            fontSize = 30,
            fontFamily = headerFont
        )

        SimpleSpacer(size = 50)

        SimpleTextDisplay(text = statement, fontSize = 24, fontFamily = super.fontFamily)

        SimpleSpacer(size = 30)

        SimpleButton(
            onClick = { selectPlayers = true },
            text = "Select Players",
            fontSize = super.fontSize,
            fontFamily = super.fontFamily,
            enabled = !showDialog
        )

        SimpleSpacer(size = 30)
        SimpleButton(
            onClick = {
                addSips(pickedPlayers = pickedPlayers)
                showDialog = true
            },
            text = "Continue",
            fontSize = super.fontSize,
            fontFamily = super.fontFamily,
            enabled = pickedPlayers.isNotEmpty() && !showDialog && !selectPlayers,
            needsConfirmation = true
        )

        SimpleSpacer(size = 50)

        if (showDialog) {
            AskPlayersToDrinkDialog(
                players = pickedPlayers,
                sips = Game.getSipMultiplier(),
                callback = {
                    showDialog = false
                    pickedPlayers = mutableListOf()
                    callback()
                })
        }
    }

    /**
     * Adds sips to the picked players
     * @param pickedPlayers Players that got picked
     */
    private fun addSips(pickedPlayers: List<Player>) {
        for (player in Game.getPlayers()) {
            if (pickedPlayers.contains(element = player)) {
                player.addSips(sips = Game.getSipMultiplier())
            }
        }
    }
}