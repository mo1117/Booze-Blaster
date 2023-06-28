package com.boozeblaster.minigames.versus

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.boozeblaster.composables.AskPlayersToDrinkDialog
import com.boozeblaster.composables.SimpleButton
import com.boozeblaster.composables.SimpleSpacer
import com.boozeblaster.composables.SimpleTextDisplay
import com.boozeblaster.enums.ButtonType
import com.boozeblaster.minigames.MiniGame
import com.boozeblaster.models.Game
import com.boozeblaster.models.Player

class SingASong(
    private val statement: String,
    private val crowdDecides: Boolean = false
) : MiniGame() {

    @Composable
    override fun DisplayContent(player: Player?, callback: () -> Unit, versusPlayer: Player?) {

        var winner: Player? by remember {
            mutableStateOf(value = null)
        }

        var showDialog by remember {
            mutableStateOf(value = false)
        }

        SimpleTextDisplay(text = this.statement, fontSize = 24, fontFamily = super.fontFamily)
        SimpleSpacer(size = 30)

        if (this.crowdDecides) {
            SimpleTextDisplay(
                text = "Let the other players decide if the song is suitable for said " +
                        "requirement!",
                fontSize = super.fontSize,
                fontFamily = super.fontFamily
            )
            SimpleSpacer(size = 30)
        }

        SimpleButton(
            onClick = { },
            text = "Winner",
            fontSize = super.fontSize,
            fontFamily = super.fontFamily,
            buttonType = ButtonType.CORRECT,
            enabled = !showDialog
        )

        SimpleSpacer(size = 30)

        SimpleButton(
            onClick = {
                winner = when (winner) {
                    player -> null
                    versusPlayer -> player
                    else -> player
                }
            },
            text = player!!.getName(),
            fontSize = super.fontSize,
            fontFamily = super.fontFamily,
            buttonType = if (winner == player) ButtonType.CORRECT else ButtonType.INCORRECT,
            enabled = !showDialog
        )

        SimpleSpacer(size = 30)

        SimpleButton(
            onClick = {
                winner = when (winner) {
                    player -> versusPlayer
                    versusPlayer -> null
                    else -> versusPlayer
                }
            },
            text = versusPlayer!!.getName(),
            fontSize = super.fontSize,
            fontFamily = super.fontFamily,
            buttonType = if (winner == versusPlayer) ButtonType.CORRECT else ButtonType.INCORRECT,
            enabled = !showDialog
        )

        SimpleSpacer(size = 50)

        SimpleButton(
            onClick = { showDialog = true },
            text = "Continue",
            fontSize = super.fontSize,
            fontFamily = super.fontFamily,
            needsConfirmation = true,
            enabled = !showDialog
        )

        SimpleSpacer(size = 50)

        if (showDialog) {
            val loser: Player? = when (winner) {
                player -> versusPlayer
                versusPlayer -> player
                else -> null
            }
            AskPlayersToDrinkDialog(
                players = if (loser == null) null else listOf(loser),
                sips = Game.getSipMultiplier(),
                callback = {
                    if (loser != null) {
                        addSips(player = loser, sips = Game.getSipMultiplier())
                    }
                    showDialog = false
                    winner = null
                    callback()
                })
        }
    }
}